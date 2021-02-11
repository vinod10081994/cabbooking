package com.cabbooking.cabbooking.strategy;

import com.cabbooking.cabbooking.datamodel.Location;
import com.cabbooking.cabbooking.datamodel.Rider;

import java.util.List;
import java.util.Optional;

import com.cabbooking.cabbooking.datamodel.Cab;

public interface CabMatchingStrategy {
	
	Cab cabMatching(Rider rider,Location startingLocation,List<Cab> closeByCabs); 

}
