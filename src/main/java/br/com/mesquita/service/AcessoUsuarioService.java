package br.com.mesquita.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mesquita.model.Usuario;
import br.com.mesquita.repository.UsuarioRepository;
import br.com.mesquita.security.AcessoUsuario;

@Service
public class AcessoUsuarioService implements UserDetailsService {

    private final UsuarioRepository userRepository;

    public AcessoUsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        return new AcessoUsuario(user);
    }
}
