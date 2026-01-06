package com.bank.account.controller;

//import ch.qos.logback.core.net.ObjectWriter;
import com.bank.account.config.AccountServiceConfig;
import com.bank.account.config.property.Properties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/config")
public class AccountConfigController {

    @Autowired
    private AccountServiceConfig accountServiceConfig;

    @GetMapping("/account/properties")
    public String getProperties() throws JsonProcessingException {
        ObjectWriter objectWriter= new ObjectMapper().writer()
                .withDefaultPrettyPrinter();

        Properties properties=new Properties(
                accountServiceConfig.getMsg(),
                accountServiceConfig.getBuildVersion(),
                accountServiceConfig.getMailDetails(),
                accountServiceConfig.getActiveBranches()
        );
        return objectWriter.writeValueAsString(properties);
    }


}
