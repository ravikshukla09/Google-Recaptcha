package com.rks.demo.googlerecaptcha.controllers;

import com.rks.demo.googlerecaptcha.dto.HelloDTO;
import com.rks.demo.googlerecaptcha.dto.HelloResponseDTO;
import com.rks.demo.googlerecaptcha.validators.CaptchaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    CaptchaValidator captchaValidator;

    @PostMapping
    public String hello(@RequestBody HelloDTO helloDTO) {
        Boolean isValidCaptcha = captchaValidator.validateCaptcha(helloDTO.getCaptchaResponse());
        if (!isValidCaptcha) {
            throw new RuntimeException("Captcha is not valid");
        }
        return "Hello, " + helloDTO.getName() + "!";
    }
}
