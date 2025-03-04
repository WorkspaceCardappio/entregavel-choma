package br.com.cardappio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
@ToString
@EqualsAndHashCode(of = "id")
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotBlank
    @Length(min = 1, max = 255)
    private String name;

    @Column(name = "cpf", unique = true)
    @CPF(message = "Informe um CPF válido")
    private String cpf;

    @Past(message = "Informe uma data de nascimento válida")
    @Column(name = "data_nascimento")
    private LocalDate birthDate;

    @Column(name = "telefone")
    @Length(max = 11)
    private String phoneNumber;
}
