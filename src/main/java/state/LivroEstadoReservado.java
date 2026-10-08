package state;

public class LivroEstadoReservado extends LivroEstado {

    private LivroEstadoReservado() {};
    private static LivroEstadoReservado instance = new LivroEstadoReservado();
    public static LivroEstadoReservado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Reservado";
    }

    public boolean vender(Livro livro) {
        livro.setEstado(LivroEstadoVendido.getInstance());
        return true;
    }
    public boolean alugar(Livro livro) {
        livro.setEstado(LivroEstadoAlugado.getInstance());
        return true;
    }

}
