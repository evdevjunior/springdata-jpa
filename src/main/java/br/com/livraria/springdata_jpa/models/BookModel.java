package br.com.livraria.springdata_jpa.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

// BookModel implementants Serializable interface de marcação
    // que salva o estado atual do objeto no computador para ser
    // raculperado posteriormente e ser alocado em memória

@Entity
@Table(name = "TB_BOOK") // Mapeamneto da entidade e criação da tabela
public class BookModel implements Serializable {
    //  Id de controle da JVM para as Serializações que forem realizada
    public static final long serialVersionUID = 1L;

    @Id // Id da tamela com geração automatica
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true) // criação da coluna não nulo e de valor unico
    private String title;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
