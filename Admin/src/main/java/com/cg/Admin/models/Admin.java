package com.cg.Admin.models;

import java.util.Set;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Admin  {
	@Id
	private String username;
	private String password;
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(name ="role",joinColumns = @JoinColumn(name="username"),inverseJoinColumns = @JoinColumn(name="rusername"))
//	private Set<Role> roles;
}
