package com.api.emp.services;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.emp.Repository.EmpRepository;
import com.api.emp.entities.Employee;

@Service
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpRepository employeeRepository;
	
	
	    @Override
        public List<Employee> getAllEmployees(){
		List<Employee> list = (List<Employee>) this.employeeRepository.findAll();
		System.out.println("Get all employees"+list);
		return list;
		
	}
	 /*   @Override
        public Optional<Employee> getEmployeeById(Long empid) {
        	Optional<Employee> emp = null;
        	try {
    			emp = this.employeeRepository.findById(empid);
    			
    		}catch (Exception e) {
    			e.printStackTrace();
    			
    		}
    		return emp;
       		
       		
       	}
       	*/
	    
	    
	@Override
	public Employee addEmployee(Employee emp) {
			Employee newEmp = this.employeeRepository.save(emp);
			return newEmp;
	}
	
	@Override
	public void updateEmployee(Employee emp, Long empId) {
		emp.setEmpId(empId);
		employeeRepository.save(emp);
		
		
	}
	
	
	@Override
	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

}
