package com.api.emp.Repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.api.emp.entities.Employee;

@Service
public interface EmpRepository extends CrudRepository<Employee, Long> {


}
