package com.example.chat.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ChatServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(ChatServerHandler.class);
    private final List<Channel> channels;

    public ChatServerHandler(List<Channel> channels) {
        this.channels = channels;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String message = (String) msg;
        logger.info("Received message from client: {}", message);

        // Broadcast the message to all connected clients except the sender
        for (Channel channel : channels) {
            if (channel != ctx.channel()) {
                channel.writeAndFlush("[" + ctx.channel().remoteAddress() + "]: " + message + "\n");
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.error("An error occurred in ChatServerHandler", cause);
        ctx.close();
    }
}
