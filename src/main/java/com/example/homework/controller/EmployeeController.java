package com.example.homework.controller;

import com.example.homework.demo.Employee;
import com.example.homework.service.EmployeeServiceImpl;
import com.example.homework.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/emploee")

public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")

    public Employee addEmployee(

            @RequestParam(value = "name") String name,

            @RequestParam(value = "lasName") String lastName

    ) {

        return employeeService.addEmployee(name, lastName);

    }


    @GetMapping("/remove")

    public Employee removeEmployee(

            @RequestParam(value = "name") String name,

            @RequestParam(value = "lastName") String lastName

    ) {

        return employeeService.removeEmployee(name, lastName);

    }


    @GetMapping("/find")

    public Employee findEmployee(

            @RequestParam(value = "name") String name,

            @RequestParam(value = "lastName") String lastName

    ) {

        return employeeService.findEmployee(name, lastName);

    }


    @GetMapping("/allEmployees")


    public List<Employee> getAllEmployees() {


        return employeeService.getAllEmployees();

    }
}
