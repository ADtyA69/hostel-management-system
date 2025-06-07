package com.springboot.HostelManagmentSystem.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.HostelManagmentSystem.Entity.Student;

@Repository
public interface StudentRepo  extends JpaRepository<Student, Integer> {

}
