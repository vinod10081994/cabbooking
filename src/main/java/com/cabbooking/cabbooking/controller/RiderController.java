package com.cabbooking.cabbooking.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.cabbooking.datamodel.Location;
import com.cabbooking.cabbooking.datamodel.Rider;
import com.cabbooking.cabbooking.datamodel.Trip;
import com.cabbooking.cabbooking.services.RiderService;
import com.cabbooking.cabbooking.services.TripService;

import lombok.NonNull;

@RestController
public class RiderController {
	
	private RiderService riderService;
	private TripService tripService;
	
	public RiderController(RiderService riderService,TripService tripService) {
		this.riderService=riderService;
		this.tripService=tripService;
	}
	@RequestMapping(value="/register/rider",method=RequestMethod.POST)
	public ResponseEntity createRider(@NonNull final String id,
			          @NonNull final String driverName,@NonNull final String mobileNumber) {
		riderService.createRider(new Rider(id,driverName,mobileNumber));
		return ResponseEntity.ok("success");
	}
	@RequestMapping(value="/trips",method=RequestMethod.GET)
	public ResponseEntity getTrips(String  riderId){
		List<Trip> trips=tripService.getTrips(riderId);
		return  ResponseEntity.ok(trips);
	}
	
	@RequestMapping(value="/trip",method=RequestMethod.POST)
	public ResponseEntity createTrip(String riderId,double stx,double sty,double enx,double eny ){
		tripService.createTrip(riderService.getRider(riderId), new Location(stx,sty), new Location(enx,eny));
		return  ResponseEntity.ok("success");
	}

}
