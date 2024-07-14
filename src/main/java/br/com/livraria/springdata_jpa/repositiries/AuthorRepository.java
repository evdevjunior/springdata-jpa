package br.com.livraria.springdata_jpa.repositiries;

import br.com.livraria.springdata_jpa.models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<AuthorModel, UUID> {


}
