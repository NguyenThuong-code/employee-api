package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
@Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee){
    employee.setEmployeeCode(UUID.randomUUID().toString());
    return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployee(){
    return employeeRepo.findAll();
    }
    public Optional<Employee> findById(Long id) {
        return employeeRepo.findById(id);
    }
    public Employee updateEmployee(Employee employee){
    return employeeRepo.save(employee);
    }
    public Employee findEmployeeById(Long id){
    return employeeRepo.findEmployeeById(id)
            .orElseThrow(()->new UserNotFoundException("User by id "+ id+" was not found"));
    }
public void deleteEmployee(Long id){
    employeeRepo.deleteById(id);
}
}