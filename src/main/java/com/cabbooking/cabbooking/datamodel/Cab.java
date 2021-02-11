package com.cabbooking.cabbooking.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
enum CabType{
	PREMIUM,ORDINARY;
	
}

@ToString
@Setter
@Getter
public class Cab {
	 private String id;
     private String driverName;
     private Location currentLocation;
     private Trip trip;
     private boolean isAvailable;
      
     public Cab(String id,String driverName) {
    	 this.id=id;
    	 this.driverName=driverName;
    	 this.isAvailable=true;
     }
     
}
