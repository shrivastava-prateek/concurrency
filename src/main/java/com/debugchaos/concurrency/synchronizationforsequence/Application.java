package com.debugchaos.concurrency.synchronizationforsequence;


import javax.persistence.*;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length=50, nullable=false, unique=true)
	private Long applicationNo;

	public Application() {
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Long getApplicationNo() {
		return applicationNo;
	}

	public void setApplicationNo(Long applicationNo) {
		this.applicationNo = applicationNo;
	}

	@Override
	public String toString() {
		return "Application{" +
				"id=" + id +
				", applicationNo=" + applicationNo +
				'}';
	}
}
