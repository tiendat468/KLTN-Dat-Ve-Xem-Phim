package com.example.datvexemphimonl.repository;

import com.example.datvexemphimonl.entity.Role;
import com.example.datvexemphimonl.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(RoleType name);
}
