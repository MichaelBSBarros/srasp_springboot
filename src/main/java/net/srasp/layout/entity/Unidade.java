package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "unidade")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_unidade")
	private String nomeUnidade;

	@Column(name = "id_microrregiao")
	private Long idMicrorregiao;

	@Column(name = "id_regiao")
	private Long idRegiao;

	public Unidade(String nomeUnidade, Long idMicrorregiao, Long idRegiao) {
		super();
		this.nomeUnidade = nomeUnidade;
		this.idMicrorregiao = idMicrorregiao;
		this.idRegiao = idRegiao;
	}
}