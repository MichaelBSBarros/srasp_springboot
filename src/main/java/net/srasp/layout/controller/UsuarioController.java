package net.srasp.layout.controller;

import net.srasp.layout.entity.Usuario;
import net.srasp.layout.service.PermissionService;
import net.srasp.layout.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;

	@Autowired
	private PermissionService permissionService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}

	//handler method to handle list usuarios and return mode and view
	@GetMapping("/cidadaos")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String listUsuarios(Model model) {
		Query userCidadao = usuarioService.createQuery("FROM Usuario WHERE matricula IS NULL");
		model.addAttribute("usuarios", userCidadao.getResultList());
		return "usuarios/cidadaos";
	}

	@GetMapping("/autenticacao/cidadaos/new")
	public String createUsuarioForm(Model model) {
		
		// create usuario object to hold usuario form data
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuarios/create_cidadao";
		
	}

	@PostMapping("/autenticacao/cidadaos")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuario.setPermissions(Collections.singletonList(permissionService.getPermissionByDescription("CIDADAO")));
		usuarioService.saveUsuario(usuario);
		return "redirect:/reclamacao";
	}

	@GetMapping("/cidadaos/edit/{id}")
	public String editUsuarioForm(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.getUsuarioById(id));
		return "usuarios/edit_cidadao";
	}

	@PostMapping("/cidadaos/{id}")
	public String updateUsuario(@PathVariable Long id,
			@ModelAttribute("usuario") Usuario usuario,
			Model model) {

		// get usuario from database by id
//		Usuario existingUsuario = usuarioService.getUsuarioById(id);
//		existingUsuario.setId(id);
//		existingUsuario.setNome(usuario.getNome());
//		existingUsuario.setSenha(usuario.getSenha());
//		existingUsuario.setEmail(usuario.getEmail());
//		existingUsuario.setDtNascimento(usuario.getDtNascimento());
//		existingUsuario.setCpf(usuario.getCpf());
//		existingUsuario.setTelefoneMovel(usuario.getTelefoneMovel());
//		existingUsuario.setTelefoneFixo(usuario.getTelefoneFixo());
//		existingUsuario.setCep(usuario.getCep());
//		existingUsuario.setLogradouro(usuario.getLogradouro());
//		existingUsuario.setNumEndereco(usuario.getNumEndereco());
//		existingUsuario.setComplemento(usuario.getComplemento());
//		existingUsuario.setUf(usuario.getUf());
//		existingUsuario.setBairro(usuario.getBairro());
//		existingUsuario.setCidade(usuario.getCidade());
//		existingUsuario.setMatricula(usuario.getMatricula());
//		existingUsuario.setDtInicial(usuario.getDtInicial());
//		existingUsuario.setDtFinal(usuario.getDtFinal());
		usuarioService.updateUsuario(id.toString(), usuario);
		return "redirect:/cidadaos";
	}

	@GetMapping("/cidadaos/{id}")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuarioById(id);
		return "redirect:/cidadaos";
	}

	@GetMapping("/ouvidores")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String listUsuariosOuvidor(Model model) {
		Query userOuvidor = usuarioService.createQuery("FROM Usuario WHERE matricula IS NOT NULL");
		model.addAttribute("usuarios", userOuvidor.getResultList());
		return "usuarios/ouvidores";
	}

	@GetMapping("/autenticacao/ouvidores/new")
	public String createUsuarioFormOuvidor(Model model) {

		// create usuario object to hold usuario form data
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "usuarios/create_ouvidor";

	}

	@PostMapping("/autenticacao/ouvidores")
	public String saveUsuarioOuvidor(@ModelAttribute("usuario") Usuario usuario) {
		usuario.setPermissions(Collections.singletonList(permissionService.getPermissionByDescription("OUVIDOR")));
		usuarioService.saveUsuario(usuario);
		return "redirect:/reclamacao";
	}

	@GetMapping("/ouvidores/edit/{id}")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String editUsuarioFormOuvidor(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.getUsuarioById(id));
		return "usuarios/edit_ouvidor";
	}

	@PostMapping("/ouvidores/{id}")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String updateUsuarioOuvidor(@PathVariable Long id,
									   @ModelAttribute("usuario") Usuario usuario,
									   Model model) {

		// get usuario from database by id
//		Usuario existingUsuario = usuarioService.getUsuarioById(id);
//		existingUsuario.setId(id);
//		existingUsuario.setNome(usuario.getNome());
//		existingUsuario.setSenha(usuario.getSenha());
//		existingUsuario.setEmail(usuario.getEmail());
//		existingUsuario.setUf(usuario.getUf());
//		existingUsuario.setMatricula(usuario.getMatricula());
//		existingUsuario.setDtInicial(usuario.getDtInicial());
		usuarioService.updateUsuario(id.toString(), usuario);
		return "redirect:/ouvidores";
	}

	@GetMapping("/ouvidores/{id}")
	@PreAuthorize("hasAnyAuthority('OUVIDOR')")
	public String deleteUsuarioOuvidor(@PathVariable Long id) {
		usuarioService.deleteUsuarioById(id);
		return "redirect:/ouvidores";
	}

}
