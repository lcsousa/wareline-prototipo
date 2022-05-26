package br.com.wareline.prototipobackend.repository.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wareline.prototipobackend.entity.security.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    public Optional<UserEntity> findByUsername(String username);
    public Optional<UserEntity> findByUsernameAndPassword(String username,String password);

}
