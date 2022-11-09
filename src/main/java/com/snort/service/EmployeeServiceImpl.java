package com.snort.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snort.entity.Employee;
import com.snort.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		log.info("EmployeeServiceImpl: getAllEmployees() has executed");
		return employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		
		log.info("EmployeeServiceImpl: saveEmployee() has executed");
		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		log.info("EmployeeServiceImpl: getEmployeeById() has executed");
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		
		if(optional.isPresent()) {
			employee = optional.get();
		}else {
			throw new RuntimeException("Employee not found for id::"+id);
		}
		return employee;
	}


	@Override
	public void deleteEmployeeById(long id) {
		log.info("EmployeeServiceImpl: deleteEmployeeById() has executed");
		this.employeeRepository.deleteById(id);
	}

	@Override
	public List<Employee> findByFirstname(String firstname) {
		log.info("EmployeeServiceImpl: findByFirstName() has executed");
		return employeeRepository.findByFirstname(firstname);
	}

	@Override
	public List<Employee> findByEmail(String Email) {
		log.info("EmployeeServiceImpl: findByEmail() has executed");
		return employeeRepository.findByEmail(Email);
	}

	@Override
	public List<Employee> findByPhone(String phone) {
		log.info("EmployeeServiceImpl: findByPhone() has executed");
		return employeeRepository.findByPhone(phone);
	}


}
