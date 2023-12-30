package com.example.billing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConsulConfigRestController {
    @Autowired
    private MyVaultConfig myVaultConfig;
    @Autowired
    private MyConsulConfig myConsulConfig;
/*
    @Value("${token.accessTokenTimeout}")
    private Long accessTokenTimeout;
    @Value("${token.refreshTokenTimeout}")
    private  Long refreshTokenTimeout;*/
    @GetMapping("/myConfig")
    public Map<String , Object> myConfig(){
        return Map.of("ConsulConfiguration",myConsulConfig,"VaultConfiguration",myVaultConfig);
    }
/*@GetMapping("/myConfig")
public MyVaultConfig myConfig(){
    return myVaultConfig;
}*/
}
