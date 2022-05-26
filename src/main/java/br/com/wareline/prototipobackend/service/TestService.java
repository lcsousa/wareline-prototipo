package br.com.wareline.prototipobackend.service;

import java.util.List;

import br.com.wareline.prototipobackend.entity.TestEntity;


public interface TestService {

	
	public List<TestEntity> findAll();

	public TestEntity findById(Long id);

	public TestEntity save(TestEntity testEntity);

	public void delete(Long id);
	
	public void update(TestEntity testEntity);
}
