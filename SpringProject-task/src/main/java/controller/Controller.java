package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDataDto;
import entity.UsersDetails;
import service.DtoService;

@RestController
public class Controller {
	
	@Autowired
	private DtoService dtoservice;
	
	@PostMapping("/save/users")
	public UsersDetails saveusers(@RequestBody UserDataDto usersdto)
	{
		return dtoservice.saveusers(usersdto);
	}

	@GetMapping("/get/users")
	public List<UsersDetails> getusers()
	{
		return dtoservice.getusers();
	}
	
	@PutMapping("/update/user")
	public UsersDetails updateUserDetailsa(@RequestBody UserDataDto usersdto) 
	{
		return dtoservice.updateusers(dtoservice);
	}
	
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteuser(@PathVariable("id") long id) 
	{
		dtoservice.deleteuser(id);
	}


}
