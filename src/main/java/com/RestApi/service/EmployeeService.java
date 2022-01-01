package com.RestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.entity.Employee;
import com.RestApi.repository.EmployeeRepository;

@Service
public class EmployeeService
{
	@Autowired
	EmployeeRepository repo;
	
	
	
//create 

public Employee createEmployee(Employee emp)
{
	return repo.save(emp);
	
}


// read

public List<Employee> getEmployee()
{
return repo.findAll();	
	
}	
	
	
//	delete

public void deleteEmployee(Long empId)
{
    repo.deleteById(empId);

}

// update	
	
public Employee updateEmployee(Long empId,Employee empdetail)
{
	
	Employee emp=repo.findById(empId).get();
	
	emp.setFirst_name(empdetail.getFirst_name());
	emp.setLast_name(empdetail.getLast_name());
	emp.setEmail(empdetail.getEmail());
	
	return repo.save(emp);
	
}	
	
}



/*
In Spring, you use @Autowired annotation for instantiating a class object.

The @Repository annotation from the EmployeeRepository class enabled the creation of a bean of this class through the @ComponentScan feature of Spring. This bean is then used in the service class using @Autowired annotation. This is called Dependency Injection in Spring.

You’ll now create methods in the service layer. Each of these methods will call JpaRepository methods extended by EmployeeRepository.

Add these methods to the EmployeeService class after EmployeeRepository empRepository:


*/


/*

The createEmployee method calls the empRepository.save() function, which will return the Employee object after saving it to the database. The parameter passed to the createEmployee method is the Employee model containing all the details to save.
Similarly, getEmployees() and deleteEmployee() call the respective JpaRepository methods extended by EmployeeRepository.
The findAll() function returns the list of all employee details in the database.
The deleteById(empId) function will delete an employee record where the emp_id in the table is equal to the empId passed.


*/



/*
The updateEmployee method accepts two parameters - an employee ID (primary key) and the employee object containing the new employee details.
To update an existing employee, you’ll first retrieve the employee object where employee ID in the database equals empId and store it in the emp variable.
After getting the old employee object, you’ll use the setters defined in Employee.java to update the fields with new values stored in employeeDetails.
Lastly, the empRespository.save(emp) function will save the updated emp object to the database.

*/
