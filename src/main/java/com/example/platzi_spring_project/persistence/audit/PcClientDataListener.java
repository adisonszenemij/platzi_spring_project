package com.example.platzi_spring_project.persistence.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class PcClientDataListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PcClientDataEntity.class);
    private PcClientDataEntity currentValue;

    @PostLoad
    public void postLoad(PcClientDataEntity pcClientDataEntity) {
        if (LOGGER.isInfoEnabled()) { LOGGER.info("POST LOAD"); }
        this.currentValue = cloneEntity(pcClientDataEntity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PcClientDataEntity pcClientDataEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("POST PERSIST OR UPDATE");
            LOGGER.info("OLD VALUE: {}", this.currentValue);
            LOGGER.info("NEW VALUE: {}", pcClientDataEntity);
        }
    }

    @PreRemove
    public void onPreDelete(PcClientDataEntity pcClientDataEntity) {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info(pcClientDataEntity.toString());
        }
    }

    private PcClientDataEntity cloneEntity(PcClientDataEntity entity) {
        PcClientDataEntity clone = new PcClientDataEntity();
        clone.setIdRegister(entity.getIdRegister());
        clone.setCdAddress(entity.getCdAddress());
        clone.setCdIdentification(entity.getCdIdentification());
        clone.setCdNames(entity.getCdNames());
        clone.setCdSurnames(entity.getCdSurnames());
        return clone;
    }
}
