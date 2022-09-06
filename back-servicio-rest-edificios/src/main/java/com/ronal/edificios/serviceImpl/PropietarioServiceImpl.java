package com.ronal.edificios.serviceImpl;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ronal.edificios.entity.Propietario;
import com.ronal.edificios.repository.PropietarioRepository;
import com.ronal.edificios.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    PropietarioRepository repository;

    @Override
    public Propietario regristrar(Propietario obj) {
        Propietario encontrado = repository.findByDni(obj.getDni());
        if(encontrado == null){
            return repository.save(obj);
        }
        return null;
    }

    @Override
    public Propietario actualizar(Propietario obj, Long id) {
        Propietario encontrado = buscar(id);
        if(Objects.nonNull(encontrado)){
            Propietario actualizar = new Propietario();
            actualizar.setId(id);
            actualizar.setNombre(obj.getNombre());
            actualizar.setApellido(obj.getApellido());
            actualizar.setFechaNacimiento(obj.getFechaNacimiento());
            actualizar.setDni(obj.getDni());
            return repository.save(actualizar);
        }
        return null;
    }

    @Override
    public List<Propietario> listar() {
        return repository.findAll();
    }

    @Override
    public Propietario buscar(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Propietario buscarPorDni(String dni) {
        return repository.findByDni(dni);
    }
}
