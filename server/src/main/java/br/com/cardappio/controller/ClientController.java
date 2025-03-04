package br.com.cardappio.controller;

import br.com.cardappio.model.Client;
import br.com.cardappio.model.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/clients")
@AllArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping
    public ResponseEntity<List<Client>> findAll() { 
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findOne(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(service.findOne(id));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid Client newClient) {

        Long idSaved = service.save(newClient);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(idSaved)
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<Client> update(@RequestBody @Valid Client newClient) {
        return ResponseEntity.ok(service.update(newClient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {

        service.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
