package com.jeido.exerciseaop.celestial.entity;

import com.jeido.exerciseaop.celestial.dto.DTOSender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Observation implements Entity{
    private Integer id;
    private CelestialObject celestialObject;
    private LocalDate date;
    private String description;
    private String position;

    @Override
    public DTOSender getSender() {
        return null;
    }
}
