package com.cabbooking.cabbooking.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

enum Status{
	IN_PROGRESS,FINISHED;
}


@ToString
@Getter
@Setter

public class Trip {
	
	private Cab cab;
	private Rider rider;
	private Location startingLocation,endingLocation;
	private Status status;
	
	public Trip(Cab cab,Rider rider,Location sl,Location el) {
		this.cab=cab;
		this.rider=rider;
		this.startingLocation=sl;
		this.endingLocation=el;
		this.status=Status.IN_PROGRESS;
	}
	
	public void endTrip() {
		status=Status.FINISHED;
	}

}
