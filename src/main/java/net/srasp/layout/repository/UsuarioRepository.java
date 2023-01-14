package net.srasp.layout.repository;

import net.srasp.layout.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    @Query("SELECT u FROM Usuario u WHERE u.email =:email AND u.senha =:password")
    Usuario findUser(@Param("email") String email, @Param("password") String password);

}
