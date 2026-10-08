package state;
import java.util.Observable;
public class Estante extends Observable {

    private String genero;
    private String nomeSecao;
    private String nomeEstante;

    public Estante( String genero, String nomeSecao, String nomeEstante) {
        this.genero = genero;
        this.nomeSecao = nomeSecao;
        this.nomeEstante = nomeEstante;
    }

    public void lancarLivroDepositado() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Estante{" +
                "genero=" + genero +
                ", nomeSecao='" + nomeSecao + '\'' +
                ", nomeEstante='" + nomeEstante + '\'' +
                '}';
    }

}
