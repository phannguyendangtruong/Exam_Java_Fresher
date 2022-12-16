package com.dangtruong.service.impl.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.dangtruong.dto.EmployeeDTO;
import com.dangtruong.dto.EmployeeDetailDTO;
import com.dangtruong.entity.Developer;
import com.dangtruong.entity.Employee;
import com.dangtruong.entity.Tester;
import com.dangtruong.repository.DeveloperRepo;
import com.dangtruong.repository.EmployeeRepo;
import com.dangtruong.repository.TesterRepo;
import com.dangtruong.service.Employee.EmployeeService;

@Service
@Order(Ordered.HIGHEST_PRECEDENCE)
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private DeveloperRepo developerRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TesterRepo testerRepo;

    @Override
    public void createEmployee() {


        // create 5 developer and 5 employee
        String skills[] = new String[]{"Java","Python","C++","C#","Ruby"};
        String firstName[] = new String[]{"Dang","Truong","Nguyen","Phan","Nguyen","Pham","Tran","Doan","Ho","Dang"};
        String lastName[] = new String[]{"An","Linh","Binh","Quynh","Phi","Nghia","Thang","Vy","Hoa","Huong"};
        for(int i = 0; i < 5; i++) {
            Developer developer = new Developer();
            developer.setSalaryMonthly(2000.0*(i+1));
            developer.setFirstName(firstName[i]);
            developer.setLastName(lastName[i]);
            developer.setProgrammingLanguage(skills[i]);
            developerRepo.save(developer);
        }


        // //create 5 tester
        Boolean auto[] = new Boolean[] {true,false,true,false,true};
        for(int i = 5; i < 10; i++) {
            Tester tester = new Tester();
            tester.setSalaryMonthly(1000.0*i);
            tester.setAutomated(auto[i-5]);
            tester.setFirstName(firstName[i]);
            tester.setLastName(lastName[i]);
            testerRepo.save(tester);
        }
    }

    @Override
    public List<EmployeeDetailDTO> updateSalaryEmployee() {
        List<Employee> employee = employeeRepo.findAll();
        employee.forEach(employee2 -> {
            employee2.setSalaryMonthly(employee2.getSalaryMonthly() + (employee2.getSalaryMonthly() * 0.1));
            employeeRepo.save(employee2);
        });
        return printEmployee();
        
    }

    @Override
    public List<EmployeeDetailDTO> printEmployee() {
        List<Tester> tester = testerRepo.findAll();
        List<EmployeeDetailDTO> employee = developerRepo.findAll().stream().map(developer2 -> modelMapper.map(developer2, EmployeeDetailDTO.class)).collect(Collectors.toList());
        for(int i = 0; i < tester.size(); i++) {
            employee.add(modelMapper.map(tester.get(i), EmployeeDetailDTO.class));
        }
        return employee;
        
    }

    @Override
    public void deleteEmployee() {
        List<Employee> employee = employeeRepo.findAll();
        //delete employee salary min top 2
        employee.stream().sorted((e1, e2) -> e1.getSalaryMonthly().compareTo(e2.getSalaryMonthly())).limit(2).forEach(employee2 -> {
            employeeRepo.delete(employee2);
        });
         
    }

    @Override
    public List<EmployeeDetailDTO> printEmployeeWithSalaryYear() {
        // print emploiyee with salary year
        List<Employee> employee = employeeRepo.findAll();
        List<EmployeeDetailDTO> employeeDetailDTO = new ArrayList<>();
        employee.forEach(employee2 -> {
            EmployeeDetailDTO employeeDetailDTO2 = modelMapper.map(employee2, EmployeeDetailDTO.class);
            employeeDetailDTO2.setSalaryYearly(employee2.getSalaryMonthly() * 12);
            employeeDetailDTO.add(employeeDetailDTO2);
        });
        return employeeDetailDTO;
    }
    
}
