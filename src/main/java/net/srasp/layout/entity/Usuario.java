package net.srasp.layout.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "senha")
	private String senha;
	
	@Column(name = "email")
	private String email;

	@Column(name = "dt_nascimento")
	private String dtNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "telefone_movel")
	private String telefoneMovel;

	@Column(name = "telefone_fixo")
	private String telefoneFixo;

	@Column(name = "cep")
	private String cep;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "num_endereco")
	private String numEndereco;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "uf")
	private String uf;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "matricula")
	private String matricula;

	@Column(name = "dt_inicial")
	private String dtInicial;

	@Column(name = "dt_final")
	private String dtFinal;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_permission",  joinColumns = {@JoinColumn (name = "id_user")},
			inverseJoinColumns = {@JoinColumn (name = "id_permission")})
	private List<Permission> permissions;

	public List<String> getRoles() {
		List<String> roles = new ArrayList<>();
		for (Permission permission : permissions) {
			roles.add(permission.getDescription());
		}
		return roles;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissions;
	}

	public Usuario(String nome, String senha, String email, String telefoneMovel, String cpf, String dtNascimento, String matricula, String dtInicial, String dtFinal) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.telefoneMovel = telefoneMovel;
		this.matricula = matricula;
		this.dtInicial = dtInicial;
		this.dtFinal = dtFinal;
	}
}
