package com.example.hs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.hs.entity.RolesEntity;

@Repository
public interface RolesRepository extends CrudRepository<RolesEntity, Integer> {

}
