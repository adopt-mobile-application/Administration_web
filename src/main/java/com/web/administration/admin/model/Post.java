package com.web.administration.admin.model;

import java.util.Date;
import java.util.List;


import lombok.Data;

@Data
public class Post {

	
    private Long id_post;
    private String animal_name;
    private String species;
    private String race;
    private String gender;
    private int age;
    private String pelage;
    private String color;
    private String description;
    private boolean confirmed; 

   
    private Date date = new Date();

  
    private Account account;
    private List<Picture> pictures;

  
   

}