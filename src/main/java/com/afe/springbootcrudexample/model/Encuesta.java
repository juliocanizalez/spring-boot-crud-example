package com.afe.springbootcrudexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EncuestaJEC")
public class Encuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "deporte_favorito")
    private String deporteFavorito;

    @Column(name = "nivel_estudio")
    private String nivelEstudio;

    @Column(name = "temas")
    private String temas;

    @Column(name = "fecha")
    private String fecha;
}