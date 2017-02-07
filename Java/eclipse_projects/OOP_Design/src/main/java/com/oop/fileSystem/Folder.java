package com.oop.fileSystem;

import java.util.ArrayList;
import java.util.Date;

public class Folder implements BaseFileSystem {

	private ArrayList<BaseFileSystem> contents = new ArrayList<>();	
	
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

}
