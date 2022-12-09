package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "unidade")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_unidade")
	private String nomeUnidade;

	@Column(name = "microrregiao")
	private String microrregiao;

	@Column(name = "regiao")
	private String regiao;

	public Unidade(String nomeUnidade, String microrregiao, String regiao) {
		super();
		this.nomeUnidade = nomeUnidade;
		this.microrregiao = microrregiao;
		this.regiao = regiao;
	}
}