package com.dangtruong.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dangtruong.entity.Employee;
import com.dangtruong.entity.Tester;

@Repository
public interface TesterRepo extends JpaRepository<Tester, Long>{

}
