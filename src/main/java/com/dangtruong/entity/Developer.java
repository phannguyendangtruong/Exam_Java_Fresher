package com.dangtruong.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Data
public class Developer extends Employee {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;
    
    private String programmingLanguage;

   

  
}
