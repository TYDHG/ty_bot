package com.tydhg.ty_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author TYDHG
 */
@SpringBootApplication
public class TyBotApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(TyBotApplication.class);
        builder.headless(false).web(WebApplicationType.NONE).run(args);
//        SpringApplication.run(TyBotApplication.class, args);
    }

}
