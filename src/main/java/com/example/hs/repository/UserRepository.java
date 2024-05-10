package com.example.hs.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hs.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>{
	Optional<UserEntity> findById(Integer id);
	
	Optional<UserEntity> findByUserName(String userName);
	
//	Boolean findByUserNameTrue(String userName);
}
