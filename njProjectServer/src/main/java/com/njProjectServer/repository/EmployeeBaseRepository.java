package com.njProjectServer.repository;

import com.njProjectServer.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmployeeBaseRepository  <T extends Employee> extends JpaRepository<T, Integer> {
}
