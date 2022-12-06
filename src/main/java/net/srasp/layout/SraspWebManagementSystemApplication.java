package net.srasp.layout;

import net.srasp.layout.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SraspWebManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SraspWebManagementSystemApplication.class, args);
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
