package br.com.livraria.springdata_jpa.services;

import br.com.livraria.springdata_jpa.dtos.BookRecordDto;
import br.com.livraria.springdata_jpa.models.BookModel;
import br.com.livraria.springdata_jpa.models.ReviewModel;
import br.com.livraria.springdata_jpa.repositiries.AuthorRepository;
import br.com.livraria.springdata_jpa.repositiries.BookRepository;
import br.com.livraria.springdata_jpa.repositiries.PublisherRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service // serviço para os pontos de injeção
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    // construtores
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;

    }
    // lista todos os books
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    // anotação transactional isola a camada da transação e caso uma das transações falharem executa um rolback e não salva partes de dados
    @Transactional  // bookmodel recebe o bookrecorddto para as transações de salvar no banco
    public BookModel saveBook(BookRecordDto bookRecordDto) {
        BookModel book = new BookModel(); // instancia book de bookmodel
        book.setTitle(bookRecordDto.title()); // salva o titulo do book
        book.setPublisher(publisherRepository.findById(bookRecordDto.publisherId()).get()); // salva a editora e o id
        book.setAuthors(authorRepository.findAllById(bookRecordDto.authorIds()).stream().collect(Collectors.toSet())); // salva o author e o id

        // salva as reviews
        ReviewModel reviewModel = new ReviewModel();
        reviewModel.setComment(bookRecordDto.reviewComment());
        reviewModel.setBook(book);
        book.setReview(reviewModel);

        return bookRepository.save(book);

    }
    // deleta o book por ID
    @Transactional
    public void deleteBook(UUID id){
        bookRepository.deleteById(id);
    }

}
