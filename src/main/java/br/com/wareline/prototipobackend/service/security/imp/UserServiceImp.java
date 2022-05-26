package br.com.wareline.prototipobackend.service.security.imp;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wareline.prototipobackend.dto.security.SaveUserRequestDTO;
import br.com.wareline.prototipobackend.dto.security.UserDTO;
import br.com.wareline.prototipobackend.entity.security.UserEntity;
import br.com.wareline.prototipobackend.mapper.security.UserMapper;
import br.com.wareline.prototipobackend.repository.security.UserRepository;
import br.com.wareline.prototipobackend.service.security.UserService;

@Component
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository repository;

	
	public UserEntity findByLogin(String username)  {
		Optional<UserEntity> usuario = repository.findByUsername(username);
		if (usuario.isPresent()) {
			UserEntity model = usuario.get();
			model.getProfile().getRoles();
			return model;
		}

		return null;
	}
	
	public UserEntity findByLoginAndPassword(String username,String password) {
		Optional<UserEntity> usuario = repository.findByUsernameAndPassword(username,password);
		if (usuario.isPresent()) {
			UserEntity model = usuario.get();
			return model;
		}

		return null;
	}
	
	
	
	public UserDTO save(SaveUserRequestDTO usuarioModel){
		UserEntity entity = save(userMapper.convertSaveDtoToEntity(usuarioModel));
		return userMapper.convertEntityToDto(entity);
	}
	
	public UserEntity save(UserEntity usuarioModel)  {		
		return repository.save(usuarioModel);
	}
	

}
