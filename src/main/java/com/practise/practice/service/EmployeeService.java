package com.practise.practice.service;

import com.practise.practice.model.Employee;
import com.practise.practice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee(){
        List<Employee> all = employeeRepository.findAll();
        all.sort(Comparator.comparing(Employee::getEmployeeId));
        return all;
    }
    public Employee getEmployeeId(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
    public String findEmployeeName(String name) {
        Employee employee = employeeRepository.findByName(name);
        if (employee != null) {
            return "Employee name is: " + employee.getName();
        }
        else {
            return "Employee not found"; }
    }

    public Employee saveEmpolyee(Employee employee){
        Employee employee1 = new Employee();
        employee1.setName(employee.getName());
        employee1.setDepartment(employee.getDepartment());
        employee1.setEmployeeId(employee.getEmployeeId());
        employee1.setAddress(employee.getAddress());
        employee1.setDateTime(employee.getDateTime());
        return employeeRepository.save(employee1);
    }

    public Employee upDateEmployee(Employee employee, Long id){
        Employee byId = employeeRepository.getById(id);
        byId.setName(employee.getName());
        byId.setEmployeeId(employee.getEmployeeId());
        byId.setAddress(employee.getAddress());
        byId.setDepartment(employee.getDepartment());
        byId.setDateTime(employee.getDateTime());
        return employeeRepository.save(byId);
    }

    public void deletEmployee(Long id){
          employeeRepository.deleteById(id);
    }

}
//@Service
//public class EmployeeService {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    public List<Employee> getAllEmployee() {
//        List<Employee> all = employeeRepository.findAll();
//        all.sort(Comparator.comparing(Employee::getEmployeeId));
//        return all;
//
//    }
//    public  Employee getEmployeeID(Integer id){
//
//        return employeeRepository.findById(id).orElse(null);
//
//    }
//    public  Employee getEmployee(String name){
//
//       return employeeRepository.findByName(name);
//    }
//    public Employee addEmployee(Employee employee){
//        Employee employee1 = new Employee();
//        employee1.setEmployeeId(employee.getEmployeeId());
//        employee1.setName(employee.getName());
//        employee1.setAddress(employee.getAddress());
//        employee1.setDepartment(employee.getDepartment());
//        return employeeRepository.save(employee1);
//    }
//    public Employee updateEmployee(Employee employee, Integer id){
//        Employee byId = employeeRepository.getById(id);
//        if (employee == null) {
//            throw new RuntimeException("Employee not found :");
//        }
//        byId.setEmployeeId(employee.getEmployeeId());
//        byId.setDepartment(employee.getDepartment());
//        byId.setName(employee.getName());
//        byId.setAddress(employee.getAddress());
//        return employeeRepository.save(byId);
//    }
//    public void deleteEmployee(Integer id){
//            employeeRepository.deleteById(id);
//    }
//}
