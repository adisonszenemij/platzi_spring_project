package com.example.platzi_spring_project.persistence.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.platzi_spring_project.persistence.entity.PcClientEmailEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class PcClientEmailListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PcClientEmailEntity.class);
    private PcClientEmailEntity currentValue;

    @PostLoad
    public void postLoad(PcClientEmailEntity pcClientEmailEntity) {
        if (LOGGER.isInfoEnabled()) { LOGGER.info("POST LOAD"); }
        this.currentValue = cloneEntity(pcClientEmailEntity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PcClientEmailEntity pcClientEmailEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("POST PERSIST OR UPDATE");
            LOGGER.info("OLD VALUE: {}", this.currentValue);
            LOGGER.info("NEW VALUE: {}", pcClientEmailEntity);
        }
    }

    @PreRemove
    public void onPreDelete(PcClientEmailEntity pcClientEmailEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(pcClientEmailEntity.toString());
        }
    }

    private PcClientEmailEntity cloneEntity(PcClientEmailEntity entity) {
        PcClientEmailEntity clone = new PcClientEmailEntity();
        clone.setIdRegister(entity.getIdRegister());
        clone.setCdData(entity.getCdData());
        clone.setPcClientData(entity.getPcClientData());
        return clone;
    }
}
