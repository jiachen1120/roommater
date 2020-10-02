package com.packt.roommater;

import com.packt.roommater.web.CarController;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoommaterApplicationTests {
	@Autowired
	private CarController carController;
	@Test
	public void contextLoads() {
		assertThat(carController).isNotNull();
	}

}
