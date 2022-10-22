package com.example.stream_API.controller;

import com.example.stream_API.model.Employee;
import com.example.stream_API.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/employee")
    public class EmployeeController {
        private final EmployeeService employeeService;

        public EmployeeController(EmployeeService employeeService) {
            this.employeeService = employeeService;
        }

        @GetMapping(path = "/add")
        public Object addEmployee(
                @RequestParam(value = "firstName") String firstName,
                @RequestParam(value = "lastName") String lastName,
                @RequestParam(value = "salary") int salary,
                @RequestParam(value = "department") int department) {
            Employee employee = null;
            try {
                employee = employeeService.addEmployee(firstName, lastName, salary, department);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping(path = "/remove")
        public Object removeEmployee(
                @RequestParam(value = "firstName") String firstName,
                @RequestParam(value = "lastName") String lastName) {
            Employee employee = null;
            try {
                employee = employeeService.removeEmployee(firstName, lastName);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping(path = "/find")
        public Object findEmployee(
                @RequestParam(value = "firstName") String firstName,
                @RequestParam(value = "lastName") String lastName) {
            Employee employee = null;
            try {
                employee = employeeService.findEmployee(firstName, lastName);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping(path = "/departments/max-salary")
        public Object getHighestPaidEmployee(
                @RequestParam(value = "departmentId") int departmentId) {
            Employee employee = null;
            try {
                employee = employeeService.getHighestPaidEmployee(departmentId);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping(path = "/departments/min-salary")
        public Object getLowestPaidEmployee(
                @RequestParam(value = "departmentId") int departmentId) {
            Employee employee = null;
            try {
                employee = employeeService.getLowestPaidEmployee(departmentId);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employee;
        }

        @GetMapping(path = "/departments/all", params = "departmentId")
        public Object printEmployeesForDepartment(
                @RequestParam(value = "departmentId") int departmentId) {
            List<Employee> employees = null;
            try {
                employees = employeeService.printEmployeesForDepartment(departmentId);
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employees;
        }

        @GetMapping(path = "/departments/all")
        public Object printEmployeesByDepartments() {
            List<Employee> employees = null;
            try {
                employees = employeeService.printEmployeesByDepartments();
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employees;
        }

        @GetMapping(path = "/print")
        public Object printEmployees() {
            List<Employee> employees = null;
            try {
                employees = employeeService.printEmployees();
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employees;
        }

        @GetMapping(path = "/fill")
        public Object fillEmployeesList() {
            List<Employee> employees = null;
            try {
                employees = employeeService.fillEmployeesList();
            } catch (Throwable e) {
                return e.getMessage();
            }
            return employees;
        }
    }
