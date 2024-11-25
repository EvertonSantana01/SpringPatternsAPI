package one.digital.golf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity    //essa classe vai virar uma tabela no banco de dados, e cada objeto é uma linha dessa tabela
public class Cliente {

    @Id // unico para cada linha
    @GeneratedValue(strategy = GenerationType.AUTO) // O banco ou JPA cria o valor automaticamente.
    private Long id;
    private String nome;
    
    @ManyToOne   // Muitos para um
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
