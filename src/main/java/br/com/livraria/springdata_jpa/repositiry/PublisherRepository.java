package br.com.livraria.springdata_jpa.repositiry;

import br.com.livraria.springdata_jpa.models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublisherRepository extends JpaRepository<PublisherModel, UUID> {
}
