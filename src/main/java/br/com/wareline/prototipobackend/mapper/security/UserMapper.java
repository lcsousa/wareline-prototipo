package br.com.wareline.prototipobackend.mapper.security;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.wareline.prototipobackend.dto.security.SaveUserRequestDTO;
import br.com.wareline.prototipobackend.dto.security.UserDTO;
import br.com.wareline.prototipobackend.entity.security.UserEntity;


@Mapper(componentModel = "spring")
public interface UserMapper {

	 List<UserDTO> convertListEntitysToDtos(List<UserEntity> carEntities);
	 
	 UserDTO convertEntityToDto(UserEntity testEntity);
	 
	 
	 UserEntity convertSaveDtoToEntity(SaveUserRequestDTO testDTO);
}
