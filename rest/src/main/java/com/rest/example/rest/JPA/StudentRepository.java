package com.rest.example.rest.JPA;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentJpa, String> {

}
