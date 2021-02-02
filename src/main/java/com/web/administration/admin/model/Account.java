package com.web.administration.admin.model;


public class Account {

  
    private long id_account;
    
  
    private String first_name;
    
    
    private String last_name;
   
    private String address;
    
   
    private boolean verified;
    
    
    private String picture;
   
   
    private String city;

    
    private String num_tel; 
    
    public String getPicture() {
        return picture;
    }
    	
    public void setPicture(String picture) {
        this.picture = picture;
    }

    
    private User user;



    public Account(){
        this.user=null;
        this.address=null;
        this.first_name=null;
        this.last_name=null;
        this.verified=false;
    }


    public Account(User user){
        this.user=user;
        this.address=null;
        this.first_name=null;
        this.last_name=null;
        this.verified=false;
    }

    public long getId_account() {
        return id_account;
    }

    public void setId_account(long id_account) {
        this.id_account = id_account;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
