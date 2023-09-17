package com.ourcompany.ourcompanytable.data.repository;

import com.ourcompany.ourcompanytable.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
    public EmployeeEntity findEmployeeEntityByName (String name);

    public boolean existsEmployeeEntityByName (String name);
}
