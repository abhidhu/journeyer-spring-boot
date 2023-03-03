package com.journeyer .controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.journeyer .modal.Customer;
import com.journeyer .modal.ERole;
import com.journeyer .modal.Role;
import com.journeyer .payload.request.LoginRequest;
import com.journeyer .payload.request.SignupRequest;
import com.journeyer .payload.response.JwtResponse;
import com.journeyer .payload.response.MessageResponse;
import com.journeyer .repository.Customerrepo;
import com.journeyer .repository.RoleRepository;
import com.journeyer .security.jwt.JwtUtils;
import com.journeyer .security.services.UserDetailsImpl;
import com.journeyer .services.CustomerService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class Customercontroller {
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	Customerrepo userRepository;
	
	@Autowired
	RoleRepository roleRepository;

	
	@Autowired
	CustomerService custservice;
	
	@Autowired
	  PasswordEncoder encoder;
	
	@Autowired
	  JwtUtils jwtUtils;

	//for checking
	@GetMapping(value = "/customers") 
	 public List<Customer> showCustomers()
	 {
		List<Customer> cus=userRepository.findAll();
		  return cus;
	 }
	
	//get customer by customer id
	@GetMapping(value = "/customer/{cid}")  
	 public List<Customer> showCustomersbyid(@PathVariable int cid)
	 {
		  return custservice.getcustomerbyid(cid);
	 }
	
	//for login
	@PostMapping("/login")
	  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    String jwt = jwtUtils.generateJwtToken(authentication);
	    
	    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());

	    return ResponseEntity.ok(new JwtResponse(jwt, 
	                         userDetails.getCust_Id(), 
	                         userDetails.getEmail(), 
	                         roles));
	  }
	
	
	//for signup
	@PostMapping("/signup")
	  public ResponseEntity<?> registerUser(@RequestBody SignupRequest  signUpRequest) {
		
		
		 System.out.println("Hello");
		 //Checking the user mobile is all ready present  or not
	    if (userRepository.existsByMobile(signUpRequest.getMobile())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Mobile Number is already taken!"));
	    }
	    
	  //Checking the user email is all ready present  or not
	    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
	      return ResponseEntity
	          .badRequest()
	          .body(new MessageResponse("Error: Email is already in use!"));
	    }

	    // Create new user's account
	    Customer user = new Customer(signUpRequest.getFirstname(),signUpRequest.getLastname(),
	    		signUpRequest.getEmail(),encoder.encode(signUpRequest.getPassword()),signUpRequest.getGender(),signUpRequest.getMobile(),signUpRequest.getDob()
	    		);
	    	
	    System.out.println(user);
	   
	    Set<String> strRoles = signUpRequest.getRole();
	    Set<Role> roles = new HashSet<>();

	    if (strRoles == null) {
	      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	      roles.add(userRole);
	    } else {
	      strRoles.forEach(role -> {
	        switch (role) {
	        case "admin":
	          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(adminRole);

	          break;
	        default:
	          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
	              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	          roles.add(userRole);
	        }
	      });
	    }
	    user.setRoles(roles);
	    userRepository.save(user);

	    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	    
	}	
}
