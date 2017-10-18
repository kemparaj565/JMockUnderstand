package com.shiva.dao;

import java.util.List;
import java.util.Map;

public interface PricingService {

	Map<Long,Double> price(List<Long> skus );

}