package practice;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cg.Admin.models.Admin;
import com.cg.Admin.repo.AdminRepo;

@Component
public class UserDetailServiceImpl implements UserDetailsService {
	
	@Autowired AdminRepo repo;
	private Admin admin;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 admin = repo.findByUsername(username);
		 System.out.println(admin);
		 if (admin == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new User(
	            admin.getUsername(),
	            admin.getPassword(),
	            getAuthorities()
	        );
	}
		 private Collection<? extends GrantedAuthority> getAuthorities() {
			 HashSet<SimpleGrantedAuthority> set = new HashSet<>();
			 set.add(new SimpleGrantedAuthority(this.admin.getRoles()));
			 return set;
		    }
	

}
