package com.ourcompany.ourcompanytable.service;

import com.ourcompany.ourcompanytable.data.dto.EmployeeDto;
import com.ourcompany.ourcompanytable.data.entity.EmployeeEntity;
import com.ourcompany.ourcompanytable.data.repository.EmployeeRepository;
import com.ourcompany.ourcompanytable.helper.mapper.EmployeeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeConverter employeeConverter;

    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(employeeConverter::employee2Dto).toList();
    }

    public EmployeeDto findById(String id) {
        if (employeeRepository.existsById(id)) {
            return employeeConverter.employee2Dto(employeeRepository.findById(id).get());
        }
        else {
            throw new IllegalArgumentException("(findById) id not found " + id);
        }
    }

    public void deleteByID(String id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        }
        else {
            throw new IllegalArgumentException("(deleteByID) id not found " + id);
        }
    }

    public void addEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(employeeConverter.employee2Entity(employeeDto));
    }

    public void updateEmployee(EmployeeEntity employeeEntity) {
        if(employeeRepository.existsById(employeeEntity.getGuid())) {
            employeeRepository.save(employeeEntity);
        }
        else {
            throw new IllegalArgumentException("(updateEmployee) employee not found " + employeeEntity);
        }
    }


}
