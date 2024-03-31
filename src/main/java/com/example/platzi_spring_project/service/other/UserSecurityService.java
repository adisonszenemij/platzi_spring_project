package com.example.platzi_spring_project.service.other;

import com.example.platzi_spring_project.persistence.entity.TgUserDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.platzi_spring_project.persistence.repository.TgUserDataRepository;

@Service
public class UserSecurityService implements UserDetailsService {
    private final TgUserDataRepository tgUserDataRepository;

    @Autowired
    public UserSecurityService(TgUserDataRepository tgUserDataRepository) {
        this.tgUserDataRepository = tgUserDataRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TgUserDataEntity tgUserDataEntity = this.tgUserDataRepository.findById(username).orElseThrow(
            () -> new UsernameNotFoundException("User " + username + " not found.")
        );

        return User.builder()
            .username(tgUserDataEntity.getCdLogin())
            .password(tgUserDataEntity.getCdPassword())
            .roles("ADMIN")
            .accountLocked(true)
            .disabled(true)
            .build();
    }
}
