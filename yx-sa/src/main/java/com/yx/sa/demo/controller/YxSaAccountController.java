package com.yx.sa.demo.controller;


import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yx.sa.demo.entity.YxSaAccount;
import com.yx.sa.demo.service.IYxSaAccountService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ljf
 * @since 2019-07-29
 */
@RestController
@RequestMapping("/demo/yx-sa-account")
@Slf4j
@Data
public class YxSaAccountController {
    private final IYxSaAccountService saAccountService;

    private final RestTemplate restTemplate;

    @PostMapping(value = "/")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String saveAB() {
        log.info("开始保存服务A中账户信息......");

        YxSaAccount yxSaAccount = new YxSaAccount().setBalance(1000L)
                .setCreateTime(LocalDateTime.now());
        saAccountService.save(yxSaAccount);

        log.info("保存服务A账户信息成功。");

        log.info("调用服务B，保存账户信息......");

        ResponseEntity<String> postForEntity = restTemplate.postForEntity("http://yx-demo-spring-service-b/demo/yx-sb-account/", null, String.class);

        String sbResult = postForEntity.getBody();

        log.info("调用服务B结果：{}", sbResult);

//        int i = 1 / 0;

        return "success";
    }
}
