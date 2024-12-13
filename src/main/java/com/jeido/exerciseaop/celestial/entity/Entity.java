package com.jeido.exerciseaop.celestial.entity;

import com.jeido.exerciseaop.celestial.dto.DTOSender;

public interface Entity {
    Integer getId();
    void setId(Integer id);
    DTOSender getSender();
}
