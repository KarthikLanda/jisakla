package service;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.UsersDetails;
import repository.AddressRepository;
import repository.UserRepository;

@Service
public class DtoService {
	
	@Autowired
	UserRepository usersRepository;
	
	@Autowired
	AddressRepository addressRepository;
	
	ModelMapper modelmapper = new ModelMapper();
	
	public UsersDetails saveusers(DtoService dtodervice)
	{
		UsersDetails user = modelmapper.map(dtodervice, UsersDetails.class);
		return usersRepository.save(user);
	}
	
	public List<UsersDetails> getusers()
	{
		return usersRepository.findAll();
	}
	
	public UsersDetails updateusers(DtoService dtodervice) 
	{
		UsersDetails users = modelmapper.map(dtodervice, UsersDetails.class);
		return usersRepository.save(users);
	}
	
	public void deleteuser(long id) 
	{
	    usersRepository.deleteById(id);
	}
	
}

