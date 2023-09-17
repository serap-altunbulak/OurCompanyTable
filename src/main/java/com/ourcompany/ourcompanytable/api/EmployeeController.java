package com.ourcompany.ourcompanytable.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ourcompany.ourcompanytable.data.dto.EmployeeDto;
import com.ourcompany.ourcompanytable.data.entity.EmployeeEntity;
import com.ourcompany.ourcompanytable.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") String id) {
        return employeeService.findById(id);
    }


    @PostMapping
    public void addEmployee(@RequestBody EmployeeDto employeeDto) {
        System.out.println(employeeDto.getBDate());
        employeeService.addEmployee(employeeDto);
    }

    @PutMapping
    public void updateEmployee(@RequestBody EmployeeDto employeeDto) {
        employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteByID(id);
    }

}
