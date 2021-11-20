package com.mall.learnMall.service;

import com.mall.learnMall.common.api.CommonResult;

/**
 * vip managementService
 *
 * @author ycd20
 * @date 2021/11/20
 * @time 10:11
 */
public interface UmsMemberService {
    /**
     * generate verifykeys
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * judge verifyCode compile telephone
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
