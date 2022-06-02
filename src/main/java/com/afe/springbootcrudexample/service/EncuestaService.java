package com.afe.springbootcrudexample.service;

import com.afe.springbootcrudexample.model.Encuesta;
import com.afe.springbootcrudexample.repository.EncuestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuestaService {
    @Autowired
    private EncuestaRepository repository;

    // Resources
    private String date = "fecha";

    //CUSTOM METHODS
    public List<Encuesta> findAllSortByDate() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, date));
    }

    public Encuesta save(Encuesta e) {
        return repository.save(e);
    }

    public String findWomanWhoEnjoysSoccer() {
        return String.format("%.2f", (repository.findWomanWhoEnjoysSoccer() * 100));
    }

    public int findManWhoEnjoysCook() {
        return repository.findManWhoEnjoysCook();
    }

    public void deleteSurvey(int id) {
        repository.deleteById(id);
    }

    public String findWoman() {
        return String.format("%.2f", (repository.findWoman() * 100));
    }

    public String findMan() {
        return String.format("%.2f", (repository.findMan() * 100));
    }

    public String findSportSoccer() {
        return String.format("%.2f", (repository.findSportSoccer() * 100));
    }

    public String findSportBasket() {
        return String.format("%.2f", (repository.findSportBasket() * 100));
    }

    public String findSportJockey() {
        return String.format("%.2f", (repository.findSportJockey() * 100));
    }

    public String findSportBaseball() {
        return String.format("%.2f", (repository.findSportBaseball() * 100));
    }

    public String findSportGolf() {
        return String.format("%.2f", (repository.findSportGolf() * 100));
    }

    public String findStudyNull() {
        return String.format("%.2f", (repository.findStudyNull() * 100));
    }

    public String findStudyLow() {
        return String.format("%.2f", (repository.findStudyLow() * 100));
    }

    public String findStudyMid() {
        return String.format("%.2f", (repository.findStudyMid() * 100));
    }

    public String findStudyHigh() {
        return String.format("%.2f", (repository.findStudyHigh() * 100));
    }

    public String findTopicTv() {
        return String.format("%.2f", (repository.findTopicTv() * 100));
    }

    public String findTopicTech() {
        return String.format("%.2f", (repository.findTopicTech() * 100));
    }

    public String findTopicCook() {
        return String.format("%.2f", (repository.findTopicCook() * 100));
    }

    public String findTopicMusic() {
        return String.format("%.2f", (repository.findTopicMusic() * 100));
    }

    public String findTopicSport() {
        return String.format("%.2f", (repository.findTopicSport() * 100));
    }
}
