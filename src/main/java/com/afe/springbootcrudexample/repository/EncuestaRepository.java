package com.afe.springbootcrudexample.repository;

import com.afe.springbootcrudexample.model.Encuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EncuestaRepository extends JpaRepository<Encuesta, Integer> {
    // @CUSTOM

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE sexo = 'Femenino') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findWoman();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE sexo = 'Masculino') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findMan();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE deporte_favorito = 'Futbol') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findSportSoccer();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE deporte_favorito = 'Basquetbol') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findSportBasket();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE deporte_favorito = 'Jockey') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findSportJockey();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE deporte_favorito = 'Beisbol') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findSportBaseball();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE deporte_favorito = 'Golf') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findSportGolf();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE nivel_estudio = 'Nulo') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findStudyNull();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE nivel_estudio = 'Basico') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findStudyLow();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE nivel_estudio = 'Intermedio') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findStudyMid();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE nivel_estudio = 'Superior') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findStudyHigh();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE temas = 'Television') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findTopicTv();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE temas = 'Tecnologia') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findTopicTech();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE temas = 'Cocina') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findTopicCook();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE temas = 'Musica') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findTopicMusic();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE temas = 'Deportes') / (SELECT COUNT(*) FROM EncuestaJEC)", nativeQuery = true)
    double findTopicSport();

    @Query(value = "SELECT (SELECT COUNT(*) FROM EncuestaJEC WHERE sexo = 'Femenino' AND deporte_favorito = 'Futbol') / (SELECT COUNT(*) FROM EncuestaJEC WHERE sexo = 'Femenino')", nativeQuery = true)
    double findWomanWhoEnjoysSoccer();

    @Query(value = "SELECT COUNT(*) FROM EncuestaJEC WHERE sexo = 'Masculino' AND temas = 'Cocina'", nativeQuery = true)
    int findManWhoEnjoysCook();
}
