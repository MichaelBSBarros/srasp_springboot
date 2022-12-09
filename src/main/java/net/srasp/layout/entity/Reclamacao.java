package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "reclamacao")
public class Reclamacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "secretaria")
	private String secretaria;

	@Column(name = "dt_abertura")
	private String dtAbertura;

	@Column(name = "descricao_reclamacao")
	private String descricaoReclamacao;

	@Column(name = "dt_conclusao")
	private String dtConclusao;

	@Column(name = "comentarios")
	private String comentarios;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "unidade")
	private String unidade;

	@Column(name = "area")
	private String area;

	@Column(name = "severidade")
	private String severidade;

	@Column(name = "statusrecl")
	private String status;

	public Reclamacao(String secretaria, String dtAbertura, String descricaoReclamacao, String dtConclusao, String comentarios, String cpf, String matricula, String unidade, String area, String severidade, String status) {
		this.secretaria = secretaria;
		this.dtAbertura = dtAbertura;
		this.descricaoReclamacao = descricaoReclamacao;
		this.dtConclusao = dtConclusao;
		this.comentarios = comentarios;
		this.cpf = cpf;
		this.matricula = matricula;
		this.unidade = unidade;
		this.area = area;
		this.severidade = severidade;
		this.status = status;
	}
}