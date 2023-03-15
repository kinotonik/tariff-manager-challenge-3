package dev.wcs.nad.tariffmanager.persistence.repository;

import dev.wcs.nad.tariffmanager.persistence.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
