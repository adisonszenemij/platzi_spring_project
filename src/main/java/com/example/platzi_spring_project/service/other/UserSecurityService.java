package com.example.platzi_spring_project.service.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.platzi_spring_project.persistence.entity.TgUserDataEntity;
import com.example.platzi_spring_project.persistence.repository.TgUserDataRepository;

@Service
public class UserSecurityService implements UserDetailsService {
    private final TgUserDataRepository tgUserDataRepository;

    @Autowired
    public UserSecurityService(TgUserDataRepository tgUserDataRepository) {
        this.tgUserDataRepository = tgUserDataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cdLogin) throws UsernameNotFoundException {
        TgUserDataEntity entityTgUserData = this.tgUserDataRepository.findFirstByCdLogin(cdLogin);
        if (entityTgUserData == null) { throw new UsernameNotFoundException("User " + cdLogin + " not found."); }
        
        Integer idRegister = entityTgUserData.getIdRegister();
        TgUserDataEntity tgUserDataEntity = this.tgUserDataRepository.findById(idRegister).orElseThrow(
            () -> new UsernameNotFoundException("User " + cdLogin + " not found.")
        );

        return User.builder()
            .username(tgUserDataEntity.getCdLogin())
            .password(tgUserDataEntity.getCdPassword())
            .roles("ADMIN")
            .accountLocked(false)
            .disabled(false)
            .build();
    }
}
