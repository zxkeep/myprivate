package com.keepzx.pcms.controller;

import com.keepzx.constant.Page;
import com.keepzx.domain.bean.AccountBean;
import com.keepzx.domain.entity.Account;
import com.keepzx.pcms.common.BaseResultVO;
import com.keepzx.pcms.common.constant.ResponseConstant;
import com.keepzx.pcms.common.constant.UriConstant;
import com.keepzx.pcms.exceptionHandler.MyException;
import com.keepzx.service.AccountService;
import com.keepzx.utils.DesUtils;
import com.keepzx.vo.assembler.AccountAssembler;
import com.keepzx.vo.responsevo.AccountVO;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author keep-zx
 * @version 1.0.0
 * @create 2021-05-31 20:23
 * @desc 账户相关  controller
 */
@RestController
public class AccountController extends BaseController {

    private static final String DEFAULT_PASSWORD = "123456";

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = UriConstant.ACCOUNT_LIST, method = RequestMethod.POST)
    public BaseResultVO<Page<AccountVO>> accountList(@RequestBody AccountVO accountVO) {
        AccountBean accountBean = AccountAssembler.vo2bean(accountVO);
        com.github.pagehelper.Page<AccountBean> accountRole = accountService.getAccounts(accountBean);
        Page<AccountVO> accountVOPage = AccountAssembler.page2vo(accountRole);
        return new BaseResultVO<>(accountVOPage);
    }

    @RequestMapping(value = UriConstant.ACCOUNT_ADD, method = RequestMethod.POST)
    public BaseResultVO<Boolean> accountAdd(@RequestBody AccountVO accountVO) {
        if(StringUtils.isBlank(accountVO.getAccountLoginName())){
            throw new MyException("登录名不能为空！");
        }
        if(StringUtils.isBlank(accountVO.getPassword())){
            throw new MyException("密码不能为空！");
        }
        if(StringUtils.isBlank(accountVO.getConfirmPassword())){
            throw new MyException("确认密码不能为空！");
        }
        AccountBean accountBean = AccountAssembler.vo2bean(accountVO);
        accountBean.setCreateUser(getSessionAccountId());
        accountService.addAccount(accountBean);
        return new BaseResultVO<>(true);
    }




    @RequestMapping(value = UriConstant.ACCOUNT_EDIT, method = RequestMethod.POST)
    public BaseResultVO<Boolean> accountUpdate(@RequestBody AccountVO accountVO) {
        if(StringUtils.isBlank(accountVO.getAccountLoginName())){
            throw new MyException("登录名不能为空！");
        }
        if(StringUtils.isBlank(accountVO.getPassword())){
            throw new MyException("密码不能为空！");
        }
        if(StringUtils.isBlank(accountVO.getConfirmPassword())){
            throw new MyException("确认密码不能为空！");
        }
        AccountBean accountBean = AccountAssembler.vo2bean(accountVO);

        /*更新账户信息 start*/
        accountBean.setUpdateUser(getSessionAccountId());
        accountService.updateEntitySelective(accountBean);
        return new BaseResultVO<>(true);
    }

    @RequestMapping(value = UriConstant.ACCOUNT_DEL, method = RequestMethod.POST)
    public BaseResultVO<Boolean> accountDel(@RequestBody List<AccountVO> accountVOList) {
        List<Integer> accountIdList = accountVOList.stream()
                .map(AccountVO::getAccountId)
                .collect(Collectors.toList());
        if(CollectionUtils.isEmpty(accountIdList)){
            return new BaseResultVO("0006","请选择要删除的账户！");
        }
        accountService.deleteAccount(accountIdList, getSessionAccountId());
        return new BaseResultVO<>(true);
    }

    @RequestMapping(value = UriConstant.ACCOUNT_MODIFY_PASSWORD, method = RequestMethod.POST)
    public BaseResultVO modifyPassword(@RequestBody AccountVO accountVo) {
        if (accountVo == null) {
            return new BaseResultVO(ResponseConstant.OPERATION_WRONG_PARAM);
        }
        if (StringUtils.isEmpty(accountVo.getPassword())) {
            return new BaseResultVO(ResponseConstant.OPERATION_WRONG_PARAM);
        }
        if (StringUtils.isEmpty(accountVo.getNewPassword())) {
            return new BaseResultVO(ResponseConstant.OPERATION_WRONG_PARAM);
        }
        if (StringUtils.isEmpty(accountVo.getConfirmPassword())) {
            return new BaseResultVO(ResponseConstant.OPERATION_WRONG_PARAM);
        }
        if(!accountVo.getNewPassword().equals(accountVo.getConfirmPassword())){
            return new BaseResultVO("0005","新密码确认失败！");
        }
        AccountBean accountBean = AccountAssembler.vo2bean(accountVo);
        accountService.updateAccount(accountBean);
        return new BaseResultVO(ResponseConstant.OPERATION_SUCCESS);
    }


    @RequestMapping(value = UriConstant.ACCOUNT_RESET_PASSWORD,method = RequestMethod.GET)
    public BaseResultVO resetPassword(@RequestParam("accountId") Integer accountId){
        if(accountId==null){
            return new BaseResultVO(ResponseConstant.OPERATION_WRONG_PARAM);
        }
        String encodeNerPwd = DesUtils.encodeWithSha1(DEFAULT_PASSWORD);
        Account account = accountService.selectEntityById(accountId);
        account.setAccPassword(encodeNerPwd);
        accountService.updateEntitySelective(account);
        return new BaseResultVO(ResponseConstant.OPERATION_SUCCESS);
    }

}
