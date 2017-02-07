package com.oop.fileSystem;

import java.util.Date;

public interface BaseFileSystem {

	void setName(String name);
	
	void setDateCreated(Date d);
	
	void setDateModified(Date d);
	
	void setVisibility(Boolean flag);
	
	void setPermission(Permission p);
	
}
