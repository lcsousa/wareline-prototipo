package br.com.wareline.prototipobackend.dto.security;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUserByTokenRequestDTO {
	
	@ApiModelProperty(value = "Access Token do usuário", name = "token", dataType = "String", example = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsdWlzQWRtaW4iLCJleHAiOjE2NDYwODA1MTB9.C1g67D05FyIBDt8w9PKWHp_4bzqkz-n_AI3fY5Qd-2D00ndWGhxWHrBaV6_ybRXpUHbcBP260KSAZy-bSWW_4g")
	private String accessToken;
	
}
