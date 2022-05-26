package br.com.wareline.prototipobackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wareline.prototipobackend.entity.TestEntity;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

}
