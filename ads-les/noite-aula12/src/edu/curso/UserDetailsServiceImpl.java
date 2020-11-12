package edu.curso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String user) 
			throws UsernameNotFoundException {
		User u = userRepository.findUserByUserName(user);
		if (u == null) { 
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		UserDetails ud = new UserDetailsImpl( u );
		return ud;
	}
}
