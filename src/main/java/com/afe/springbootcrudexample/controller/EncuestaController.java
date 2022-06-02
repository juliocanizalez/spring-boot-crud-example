package com.afe.springbootcrudexample.controller;

import com.afe.springbootcrudexample.model.Encuesta;
import com.afe.springbootcrudexample.service.EncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class EncuestaController {

    @Autowired
    private EncuestaService service;

    private boolean isActive = false;

    @GetMapping("/survey")
    public List<Encuesta> getAll() {
        return service.findAllSortByDate();
    }

    @GetMapping("/survey/results/gender")
    public Map<String, String> getGender() {
        String man = service.findMan();
        String woman = service.findWoman();

        HashMap<String, String> results = new HashMap<>();
        results.put("hombres", man);
        results.put("mujeres", woman);

        return results;
    }

    @GetMapping("/survey/results/sport")
    public Map<String, String> getSport() {
        HashMap<String, String> results = new HashMap<>();
        String footbal = service.findSportSoccer();
        String basket = service.findSportBasket();
        String jockey = service.findSportJockey();
        String baseball = service.findSportBaseball();
        String golf = service.findSportGolf();

        results.put("footbal", footbal);
        results.put("basket", basket);
        results.put("jockey", jockey);
        results.put("baseball", baseball);
        results.put("golf", golf);

        return results;
    }

    @GetMapping("/survey/results/study")
    public Map<String, String> getStudy() {
        HashMap<String, String> results = new HashMap<>();
        String nulo = service.findStudyNull();
        String basic = service.findStudyLow();
        String mid = service.findStudyMid();
        String high = service.findStudyHigh();

        results.put("nulo", nulo);
        results.put("basico", basic);
        results.put("medio", mid);
        results.put("superior", high);

        return results;
    }

    @GetMapping("/survey/results/topic")
    public Map<String, String> getTopic() {
        HashMap<String, String> results = new HashMap<>();
        String tv = service.findTopicTv();
        String cook = service.findTopicCook();
        String tech = service.findTopicTech();
        String music = service.findTopicMusic();
        String sport = service.findTopicSport();

        results.put("tv", tv);
        results.put("cook", cook);
        results.put("tech", tech);
        results.put("music", music);
        results.put("sport", sport);

        return results;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/survey/new")
    public ResponseEntity<Void> saveSurvey(@RequestBody Encuesta e) {
        service.save(e);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @DeleteMapping("/survey/delete/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable int id) {
        service.deleteSurvey(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/survey/search/{id}")
    public Optional<Encuesta> searchSurvey(@PathVariable int id) {
        Optional<Encuesta> e = service.findById(id);
        return e;
    }

    @GetMapping("/survey/results/womansoccer")
    @ResponseBody
    public Map<String, String> findWomanWhoEnjoysSoccer() {
        String result = service.findWomanWhoEnjoysSoccer();
        return Collections.singletonMap("result", result);
    }

    @GetMapping("/survey/results/mancook")
    @ResponseBody
    public Map<String, Integer> findManWhoEnjoysCook() {
        int result = service.findManWhoEnjoysCook();
        return Collections.singletonMap("result", result);
    }

    // Survey activation handlers
    @PostMapping("/survey/enable")
    public ResponseEntity<HttpStatus> enableSurvey() {
        isActive = true;

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/survey/disable")
    public ResponseEntity<HttpStatus> disableSurvey() {
        isActive = false;

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/survey/status")
    @ResponseBody
    public Map<String, Boolean> getSurveyStatus() {
        return Collections.singletonMap("isActive", isActive);
    }
}
