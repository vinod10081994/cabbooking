package com.cabbooking.cabbooking.strategy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.cabbooking.cabbooking.datamodel.Cab;
import com.cabbooking.cabbooking.datamodel.Location;
import com.cabbooking.cabbooking.datamodel.Rider;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {

	@Override
	public Cab cabMatching(Rider rider, Location startingLocation, List<Cab> closeByCabs) {
		// TODO Auto-generated method stub
		List<Cab> sortedCabs=closeByCabs.stream().sorted(Comparator.comparing(Cab::getCurrentLocation,(l1,l2)->
		                      {return (int) (l1.distance(startingLocation)-l2.distance(startingLocation));}))
				              .collect(Collectors.toList());
				
		return sortedCabs.get(0);
	}

}