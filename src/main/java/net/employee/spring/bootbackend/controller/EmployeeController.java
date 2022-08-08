package net.employee.spring.bootbackend.controller;

import net.employee.spring.bootbackend.exception.ResourceNotFoundException;
import net.employee.spring.bootbackend.model.EmployeeModel;
import net.employee.spring.bootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<EmployeeModel> getAllEmployees() {

        return (List<EmployeeModel>) employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable(value = "id") Long id) {

        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(employeeModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable(value = "id") Long id,@RequestBody
    EmployeeModel empdetails) {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employeeModel.setEmp_name(empdetails.getEmp_name());
        employeeModel.setEmail_id(empdetails.getEmail_id());
        employeeModel.setSalary(empdetails.getSalary());

        final EmployeeModel updatedEmployee = employeeRepository.save(employeeModel);

        return ResponseEntity.ok(updatedEmployee);

    }

    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus>DeleteEmployee(@PathVariable Long id)
    {
        EmployeeModel employeeModel = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employeeRepository.delete(employeeModel);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }


}

