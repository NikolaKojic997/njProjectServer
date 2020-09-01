package com.njProjectServer.repository;

import com.njProjectServer.model.Employee;
import com.njProjectServer.model.UserProfile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface EmployeeRepository extends EmployeeBaseRepository<Employee> {
    Optional<Employee> findByIdentificationNumber(String identificationNumber);
}
