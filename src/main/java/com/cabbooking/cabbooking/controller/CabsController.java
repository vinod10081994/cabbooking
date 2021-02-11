package com.cabbooking.cabbooking.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.cabbooking.datamodel.Cab;
import com.cabbooking.cabbooking.datamodel.Location;
import com.cabbooking.cabbooking.services.CabService;
import com.cabbooking.cabbooking.services.TripService;

@RestController
public class CabsController {
	
	private TripService tripService;
	private CabService cabService;
	
	public CabsController(TripService tripService,CabService cabService) {
		this.tripService=tripService;
		this.cabService=cabService;
	}
	
	@RequestMapping(value="/register/cab",method=RequestMethod.POST)
	public ResponseEntity createCab(String id,String driverName) {
		cabService.createCab(new Cab(id,driverName));
		return ResponseEntity.ok("sucess");
	}
	
	@RequestMapping(value="/trip/end",method=RequestMethod.POST)
	public ResponseEntity endTrip(String cabId) {
		tripService.endTrip(cabService.getCab(cabId));
		return ResponseEntity.ok("sucess");
	}
	
	@RequestMapping(value="/car/update/location",method=RequestMethod.PUT)
	public ResponseEntity updateCabLocation(String cabId,double x,double y) {
		cabService.updateCabLocation(cabId,new Location(x,y));
		return ResponseEntity.ok("sucess");
	}
	
	@RequestMapping(value="/car/update/availability",method=RequestMethod.PUT)
	public ResponseEntity updateCabAvailability(String cabId,boolean isAvailable) {
		cabService.updateCabAvailability(cabId, isAvailable);;
		return ResponseEntity.ok("sucess");
	}

}
