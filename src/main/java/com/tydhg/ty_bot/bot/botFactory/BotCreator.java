package com.tydhg.ty_bot.bot.botFactory;

import com.qrcode.QRCodeBot;
import com.tydhg.ty_bot.bot.listener.BotGlobalListener;
import com.tydhg.ty_bot.config.BotConfig;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.DeviceInfo;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * QQ机器人创建器
 * @author TYDHG
 */
@Component
public class BotCreator implements ApplicationListener<ContextRefreshedEvent> {
    @Resource
    private BotConfig botConfig;

    @Resource
    private BotGlobalListener globalListener;

    public void createBot() {
        List<BotConfig.QqAccount> accounts = botConfig.getAccounts();

        BotConfiguration configuration = new BotConfiguration();
        File botFile = new File("C:\\Users\\TYDHG\\Desktop\\bot-logs");
        File device = new File("device.json");
        // 设置缓存文件夹
        configuration.setCacheDir(botFile);
        configuration.setWorkingDir(botFile);

        if (accounts == null || accounts.size() == 0) {
            throw new RuntimeException("账号为空");
        }
        if (!device.exists()) {
            throw new RuntimeException("设备文件不能为空");
        }
        for (BotConfig.QqAccount account : accounts) {
            configuration.setDeviceInfo(bot -> DeviceInfo.from(device));
            // 使用扫码登录
            Bot bot = QRCodeBot.getQRCodeBot(account.getCode());
            bot.login();
            // 使用原始账号密码登录
            // Bot bot = BotFactory.INSTANCE.newBot(account.getCode(), account.getPassword(), configuration);
            // bot.login();
        }

        globalListener.startListener();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        this.createBot();
    }
}
