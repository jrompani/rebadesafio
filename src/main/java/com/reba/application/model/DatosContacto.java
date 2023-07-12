package com.reba.application.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "datos_contactos")
@NoArgsConstructor
@Data
public class DatosContacto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String valor;
    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    public DatosContacto(String tipo, String valor, Persona persona){
        this.tipo = tipo;
        this.valor = valor;
        this.persona = persona;
    }

    public DatosContacto(String tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }
}
