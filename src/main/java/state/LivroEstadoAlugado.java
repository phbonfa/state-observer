package state;

public class LivroEstadoAlugado extends LivroEstado {

    private LivroEstadoAlugado() {};
    private static LivroEstadoAlugado instance = new LivroEstadoAlugado();
    public static LivroEstadoAlugado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Alugado";
    }

    public boolean vender(Livro livro) {
        livro.setEstado(LivroEstadoVendido.getInstance());
        return true;
    }

    public boolean perder(Livro livro) {
        livro.setEstado(LivroEstadoPerdido.getInstance());
        return true;
    }

    public boolean cadastrar(Livro livro) {
        livro.setEstado(LivroEstadoCadastrado.getInstance());
        return true;
    }

}
