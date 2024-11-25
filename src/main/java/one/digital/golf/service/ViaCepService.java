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
@FeignClient(name = "viacep", url ="https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Endereco consultarCep(@PathVariable("cep") String cep);
}
