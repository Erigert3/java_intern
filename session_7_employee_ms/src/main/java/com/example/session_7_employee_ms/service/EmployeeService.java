package com.example.session_7_employee_ms.service;

import com.example.session_7_employee_ms.entity.Employee;
import com.example.session_7_employee_ms.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {


    private final EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByDepartment (String department){
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesBySalaryGreaterThan(BigDecimal salary){
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public List<Employee> getEmployeesByLastNameContaining (String text){
        return employeeRepository.findByLastNameContaining(text);
    }

    public List<Employee> getEmployeesByDepartmentAndSalaryGreaterThan (String department, BigDecimal salary){
        return employeeRepository.findByDepartmentAndSalaryGreaterThan(department, salary);
    }

    public List<Employee> getEmployeesByHiredAfter (LocalDate date){
        return employeeRepository.findByHiredAfter(date);
    }

    public List<Employee> getEmployeesBySalaryGreaterThanGiven (BigDecimal salary){
        return employeeRepository.findBySalaryGreaterThanGiven(salary);
    }

    public Page<Employee> getFirstPageOfEmployees(){
        Pageable pageable = PageRequest.of(0, 5);
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getAllEmployeesSortedBySalaryDescending(){
        return employeeRepository.findByOrderBySalaryDesc();
    }



}
