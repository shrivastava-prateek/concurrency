package com.debugchaos.concurrency.synchronizationforsequence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TableLock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String tableName;

	public TableLock(String tableName) {
		this.tableName = tableName;
	}

	public TableLock() {

	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
