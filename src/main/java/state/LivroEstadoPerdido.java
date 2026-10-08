package state;

public class LivroEstadoPerdido extends LivroEstado {

    private LivroEstadoPerdido() {};
    private static LivroEstadoPerdido instance = new LivroEstadoPerdido();
    public static LivroEstadoPerdido getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Perdido";
    }


}
