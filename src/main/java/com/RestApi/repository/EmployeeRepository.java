package com.RestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RestApi.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	
	
}



/*

The @Repository on the class indicates that the class is a data repository that will contain CRUD operations. CRUD is an acronym that stands for the four basic operations of the database - Create, Read, Update, Delete.

The EmployeeRepository extends JpaRepository. You have two parameters passed to the JpaRepository - first parameter is the model class that will be managed by this repository, second is the data type of the primary key.

The JpaRepository interface provided by Spring Data JPA makes it possible for the repository class to retrieve, update, delete records in the employee table.

This interface also defines methods such as save(), findAll() , delete(), to operate on the database. The implementation of these methods is provided by the default implementation class called SimpleJpaRepository. You have to make a call to these methods thus saving you from writing queries for these operations.

In the next section you’ll create the service class that will call the JpaRepository implementation methods.



*/