package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;

import support.api.UsuarioApi;
import support.dominio.User;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;


public class UsuarioStepDefinition {

    private static final String ENDPOINT_CRIAR_USUARIO = "/user";
    private static final String ENDPOINT_USUARIO = "/user/{name}";

    private User usuario;

    @Quando("criar um usuario")
    public void criarUmUsuario() {

        usuario = User.builder().build(); //Pegando informações do usuário da classe User support.dominio

        UsuarioApi usuarioApi = new UsuarioApi();
        usuarioApi.criarInformacoesUsuario(usuario);

    }

    @Então("o usuario é salvo no sistema")
    public void oUsuarioESalvoNoSistema() {

        usuario = User.builder().build(); //Pegando informações do usuário da classe User support.dominio

        UsuarioApi usuarioApi = new UsuarioApi();
        usuarioApi.procurarUsuarioPorNome(usuario);

    }
}
