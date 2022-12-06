package net.srasp.layout.service.impl;

import net.srasp.layout.entity.Usuario;
import net.srasp.layout.repository.UsuarioRepository;
import net.srasp.layout.service.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);
	}

}
