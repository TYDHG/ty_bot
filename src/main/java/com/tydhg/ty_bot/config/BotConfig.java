package com.tydhg.ty_bot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 机器人配置类，依据yaml配置获取
 * @author TYDHG
 */
@Configuration
@ConfigurationProperties(prefix = "qq-bot")
public class BotConfig {

    List<QqAccount> accounts;


    public List<QqAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<QqAccount> accounts) {
        this.accounts = accounts;
    }

    /**
     * qq账号实体类
     */
    public static class QqAccount {
        private Long code;

        private String password;

        public Long getCode() {
            return code;
        }

        public void setCode(Long code) {
            this.code = code;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
