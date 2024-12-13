package com.jeido.exerciseaop.celestial.entity;

import com.jeido.exerciseaop.celestial.dto.celestial.CelestialDTOSend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CelestialObject implements Entity {
    private Integer id;
    private String name;

    public static CelestialObject parse(String line) {
        String[] fields = line.split(",");
        String idStr = fields[0];
        String name = fields[1];
        try {
            return CelestialObject.builder().id(Integer.parseInt(idStr)).name(name).build();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CelestialDTOSend getSender() {
        return CelestialDTOSend.builder().id(id).name(name).build();
    }
}