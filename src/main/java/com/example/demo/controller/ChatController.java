package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import com.example.demo.structure.Message;

@Controller
public class ChatController {
	
	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public Message sendMessage(Message message) {
		return new Message(HtmlUtils.htmlEscape(message.getContent()));
	}
	
}
