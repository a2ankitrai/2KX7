package com.oop.fileSystem;

import java.util.Date;

public class File implements BaseFileSystem {

	private String data;
	private String name;
	private Date dateCreated;
	private Date dateModified;
	private Boolean visibilty;
	private Permission permission;
	
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDateCreated(Date d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDateModified(Date d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setVisibility(Boolean flag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPermission(Permission p) {
		// TODO Auto-generated method stub

	}

	public String getName() {
		return name;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public Boolean getVisibilty() {
		return visibilty;
	}

	public Permission getPermission() {
		return permission;
	}

}
