package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskyByYear(){
		assertEquals(4, whiskyRepository.findWhiskyByYear(2014).size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		assertEquals(3, distilleryRepository.findDistilleriesByRegion("Island").size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		Distillery distillery12 = distilleryRepository.findDistilleryByName("Isle of Arran");
		assertEquals("Seven Wood", whiskyRepository.findWhiskyByDistilleryAndAge(distillery12, 1).get(0).getName());
	}
}
