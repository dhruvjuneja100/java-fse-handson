package com.ormlearn.service;

import com.ormlearn.model.Employee;
import com.ormlearn.model.EmployeeProjection;
import com.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll() { return employeeRepository.findAll(); }
    public Employee getById(Long id) { return employeeRepository.findById(id).orElseThrow(); }
    public Employee save(Employee emp) { return employeeRepository.save(emp); }
    public void delete(Long id) { employeeRepository.deleteById(id); }

    public List<Employee> findByDepartment(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    public Page<Employee> getPage(int page, int size, String sortBy) {
        return employeeRepository.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

    @Transactional
    public List<EmployeeProjection> getProjection(String deptName) {
        return employeeRepository.findProjectedByDepartmentName(deptName);
    }
}
