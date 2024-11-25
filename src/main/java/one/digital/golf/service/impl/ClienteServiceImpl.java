package one.digital.golf.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digital.golf.model.Cliente;
import one.digital.golf.model.ClienteRepository;
import one.digital.golf.model.Endereco;
import one.digital.golf.model.EnderecoRepository;
import one.digital.golf.service.ClienteService;
import one.digital.golf.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela sera tratada como um <b>Strategy</b>.
 */

@Service
public class ClienteServiceImpl implements ClienteService {
	 
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
    public Iterable<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }
    @Override
    public Cliente buscarPorId(Long id){
    	return clienteRepository.findById(id)
    			.orElseThrow(() -> new RuntimeException("Cliente não encontrado! ID: " + id));
    }
    
    @Override
    public void inserir(Cliente cliente){
       salvarClienteComCep(cliente);
    }
    
    
    @Override
    public void atualizar(Long id, Cliente cliente) {
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isEmpty()) {
            throw new RuntimeException("Cliente não encontrado para atualização! ID: " + id);
        }

        Cliente clienteExistente = clienteBd.get();
        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEndereco(cliente.getEndereco());
        clienteRepository.save(clienteExistente);
    }

    
    public void deletar(Long id){
        clienteRepository.deleteById(id);
    }
    
    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();

        // Validar o CEP
        if (cep == null || cep.isBlank()) {
            throw new RuntimeException("CEP inválido!");
        }

        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            if (novoEndereco == null) {
                throw new RuntimeException("Falha ao consultar o CEP na API ViaCEP.");
            }
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
