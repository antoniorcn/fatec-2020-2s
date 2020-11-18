package les.tarde.aula13;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TesteSenha {

	public static void main(String[] args) {
		BCryptPasswordEncoder pass = new BCryptPasswordEncoder();
		
		System.out.println("Senha: " + pass.encode("user"));

	}

}
