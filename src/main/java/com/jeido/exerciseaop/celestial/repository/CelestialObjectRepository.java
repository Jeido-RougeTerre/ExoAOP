package com.jeido.exerciseaop.celestial.repository;


import com.jeido.exerciseaop.celestial.entity.CelestialObject;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CelestialObjectRepository implements BaseRepository<CelestialObject> {
    private static CelestialObjectRepository instance;
    private Map<Integer, CelestialObject> map;

    private CelestialObjectRepository() {
        this.map = new HashMap<>();
    }

    public static CelestialObjectRepository getInstance() {
        if (instance == null) {
            instance = new CelestialObjectRepository();
        }
        return instance;
    }
    @Override
    public CelestialObject save(CelestialObject t) {
        if (t.getId() == null) {
            t.setId(map.size());
        }
        map.put(t.getId(), t);
        return t;
    }
    @Override
    public Optional<CelestialObject> findById(int id) {
        return Optional.ofNullable(map.get(id));
    }
    @Override
    public List<CelestialObject> findAll() {
        return new ArrayList<>(map.values());
    }
    @Override
    public List<Integer> findAllIds() {
        return new ArrayList<>(map.keySet());
    }
    @Override
    public boolean deleteById(int id) {
        return map.remove(id) != null;
    }

    @Override
    public String getEntityName() {
        return CelestialObject.class.getSimpleName();
    }

}
