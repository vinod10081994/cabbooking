package com.cabbooking.cabbooking.strategy;

import com.cabbooking.cabbooking.datamodel.Location;

public class DefaultPricingStrategy implements PricingStrategy{
    private final double  PER_KM_RATE=25.00;
	@Override
	public double priceCalculator(Location starting, Location ending) {
		// TODO Auto-generated method stub
		return starting.distance(ending)*PER_KM_RATE;
	}

}
