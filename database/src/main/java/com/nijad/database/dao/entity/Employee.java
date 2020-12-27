package com.nijad.database.dao.entity;

import com.nijad.database.dao.enums.Gender;
import com.nijad.database.dao.listener.EmployeeListener;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "employee")
@EntityListeners(value = EmployeeListener.class)
@NoArgsConstructor
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "department")
    private String department;

    @Column(name = "gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

}
