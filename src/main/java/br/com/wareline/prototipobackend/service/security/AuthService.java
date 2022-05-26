package br.com.wareline.prototipobackend.service.security;

import java.util.List;

import br.com.wareline.prototipobackend.dto.security.ChangePasswordRequestDTO;
import br.com.wareline.prototipobackend.dto.security.LoginRequestDTO;
import br.com.wareline.prototipobackend.dto.security.RefreshTokenResponseDTO;
import br.com.wareline.prototipobackend.dto.security.ResetPasswordRequestDTO;
import br.com.wareline.prototipobackend.dto.security.TokenLoginResponseDTO;
import br.com.wareline.prototipobackend.dto.security.UserDTO;
import br.com.wareline.prototipobackend.entity.security.RoleEntity;


public interface AuthService {


	public TokenLoginResponseDTO login(LoginRequestDTO userLogin);
	
	public void changePassword(ChangePasswordRequestDTO userLogin);
	
	public void resetPassword(ResetPasswordRequestDTO userLogin);
	
	public List<RoleEntity> getRolesByToken(String token);
	
	public RefreshTokenResponseDTO refreshToken(String token);	
	
	public UserDTO getUserByToken(String token);

	public boolean validateToken(String token);

	public String getLoginByToken(String token);

	
	public boolean isAccessToken(String token) ;
	
}
