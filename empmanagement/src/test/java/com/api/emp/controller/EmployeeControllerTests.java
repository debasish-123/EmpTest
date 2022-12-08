package com.api.emp.controller;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import com.api.emp.Repository.EmpRepository;
import com.api.emp.entities.Employee;
import com.api.emp.services.EmpServiceImpl;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTests {
	
	
	@InjectMocks
	private EmpServiceImpl empService;
	
	@Mock
	private EmpRepository empRepository;
	
	@Test
	public void getEmployeesTest() {
		
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(982, "Hello", "World", 40, 10000));
		emp.add(new Employee(983, "Ankit", "Kumar", 50, 20000));
		emp.add(new Employee(984, "Asutosh", "Satpathy", 50, 45000));
		emp.add(new Employee(985, "Suhana", "Triapthy", 50, 40000));
		
		when(empService.getAllEmployees()).thenReturn(emp);
		List<Employee> emp2 = empService.getAllEmployees();
//    assertEquals(2, emp2.size());
//		verify(mock(employeeService), times(1)).getAllEmployees();

		assertThat(emp2).isNotNull();
		assertThat(emp2.size()).isEqualTo(4);
	}
	
	@Test
	public void AddEmployeeTest(){
		
		
		Employee emp= new Employee(987,"Hello","World",40,7650);
		when(empRepository.save(emp)).thenReturn(emp);
		
		Employee newEmp = empService.addEmployee(emp);
		System.out.println(newEmp);
		assertThat(newEmp).isNotNull();
	}
	
	
	
	 @Test
	 public void UpdateEmployeeTest() {
	    	Employee emp= new Employee(985,"Ram","Satpathy",40,10000);
	    	when(empRepository.save(emp)).thenReturn(emp);
	    	emp.setAge(50);
	    	emp.setFirstName("Anmol");
	    	emp.setLastName("Sharma");
	    	emp.setSalary(20000);
	    	
	    	Employee newEmployee=empService.addEmployee(emp);
	    	
	    	assertThat(newEmployee.getAge()).isEqualTo(50);
	    	assertThat(newEmployee.getFirstName()).isEqualTo("Anmol");
	    	assertThat(newEmployee.getLastName()).isEqualTo("Sharma");
	    	assertThat(newEmployee.getSalary()).isEqualTo(20000);
	    }
	 
	    @Test
	    public void DeleteEmployeeTest() {
	    	long empid=985;
	    	willDoNothing().given(empRepository).deleteById(empid);
	    	empService.deleteEmployee(empid);
	    	verify(empRepository, times(1)).deleteById(empid);
  }



}



