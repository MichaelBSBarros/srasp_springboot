package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_area")
	private String nomeArea;

	@Column(name = "microrregiao")
	private String microrregiao;

	@Column(name = "regiao")
	private String regiao;

	public Area(String nomeArea, String microrregiao, String regiao) {
		super();
		this.nomeArea = nomeArea;
		this.microrregiao = microrregiao;
		this.regiao = regiao;
	}
}