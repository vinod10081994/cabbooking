package com.cabbooking.cabbooking.services;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cabbooking.cabbooking.Exception.CabNotFoundException;
import com.cabbooking.cabbooking.Exception.RiderNotFoundException;
import com.cabbooking.cabbooking.Exception.TripNotFoundException;
import com.cabbooking.cabbooking.datamodel.Cab;
import com.cabbooking.cabbooking.datamodel.Location;
import com.cabbooking.cabbooking.datamodel.Rider;
import com.cabbooking.cabbooking.datamodel.Trip;
import com.cabbooking.cabbooking.strategy.CabMatchingStrategy;
import com.cabbooking.cabbooking.strategy.PricingStrategy;

import lombok.NonNull;

public class TripService {
    private Map<String,ArrayList<Trip>> tripMap=new HashMap<>();
    private static final double MAX_ALLOWABLE_DISTANCE=10;
    private CabService cabService;
    private RiderService riderService;
    private PricingStrategy pricingStrategy;
    private CabMatchingStrategy cabMatchingStrategy;
    public TripService(CabService cabService,RiderService riderService,
    		           PricingStrategy pricingStrategy,CabMatchingStrategy cabMatchingStrategy) {
    	this.cabService=cabService;
    	this.riderService=riderService;
    	this.pricingStrategy=pricingStrategy;
    	this.cabMatchingStrategy=cabMatchingStrategy;
    }
    
    public void createTrip(@NonNull final Rider rider,@NonNull final Location startingLocation,@NonNull final Location endingLocation) {
    	List<Cab> closeByCabs=cabService.getCabs(startingLocation, MAX_ALLOWABLE_DISTANCE);
    	Cab selectedCab=cabMatchingStrategy.cabMatching(rider, startingLocation, closeByCabs);
    	
    	if(selectedCab==null) {
    		
    		throw new CabNotFoundException();
    	}
    	
    	double price=pricingStrategy.priceCalculator(startingLocation, endingLocation);
    	Trip trip=new Trip(selectedCab, rider, startingLocation, endingLocation);
    	selectedCab.setTrip(trip);
    	if(!tripMap.containsKey(rider.getId())) {
    		tripMap.put(rider.getId(), new ArrayList<>());
    	}
    	tripMap.get(rider.getId()).add(trip);
    	selectedCab.setAvailable(false);
    }
    
    public List<Trip> getTrips(@NonNull final String riderId){
    	if(!tripMap.containsKey(riderId)) {
    		throw new RiderNotFoundException();
    	}
    	return tripMap.get(riderId);
    }
    
    public void endTrip(@NonNull final Cab cab) {
    	if(cab.getTrip()==null) {
    
    		throw new TripNotFoundException();
    	}
    	cab.getTrip().endTrip();
    	cab.setTrip(null);
    	cab.setAvailable(true);
    }
}
