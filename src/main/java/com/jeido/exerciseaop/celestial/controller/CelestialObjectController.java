package com.jeido.exerciseaop.celestial.controller;

import com.jeido.exerciseaop.celestial.dto.DTOSender;
import com.jeido.exerciseaop.celestial.service.CelestialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/celestial")
public class CelestialObjectController {
    @Autowired
    private CelestialService celestialService;

    @GetMapping
    public ResponseEntity<List<DTOSender>> getAllCelestialObject() {
        return ResponseEntity.ok(celestialService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> initCelestialObject() {
        return new ResponseEntity<>(celestialService.init(), HttpStatus.CREATED);
    }
}
