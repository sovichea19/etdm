package edu.mum.cs.cs425.etdm.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.mum.cs.cs425.etdm.service.impl.AthleteService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AthleteServiceImplTest {
	@Autowired
	private AthleteService athleteService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
	     int actual = athleteService.countEliteAthletes();
	     int expected = 2;
	     assertEquals((long)expected, (long)actual);
	}
}
