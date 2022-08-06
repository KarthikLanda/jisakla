package service;

import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.UserDataDto;
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
	
	public  DtoService(UserRepository usersRepository) {
	       this.usersRepository = usersRepository;
	}

	public UsersDetails saveusers(UserDataDto userdatadto)
	{
		UsersDetails user = modelmapper.map(userdatadto, UsersDetails.class);
		return usersRepository.save(user);
	}
	
	public List<UsersDetails> getusers()
	{
		return usersRepository.findAll();
	}
	
	public UsersDetails updateusers(UserDataDto usersdto) 
	{
		UsersDetails users = modelmapper.map(usersdto, UsersDetails.class);
		return usersRepository.save(users);
	}
	
	public void deleteuser(long id) 
	{
	    usersRepository.deleteById(id);
	}
	
}

