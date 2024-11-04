package com.practise.practice.service;

import com.practise.practice.model.Employee;
import com.practise.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        all.sort(Comparator.comparing(Employee::getEmployeeId));
        return all;
    }
    public  Employee getEmployeeID(Integer id){

        return employeeRepository.findById(id).orElse(null);

    }
    public  Employee getEmployee(String name){

       return employeeRepository.findByName(name);
    }
    public Employee addEmployee(Employee employee){
        Employee employee1 = new Employee();
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setName(employee.getName());
        employee1.setAddress(employee.getAddress());
        employee1.setDepartment(employee.getDepartment());
        return employeeRepository.save(employee1);
    }
    public Employee updateEmployee(Employee employee, Integer id){
        Employee byId = employeeRepository.getById(id);
        if (employee == null) {
            throw new RuntimeException("Employee not found :");
        }
        byId.setEmployeeId(employee.getEmployeeId());
        byId.setDepartment(employee.getDepartment());
        byId.setName(employee.getName());
        byId.setAddress(employee.getAddress());
        return employeeRepository.save(byId);
    }
    public void deleteEmployee(Integer id){
            employeeRepository.deleteById(id);
    }


}
