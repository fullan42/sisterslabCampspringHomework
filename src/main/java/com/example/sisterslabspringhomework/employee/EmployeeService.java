package com.example.sisterslabspringhomework.employee;

import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        Employee employee = new Employee(request.name(), request.role());

        Employee save = employeeRepository.save(employee);

        return CreateEmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .role(employee.getRole())
                .build();

    }
    public UpdateEmployeeResponse updateEmployeeName(UpdateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(request.id()).orElse(null);
        employee.setName(request.name());
        Employee save = employeeRepository.save(employee);
        return UpdateEmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .role(employee.getRole())
                .build();
    }

    public GetEmployeeResponse getEmployee(GetEmployeeRequest request) {
        Employee employee = employeeRepository.findById(request.id()).orElse(null);
        return GetEmployeeResponse.builder()
                .id(employee.getId())
                .name(employee.getName())
                .role(employee.getRole())
                .build();
    }
    public List<GetEmployeeResponse> getAllEmployees() {
        List<Employee> all = employeeRepository.findAll();
        return all.stream()
                .map(employee -> GetEmployeeResponse.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .role(employee.getRole())
                        .build())
                .toList();
    }

    public void deleteEmployee(DeleteEmployeeRequest request) {
        employeeRepository.deleteById(request.id());
    }
}
