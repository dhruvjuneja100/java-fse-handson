package com.ormlearn.service;

import com.ormlearn.model.Department;
import com.ormlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAll() { return departmentRepository.findAll(); }
    public Department getById(Long id) { return departmentRepository.findById(id).orElseThrow(); }
    public Department save(Department dept) { return departmentRepository.save(dept); }
    public void delete(Long id) { departmentRepository.deleteById(id); }
}
