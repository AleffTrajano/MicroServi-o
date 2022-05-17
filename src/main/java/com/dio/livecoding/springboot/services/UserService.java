package com.dio.livecoding.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.livecoding.springboot.dto.UserDTO;
import com.dio.livecoding.springboot.model.UserModel;
import com.dio.livecoding.springboot.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private final UserRepository userRepository = null;
	
	public Iterable<UserModel> getUsers(){
		log.error("getUsers");
		return userRepository.findAll();
	}
	
	public UserModel getUsers(Long id) {
		return userRepository.findById(id).orElseThrow(()->
		{
			log.error("User not found with id{}",id);
			return new RuntimeException("User not found"+id);	
		});
	}
	
	public UserModel create(UserDTO userDTO) {
		
			UserModel userModel = UserModel.builder()
			.name(userDTO.getName())
			.email(userDTO.getEmail())
			.build();
		return userRepository.save(userModel);
	}
	public UserModel update(Long id, UserDTO userDTO) {
		UserModel userModel=userRepository.findById(id).orElseThrow(()->
		{
			log.error("User not found with id{}",id);
			return new RuntimeException("User not found"+id);	
		});
		
		userModel.setName(userDTO.getName());
		userModel.setEmail(userDTO.getEmail());
		return userRepository.save(userModel);
	}
	
	public UserModel delete(Long id) {
		UserModel userModel=userRepository.findById(id).orElseThrow(()->
		{
			log.error("User not found with id{}",id);
			return new RuntimeException("User not found"+id);	
		});
		
		userRepository.delete(userModel);
		return userModel;
	}
		
		
}