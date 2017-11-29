package com.shopping.bean;

import java.util.Date;

public class Factory {

	private int factory_id;
	private Long factory_acct;
	private String factory_name;
	private String factory_addr;
	private Long fac_contact_nbr;
	private String factory_log;
	private String comment;
	
	public String getFactory_name() {
		return factory_name;
	}
	public void setFactory_name(String factory_name) {
		this.factory_name = factory_name;
	}
	public String getFactory_addr() {
		return factory_addr;
	}
	public void setFactory_addr(String factory_addr) {
		this.factory_addr = factory_addr;
	}
	public Long getFac_contact_nbr() {
		return fac_contact_nbr;
	}
	public void setFac_contact_nbr(Long fac_contact_nbr) {
		this.fac_contact_nbr = fac_contact_nbr;
	}
	public String getFactory_log() {
		return factory_log;
	}
	public void setFactory_log(String factory_log) {
		this.factory_log = factory_log;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getFactory_id() {
		return factory_id;
	}
	public void setFactory_id(int factory_id) {
		this.factory_id = factory_id;
	}

	public Long getFactory_acct() {
		return factory_acct;
	}
	public void setFactory_acct(Long factory_acct) {
		this.factory_acct = factory_acct;
	}
	
	
}
