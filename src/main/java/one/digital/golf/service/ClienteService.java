package one.digital.golf.service;

import one.digital.golf.model.Cliente;

/**
 * Interface que define o padrao <b>Strategy</b> no dominio de cliente. Com
 * isso, se necessario, podemos ter multiplas implementações dessa mesma
 * interface.
 */

public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id ,Cliente cliente);

    void deletar(Long id);
}
