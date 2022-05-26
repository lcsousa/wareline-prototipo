package br.com.wareline.prototipobackend.dto.security;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDTO {
	@NotNull(message = "Campo Login é obrigatório")
	@ApiModelProperty(value = "Login do usuário", name = "login", dataType = "String", example = "admin")
	private String username;
	
	@NotNull(message = "Campo Password é obrigatório")
	@ApiModelProperty(value = "Senha do usuário", name = "password", dataType = "String", example = "jah")
	private String password;
}
