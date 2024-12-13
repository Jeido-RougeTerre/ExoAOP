package com.jeido.exerciseaop.celestial.service;

import com.jeido.exerciseaop.celestial.entity.CelestialObject;
import com.jeido.exerciseaop.celestial.repository.CelestialObjectRepository;
import org.springframework.stereotype.Service;

@Service
public class CelestialService extends BaseService<CelestialObject> {

    public CelestialService() {
        super(CelestialObjectRepository.getInstance());
    }

    public String init() {
        return "NYI";
    }
}
