package com.example.sisterslabspringhomework.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@RestController
@HttpExchange("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @HttpExchange("/create")
    public ResponseEntity<CreateEmployeeResponse> create(@RequestBody CreateEmployeeRequest request) {
        CreateEmployeeResponse response = employeeService.createEmployee(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @HttpExchange("/updateName")
    public ResponseEntity<UpdateEmployeeResponse> updateName(UpdateEmployeeRequest request) {
        return new ResponseEntity<>(employeeService.updateEmployeeName(request), HttpStatus.OK);
    }

    @HttpExchange("/get")
    public ResponseEntity<GetEmployeeResponse> get(GetEmployeeRequest request) {
        return new ResponseEntity<>(employeeService.getEmployee(request), HttpStatus.OK);
    }
    @HttpExchange("/getAll")
    public ResponseEntity<List<GetEmployeeResponse>> getAll() {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @HttpExchange("/delete")
    public void delete(DeleteEmployeeRequest request) {
        employeeService.deleteEmployee(request);
    }
}
