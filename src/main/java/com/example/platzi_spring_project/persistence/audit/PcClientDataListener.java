package com.example.platzi_spring_project.persistence.audit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.SerializationUtils;

import com.example.platzi_spring_project.persistence.entity.PcClientDataEntity;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class PcClientDataListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(PcClientDataEntity.class);
    private PcClientDataEntity currentValue;

    /*@PostLoad
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
    }*/

    @PostLoad
    public void postLoad(PcClientDataEntity entity) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(PcClientDataEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(PcClientDataEntity entity) {
        System.out.println(entity.toString());
    }
}
