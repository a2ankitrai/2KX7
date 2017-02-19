package com.java.collections.set;

class User {
	 User(int id,String name){
	  this.id = id;
	  this.name = name;
	 }
	 private int id;
	 private String name;
	 public int getId() {
	  return id;
	 }
	 public void setId(int id) {
	  this.id = id;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 /*@Override
	 public int compareTo(User o) {
	  if(o==null)
	   return 1;
	  if( this.getId()>o.getId())
	   return 1;
	  else if(this.getId()<o.getId())
	   return -1;
	  
	  return 0;
	 }*/
} 