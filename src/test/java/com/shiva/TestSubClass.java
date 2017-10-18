package com.shiva;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Mocked;

public class TestSubClass {
	
	
	private SubClass subClass;
	
	@Test
	public void shouldGetData(@Mocked final SuperClass superClass){
		
		subClass=new SubClass("Data");
		assertEquals("Data",subClass.getData());
	}

}
