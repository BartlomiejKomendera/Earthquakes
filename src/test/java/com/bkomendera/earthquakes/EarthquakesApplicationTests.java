package com.bkomendera.earthquakes;

import com.bkomendera.earthquakes.data.EarthquakesApiInterface;
import com.bkomendera.earthquakes.data.api.RESTclient;
import com.bkomendera.earthquakes.service.EarthquakesServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class EarthquakesApplicationTests {

	@Autowired
	private RESTclient restClient;
	@Autowired
	private EarthquakesApiInterface eai;
	@Autowired
	private EarthquakesServiceInterface esi;

	@Test
	void contextLoads() {
	}

	@Test
	void restApi() throws IOException {
		restClient.getClient().getFeatures().forEach(f-> System.out.println("f.getId() = " + f.getId()));
	}
	@Test
	void apiInterface() throws IOException {
		eai.getAllMonth().forEach(f-> System.out.println("f.getId() = " + f.getId()));
	}
	@Test
	void serviceInterface() throws IOException {
		esi.getEarthquakes().forEach(f-> System.out.println("f = " + f));
	}
	

}
