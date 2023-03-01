package support.dominio;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
@Getter
@Setter // lombok cria automaticamente os get,set...
@Builder // gerando uma instancia desse usuário
public class User {

    @Builder.Default
    private int id = 0;
    @Builder.Default
    private String userName = "Lucas Silva Cruz";
    @Builder.Default
    private String firtName = "Lucas";
    @Builder.Default
    private String lastName = "Cruz";
    @Builder.Default
    private String email = "lucas@teste";
    @Builder.Default
    private String password = "teste123";
    @Builder.Default
    private String phone = "11999999999";
    @Builder.Default
    private int userStatus = 0;


}