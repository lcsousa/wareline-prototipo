package br.com.wareline.prototipobackend.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wareline.prototipobackend.entity.TestEntity;
import br.com.wareline.prototipobackend.exception.MessageBusiness;
import br.com.wareline.prototipobackend.repository.TestRepository;
import br.com.wareline.prototipobackend.service.TestService;

@Service
public class TestServiceImp implements TestService{

	
	@Autowired
	private TestRepository testRepository;
	/*
	 * @Autowired private FeignClientDocumentService feignClientDocumentService;
	 */

	public List<TestEntity> findAll() {

		return testRepository.findAll();

	}

	public TestEntity findById(Long id) {
		Optional<TestEntity> testEntity = testRepository.findById(id);
		
		if (testEntity.isPresent()) {
			//String documentNumber = feignClientDocumentService.listDocuments().get(0).getDocumentNumber();
			return testEntity.get();
		}else {
			throw MessageBusiness.NOT_FOUND.createException();
		}
		

	}

	public TestEntity save(TestEntity testEntity) {
		if (!testEntity.getName().contains("0")) {
			throw MessageBusiness.NUMBER_0_REQUIRED.createException();
		}

		return testRepository.save(testEntity);

	}

	public void delete(Long id) {
		testRepository.deleteById(id);
	}
	
	public void update(TestEntity testEntity) {
		findById(testEntity.getId());
		testRepository.save(testEntity);
		
	}
}
