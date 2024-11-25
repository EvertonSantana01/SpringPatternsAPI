package one.digital.golf.service;

import one.digital.golf.model.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Cliente HTTP, criando via <b>OpenFeign</b>, para o consumo da APi do <b>ViaCEP</b>.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud OpenFeing</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 */
@FeignClient(name = "viacep", url ="https://viacep.com.br/ws")          // define um cliente Feign para consumir APIs externas
public interface ViaCepService {
    @GetMapping("/{cep}/json/")  // retorna o valor desejado 
    Endereco consultarCep(@PathVariable("cep") String cep);  // captura o valor do CEP da URL e passa para o método.
}