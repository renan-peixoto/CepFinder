package one.digitalinnovation.cep_finder.repositories;

import one.digitalinnovation.cep_finder.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, String> {}
