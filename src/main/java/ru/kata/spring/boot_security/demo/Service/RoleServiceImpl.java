package ru.kata.spring.boot_security.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.Repository.RoleRepository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
