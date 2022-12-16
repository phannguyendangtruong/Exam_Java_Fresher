package com.dangtruong.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dangtruong.entity.Developer;
import com.dangtruong.entity.Employee;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Integer> {

}
