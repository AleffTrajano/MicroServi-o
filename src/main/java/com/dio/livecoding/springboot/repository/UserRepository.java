package com.dio.livecoding.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dio.livecoding.springboot.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
