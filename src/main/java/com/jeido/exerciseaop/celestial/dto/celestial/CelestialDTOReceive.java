package com.jeido.exerciseaop.celestial.dto.celestial;

import com.jeido.exerciseaop.celestial.dto.DTOReceiver;
import com.jeido.exerciseaop.celestial.entity.CelestialObject;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CelestialDTOReceive implements DTOReceiver<CelestialObject> {
    private Integer id;
    private String name;

    @Override
    public CelestialObject receive() {
        if (id == null) return CelestialObject.builder().name(name).build();
        return CelestialObject.builder().id(id).name(name).build();
    }
}
