package br.com.livraria.springdata_jpa.repositiries;

import br.com.livraria.springdata_jpa.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

    // interface para consultas e querys no banco de dados
public interface BookRepository extends JpaRepository<BookModel, UUID> {

    // busca no banco pelo titulo do book
    //BookModel findBookModelByTitle(String title);

    // busca nativa utilizando parametros Sql para buscar todos os books
    //@Query(value = "SELECT * FROM tb_book WHERE publisher_id = :id", nativeQuery = true)
    //List<BookModel> findBookModelByPublisherId(UUID id);

}
