package state;

public class LivroEstadoCadastrado extends LivroEstado {

    private LivroEstadoCadastrado() {};
    private static LivroEstadoCadastrado instance = new LivroEstadoCadastrado();
    public static LivroEstadoCadastrado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Cadastrado";
    }

    @Override
    public String notificarLivroCadastrado(Livro livro, Estante estante) {
        return livro.getNome() + ", depositado na " + estante.toString();
    }

    public boolean vender(Livro livro) {
        livro.setEstado(LivroEstadoVendido.getInstance());
        return true;
    }
    public boolean alugar(Livro livro) {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        return true;
    }
    public boolean reservar(Livro livro) {
        livro.setEstado(LivroEstadoReservado.getInstance());
        return true;
    }
    


}
