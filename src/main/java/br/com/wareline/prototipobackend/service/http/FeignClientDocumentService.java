package br.com.wareline.prototipobackend.service.http;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.wareline.prototipobackend.dto.DocumentDTO;

@FeignClient(name = "testfeign", url = "${url.feign.base.client}")
public interface FeignClientDocumentService {
	
	  @GetMapping("/docs")
	  List<DocumentDTO> listDocuments();

}
