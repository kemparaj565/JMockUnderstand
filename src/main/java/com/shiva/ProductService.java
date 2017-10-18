package com.shiva;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.shiva.beans.Product;
import com.shiva.dao.PricingService;
import com.shiva.dao.SearchService;

public class ProductService {
	
	
	private SearchService searchService;
	
	private PricingService priceService;

	public List<Product> find(String token) {
		
		List<Product> products=searchService.search(token);
		
		List<Long> skus=new ArrayList<>();
		
		for(Product product:products){
			skus.add(product.getSku());
		}
		
		Map<Long,Double> priceMap=priceService.price(skus);
		
		for(Product product:products){
			product.setPrice(priceMap.get(product.getSku()));
		}  
		return products;
		
	}

}
