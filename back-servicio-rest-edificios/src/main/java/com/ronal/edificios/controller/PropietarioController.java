package com.ronal.edificios.controller;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ronal.edificios.entity.Propietario;
import com.ronal.edificios.service.PropietarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/propietario")
@CrossOrigin
public class PropietarioController {
    @Autowired
    PropietarioService service;

    @GetMapping("/listar")
    public List<Propietario> listar(){
        return service.listar();
    }
    @GetMapping("/buscarPorDni/{dni}")
    public Propietario buscarPorDni(@PathVariable("dni") String dni){
        return service.buscarPorDni(dni);
    }
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Map<String, Object>> actualizar(@RequestBody Propietario obj, @PathVariable("id") Long id){
        Map<String, Object> salida = new HashMap<>();
        try{
            Propietario pro = service.buscar(id);
            if(Objects.nonNull(pro)){
                service.actualizar(obj,id);
                salida.put("mensaje","Propietario " + id + " Actualizado");
            }
            else{
                salida.put("mensaje","Error al Actualizar");
            }
        }catch (Exception e){
            e.printStackTrace();
            salida.put("mensaje","Error al Actualizar");
        }
        return ResponseEntity.ok(salida);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Map<String,Object>> registrar(@RequestBody Propietario obj) {
        Map<String, Object> salida = new HashMap<>();

        try {
            Propietario pro = service.regristrar(obj);

            if (Objects.nonNull(pro)) {
                salida.put("mensaje", "Registro Exitoso");
            } else {
                salida.put("mensaje", "Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", "Error");
        }
        return ResponseEntity.ok(salida);
    }
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        Propietario propietario = service.buscar(id);
        if(Objects.nonNull(propietario)){
            service.eliminar(id);
            return "Eliminado correctamente";
    }
        return "Id no Existe";
    }
  /*  public ResponseEntity<Map<String,Object>> eliminar(@PathVariable("id") Long id){
        Map<String, Object> salida = new HashMap<>();
        try {
            Propietario propietario = service.buscar(id);
            if(Objects.nonNull(propietario)){
                service.eliminar(id);
                salida.put("mensaje","Eliminado Correctamente");
            }
            else{
                salida.put("mensaje","El Propietario no Existe");
            }
        }
        catch (Exception e) {
        e.printStackTrace();
            salida.put("mensaje","Error");

        }

        service.eliminar(id);
        return  ResponseEntity.ok(salida);
    }*/
}
