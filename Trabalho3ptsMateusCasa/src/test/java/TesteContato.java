import com.model.Contato;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.time.LocalDate;

public class TesteContato {

    @Test
    void construtor(){
        Contato c1 = new Contato(1, "Matheus", "123", "haha", LocalDate.of(2005, 9, 16));

        Long teste1 = c1.getId();
        String teste2 = c1.getNome();
        String teste3 = c1.getTelefone();
        String teste4 = c1.getEmail();
        LocalDate teste5 = c1.getData();

    }

    @Test
    void testeGetId(){
        Contato c1 = new Contato(1, null, null, null, null);

        c1.getId();
    }

    @Test
    void testeSetId(){
        Contato c1 = new Contato();

        c1.setId(1);

    }

    @Test
    void testeGetNome(){
        Contato c1 = new Contato(1, "Matheus", null, null, null);

        c1.getNome();
    }

    @Test
    void testeSetNome(){
        Contato c1 = new Contato();

        c1.setNome("Matheus");

    }

    @Test
    void testeGetTelefone(){
        Contato c1 = new Contato(1, null, "231", null, null);

        c1.getTelefone();
    }

    @Test
    void testeSetTelefone(){
        Contato c1 = new Contato();

        c1.setTelefone("123");

    }

    @Test
    void testeGetEmail(){
        Contato c1 = new Contato(1, null, null, "abc", null);

        c1.getEmail();
    }

    @Test
    void testeSetEmail(){
        Contato c1 = new Contato();

        c1.setEmail("abc");

    }

    @Test
    void testeGetData(){
        Contato c1 = new Contato(1, null, null, "abc", LocalDate.of(2000, 10, 11));

        c1.getData();
    }

    @Test
    void testeSetData(){
        Contato c1 = new Contato();

        c1.setData(LocalDate.of(2000, 11, 10));

    }

    @Test
    void testeToString(){
        Contato c1 = new Contato(1, "Matheus", "1234", "abc", LocalDate.of(2000, 10, 12));

        c1.toString();
    }

}
