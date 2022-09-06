package com.ronal.edificios.service;

import com.ronal.edificios.entity.Propietario;

import java.util.List;

public interface PropietarioService {

     Propietario regristrar(Propietario obj);
     Propietario actualizar(Propietario obj , Long id);
     List<Propietario> listar();
     Propietario buscar(Long id);
     void eliminar(Long id);
     Propietario buscarPorDni(String dni);
}
