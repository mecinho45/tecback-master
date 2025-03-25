package br.uniesp.si.techback.controller;


import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import br.uniesp.si.techback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listar(){
        return service.listar();

    }

    @PostMapping
    public Usuario incluir(@RequestBody Usuario usuario){
        return service.cadastrar(usuario);
    }
    @PutMapping

    public Usuario alterar(@RequestBody Usuario usuario){
        return service.alterar(usuario);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        service.excluir(id);
        return ResponseEntity.ok().build();

    }


}
