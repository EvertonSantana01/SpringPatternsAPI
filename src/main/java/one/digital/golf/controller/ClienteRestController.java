package one.digital.golf.controller;

import one.digital.golf.model.Cliente;
import one.digital.golf.model.ClienteRepository;
import one.digital.golf.service.ClienteService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Esse link {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integração (Banco de dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 */
@RestController
@RequestMapping("clientes")
public class ClienteRestController {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        clienteService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        
        Optional<Cliente> clienteAtualizado = clienteRepository.findById(id);
        if(clienteAtualizado.isPresent()) {
        	return ResponseEntity.ok(clienteAtualizado.get());
        }else {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
