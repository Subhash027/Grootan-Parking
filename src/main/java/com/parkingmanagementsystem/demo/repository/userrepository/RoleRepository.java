package com.parkingmanagementsystem.demo.repository.userrepository;

import com.parkingmanagementsystem.demo.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
