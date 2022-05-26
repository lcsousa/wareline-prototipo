package br.com.wareline.prototipobackend.controller.security;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wareline.prototipobackend.dto.security.ChangePasswordRequestDTO;
import br.com.wareline.prototipobackend.dto.security.IdentityUserByTokenRequestDTO;
import br.com.wareline.prototipobackend.dto.security.LoginRequestDTO;
import br.com.wareline.prototipobackend.dto.security.RefreshTokenRequestDTO;
import br.com.wareline.prototipobackend.dto.security.RefreshTokenResponseDTO;
import br.com.wareline.prototipobackend.dto.security.ResetPasswordRequestDTO;
import br.com.wareline.prototipobackend.dto.security.RoleUserByTokenRequestDTO;
import br.com.wareline.prototipobackend.dto.security.TokenLoginResponseDTO;
import br.com.wareline.prototipobackend.dto.security.UserDTO;
import br.com.wareline.prototipobackend.entity.security.RoleEntity;
import br.com.wareline.prototipobackend.exception.BusinessException.BusinessExceptionBody;
import br.com.wareline.prototipobackend.exception.SecurityBusinessException.SecurityExceptionBody;
import br.com.wareline.prototipobackend.service.security.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@Api(tags = { "Security" })
@RequestMapping("/v1/auth")
public class AuthController {
	@Autowired
	private AuthService service;
	
	@ApiOperation(value = "Endpoint de autenticação de usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso", response = TokenLoginResponseDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@PostMapping(value="/login",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TokenLoginResponseDTO> login(@Valid @RequestBody LoginRequestDTO usuario) {
		log.info("Login user");
		return ResponseEntity.ok(service.login(usuario));
	}
	
	@ApiOperation(value = "Endpoint de refreshToken - Obtém um novo token válido")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso", response = RefreshTokenResponseDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)
 
	})
	@PostMapping(value="/refreshToken",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RefreshTokenResponseDTO> refreshToken(@Valid @RequestBody RefreshTokenRequestDTO token) {
		log.info("refreshToken");
		return ResponseEntity.ok(service.refreshToken(token.getRefreshToken()));
	}
	
	

	@ApiOperation(value = "Endpoint que obtém os dados do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso", response = UserDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@PostMapping(value="/identityUser",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_AUTH_IDENTITY_USER')")	
	public ResponseEntity<UserDTO> getUserByToken(@Valid @RequestBody IdentityUserByTokenRequestDTO token) {
		log.info("getUserByToken");
		return ResponseEntity.ok(service.getUserByToken(token.getAccessToken()));
	}
	
	
	@ApiOperation(value = "Endpoint que obtém as roles do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso", response = RoleEntity.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@PostMapping(value="/getRoles",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_AUTH_GET_ROLES')")	
	public ResponseEntity<List<RoleEntity>> getRoles(@Valid @RequestBody RoleUserByTokenRequestDTO token) {
		log.info("getRoles");
		return ResponseEntity.ok(service.getRolesByToken(token.getAccessToken()));
	}
	
	
	
	@ApiOperation(value = "Endpoint de reset de senha do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso"),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@PutMapping(value="/changePassword",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_CHANGE_PASSWORD_ROLE')")
	public ResponseEntity<Void> changePassword(@Valid @RequestBody ChangePasswordRequestDTO usuario) {
		log.info("ChangePassword user");
		service.changePassword(usuario);
		return ResponseEntity.ok().build();
	}
	
	@ApiOperation(value = "Endpoint de reset de senha do usuário")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso"),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@PutMapping(value="/resetPassword",consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_RESET_PASSWORD_ROLE')")
	public ResponseEntity<Void> resetPassword(@Valid @RequestBody ResetPasswordRequestDTO usuario) {
		log.info("ChangePassword user");
		service.resetPassword(usuario);
		return ResponseEntity.ok().build();
	}
	
}
