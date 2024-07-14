package br.com.livraria.springdata_jpa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY) // relação muitos para um
    @JoinColumn(name = "publisher_id") // relaciona a coluna publisher com a coluna Id da entidade publisher
    private PublisherModel publisher;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( // junção das entidades book e author criando uma tabela auxiliar da relação
            name = "tb_book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id") )
    private Set<AuthorModel> authors = new HashSet<>();

    // relacionamento um para um mapeado id do book referenciando o review
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL) // castacde liga os reviews aos seu respectivos books em modo cascata
    private ReviewModel review;




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

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<AuthorModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorModel> authors) {
        this.authors = authors;
    }

    public ReviewModel getReview() {
        return review;
    }

    public void setReview(ReviewModel review) {
        this.review = review;
    }

}
