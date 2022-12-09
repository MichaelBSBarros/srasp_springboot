package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "statusrecl")
public class StatusRecl {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao")
	private String descricao;

	public StatusRecl(String descricao) {
		super();
		this.descricao = descricao;
	}
}
