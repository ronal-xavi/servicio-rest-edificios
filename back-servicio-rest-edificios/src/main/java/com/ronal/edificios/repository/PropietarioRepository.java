package com.ronal.edificios.repository;

import com.ronal.edificios.entity.Propietario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropietarioRepository extends JpaRepository<Propietario,Long> {

    Propietario findByDni(String dni);
}
