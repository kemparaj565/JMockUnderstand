package com.shiva.dao;

import java.util.List;

import com.shiva.beans.Product;

public interface SearchService {

	List<Product> search(String token);

}
