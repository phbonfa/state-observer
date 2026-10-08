package state;

public class LivroEstadoVendido extends LivroEstado {

    private LivroEstadoVendido() {};
    private static LivroEstadoVendido instance = new LivroEstadoVendido();
    public static LivroEstadoVendido getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Vendido";
    }

}

