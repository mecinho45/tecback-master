package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Produtor;
import br.uniesp.si.techback.repository.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public List<Produtor> listarTodos() {
        return produtorRepository.findAll();
    }

    public Optional<Produtor> buscarPorId(Long id) {
        return produtorRepository.findById(id);
    }

    public Produtor criarProdutor(Produtor produtor){
        return produtorRepository.save(produtor);


    }

    public Optional<Produtor> atualizarProdutor(Produtor produtor) {
        return produtorRepository.findById(produtor.getId()).map(p -> {
            p.setNome(produtor.getNome());
            p.setIdade(produtor.getIdade());
            p.setNacionalidade(produtor.getNacionalidade());
            return produtorRepository.save(p);
        });
    }

    public boolean deletarProdutor(long id) {
        if (produtorRepository.existsById(id)) {
            produtorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
