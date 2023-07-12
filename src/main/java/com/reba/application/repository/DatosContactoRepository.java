package com.reba.application.repository;

import com.reba.application.model.DatosContacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosContactoRepository extends CrudRepository<DatosContacto, Long> {
}
