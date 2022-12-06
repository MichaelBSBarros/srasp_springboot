package net.srasp.layout.service;

import net.srasp.layout.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioService {

	List<Usuario> getAllUsuarios();

	Usuario saveUsuario(Usuario usuario);
	
	Usuario getUsuarioById(Long id);
	
	Usuario updateUsuario(Usuario usuario);
	
	void deleteUsuarioById(Long id);
}
