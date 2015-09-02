package com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="TASKS")
public class Tasks {
	
	@Id
    @GeneratedValue
    @Column(name="taskId")
	private Integer taskId;
	
	@Column(name="description")
	@Size(max=150)
	private String description;
	
	@Column(name="start")
	@NotNull
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private String start;
	
	@Column(name="end")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private String end;
	
	@NotNull
	@Column(name="status")
	private Boolean status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USERTASKS", joinColumns = @JoinColumn(name = "taskId"),inverseJoinColumns = @JoinColumn(name = "userId"))
	private List<User> user;
	

	public Integer getTaskId() {
		return taskId;
	}

	
	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}


	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
