package dev.wcs.nad.tariffmanager.persistence.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

import java.util.List;


@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", orphanRemoval = true)
    private List<Tariff> tariffs = new ArrayList<>();
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
