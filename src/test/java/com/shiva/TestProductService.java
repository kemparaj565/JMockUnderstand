package com.shiva;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.shiva.beans.Product;
import com.shiva.dao.PricingService;
import com.shiva.dao.SearchService;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

public class TestProductService {
	
	@Tested
	private ProductService productService;
	
	@Injectable
	private SearchService searchService;
	
	@Injectable
	private PricingService pricingService;
	 
	private List<Product> products;
	
	private Map<Long,Double> priceMap;
	
	@Before
	public void setup(){
		products=new ArrayList<>();
		Product p1=new Product();
		p1.setSku(1L);
		Product p2=new Product();
		p2.setSku(2L);
		products.add(p1);
		products.add(p2);
		
		
		priceMap=new HashMap<>();
		 priceMap.put(1L, 111.90);
		 priceMap.put(2L,15.40);
		 
	}
	
	@SuppressWarnings("unchecked")
	//@Test
	public void shouldFindProducts(){
		new Expectations(){{
			searchService.search("Shiva");
			returns(products);
			times=1;
			
			pricingService.price((List<Long>)any);
			returns(priceMap);
			times=1;
		}}; 
	
		List<Product> list=searchService.search("Shiva");
		assertEquals(2,list.size());
		Product product1=list.get(0);
		assertEquals(1L,product1.getSku());
		//assertEquals(111.90,product1.getPrice(),0);
		Product product2=list.get(1);
		assertEquals(2L,product2.getSku());
		//assertEquals(15.40,product2.getPrice(),0);
	}

}
