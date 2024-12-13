package com.jeido.exerciseaop.celestial.dto.celestial;

import com.jeido.exerciseaop.celestial.dto.DTOSender;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CelestialDTOSend implements DTOSender {
    private int id;
    private String name;

    @Override
    public void send() {

    }
}
