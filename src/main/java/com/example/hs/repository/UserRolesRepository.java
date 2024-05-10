package com.example.hs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hs.entity.UserEntity;
import com.example.hs.entity.UserRolesBridgeID;
import com.example.hs.entity.UserRolesEntity;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRolesEntity, UserRolesBridgeID>{
	
}
