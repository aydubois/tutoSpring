package org.tutoSpring.ponyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tutoSpring.ponyo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
