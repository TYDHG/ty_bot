package com.tydhg.ty_bot.bot.listener;

import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.Listener;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author TYDHG
 */
@Component
public class BotGlobalListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(BotGlobalListener.class);

    public void startListener() {
        // 创建群组消息监听
        Listener listener= GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class, event->{
            String name = event.getSubject().getName();
            String nick = event.getSource().getSender().getNick();
            LOGGER.info("收到【{}】群聊的【{}】消息，", name, nick);
            System.out.println("收到消息群聊消息，名称 = " + name);
        });

        // 创建好友消息监听
        Listener friendMessageListener= GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, event->{

        });
    }
}
