package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl 
			implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
//	public UserDetailServiceImpl(UserRepository ur) { 
//		this.userRepository = ur;
//	}

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		User u = userRepository.getUsersByUserName(user);
		
		if (u == null) { 
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return new UserDetailImpl(u);
	}

}
