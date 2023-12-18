package br.com.volmed.volmed.controller;

import br.com.volmed.volmed.domain.usuario.DadosAutenticacao;
import br.com.volmed.volmed.domain.usuario.Usuario;
import br.com.volmed.volmed.infra.security.DadosTokenJWT;
import br.com.volmed.volmed.infra.security.TokenService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    //O AuthenticationManager no Spring é responsável por autenticar usuários durante o processo de login.
    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    //Retornando token jwt
    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }
}
