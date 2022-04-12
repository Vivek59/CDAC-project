package DoorServe.com.CustomerServiceproviderJwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import DoorServe.com.Dao.DoorServerHibenateDao;
import DoorServe.com.Entity.Customer;
import DoorServe.com.Entity.Serviceprovider;


@Service
public class CustomerServiceproviderAuthenticate implements UserDetailsService {

	@Autowired
	DoorServerHibenateDao DB;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Object cs =  (DB.cfindByUsername(username)!=null)?DB.cfindByUsername(username):DB.sfindByUsername(username);
		
		if( cs instanceof Customer ) {
			return new User(((Customer) cs).getUsername(), ((Customer) cs).getPassword(),new ArrayList<>());
		}
		else if( cs instanceof Serviceprovider ) {
		
			return new User(((Serviceprovider) cs).getUsername(), ((Serviceprovider) cs).getPassword(),new ArrayList<>());	
		}

		else {
			throw new UsernameNotFoundException("Invalid Username or Password");
		}
		
	}
	

}
