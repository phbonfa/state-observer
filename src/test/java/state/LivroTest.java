package state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroTest {

    Livro livro;

    @BeforeEach
    public void setUp() {
        livro = new Livro();
    }

    // Livro cadastrado

    @Test
    public void naoDeveCadastrarLivroCadastrado() {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        assertFalse(livro.cadastrar());
    }

    @Test
    public void deveAlugarLivroCadastrado() {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        assertTrue(livro.alugar());
        assertEquals(LivroEstadoAlugado.getInstance(), livro.getEstado());
    }

    @Test
    public void deveReservarLivroCadastrado() {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        assertTrue(livro.reservar());
        assertEquals(LivroEstadoReservado.getInstance(), livro.getEstado());
    }

    @Test
    public void deveVenderLivroCadastrado() {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        assertTrue(livro.vender());
        assertEquals(LivroEstadoVendido.getInstance(), livro.getEstado());
    }

    @Test
    public void naoDevePerderLivroCadastrado() {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        assertFalse(livro.perder());
    }

    // Livro reservado

    @Test
    public void naoDeveCadastrarLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.cadastrar());
    }

    @Test
    public void deveAlugarLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertTrue(livro.alugar());
        assertEquals(LivroEstadoAlugado.getInstance(), livro.getEstado());
    }

    @Test
    public void naoDeveReservarLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void deveVenderLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertTrue(livro.vender());
        assertEquals(LivroEstadoVendido.getInstance(), livro.getEstado());
    }

    @Test
    public void naoDevePerderLivroReservado() {
        livro.setEstado(LivroEstadoReservado.getInstance());
        assertFalse(livro.perder());
    }

    // Livro alugado

    @Test
    public void deveCadastrarLivroAlugado() {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        assertTrue(livro.cadastrar());
        assertEquals(LivroEstadoCadastrado.getInstance(), livro.getEstado());
    }

    @Test
    public void naoDeveAlugarLivroAlugado() {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        assertFalse(livro.alugar());
    }

    @Test
    public void naoDeveReservarLivroAlugado() {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void deveVenderLivroAlugado() {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        assertTrue(livro.vender());
        assertEquals(LivroEstadoVendido.getInstance(), livro.getEstado());
    }

    @Test
    public void devePerderLivroAlugado() {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        assertTrue(livro.perder());
        assertEquals(LivroEstadoPerdido.getInstance(), livro.getEstado());
    }

    // Livro vendido

    @Test
    public void naoDeveCadastrarLivroVendido() {
        livro.setEstado(LivroEstadoVendido.getInstance());
        assertFalse(livro.cadastrar());
    }

    @Test
    public void naoDeveAlugarLivroVendido() {
        livro.setEstado(LivroEstadoVendido.getInstance());
        assertFalse(livro.alugar());
    }

    @Test
    public void naoDeveReservarLivroVendido() {
        livro.setEstado(LivroEstadoVendido.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void naoDeveVenderLivroVendido() {
        livro.setEstado(LivroEstadoVendido.getInstance());
        assertFalse(livro.vender());
    }

    @Test
    public void naoDevePerderLivroVendido() {
        livro.setEstado(LivroEstadoVendido.getInstance());
        assertFalse(livro.perder());
    }

    // Livro perdido

    @Test
    public void naoDeveCadastrarLivroPerdido() {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        assertFalse(livro.cadastrar());
    }

    @Test
    public void naoDeveAlugarLivroPerdido() {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        assertFalse(livro.alugar());
    }

    @Test
    public void naoDeveReservarLivroPerdido() {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void naoDeveVenderLivroPerdido() {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        assertFalse(livro.vender());
    }

    @Test
    public void naoDevePerderLivroPerdido() {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        assertFalse(livro.perder());
    }



    //Test observer
    @Test
    public void deveNotificarLivroAlugadoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivro(estante);
        estante.lancarLivroDepositado();

        assertEquals("Livro 1, depositado na Estante{, genero=Ação, nomeSecao='A', nomeEstante='Romance'}", livro.getUltimaNotificacao());
    }

    @Test
    public void deveNotificarLivroCadastradoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivro(estante);
        estante.lancarLivroDepositado();

        assertEquals("Livro 1, depositado na Estante{, genero=Ação, nomeSecao='A', nomeEstante='Romance'}", livro.getUltimaNotificacao());
    }


    // Testes integração state & observer
    @Test
    public void naoDeveNotificarLivroPerdidoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivro(estante);

        livro.setEstado(LivroEstadoPerdido.getInstance());

        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

}