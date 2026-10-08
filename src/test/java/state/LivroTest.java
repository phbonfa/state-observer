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
    void deveNotificarUmLivro() {
        Estante estante = new Estante("Ficção", "Seção A", "Estante 1");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivroEstante(estante);
        estante.lancarLivroDepositado();
        assertEquals("Livro 1, depositado na Estante{genero=Ficção, nomeSecao='Seção A', nomeEstante='Estante 1'}", livro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarMultiplosLivros() {
        Estante estante = new Estante("Ficção", "Seção A", "Estante 1");
        Livro livro1 = new Livro();
        livro1.setNome("Livro 1");
        Livro livro2 = new Livro();
        livro2.setNome("Livro 2");
        livro1.depositarLivroEstante(estante);
        livro2.depositarLivroEstante(estante);
        estante.lancarLivroDepositado();
        assertEquals("Livro 1, depositado na Estante{genero=Ficção, nomeSecao='Seção A', nomeEstante='Estante 1'}", livro1.getUltimaNotificacao());
        assertEquals("Livro 2, depositado na Estante{genero=Ficção, nomeSecao='Seção A', nomeEstante='Estante 1'}", livro2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLivroNaoDepositado() {
        Estante estante = new Estante("Ficção", "Seção A", "Estante 1");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

    @Test
    void deveNotificarApenasLivroDaEstanteNotificada() {
        Estante estanteA = new Estante("Ficção", "Seção A", "Estante A");
        Estante estanteB = new Estante("Ficção", "Seção B", "Estante B");
        Livro livro1 = new Livro();
        livro1.setNome("Livro 1");
        Livro livro2 = new Livro();
        livro2.setNome("Livro 2");
        livro1.depositarLivroEstante(estanteA);
        livro2.depositarLivroEstante(estanteB);
        estanteA.lancarLivroDepositado();
        assertEquals("Livro 1, depositado na Estante{genero=Ficção, nomeSecao='Seção A', nomeEstante='Estante A'}", livro1.getUltimaNotificacao());
        assertNull(livro2.getUltimaNotificacao());
    }


    // Test integração State & Observer
    @Test
    void naoDeveNotificarLivroPerdidoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivroEstante(estante);

        livro.setEstado(LivroEstadoPerdido.getInstance());

        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLivroVendidoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivroEstante(estante);

        livro.vender();

        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLivroAlugadoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivroEstante(estante);

        livro.alugar();

        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarLivroReservadoDepositado() {
        Estante estante = new Estante("Ação", "A", "Romance");
        Livro livro = new Livro();
        livro.setNome("Livro 1");
        livro.depositarLivroEstante(estante);

        livro.reservar();

        estante.lancarLivroDepositado();
        assertNull(livro.getUltimaNotificacao());
    }

}