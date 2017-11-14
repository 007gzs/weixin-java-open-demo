package com.github.binarywang.demo.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author <a href="https://github.com/007gzs">007</a>
 */
@SpringBootApplication
@EnableAutoConfiguration
public class WxOpenApplication {
    public static void main(String[] args) {
        SpringApplication.run(WxOpenApplication.class, args);
    }
}
