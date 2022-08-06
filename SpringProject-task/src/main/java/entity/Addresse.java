package entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@Builder
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
	private long zipcode;

}
