package br.com.livraria.springdata_jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TB_PUBLISHER")
public class PublisherModel implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    //JsonPropertis permitindo escrita e não de leitura da requisição evitando erro de serielização
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // relação um para muitos mapeando a coluna publisher da entidade bookmodel com carregamento lento do tipo LAZY
    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY)
    private Set<BookModel> books = new HashSet<>(); // cria a lista do tipo set para carregar os livros associados a editora




    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<BookModel> getBooks() {
        return books;
    }

    public void setBooks(Set<BookModel> books) {
        this.books = books;
    }

}
