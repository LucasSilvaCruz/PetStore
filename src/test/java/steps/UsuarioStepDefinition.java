package steps;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.http.HttpStatus;
import petstore.Pet;
import support.dominio.User;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static petstore.Pet.lerJson;

public class UsuarioStepDefinition {

    private Map<String, String> expectedUser = new HashMap<>();
    private User user;
    private static final String ENDPOINT_CRIAR_USUARIO = "/user";
    private static final String ENDPOINT_USUARIO = "/user/{name}";


    @Quando("criar um usuario")
    public void criarUmUsuario() {


        user = User.builder().build(); //Pegando informações do usuário da classe User support.dominio

        //String jsonBody = lerJson("db\\usuario.Json");

        given().
                log().all().
                body(user).

        when().
                log().all().
                post(baseURI + ENDPOINT_CRIAR_USUARIO).


        then().
                log().all().
                statusCode(200).
                statusCode(HttpStatus.SC_OK);
        System.out.println("o que está vindo do config é " + user);

    }

    @Então("o usuario é salvo no sistema")
    public void oUsuarioESalvoNoSistema() throws IOException {

        user = User.builder().build(); //Pegando informações do usuário da classe User support.dominio
        String jsonBody = lerJson("db\\usuario.Json");

        given().
                log().all().
                pathParam("name", user.getUserName()).


        when().
                log().all().
                get(baseURI + ENDPOINT_USUARIO).
        then().
                log().all().
                statusCode(200).
                body("username", is(user.getUserName()))

        ;

    }
}
