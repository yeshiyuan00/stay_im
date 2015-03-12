package com.stay4it.im.entities;

import java.io.Serializable;

/** 
 * @author Stay  
 * @version create time：Mar 9, 2015 4:38:54 PM 
 */
public class Attachment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;
	private String name;
	private String desc;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
}
