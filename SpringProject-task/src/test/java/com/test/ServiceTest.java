package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dto.UserDataDto;
import entity.Addresse;
import entity.UsersDetails;
import repository.UserRepository;
import service.DtoService;

@SpringBootTest
public class ServiceTest {
	
	@Autowired
	private DtoService dtservice;
	
	@Mock
	private UserRepository userRepository;
	
	ModelMapper modelmapper = new ModelMapper();
	
	@BeforeEach
	public void init() {
		dtservice  = new DtoService(userRepository);
	}
	
	@Test
	public void saveunittest() {
		
		Addresse address = new Addresse();
		
		address.setId(1);
		address.setStreet("maddilapalem");
		address.setSuite("apt.554");
		address.setCity("Vizag");
		address.setZipcode(530013);
		
		List<Addresse> useraddress = new ArrayList<>();
		useraddress.add(address);
		
		UserDataDto usersdto = new UserDataDto();
		
		usersdto.setId(1);
		usersdto.setEmail("karthik.landa@gmail.com");
		usersdto.setPhone("8886449803");
		usersdto.setWebsite("www.imaginnovate.com");
		usersdto.setCompany("Imaginnovate");
		usersdto.setAddress(useraddress);
		
		UsersDetails usersd = modelmapper.map(usersdto, UsersDetails.class);
		
		when(userRepository.save(any(UsersDetails.class))).thenReturn(usersd);
		
		UsersDetails users = dtservice.saveusers(usersdto);
		
		assertEquals(usersd,users);
		
	}
	@Test
	public void getalltest() {
		Addresse address = new Addresse();
		
		address.setId(1);
		address.setStreet("maddilapalem");
		address.setSuite("apt.235");
		address.setCity("Vishakapatnam");
		address.setZipcode(530013);
		
		List<Addresse> list1 = new ArrayList<>();
		list1.add(address);
		
		UsersDetails user = new UsersDetails(1,"karthik","karthikl","karthik.landa@gmail.com","8886449803","www.imaginnovate.com","Imaginnovate",list1);
		
		List<UsersDetails> list2 = new ArrayList<>();
		list2.add(user);
		when(userRepository.findAll()).thenReturn(list2);
		assertEquals(1, list2.size());
	}
	@Test
	public void updatetest() {
        Addresse address = new Addresse();
		
		address.setId(1);
		address.setStreet("maddilapalem");
		address.setSuite("apt.235");
		address.setCity("Vishakapatnam");
		address.setZipcode(530013);
		
		List<Addresse> list1 = new ArrayList<>();
		list1.add(address);
		
        UserDataDto usersdto = new UserDataDto();
		
		usersdto.setId(1);
		usersdto.setEmail("karthik.landa@gmail.com");
		usersdto.setPhone("8886449803");
		usersdto.setWebsite("www.imaginnovate.com");
		usersdto.setCompany("Imaginnovate");
		usersdto.setAddress(list1);
		
		UsersDetails usersd = modelmapper.map(usersdto, UsersDetails.class);
		
		when(userRepository.save(any(UsersDetails.class))).thenReturn(usersd);
		
		UsersDetails users2 = dtservice.updateusers(usersdto);
		
		assertEquals(users2, usersd);
	}
	@Test
	public void deletetest() {
        Addresse address = new Addresse();
		
		address.setId(1);
		address.setStreet("maddilapalem");
		address.setSuite("apt.235");
		address.setCity("Vishakapatnam");
		address.setZipcode(530013);
		
		List<Addresse> list1 = new ArrayList<>();
		list1.add(address);
		
		UsersDetails user = new UsersDetails(1,"karthik","karthikl","karthik.landa@gmail.com","8886449803","www.imaginnovate.com","Imaginnovate",list1);
		
		dtservice.deleteuser(1L);
		
		assertEquals(1, user.getId());	
		
	}
	
}
