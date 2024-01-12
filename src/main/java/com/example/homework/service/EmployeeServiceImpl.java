package com.example.homework.service;


import com.example.homework.demo.Employee;

import com.example.homework.exteption.EmployeeNotFoundException;

import com.example.homework.exteption.EmployeeStorageIsFullException;

import com.example.homework.exteption.EmployeeAlreadyAddedException;

import org.springframework.stereotype.Service;


import java.util.List;


@Service

public class EmployeeServiceImpl implements EmployeeService {

    private final int STORAGE_SIZE = 5;


    private final List<Employee> employees = List.of(

            new Employee(" Иван  ", "Иванов"),

            new Employee(" Семен  ", "Горбунков "),

            new Employee("Петр  ", " Петров"),

            new Employee(" Николай ", "Николаев"),

            new Employee("  Федор  ", "Федоров"));


    @Override

    public Employee addEmployee(String name, String lastName) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {

        Employee employee = new Employee(name, lastName);


        if (employees.size() == STORAGE_SIZE) {

            throw new EmployeeStorageIsFullException("Хранилище заполнено");

        }


        if (employees.contains(employee)) {

            throw new EmployeeAlreadyAddedException("Сотрудник уже есть в хранилище");

        }


        employees.add(employee);

        return employee;


    }


    @Override


    public Employee removeEmployee(String name, String lastName) throws EmployeeNotFoundException {

        Employee employee = new Employee(name, lastName);


        if (!employees.contains(employee)) {

            throw new EmployeeNotFoundException("Такого  сотрудника нет в хранилище");

        }

        employees.remove(employee);


        return employee;

    }

    @Override

    public Employee findEmployee(String name, String lastName) throws EmployeeNotFoundException {

        Employee employeeFind = new Employee(name, lastName);


        if (!employees.contains(employeeFind)) {

            throw new EmployeeNotFoundException("Такого  сотрудника нет в хранилище");

        }

        for (Employee employee : employees) {

            if (employee.equals(employeeFind)) {

                return employee;

            }

        }

        return null;

    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

}