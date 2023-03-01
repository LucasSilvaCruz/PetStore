package support.api;

import lombok.Builder;
import org.apache.http.HttpStatus;
import org.junit.rules.Timeout;
import support.dominio.User;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;


public class UsuarioApi {

    private static final String ENDPOINT_CRIAR_USUARIO = "/user";
    private static final String ENDPOINT_USUARIO = "/user/{name}";




    public void criarInformacoesUsuario(User usuario) {

        given().
            log().all().
            body(usuario).
        when().
            log().all().
            post(baseURI + ENDPOINT_CRIAR_USUARIO).
        then().
            log().all().
            statusCode(HttpStatus.SC_OK)
        ;

    }

    public void procurarUsuarioPorNome(User usuario) {

        //String jsonBody = lerJson("db\\usuario.Json");
        given().
                log().all().
                pathParam("name",   usuario.getUserName()).
        when().
                log().all().
                get(baseURI + "/user/{name}").
        then().
                log().all().
                statusCode(200).
                body("username", is(usuario.getUserName()))
        ;

    }
}
