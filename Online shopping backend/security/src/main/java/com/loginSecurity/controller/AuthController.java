package com.loginSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginSecurity.model.AuthenticationRequest;
import com.loginSecurity.model.AuthenticationResponse;
import com.loginSecurity.model.UserModel;
import com.loginSecurity.repository.UserRepository;
import com.loginSecurity.services.UserServices;
import com.loginSecurity.utils.JwtUtils;

@RestController
@CrossOrigin
public class AuthController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServices userServices;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	@GetMapping("/dashboard")
	private String testingToken() {
		return "Welcome to DASHBOARD "+ SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	//to add new user
	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		UserModel userModel=new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(new BCryptPasswordEncoder().encode(password));
		try {
			userRepository.save(userModel);
		}
		catch(Exception e) {
			throw new Exception("error",e);
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client "+ username));
		
	}
	
	//to authenticate existing user
	@PostMapping("/auth")
    private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(Exception e) {
			throw new Exception("invalid",e);

		}
		UserDetails loadeduser=userServices.loadUserByUsername(username);
		String generatedToken=jwtUtils.generateToken(loadeduser);
		
		return ResponseEntity.ok(new AuthenticationResponse(generatedToken));

	}
	

}
