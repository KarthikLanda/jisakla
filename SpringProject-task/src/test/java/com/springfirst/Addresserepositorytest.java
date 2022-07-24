package com.springfirst;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import entity.Addresse;
import repository.AddressRepository;

@DataJpaTest
public class Addresserepositorytest {
	
	@Autowired
	private AddressRepository addressrepository;
	
	@Test
	public void saveaddresstest() {
		Addresse adrs1 = Addresse.builder()
				.id(1)
				.street("maddialpalem")
				.suite("apt.54")
				.city("Vishakapatnam")
				.zipcode(532312)
				.build();
		
		addressrepository.save(adrs1);
		
		Assertions.assertThat(adrs1.getId()).isGreaterThan(0);
	}
	@Test
	public void getaddresstest() {
		Addresse adrs2 = addressrepository.findById(1L).get();
		
		Assertions.assertThat(adrs2.getId()).isEqualTo(1L);
	}
	
	@Test
	public void getalladdresstest() {
		
		List<Addresse> adrs3 = addressrepository.findAll();
		
		Assertions.assertThat(adrs3.size()).isGreaterThan(0);
	}
	
	@Test
	public void updataddresstest() {
		Addresse adrs4 = addressrepository.findById(1L).get();
		
		adrs4.setCity("Hyderabad");
		
		Addresse updatemail = addressrepository.save(adrs4);
		
		Assertions.assertThat(updatemail.getId()).isEqualTo("Hyderabad");
	}
	
	@Test
	public void deleteusertest() {
		Addresse adrs5 = addressrepository.findById(1L).get();
		
		addressrepository.delete(adrs5);
		
		Addresse addressdel = null;
		
		Optional<Addresse> optionaladd = addressrepository.findByCity("Hyderabad");
		
		if(optionaladd.isPresent()) {
			addressdel = optionaladd.get();
		}
		Assertions.assertThat(addressdel).isNull();
	}
}


