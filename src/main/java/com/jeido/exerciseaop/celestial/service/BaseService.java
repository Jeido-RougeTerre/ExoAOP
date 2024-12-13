package com.jeido.exerciseaop.celestial.service;

import com.jeido.exerciseaop.celestial.dto.DTOReceiver;
import com.jeido.exerciseaop.celestial.dto.DTOSender;
import com.jeido.exerciseaop.celestial.entity.Entity;
import com.jeido.exerciseaop.celestial.repository.BaseRepository;
import com.jeido.exerciseaop.celestial.utils.exception.AlreadyInDBException;
import com.jeido.exerciseaop.celestial.utils.exception.NotFoundException;

import java.util.List;

public abstract class BaseService<T extends Entity> {

    protected BaseRepository<T> repository;

    public BaseService(BaseRepository<T> repository) {
        this.repository = repository;
    }

    public DTOSender save(DTOReceiver<T> receiver) {
        T obj = receiver.receive();
        if (obj.getId() != null) {
            if (repository.findAllIds().contains(obj.getId())) throw new AlreadyInDBException(obj);
        }

        T savedObj = (T) repository.save(obj);

        return savedObj.getSender();
    }

    public DTOSender findById(int id) {
        T obj = repository.findById(id).orElseThrow(() -> new NotFoundException(repository.getEntityName(), id));
        return obj.getSender();
    }

    public List<DTOSender> findAll() {
        List<T> list = repository.findAll();
        return list.stream().map(T::getSender).toList();
    }

    public boolean deleteById(int id) {
        T obj = repository.findById(id).orElseThrow(() -> new NotFoundException(repository.getEntityName(), id));
        return repository.deleteById(id);
    }
}
