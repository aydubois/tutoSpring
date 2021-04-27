package org.tutoSpring.ponyo.controller;

import org.springframework.web.bind.annotation.*;
import org.tutoSpring.ponyo.entity.Employee;
import org.tutoSpring.ponyo.exception.EmployeeNotFoundException;
import org.tutoSpring.ponyo.repository.EmployeeRepository;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return  repository.findAll();
    }
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee){
        return  repository.save(newEmployee);
    }
    @GetMapping("/employees/{id}")
    Employee oneEmployee(@PathVariable Long id){
        return repository.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));
    }
    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return repository.findById(id).map(
                employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                }
        ).orElseGet(()->{
            newEmployee.setId(id);
            return repository.save(newEmployee);
        });
    }
    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
