package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "secretaria")
public class Secretaria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_secretaria")
	private String nomeSecretaria;

	public Secretaria(String nomeSecretaria) {
		super();
		this.nomeSecretaria = nomeSecretaria;
	}
}