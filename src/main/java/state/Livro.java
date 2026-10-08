package state;

import java.util.Observable;
import java.util.Observer;
public class Livro implements Observer {
    
    private String nome;
    private LivroEstado estado;
    private String ultimaNotificacao;

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void depositarLivro(Estante estante) {
        estante.addObserver(this);
    }


    @Override
    public void update(Observable estante, Object arg) {
        this.ultimaNotificacao = this.estado.notificarLivroCadastrado(this, (Estante) estante);
    }


    public Livro() {
        this.estado = LivroEstadoCadastrado.getInstance();
    }
    
    public void setEstado(LivroEstado estado) {
        this.estado = estado;
    }
    
    public boolean cadastrar() {
        return estado.cadastrar(this);
    }
    
    public boolean vender() {
        return estado.vender(this);
    }

    public boolean perder() {
        return estado.perder(this);
    }

    public boolean alugar() {
        return estado.alugar(this);
    }

    public boolean reservar() {
        return estado.reservar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LivroEstado getEstado() {
        return estado;
    }    
}
