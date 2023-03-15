package dev.wcs.nad.tariffmanager.department;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertNotNull;


import dev.wcs.nad.tariffmanager.persistence.entity.Department;

import dev.wcs.nad.tariffmanager.persistence.entity.Tariff;
import dev.wcs.nad.tariffmanager.persistence.repository.DepartmentRepository;

import dev.wcs.nad.tariffmanager.persistence.repository.TariffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class DepartmentTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired private TariffRepository tariffRepository;

    @Test
    public void shouldReturnAllDepartments() {
        for (Department it : departmentRepository.findAll()) {
            assertThat(it.getName());
        }
    }
    @Test
    public void shouldCreateTariffWithDepartment() {
        // Créer un nouveau Department
        Department department = new Department();
        department.setName("dpt");
        departmentRepository.save(department);

        // Créer un nouveau Tariff et l'associer avec le Department créé
        Tariff tariff = new Tariff();
        tariff.setName("Tariff Test");
        tariff.setDepartment(department);
        tariffRepository.save(tariff);

        // Vérifier que le Tariff est bien créé avec le Department associé en base de données
        Tariff savedTariff = tariffRepository.findById(tariff.getId()).orElse(null);
        assertNotNull(savedTariff);
        assertThat(tariff.getName().equals(savedTariff.getName()));
        assertThat(tariff.getDepartment().equals(savedTariff.getDepartment()));
    }
}
