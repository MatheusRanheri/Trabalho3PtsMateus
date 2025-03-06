import com.controller.Agenda;
import com.model.ParametroInvalidoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.NoSuchElementException;

public class TestaAgenda {

    @Test
    void testeAdicionar() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();
        a1.adicionar(1, "matheus", "abc", "123", LocalDate.of(2005, 9, 16));

        assertEquals(1, a1.listarContatos().size(), "Deve adicionar um contato na lista");
    }

    @Test
    void testeNegativoAdicionarNome() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();


        assertThrows(ParametroInvalidoException.class,() -> {
            a1.adicionar(1, null, "abc", "123", LocalDate.of(2005, 9, 16));
        });
    }

    @Test
    void testeNegativoAdicionarTelefone() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();


        assertThrows(ParametroInvalidoException.class,() -> {
            a1.adicionar(1, "matheus", "abc", null, LocalDate.of(2005, 9, 16));
        });
    }

    @Test
    void testeNegativoAdicionarData() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();


        assertThrows(ParametroInvalidoException.class,() -> {
            a1.adicionar(1, "matheus", "abc", "123", null);
        });
    }

    @Test
    void testeRemover() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();
        a1.adicionar(1, "m", "a", "1", LocalDate.of(2005, 9, 16));
        a1.remover(1);

        assertEquals(0, a1.listarContatos().size(), "Deve  remover um contato pelo id informado");
    }

    @Test
    void testeRemoverNegativo() throws NoSuchElementException {
        Agenda a1 = new Agenda();


        assertThrows(NoSuchElementException.class, () -> {
            a1.adicionar(1L, "m", "a", "1", LocalDate.of(2005, 9, 16));
            a1.remover(2);

        });
    }

    @Test
    void testaEditar() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();

        a1.adicionar(1, "m", "a", "1", LocalDate.of(2005, 9, 16));

        a1.editarContato(1L, "m", "a", "1", LocalDate.of(2005, 9, 16));
        assertEquals(1, a1.listarContatos().size(), "Deve editar um contato escolhido pelo id");
    }

    @Test
    void testaEditarNnegativo() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();

        a1.adicionar(1, "m", "a", "1", LocalDate.of(2005, 9, 16));

        a1.editarContato(0L, "m", "a", "1", LocalDate.of(2005, 9, 16));

    }

    @Test
    void testaPesquisaPorLetra() throws ParametroInvalidoException {
        Agenda a1 =  new Agenda();

        a1.adicionar(1, "matheus", "a", "1", LocalDate.of(2005, 9, 16));

        a1.pesquisaPorLetra("mat");
        assertEquals(1,  a1.listarContatos().size(), "deve encontrar um contato pela pesquisa de letras iniciais de seu nome ou o nome completo");
    }

    @Test
    void testaPesquisaPorLetraNegativo() throws ParametroInvalidoException {
        Agenda a1 =  new Agenda();

        a1.adicionar(1, "matheus", "a", "1", LocalDate.of(2005, 9, 16));

        a1.pesquisaPorLetra("abner");
        assertEquals(1,  a1.listarContatos().size(), "deve encontrar um contato pela pesquisa de letras iniciais de seu nome ou o nome completo");
    }

    @Test
    void testaAniversarianteDoMes() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();

        a1.adicionar(1, "matheus", "a", "1", LocalDate.of(2005, 3, 16));

        a1.aniversarianteDoMes(3);
        assertEquals(1, a1.listarContatos().size(), "Deve mostrar o aniversariante do mes, com base no mes");
    }

    @Test
    void testaAniversarianteDoMesNegativo() throws ParametroInvalidoException {
        Agenda a1 = new Agenda();

        a1.adicionar(1, "matheus", "a", "1", LocalDate.of(2005, 3, 16));

        a1.aniversarianteDoMes(4);
        assertEquals(1, a1.listarContatos().size(), "Deve mostrar o aniversariante do mes, com base no mes");
    }

}
