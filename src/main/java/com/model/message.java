package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="MESSAGE")
public class message {
	
	@Id
    @GeneratedValue
    @Column(name="messageId")
	private Integer messageId;
	
	private User fromUser;
	
	private User toUser;
	
	@Column(name="title")
	@Size(max=45, message="max 45 chars")
	private String title;
	
	@Column(name="message")
	@Size(max=1000, message="max 1000 chars")
	@NotEmpty(message = "Please enter your text.")
	private String message;
	
	@Column(name="status")
	private Boolean status;
	
	@Column(name="date")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@NotEmpty
	private String date;

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
