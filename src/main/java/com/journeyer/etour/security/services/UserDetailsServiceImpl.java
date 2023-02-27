package com.journeyer.etour.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.journeyer.etour.modal.Customer;
import com.journeyer.etour.repository.Customerrepo;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  Customerrepo userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Customer user = userRepository.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with Email Id: " + email));

    return UserDetailsImpl.build(user);
  }

}
