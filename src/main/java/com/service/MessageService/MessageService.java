package com.service.MessageService;

import java.util.List;

import com.model.Message.Message;


public interface MessageService {
	public List<Message> listMessages();
	public void sendMessage(Message message);
	public void deleteMessage(Integer messageId);
}
