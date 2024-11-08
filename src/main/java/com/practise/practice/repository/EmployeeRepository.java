package com.practise.practice.repository;

import com.practise.practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByName(String name);

//    Employee findName(String name);
}
