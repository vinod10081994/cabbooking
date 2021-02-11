package com.cabbooking.cabbooking.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Location {
	
	private double x,y;
	public double distance(Location endPoint) {
		
		return Math.sqrt(Math.pow(this.x-endPoint.x,2)+Math.pow(this.y-endPoint.y, 2));
	}

}
