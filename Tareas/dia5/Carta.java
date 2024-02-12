package dia5;

public class Carta {
    char valor;
    char palo;

    public Carta(char valor, char palo) {
        this.valor = valor;
        this.palo = palo;
    }

    @Override
    public String toString() {
        return "" + valor + palo;
    }
}
