package com.RestApi.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.entity.Employee;
import com.RestApi.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController
{
	
@Autowired
EmployeeService ser;



@RequestMapping(value="/employees",method=RequestMethod.POST)
public Employee createEmployee(@RequestBody Employee emp)
{
	
	return ser.createEmployee(emp);
}	


@RequestMapping(value="/employees" ,method=RequestMethod.GET)
public List<Employee> readEmployee()
{
	return ser.getEmployee();
	
	
}


@RequestMapping(value="/employees",method=RequestMethod.PUT)
public Employee readEmployee(@PathVariable(value="empId") Long id,@RequestBody Employee empdetails)
{
return ser.updateEmployee(id, empdetails);	
	
	
}	


@RequestMapping(value="/employee/{empId}",method=RequestMethod.DELETE)
public void deleteemployee(@PathVariable(value ="empId") Long id)
{
	ser.deleteEmployee(id);
	
}

	
	
}



/*
@RequestMapping annotation on the class defines a base URL for all the REST APIs created in this controller.
 This base URL is followed by individual REST endpoints given to each of the controller methods.
@RestController on the class is a combination of:
@Controller - tells Spring Boot that this class is a controller.
@ResponseBody - indicates that the return value of the methods inside
 the controller will be returned as the response body for the REST API.
EmployeeService is injected as a dependency using @Autowired annotation


*/


/*
value - is the endpoint. In your case, it’s /employees. Note that the endpoint given in the value field is only “/employees” and not “/API/employees”. Since “/api” is common for all the endpoints, this was added as the base URL in the @RequestMapping annotation on the class.
method - this is the HTTP method type represented by an enum. For the create employee endpoint, the HTTP method is POST. Hence, you’ll add RequestMethod.POST as its value.
@RequestBody annotation is used to map the request body of the endpoint to the method parameter. emp will contain the request JSON passed to this endpoint.


*/