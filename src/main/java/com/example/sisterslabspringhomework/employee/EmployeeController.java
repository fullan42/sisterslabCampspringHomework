package com.example.sisterslabspringhomework.employee;

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
    public CreateEmployeeResponse create(CreateEmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @HttpExchange("/updateName")
    public UpdateEmployeeResponse updateName(UpdateEmployeeRequest request) {
        return employeeService.updateEmployeeName(request);
    }

    @HttpExchange("/get")
    public GetEmployeeResponse get(GetEmployeeRequest request) {
        return employeeService.getEmployee(request);
    }
    @HttpExchange("/getAll")
    public List<GetEmployeeResponse> getAll() {
        return employeeService.getAllEmployees();
    }

    @HttpExchange("/delete")
    public void delete(DeleteEmployeeRequest request) {
        employeeService.deleteEmployee(request);
    }
}
