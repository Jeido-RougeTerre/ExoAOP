package com.jeido.exerciseaop.celestial.dto.observation;

import com.jeido.exerciseaop.celestial.dto.DTOReceiver;
import com.jeido.exerciseaop.celestial.entity.Observation;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ObservationDTOSend implements DTOReceiver<Observation> {
    private int observationId;
    private LocalDate date;
    private String description;
    private String position;

    @Override
    public Observation receive() {
        return Observation.builder().build();
    }
}
