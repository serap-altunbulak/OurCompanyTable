package com.ourcompany.ourcompanytable.helper.mapper;

import com.ourcompany.ourcompanytable.data.dto.EmployeeDto;
import com.ourcompany.ourcompanytable.data.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {
    public EmployeeDto employee2Dto(EmployeeEntity employeeEntity) {
        return new EmployeeDto(employeeEntity.getName(), employeeEntity.getBDate());
    }
    public EmployeeEntity employee2EntityWithId(EmployeeDto employeeDto, String id) {
        return new EmployeeEntity(id, employeeDto.getName(), employeeDto.getBDate());
    }

    public EmployeeEntity employee2Entity(EmployeeDto employeeDto) {
        return new EmployeeEntity(employeeDto.getName(), employeeDto.getBDate());
    }
}
