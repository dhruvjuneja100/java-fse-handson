package com.ormlearn.controller;

import com.ormlearn.model.Department;
import com.ormlearn.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAll() { return departmentService.getAll(); }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) { return departmentService.getById(id); }

    @PostMapping
    public Department create(@RequestBody Department dept) { return departmentService.save(dept); }

    @PutMapping("/{id}")
    public Department update(@PathVariable Long id, @RequestBody Department dept) {
        Department existing = departmentService.getById(id);
        existing.setName(dept.getName());
        return departmentService.save(existing);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        departmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
