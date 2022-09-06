package com.ronal.edificios.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private boolean isActive;
}
