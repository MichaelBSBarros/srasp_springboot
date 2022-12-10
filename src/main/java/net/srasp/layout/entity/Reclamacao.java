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

	@Column(name = "id_secretaria")
	private Long idSecretaria;

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

	@Column(name = "id_unidade")
	private Long idUnidade;

	@Column(name = "id_area")
	private Long idArea;

	@Column(name = "id_severidade")
	private Long idSeveridade;

	@Column(name = "id_statusrecl")
	private Long idStatus;

	public Reclamacao(Long idSecretaria, String dtAbertura, String descricaoReclamacao, String dtConclusao, String comentarios, String cpf, String matricula, Long idUnidade, Long idArea, Long idSeveridade, Long idStatus) {
		this.idSecretaria = idSecretaria;
		this.dtAbertura = dtAbertura;
		this.descricaoReclamacao = descricaoReclamacao;
		this.dtConclusao = dtConclusao;
		this.comentarios = comentarios;
		this.cpf = cpf;
		this.matricula = matricula;
		this.idUnidade = idUnidade;
		this.idArea = idArea;
		this.idSeveridade = idSeveridade;
		this.idStatus = idStatus;
	}
}