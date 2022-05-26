package br.com.wareline.prototipobackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wareline.prototipobackend.dto.TestDTO;
import br.com.wareline.prototipobackend.exception.BusinessException.BusinessExceptionBody;
import br.com.wareline.prototipobackend.exception.SecurityBusinessException.SecurityExceptionBody;
import br.com.wareline.prototipobackend.mapper.TestMapper;
import br.com.wareline.prototipobackend.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/test")
@Slf4j
@Api(tags = { "Test" })
public class TestController {

	@Autowired
	public TestService service;
	
	@Autowired
	private TestMapper testMapper;

	@ApiOperation(value = "Endpoint que busca todos os registros test")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso", response = TestDTO.class, responseContainer = "List"),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class)

	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_TEST_FINDALL')")
	public ResponseEntity<List<TestDTO>> findAll() throws Exception {

		log.info("Find all tests");
		return ResponseEntity.status(HttpStatus.OK).body(testMapper.convertListEntitysToDtos(service.findAll()));
	}

	@ApiOperation(value = "Endpoint que busca registro test por Id")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Requisição processada com Sucesso. registro localizado.", response = TestDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 404, message = "Not Found. Registro(s) não encontrado(s).", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class) })
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_TEST_FIND')")
	public ResponseEntity<TestDTO> findById(@Valid @PathVariable Long id) throws Exception {

		log.info("Buscar test {}", id);

		return ResponseEntity.status(HttpStatus.OK).body( testMapper.convertEntityToDto(service.findById(id)));
	}

	@ApiOperation(value = "Endpoint que salvar registro test")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registro criado.", response = TestDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 400, message = "Bad Request. Parâmetro(s) inválido(s)", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class) })
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_TEST_CREATE')")
	public ResponseEntity<TestDTO> save(
			@Valid @RequestBody @ApiParam(value = "TestDto", required = true, name = "testDto") TestDTO testDTO)
			throws Exception {

		log.info("Save test {}", testDTO);
		return ResponseEntity.status(HttpStatus.OK).body(testMapper.convertEntityToDto(service.save(testMapper.convertDtoToEntity(testDTO))));
	}

	@ApiOperation(value = "Endpoint que atualiza registro test")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registro Atualizado.", response = TestDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 404, message = "Not Found. Registro(s) não encontrado(s).", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class) })
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasAnyRole('ROLE_TEST_UPDATE')")
	public ResponseEntity<TestDTO> update(@Valid @PathVariable Long id,
			@Valid @RequestBody @ApiParam(value = "TestDtos", required = true, name = "testDto") TestDTO testDTO)
			throws Exception {

		log.info("Atualiza test {}", testDTO);
		testDTO.setId(id);
		service.update(testMapper.convertDtoToEntity(testDTO));
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Endpoint que Exclui registro test")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Registro Excluído.", response = TestDTO.class),
			@ApiResponse(code = 500, message = "Erro interno", response = BusinessExceptionBody.class),
			@ApiResponse(code = 404, message = "Not Found. Registro(s) não encontrado(s).", response = BusinessExceptionBody.class),
			@ApiResponse(code = 401, message = "Unauthorized - Usuário não Autenticado", response = SecurityExceptionBody.class),
			@ApiResponse(code = 403, message = "Forbidden - Usuário não Atorizado para acessar o método.", response = SecurityExceptionBody.class) })
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ROLE_TEST_DELETE')")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception {

		log.info("Delete test {}", id);
		service.delete(id);
		return ResponseEntity.ok().build();
	}

}