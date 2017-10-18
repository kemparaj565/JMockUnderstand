package com.shiva;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;

public class TestShoutingManager {
	
	@Tested
	private ShoutingManager shoutingManager;
	
	@Test
	public void shouldShout(){
		
		new MockUp<DirtyWordService>(){
			
			@Mock
			public String getDirtyWord(){
				return "You are nice person";
			}
			
		};
	
		
		String word=shoutingManager.shout();
		assertEquals("You are nice person",word);
		
	}

}
