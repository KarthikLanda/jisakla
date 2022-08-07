package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import controller.Controller;
import dto.UserDataDto;
import entity.Addresse;
import entity.UsersDetails;
import service.DtoService;

@SpringBootTest
public class ControllerTest {
	
	@InjectMocks
	private Controller controller;
	
	@Mock
	private DtoService dtoservice;
	
	@Test
	public void savetests() {
		Addresse address = new Addresse();
		address.setId(1);
		address.setStreet("Maddilapalem");
		address.setCity("Vizag");
		address.setSuite("apt.99");
		address.setZipcode(530013);
		
		List<Addresse> add1 = new ArrayList<>();
		add1.add(address);
		
		UserDataDto userdto = new UserDataDto();
		userdto.setId(1);
		userdto.setUsername("karthikl");
		userdto.setEmail("karthik.landa@gmail.com");
		userdto.setWebsite("www.Imaginnovate");
		userdto.setCompany("Imaginnovate");
		userdto.setPhone("8886449803");
		userdto.setAddress(add1);
		
		UsersDetails users = new UsersDetails();
		users.setId(1);
		users.setName("karthik");
		users.setUsername("karthikl");
		users.setEmail("karthik.landa@gmail.com");
		users.setPhone("8886449803");
		users.setWebsite("www.imaginnovate.com");
		users.setCompany("Imaginnovate");
		users.setAddress(add1);
		
		
		
	}
	
	public void gettest() {
		Addresse  address = new Addresse();
		address.setId(1);
		address.setStreet("Maddilapalem");
		address.setSuite("apt.101");
		address.setCity("Vizag");
		address.setZipcode(530013);
		
		List<Addresse> list = new ArrayList<>();
		list.add(address);
		
		UsersDetails users = new UsersDetails(1,"karthik","karthikl","karthik.landa@gmail.com","8886449803","www.imaginnovate.com","Imaginnovate",list);
		
		List<UsersDetails> list2 = new ArrayList<>();
		list2.add(users);
		
		when(dtoservice.getusers()).thenReturn(list2);
		
		List<UsersDetails> users2 = controller.getusers();
	    assertEquals(1, users2.size());
		
	}
	
	@Test
	public void updatetest() {
		Addresse address = new Addresse();
		address.setId(1);
		address.setStreet("Maddilapalem");
		address.setCity("Vizag");
		address.setSuite("apt.99");
		address.setZipcode(530013);
		
		List<Addresse> add1 = new ArrayList<>();
		add1.add(address);
		
		UserDataDto userdto = new UserDataDto();
		userdto.setId(1);
		userdto.setUsername("karthikl");
		userdto.setEmail("karthik.landa@gmail.com");
		userdto.setWebsite("www.Imaginnovate");
		userdto.setCompany("Imaginnovate");
		userdto.setPhone("8886449803");
		userdto.setAddress(add1);
		
		UsersDetails users = new UsersDetails();
		users.setId(1);
		users.setName("karthik");
		users.setUsername("karthikl");
		users.setEmail("karthik.landa@gmail.com");
		users.setPhone("8886449803");
		users.setWebsite("www.imaginnovate.com");
		users.setCompany("Imaginnovate");
		users.setAddress(add1);
		
		 dtoservice.updateusers(userdto);
		 
		 verify(dtoservice, times(1)).updateusers(userdto);
	      
	}
	@Test
	public void getusers() {
		

        Addresse address = new Addresse();
        
        address.setId(1);
		address.setStreet("Maddilapalem");
		address.setCity("Vizag");
		address.setSuite("apt.99");
		address.setZipcode(530013);

        List<Addresse> listad = new ArrayList<>();
        listad.add(address);

        Optional<UsersDetails> users1 = Optional.of(new UsersDetails());
        when(dtoservice.getuserdetails(1)).thenReturn(users1);

        Optional<UsersDetails> users2=dtoservice.getuserdetails(1);
        
        assertEquals(1, users2.get().getId());
        assertEquals("karthik", users2.get().getName());
        assertEquals("8886449803", users2.get().getPhone());
     
	}
	@Test
	public void deletetest() {
		Addresse address = new Addresse();
		
		address.setId(1);
		address.setStreet("Maddilapalem");
		address.setCity("Vizag");
		address.setSuite("apt.99");
		address.setZipcode(530013);
		
		List<Addresse> listad= new ArrayList<>();
		listad.add(address);
		
		UsersDetails user = new UsersDetails(1,"karthik","karthikl","karthik.landa@gmail.com","8886449803","www.imaginnovate.com","Imaginnovate",listad);
		
		assertEquals(1, user.getId());
		controller.deleteuser(1);
	}

}
