// 1 - Pacote
package petstore;

// 2 - Bibliotecas
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;

// 3 - Classe
public class Pet {

// 3.1 Atributos
String uri = "https://petstore.swagger.io/v2/pet"; //Endereço da entidade para cadastrar PET


//3.2 Métodos e Funções
    public String lerJson(String caminhoJson) throws IOException {

        //caminhoJson = "C:\\Projetos\\PetStore\\db\\pet1.Json";
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post

    @Test // anotação do TestNG que identifica a função ou método como um teste.
    public void incluirPet() throws IOException {
        //Atributos do teste
        String jsonBody = lerJson("db\\pet1.Json");

        // Sintaxe Gherkin
        // DADO - QUANDO - ENTÃO
        // Given - When - Then

        given()// Dado
                .contentType("application/json") // comuns em apis REST - antigas text/xml
                .log().all() // incluindo log total
                .body(jsonBody) // incluindo no body da requisição, o arquivo carregado na variável jsonBody
        .when()// Quando
                .post(uri) //realizar a requisição na uri informada
        .then()// Então
                .log().all() // incluindo log total
                .statusCode(200)  // validando status code 200 no retorno
                .body("name", is("Simba")) // Validando que no response body, tem um atributo nome com o vlor Snoopy
                .body("status", is("available")) // Validando que no response body, o status está como disponível
                .body("category.name", is("dog"))
                .body("tags.name", contains("Treino REST assured"))


         ;


    }

    @Test(priority = 2)
    public void consultarPet(){

        String petId = "13122016";

        given()
                .contentType("application/Json")
                .log().all()

        .when()
                .get(uri + "/" + petId)


        .then()
            .log().all()
            .statusCode(200)
            .body("name", is( "Simba"))
            .body("tags.id", contains (2023))
            .body("status", is("available"))

        ;


    }

    @Test(priority = 3)
    public void alterarPet() throws IOException {

        String jsonBody = lerJson("db\\pet2.Json");

        given()
                .contentType("application/Json")
                .body(jsonBody)
                .log().all()

        .when()
                .put(uri)

        .then()
                .statusCode(200)
                .log().all()
                .body("name", is ("Potó"))

         ;



    }

    @Test(priority = 4)
    public void deletarPet() {

        String petId = "13122016";

        given()
                .log().all()
                .contentType("application/Json")
        .when()
                .log().all()
                .delete(uri + "/" + petId)


        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("message", is(petId))
        ;
    }


}
