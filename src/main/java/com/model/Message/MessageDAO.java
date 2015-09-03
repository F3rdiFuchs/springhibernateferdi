package com.model.Message;

import java.util.List;

public interface MessageDAO {
	public List <Message> listMessages();
	public void sendMessage(Message message);
	public void deleteMessage(Integer messageId);
}
