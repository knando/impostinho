package br.com.mesquita.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mesquita.model.Usuario;
import br.com.mesquita.repository.UsuarioRepository;
import br.com.mesquita.security.AcessoUsuario;

@Service
public class AcessoUsuarioService implements UserDetailsService {

	private final UsuarioRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public AcessoUsuarioService(UsuarioRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
		return new AcessoUsuario(user);
	}

	public List<Usuario> listar() {
		return userRepository.findAll();
	}

	public Long salvar(Usuario usuario) {
		if (usuario.getRole() == null || usuario.getRole().isBlank()) {
			usuario.setRole("ROLE_ATENDENTE");
		}
		if (usuario.getSenha() != null && !usuario.getSenha().isBlank()) {
			usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		}
		return userRepository.save(usuario).getId();
	}

	public Usuario buscarPorId(Long id) {
		return userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado: " + id));
	}
}