package br.com.wareline.prototipobackend.dto.security;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshTokenResponseDTO {
	
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("expires_in")
	private Integer expiresIn;
	@JsonProperty("token_type")
	private String tokenType;
}
