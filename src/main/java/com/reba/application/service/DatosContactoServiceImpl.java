package com.reba.application.service;

import com.reba.application.model.DatosContacto;
import com.reba.application.repository.DatosContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosContactoServiceImpl implements DatosContactoService{
    @Autowired
    DatosContactoRepository datosContactoRepository;

    @Override
    public DatosContacto save(DatosContacto datosContacto) {
        return this.datosContactoRepository.save(datosContacto);
    }
}
