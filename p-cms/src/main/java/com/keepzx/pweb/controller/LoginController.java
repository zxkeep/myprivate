package com.keepzx.pweb.controller;

import com.keepzx.pweb.common.BaseResultVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController extends BaseController {


    @RequestMapping(value = "login", method = RequestMethod.GET)
    public BaseResultVO logout() {
        request.getSession().invalidate();
        return new BaseResultVO();
    }
}
