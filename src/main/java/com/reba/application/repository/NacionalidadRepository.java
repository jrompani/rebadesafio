package com.reba.application.repository;

import com.reba.application.model.Nacionalidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NacionalidadRepository extends CrudRepository<Nacionalidad, Long> {
}
