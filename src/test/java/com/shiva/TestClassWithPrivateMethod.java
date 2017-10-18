package com.shiva;

import static org.junit.Assert.*;

import org.junit.Test;

import mockit.Deencapsulation;
import mockit.Tested;

public class TestClassWithPrivateMethod {
	
	@Tested 
	private ClassWithPrivateMethod classWithPrivateMethod;
	
	@Test
	public void shouldGetSome(){
		int sum=Deencapsulation.invoke(classWithPrivateMethod, "sum", 1,2);
		assertEquals(3,sum);
	}
	
	

}
