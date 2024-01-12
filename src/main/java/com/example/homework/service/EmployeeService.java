package com.example.homework.service;

import com.example.homework.demo.Employee;
import com.example.homework.exteption.EmployeeAlreadyAddedException;
import com.example.homework.exteption.EmployeeNotFoundException;
import com.example.homework.exteption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.List;


    @Service


    public interface EmployeeService {

        Employee addEmployee (String name, String lastName)throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException;

        Employee removeEmployee (String name, String lastName)throws EmployeeNotFoundException;


        Employee findEmployee  (String name, String lastName)throws EmployeeNotFoundException;


        List<Employee> getAllEmployees();

    }