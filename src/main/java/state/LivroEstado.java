package state;

public abstract class LivroEstado {

    public String notificarLivroCadastrado(Livro livro, Estante estante) {
        return null;
    }

    public abstract String getEstado();

    public boolean cadastrar(Livro livro) {
        return false;
    }

    public boolean vender(Livro livro) {
        return false;
    }

    public boolean reservar(Livro livro) {
        return false;
    }

    public boolean alugar(Livro livro) {
        return false;
    }

    public boolean perder(Livro livro) {
        return false;
    }

    
}
