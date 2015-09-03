package com.service.MessageService;

import java.util.List;

import com.model.Message.Message;
import com.model.Message.MessageDAO;


public class MessageServiceImpl implements MessageService {
	private MessageDAO messageDAO;
	
	public List<Message> listMessages() {
		return this.messageDAO.listMessages();
	}

	public MessageDAO getMessageDAO() {
		return messageDAO;
	}

	public void setMessageDAO(MessageDAO messageDAO) {
		this.messageDAO = messageDAO;
	}

	public void sendMessage(Message message) {
		this.messageDAO.sendMessage(message);
	}

	public void deleteMessage(Integer messageId) {
		this.messageDAO.deleteMessage(messageId);	
	}
}
