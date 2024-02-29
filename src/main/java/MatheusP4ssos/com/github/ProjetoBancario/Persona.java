package MatheusP4ssos.com.github.ProjetoBancario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data     //Gera o Get, Set, Equals e HashCode
@Builder  //Habilita a criação de um objeto staticamente
@Entity   //Isso aqui define que é uma classe do banco de dados
@NoArgsConstructor  //Cria um construtor vazio
@AllArgsConstructor //Cria um construtor com todos parametros
public class Persona {

 @Id //Define qual é a primary Key do banco de dados
 @GeneratedValue(strategy = GenerationType.IDENTITY) //Define o tipo de gerador do PK
 private Long id;

 @Column(name = "name", nullable = false) //Define o padrão para a coluna
 private String name;

 @Email  //Faz a validação do tipo email (@ .com)
 private String email;

 private String password;

 @CPF  //Faz a validação matematica do CPF
 private String cpf;

 private LocalDate birthDay;

 private Character gender;

 private LocalDate whenCreated;

 private LocalDate lastLogin;

}


