package com.dream.common.enums;

public enum OzWitch {
   WEST("Miss Gulch, aka the Wiched Witch of the West"),
   NORTH("Glinda,the Good Witch of the North"),
   EAST("Wiched Witch of the east, wearer of the Ruby  "),
   SOUTH("Good by inference, but missing ");
   private String description;
   private OzWitch(String description){
	   this.description = description;
   }
   public String getDescription(){return this.description;}
   
   public static void main(String[] args) {
	  for(OzWitch s:OzWitch.values()){
		  System.out.println(s.getDescription());
	  }
   }
}
