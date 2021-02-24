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
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2014);
		assertEquals(4, found.size());
	}

	@Test
	public void canFindDistilleryByRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Island");
		assertEquals(3, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		Distillery distillery12 = distilleryRepository.findDistilleryByName("Isle of Arran");
		List<Whisky> found = whiskyRepository.findWhiskyFromDistilleryByAge(distillery12, 1);
		assertEquals("Seven Wood", found.get(0).getName());
	}
}
