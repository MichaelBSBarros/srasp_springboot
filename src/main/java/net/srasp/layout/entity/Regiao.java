package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "regiao")
public class Regiao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao_regiao")
	private String descricaoRegiao;

	@Column(name = "cod_regiao")
	private String codRegiao;

	public Regiao(String descricaoRegiao, String codRegiao) {
		super();
		this.descricaoRegiao = descricaoRegiao;
		this.codRegiao = codRegiao;
	}
}