package com.yx.sb.demo.controller;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yx.sb.demo.entity.YxSbAccount;
import com.yx.sb.demo.service.IYxSbAccountService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljf
 * @since 2019-07-30
 */
@RestController
@RequestMapping("/demo/yx-sb-account")
@Slf4j
@Data
public class YxSbAccountController {
    private final IYxSbAccountService sbAccountService;

    @PostMapping(value = "/")
    @Transactional
    @LcnTransaction
    public String saveAB() throws InterruptedException {
        log.info("开始保存服务B中账户信息......");

        YxSbAccount yxSbAccount = new YxSbAccount().setBalance(1000L)
                .setCreateTime(LocalDateTime.now());
        sbAccountService.save(yxSbAccount);

        // 测试RPC调用超时，调节消费者调用超时时间
        Thread.sleep(4000L);

        log.info("保存服务B账户信息成功。");

        return "success";
    }
}
