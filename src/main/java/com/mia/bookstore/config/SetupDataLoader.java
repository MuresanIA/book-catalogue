package com.mia.bookstore.config;

import com.mia.bookstore.model.Privilege;
import com.mia.bookstore.model.Role;
import com.mia.bookstore.model.User;
import com.mia.bookstore.repository.PrivilegeRepository;
import com.mia.bookstore.repository.RoleRepository;
import com.mia.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) {
            return;
        }
    }

    @Transactional
    Privilege createPrivilegeIfNotFound() {
    }

    @Transactional
    Role createRoleIfNotFound() {
    }

    @Transactional
    User createUserIfNotFound() {
    }
}
