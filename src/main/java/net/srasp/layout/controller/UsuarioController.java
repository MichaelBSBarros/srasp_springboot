package net.srasp.layout.controller;

import net.srasp.layout.entity.Usuario;
import net.srasp.layout.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class UsuarioController {
	
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	// handler method to handle list usuarios and return mode and view
	@GetMapping("/cidadaos")
	public String listUsuarios(Model model) {
		model.addAttribute("usuarios", usuarioService.getAllUsuarios());
		return "cidadaos";
	}

	@GetMapping("/cidadaos/new")
	public String createUsuarioForm(Model model) {
		
		// create usuario object to hold usuario form data
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "create_cidadao";
		
	}
	
	@PostMapping("/cidadaos")
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "redirect:/cidadaos";
	}
	
	@GetMapping("/cidadaos/edit/{id}")
	public String editUsuarioForm(@PathVariable Long id, Model model) {
		model.addAttribute("usuario", usuarioService.getUsuarioById(id));
		return "edit_cidadao";
	}

	@PostMapping("/cidadaos/{id}")
	public String updateUsuario(@PathVariable Long id,
			@ModelAttribute("usuario") Usuario usuario,
			Model model) {
		
		// get usuario from database by id
		Usuario existingUsuario = usuarioService.getUsuarioById(id);
		existingUsuario.setId(id);
		existingUsuario.setNome(usuario.getNome());
		existingUsuario.setSenha(usuario.getSenha());
		existingUsuario.setEmail(usuario.getEmail());
		existingUsuario.setDtNascimento(usuario.getDtNascimento());
		existingUsuario.setCpf(usuario.getCpf());
		existingUsuario.setTelefoneMovel(usuario.getTelefoneMovel());
		existingUsuario.setTelefoneFixo(usuario.getTelefoneFixo());
		existingUsuario.setCep(usuario.getCep());
		existingUsuario.setLogradouro(usuario.getLogradouro());
		existingUsuario.setNumEndereco(usuario.getNumEndereco());
		existingUsuario.setComplemento(usuario.getComplemento());
		existingUsuario.setUf(usuario.getUf());
		existingUsuario.setBairro(usuario.getBairro());
		existingUsuario.setCidade(usuario.getCidade());
		existingUsuario.setMatricula(usuario.getMatricula());
		existingUsuario.setDtInicial(usuario.getDtInicial());
		existingUsuario.setDtFinal(usuario.getDtFinal());
		
		// save updated usuario object
		usuarioService.updateUsuario(existingUsuario);
		return "redirect:/cidadaos";
	}
	
	// handler method to handle delete usuario request
	
	@GetMapping("/cidadaos/{id}")
	public String deleteUsuario(@PathVariable Long id) {
		usuarioService.deleteUsuarioById(id);
		return "redirect:/cidadaos";
	}
	
}
