package com.practise.practice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.lang.model.element.NestingKind;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Employee_Id")
    private String employeeId;
    @Column(name = "Department of Raw")
    private String department;
    @Column(name = "Address")
    private String address;
    @Column(name ="Date_of_joining")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTime;

}
//@Entity
//@Data
//@NoArgsConstructor
//@Table(name = "employee")
//public class Employee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY )
//    private long id;
//    private String name;
//    private String address;
//    private int employeeId;
////    private String department;
//
//
//}
