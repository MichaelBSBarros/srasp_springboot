package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "microrregiao")
public class Microrregiao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao_microrregiao")
	private String descricaoMicrorregiao;

	@Column(name = "cod_microrregiao")
	private String codMicrorregiao;

	public Microrregiao(String descricaoMicrorregiao, String codMicrorregiao) {
		super();
		this.descricaoMicrorregiao = descricaoMicrorregiao;
		this.codMicrorregiao = codMicrorregiao;
	}
}