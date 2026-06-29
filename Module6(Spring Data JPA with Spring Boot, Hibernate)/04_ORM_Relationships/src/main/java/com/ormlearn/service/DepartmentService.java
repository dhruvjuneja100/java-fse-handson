package com.ormlearn.service;

import com.ormlearn.model.Department;
import com.ormlearn.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Department get(int id) {
        LOGGER.info("Start");
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found: " + id));
    }

    @Transactional
    public void save(Department department) {
        LOGGER.info("Start");
        departmentRepository.save(department);
        LOGGER.info("End");
    }
}
