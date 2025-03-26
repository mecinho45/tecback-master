package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Produtor;
import br.uniesp.si.techback.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class ProdutorController {

    @Autowired
    private ProdutorService service;

    @GetMapping
    public List<Produtor> listar(){
        return service.listarTodos();

    }

    @PostMapping
    public Produtor criarProdutor(@RequestBody Produtor produtor){
        return service.criarProdutor(produtor);
    }
    @PutMapping

    public Optional<Produtor> atualizarProdutor(@RequestBody Produtor produtor){
        return service.atualizarProdutor(produtor);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        service.deletarProdutor(id);
        return ResponseEntity.ok().build();

    }
}
