package br.com.wareline.prototipobackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Test")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(of = {"id","name" ,"description", "age"})
public class TestDTO {
	
	@ApiModelProperty(value = "Id do Teste", name = "Id", dataType = "Long", example = "1")
	private Long id;
	
	@ApiModelProperty(value = "Nome do Teste", name = "name", dataType = "String", example = "Name Teste Luis")
	private String name;
	
	@ApiModelProperty(value = "Descrição do Teste",name = "description", dataType = "String", example = "Description Test Luis ")
	private String description;
	

	@ApiModelProperty(value = "Idade",name = "insertId", dataType = "Age", example = "38")
	private Long age;
	

}
