package com.tydhg.ty_bot.bot.listener;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import org.springframework.stereotype.Component;

/**
 * @author TYDHG
 */
@Component
public class BotGlobalListener {

    public void startListener() {
        // 创建监听
        Listener listener= GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event->{
            MessageChain chain=event.getMessage(); // 可获取到消息内容等, 详细查阅 `GroupMessageEvent`
            String name = event.getSubject().getName();
            System.out.println("收到消息，名称 = " + name);
        });
    }
}
