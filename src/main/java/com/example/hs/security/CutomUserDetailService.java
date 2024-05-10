package com.example.hs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hs.entity.RolesEntity;
import com.example.hs.entity.UserEntity;
import com.example.hs.entity.UserRolesEntity;
import com.example.hs.repository.UserRepository;


@Service
public class CutomUserDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUserName(username)
										.orElseThrow(() -> new UsernameNotFoundException("username not found"));
		
		List<RolesEntity> listRoles = new ArrayList<>();
		listRoles.add(new RolesEntity(1,"ADMIN"));
		return new User(user.getUserName(), user.getPassword(), mapRolestoAuthorities(listRoles) );
	}
	
	private Collection<GrantedAuthority> mapRolestoAuthorities(List<RolesEntity> set){
		return set.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
	}

}
