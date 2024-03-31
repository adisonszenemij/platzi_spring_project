package com.example.platzi_spring_project.persistence.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.platzi_spring_project.persistence.entity.PcClientPhoneEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class PcClientPhoneListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PcClientPhoneEntity.class);
    private PcClientPhoneEntity currentValue;

    @PostLoad
    public void postLoad(PcClientPhoneEntity pcClientPhoneEntity) {
        if (LOGGER.isInfoEnabled()) { LOGGER.info("POST LOAD"); }
        this.currentValue = cloneEntity(pcClientPhoneEntity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PcClientPhoneEntity pcClientPhoneEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("POST PERSIST OR UPDATE");
            LOGGER.info("OLD VALUE: {}", this.currentValue);
            LOGGER.info("NEW VALUE: {}", pcClientPhoneEntity);
        }
    }

    @PreRemove
    public void onPreDelete(PcClientPhoneEntity pcClientPhoneEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(pcClientPhoneEntity.toString());
        }
    }

    private PcClientPhoneEntity cloneEntity(PcClientPhoneEntity entity) {
        PcClientPhoneEntity clone = new PcClientPhoneEntity();
        clone.setIdRegister(entity.getIdRegister());
        clone.setCdData(entity.getCdData());
        clone.setPcClientData(entity.getPcClientData());
        return clone;
    }
}
