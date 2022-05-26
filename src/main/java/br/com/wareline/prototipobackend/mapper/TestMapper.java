package br.com.wareline.prototipobackend.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.wareline.prototipobackend.dto.TestDTO;
import br.com.wareline.prototipobackend.entity.TestEntity;


@Mapper(componentModel = "spring")
public interface TestMapper {

	 List<TestDTO> convertListEntitysToDtos(List<TestEntity> carEntities);
	 
	 TestDTO convertEntityToDto(TestEntity testEntity);
	 
	 TestEntity convertDtoToEntity(TestDTO testDTO);
}
