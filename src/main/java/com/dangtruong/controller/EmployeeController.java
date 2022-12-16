package com.dangtruong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dangtruong.service.Employee.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity create() {
        try {
            employeeService.createEmployee();
            return ResponseEntity.ok("Create success");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-all")
    public ResponseEntity getAll() {
        try {
            return ResponseEntity.ok(employeeService.printEmployee());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update-salary")
    public ResponseEntity updateSalary() {
        try {
           
            return ResponseEntity.ok(employeeService.updateSalaryEmployee());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete() {
        try {
            employeeService.deleteEmployee();
            return ResponseEntity.ok("Delete success");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/get-all-employee-with-salary-year")
    public ResponseEntity getAllEmployeeWithSalaryYear() {
        try {
            return ResponseEntity.ok(employeeService.printEmployeeWithSalaryYear());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
