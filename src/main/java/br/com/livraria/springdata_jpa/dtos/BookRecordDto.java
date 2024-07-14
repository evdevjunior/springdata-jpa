package br.com.livraria.springdata_jpa.dtos;

import java.util.Set;
import java.util.UUID;

    // records disponivel apartir do Java14 facilitando a criação das classes DTO
public record BookRecordDto(String title, UUID publisherId, Set<UUID> authorIds, String reviewComment) {


}
