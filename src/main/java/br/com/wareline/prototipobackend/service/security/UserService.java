package br.com.wareline.prototipobackend.service.security;

import br.com.wareline.prototipobackend.dto.security.SaveUserRequestDTO;
import br.com.wareline.prototipobackend.dto.security.UserDTO;
import br.com.wareline.prototipobackend.entity.security.UserEntity;


public interface UserService {

	public UserEntity findByLogin(String username);
	
	public UserEntity findByLoginAndPassword(String username,String password);	
	
	public UserDTO save(SaveUserRequestDTO usuarioModel);
	
	public UserEntity save(UserEntity usuarioModel);
	

	
}
