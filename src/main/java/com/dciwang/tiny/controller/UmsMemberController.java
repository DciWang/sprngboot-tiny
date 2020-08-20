package com.dciwang.tiny.controller;

import com.dciwang.tiny.common.api.CommonResult;
import com.dciwang.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author DciWang
 * @Description TODO  会员登录注册管理Controller
 * @Date 2020/8/20 下午5:41
 * @Version 1.0
 */
@Controller
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService memberService;

    @ApiOperation("获取验证码")
    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@ApiParam("电话号码") @RequestParam("telephone") String telephone) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@ApiParam("电话号码") @RequestParam String telephone,
                                       @ApiParam("验证码") @RequestParam String authCode) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
