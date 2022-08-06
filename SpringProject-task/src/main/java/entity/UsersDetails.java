package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UsersDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String username;
	
	@Column
	private String email;
	
	@Column
	private String phone;
	
	@Column	
	private String website;
	
	@Column	
	private String Company;
 
	@OneToMany(targetEntity = Addresse.class, cascade = CascadeType.ALL)
	@JoinColumn(name="u_id", referencedColumnName = "id")
	
	private List<Addresse> address;

}
