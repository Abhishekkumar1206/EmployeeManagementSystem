package net.employee.spring.bootbackend.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="employees")
public class EmployeeModel {

    @Id
    @Generated
    private long id;
    private String emp_name;
    private String email_id;
    private int salary;


}
