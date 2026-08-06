package com.example.session_7_employee_ms.repository;

import com.example.session_7_employee_ms.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> findByDepartment (String department);

    public List<Employee> findBySalaryGreaterThan (BigDecimal salary);

    public List<Employee> findByLastNameContaining (String text);

    public List<Employee> findByDepartmentAndSalaryGreaterThan (String department, BigDecimal salary);

    //create a repository method that returns all employees hired
    //after a given date
    @Query("SELECT e FROM Employee e WHERE e.hireDate > :givenHireDate")
    public List<Employee> findByHiredAfter (@Param("givenHireDate") LocalDate hireDate);

    //Using a native SQL query, create a repository method that returns all employees whose salary is
    //greater than a given amount.
    @Query(value = "SELECT * FROM employee WHERE salary > :givenSalary", nativeQuery = true)
    public List<Employee> findBySalaryGreaterThanGiven(@Param("givenSalary") BigDecimal salary);

    //Retrieve all employees sorted by salary in descending order
    //@Query(value = "")

    public List<Employee> findByOrderBySalaryDesc ();
}
