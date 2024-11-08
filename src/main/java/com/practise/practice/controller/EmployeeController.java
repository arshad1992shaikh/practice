package com.practise.practice.controller;

import com.practise.practice.model.Employee;
import com.practise.practice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController{
    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }@GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable Long id){
        return employeeService.getEmployeeId(id);
    }
    @GetMapping("/name/{name}")
    public String getEmployeeName(@PathVariable String name){
        return employeeService.findEmployeeName(name);
    }
    @PostMapping("/addEmployee")
    public Employee saveEmpolyee(@RequestBody Employee employee){
        return  employeeService.saveEmpolyee(employee);
    }
    @PutMapping("/updateEmployee")
    public Employee upDateEmployee(@RequestBody Employee employee, @PathVariable Long id){
        Employee employee1 = employeeService.upDateEmployee(employee, id);

        return employee1;
    }
    @DeleteMapping("/{id}")
    public String deletEmployee(@PathVariable Long id){
         employeeService.deletEmployee(id);
         return "deleted succesfully ;"+id;
    }
}

//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//
//    @Autowired
//    EmployeeService employeeService;
//
//    @GetMapping
//    public List<Employee> getAllEmployee() {
//        return employeeService.getAllEmployee();
//    }
//    @GetMapping("/{id}")
//    public Employee getById(@PathVariable Integer id){
//        Employee employee = employeeService.getEmployeeID(id);
//        if ( employee == null) {
//
//            throw new RuntimeException("Student not found");
////        }
////        return employee;
//
//    }
//    @GetMapping("/name/{name}")
//    public  Employee getEmployee(@PathVariable String name){
//        Employee employee = employeeService.getEmployee(name);
//        if (employee == null) {
//            throw new RuntimeException("Employee not found :");
//        }
//
//        return employee;
//    }
//    @PostMapping("/addEmployee")
//    public Employee addEmployee(@RequestBody Employee employee){
//        return employeeService.addEmployee(employee);
//    }
//
//    @PutMapping("/updateEmployee/{id}")
//    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer id){
//        if (id == null) {
//            throw new RuntimeException("Employee not found :");
//        }
//        return employeeService.updateEmployee(employee, id);
//    }
//
//    @DeleteMapping("/{id}")
//    public String deleteEmployee(@PathVariable Integer id){
//        if (id  == null) {
//            throw new RuntimeException("Employee not found :");
//        }
//        employeeService.deleteEmployee(id);
//        return "successfull delete "+id+" Employee";
//    }
//}
