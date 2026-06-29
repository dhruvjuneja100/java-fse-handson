package com.ormlearn.controller;

import com.ormlearn.model.Employee;
import com.ormlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAll() { return employeeService.getAll(); }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) { return employeeService.getById(id); }

    @PostMapping
    public Employee create(@RequestBody Employee emp) { return employeeService.save(emp); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        Employee existing = employeeService.getById(id);
        existing.setName(emp.getName());
        existing.setEmail(emp.getEmail());
        return employeeService.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page")
    public Page<Employee> getPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return employeeService.getPage(page, size, sortBy);
    }

    @GetMapping("/department/{deptName}")
    public List<Employee> getByDepartment(@PathVariable String deptName) {
        return employeeService.findByDepartment(deptName);
    }
}
