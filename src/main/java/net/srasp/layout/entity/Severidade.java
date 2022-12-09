package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "severidade")
public class Severidade {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "severidade")
	private String severidade;

	public Severidade(String severidade) {
		super();
		this.severidade = severidade;
	}
}