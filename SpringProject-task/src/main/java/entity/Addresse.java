package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "addresst")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Addresse {
	
	@Id
	private long id;
	
	@Column
	private String street;
	
	@Column
	private String suite;
	
	@Column
	private String city;
	
	@Column
	private String zipcode;

}
