package com.example.grapgqljpaexample.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.grapgqljpaexample.model.Author;
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID>{
}
