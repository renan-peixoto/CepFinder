package one.digitalinnovation.cep_finder.service.impl;

import java.util.Optional;
import one.digitalinnovation.cep_finder.model.Address;
import one.digitalinnovation.cep_finder.model.Client;
import one.digitalinnovation.cep_finder.repositories.AddressRepository;
import one.digitalinnovation.cep_finder.repositories.ClientRepository;
import one.digitalinnovation.cep_finder.service.ClientService;
import one.digitalinnovation.cep_finder.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientRepository clientRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private ViaCepService viaCepService;

  @Override
  public Iterable<Client> findAll() {
    return clientRepository.findAll();
  }

  @Override
  public Client findById(Long id) {
    return clientRepository.findById(id).get();
  }

  @Override
  public void insert(Client client) {
    saveClientWithZipCode(client);
  }

  @Override
  public void update(Long id, Client cliente) {
    Optional<Client> clientBD = clientRepository.findById(id);
    if (clientBD.isPresent()) {
      saveClientWithZipCode(cliente);
    }
  }

  @Override
  public void delete(Long id) {
    clientRepository.deleteById(id);
  }

  private void saveClientWithZipCode(Client client) {
    String cep = client.getAddress().getCep();
    Address address = addressRepository
      .findById(cep)
      .orElseGet(() -> {
        Address newAddress = viaCepService.consultZipCode(
          client.getAddress().getCep()
        );
        addressRepository.save(newAddress);
        return newAddress;
      });

    client.setAddress(address);
    clientRepository.save(client);
  }
}
