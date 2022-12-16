package com.dangtruong.entity;

import java.io.Serializable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@DiscriminatorValue("1")
public class Tester extends Employee {

    private Boolean automated;


}