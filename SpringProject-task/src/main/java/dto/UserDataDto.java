package dto;

import java.util.List;

import entity.Addresse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDataDto {
	
	    private int id;
		private String name;
		private String username;
		private String email;
		private String phone;
		private String website;
		private String company;
		
		private List<Addresse> address;

}
