package com.keepzx.pcms.controller;

import com.keepzx.constant.Indicator;
import com.keepzx.domain.entity.Account;
import com.keepzx.pcms.common.BaseResultVO;
import com.keepzx.pcms.common.constant.ResponseConstant;
import com.keepzx.pcms.common.constant.SessionConstant;
import com.keepzx.pcms.common.constant.UriConstant;
import com.keepzx.service.AccountService;
import com.keepzx.utils.DesUtils;
import com.keepzx.vo.LoginRequest;
import com.keepzx.vo.LoginResult;
import com.keepzx.vo.assembler.LoginAssembler;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController extends BaseController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = UriConstant.LOGIN, method = RequestMethod.POST)
    public BaseResultVO<LoginResult> login(@RequestBody LoginRequest loginRequest) {
        if(loginRequest.getPhaId()!=null && request.getSession().getAttribute(SessionConstant.SESSION_ACCOUNT.name())!=null)
        {
            request.getSession().setAttribute(SessionConstant.SESSION_PHA_ID.name(),loginRequest.getPhaId());
            return new BaseResultVO<>();
        }
        Account queryCondition = new Account();
        queryCondition.setAccLoginName(loginRequest.getLoginName());
        queryCondition.setDataDelete(Indicator.COMMON_NO.getCode());
        List<Account> accountList = accountService.select(queryCondition);
        if (CollectionUtils.isEmpty(accountList)) {
            return new BaseResultVO<>(ResponseConstant.OPERATION_LOGIN_FAIL);
        }

        int size=accountList.size();
        Account accountResult=null;
        for(int i=0;i<size;i++){
            Account temp=accountList.get(i);
            if(temp.getAccLoginName().equals(loginRequest.getLoginName())){
                accountResult=temp;
                break;
            }
        }
        String encodePwd = DesUtils.encodeWithSha1(loginRequest.getPassword());
        if (!encodePwd.equals(accountResult.getAccPassword())) {
            return new BaseResultVO<>(ResponseConstant.OPERATION_LOGIN_FAIL);
        }
        Account account=accountResult;
        request.getSession().setAttribute(SessionConstant.SESSION_ACCOUNT.name(), account);
        /*账户登录验证 end*/
        LoginResult loginResult = LoginAssembler.toVo(account);
        return new BaseResultVO<>(loginResult);
    }

    @RequestMapping(value = UriConstant.LOGOUT, method = RequestMethod.GET)
    public BaseResultVO logout() {
        request.getSession().invalidate();
        return new BaseResultVO();
    }
}
