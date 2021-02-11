package com.cabbooking.cabbooking.strategy;

import com.cabbooking.cabbooking.datamodel.Location;

public interface PricingStrategy {
   
   
   double priceCalculator(Location starting,Location ending);
   
}
