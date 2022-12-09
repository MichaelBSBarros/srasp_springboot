package net.srasp.layout.service;

import net.srasp.layout.entity.StatusRecl;
import net.srasp.layout.entity.Usuario;
import net.srasp.layout.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;

	@PersistenceContext
	private EntityManager entityManager;

	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).get();
	}

//	public Usuario updateUsuario(Usuario usuario) {
//		return usuarioRepository.save(usuario);
//	}

	public void updateUsuario(String id, Usuario instance_update) {
		Optional<Usuario> existing_instance = usuarioRepository.findById(Long.parseLong(id));
		if (existing_instance.isPresent()) {
			if (existing_instance.get().getId().equals(instance_update.getId())) {
				usuarioRepository.save(instance_update);
			}
		}
	}

	public void deleteUsuarioById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Query createQuery(String query) {
		return entityManager.createQuery(query);
	}

}
