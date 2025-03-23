package br.com.cardappio.model;

import br.com.cardappio.client.SMTPFeignClient;
import br.com.cardappio.dto.EmailRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository repository;
    private final SMTPFeignClient smtpFeignClient;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findOne(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Long save(Client newClient) {

        Client savedClient = repository.save(newClient);

        smtpFeignClient.sendEmail(buildEmailRequest(savedClient));

        return savedClient.getId();
    }

    public Client update(final Long id, final Client updatedClient) {
        return repository.findById(id)
                .map(client -> repository.save(updatedClient))
                .orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private EmailRequest buildEmailRequest(Client client) {

        return new EmailRequest(client.getEmail(), "Seja Bem-Vindo", "Seu Cadastro foi concluído com sucesso");
    }

}
