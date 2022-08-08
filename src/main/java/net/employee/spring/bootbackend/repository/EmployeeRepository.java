package net.employee.spring.bootbackend.repository;

import net.employee.spring.bootbackend.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel,Long>{
}
