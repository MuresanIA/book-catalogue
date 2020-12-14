package com.mia.bookstore.config;

import com.mia.bookstore.model.Privilege;
import com.mia.bookstore.repository.PrivilegeRepository;
import com.mia.bookstore.repository.RoleRepository;
import com.mia.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class SetupDataLoader implements ApplicationListener {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        if (alreadySetup) {
            return;
        }
    }
}
