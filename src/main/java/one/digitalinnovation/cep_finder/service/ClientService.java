package one.digitalinnovation.cep_finder.service;

import one.digitalinnovation.cep_finder.model.Client;

public interface ClientService {
  Iterable<Client> findAll();

  Client findById(Long id);

  void insert(Client cliente);

  void update(Long id, Client cliente);

  void delete(Long id);
}
