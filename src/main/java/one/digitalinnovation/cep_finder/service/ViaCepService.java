package one.digitalinnovation.cep_finder.service;

import one.digitalinnovation.cep_finder.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {
  @GetMapping("/{cep}/json/")
  Address consultZipCode(@PathVariable("cep") String cep);
}
