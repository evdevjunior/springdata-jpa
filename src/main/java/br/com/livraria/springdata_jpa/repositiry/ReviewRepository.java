package br.com.livraria.springdata_jpa.repositiry;

import br.com.livraria.springdata_jpa.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepository extends JpaRepository<ReviewModel, UUID> {
}
