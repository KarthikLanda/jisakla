package com.test;
//package com.springfirst;
//
//import java.util.List;
//
//import java.util.Optional;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import entity.UsersDetails;
//import repository.UserRepository;
//
//@DataJpaTest
//public class Userrepositorytest {
//	
//	@Mock
//	private UserRepository userrepository;
//	
//	@Test
//	public void saveusertest() {
//		UsersDetails user1 = UsersDetails.builder()
//				.id(1)
//				.name("karthik")
//				.username("karthikl")
//				.email("karthik.landa")
//				.phone("8886449803")
//				.website("imaginnovate.com")
//				.Company("Imagginovate")
//				.build();
//		
//		userrepository.save(user1);
//		Assertions.assertThat(user1.getId()).isGreaterThan(0);
//	}
//	@Test
//	public void getusertest() {
//		UsersDetails user2 = userrepository.findById(1L).get();
//		
//		Assertions.assertThat(user2.getId()).isEqualTo(1L);
//	}
//	
//	@Test
//	public void getallusertest() {
//		
//		List<UsersDetails> user3 = userrepository.findAll();
//		
//		Assertions.assertThat(user3.size()).isGreaterThan(0);
//	}
//	
//	@Test
//	public void updateusertest() {
//		UsersDetails user3 = userrepository.findById(1L).get();
//		
//		user3.setEmail("landa@gmail.com");
//		
//		UsersDetails updatemail = userrepository.save(user3);
//		
//		Assertions.assertThat(updatemail.getId()).isEqualTo("landa@gmail.com");
//	}
//	
//	@Test
//	public void deleteusertest() {
//		UsersDetails user4 = userrepository.findById(1L).get();
//		
//		userrepository.delete(user4);
//		
//		UsersDetails userdet = null;
//		
//		Optional<UsersDetails> optional = userrepository.findByEmail("landa@gmail.com");
//		
//		if(optional.isPresent()) {
//			userdet = optional.get();
//		}
//		Assertions.assertThat(userdet).isNull();
//	}
//}
