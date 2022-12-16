package com.dangtruong.service.Employee;

import java.util.List;

import com.dangtruong.entity.Developer;
import com.dangtruong.dto.EmployeeDTO;
import com.dangtruong.dto.EmployeeDetailDTO;

public interface EmployeeService {
    
    void createEmployee();

    List<EmployeeDetailDTO> updateSalaryEmployee();

    List<EmployeeDetailDTO> printEmployee();

    void deleteEmployee();

    List<EmployeeDetailDTO> printEmployeeWithSalaryYear();


}
