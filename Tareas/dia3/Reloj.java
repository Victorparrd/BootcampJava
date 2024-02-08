package dia3;

public class Reloj {
    private int horas;
    private int minutos;
    private int segundos;

    // Constructor por defecto
    public Reloj() {
        this.horas = 12;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Reloj(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Reloj(int tiempoSegundos) {
        this.horas = tiempoSegundos / 3600;
        this.minutos = (tiempoSegundos % 3600) / 60;
        this.segundos = (tiempoSegundos % 3600) % 60;
    }

    public void setReloj(int tiempoSegundos) {
        this.horas = tiempoSegundos / 3600;
        this.minutos = (tiempoSegundos % 3600) / 60;
        this.segundos = (tiempoSegundos % 3600) % 60;
    }

    public int getHoras() {
        return this.horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        return this.minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return this.segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public void tick() {
        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
            if (minutos == 60) {
                minutos = 0;
                horas++;
                if (horas == 24) {
                    horas = 0;
                }
            }
        }
    }

    public void addReloj(Reloj reloj2) {
        this.horas += reloj2.getHoras();
        this.minutos += reloj2.getMinutos();
        this.segundos += reloj2.getSegundos();

        if (segundos >= 60) {
            segundos -= 60;
            minutos++;
        }
        if (minutos >= 60) {
            minutos -= 60;
            horas++;
        }
        if (horas >= 24) {
            horas -= 24;
        }
    }

    public String toString() {
        return String.format("[%02d:%02d:%02d]", horas, minutos, segundos);
    }

    public void tickDecrement() {
        segundos--;
        if (segundos < 0) {
            segundos = 59;
            minutos--;
            if (minutos < 0) {
                minutos = 59;
                horas--;
                if (horas < 0) {
                    horas = 23;
                }
            }
        }
    }

    public Reloj restaReloj(Reloj reloj2) {
        int segundosActuales = this.segundos + this.minutos * 60 + this.horas * 3600;
        int segundosReloj2 = reloj2.getSegundos() + reloj2.getMinutos() * 60 + reloj2.getHoras() * 3600;
        int diferenciaSegundos = segundosActuales - segundosReloj2;
        if (diferenciaSegundos < 0) {
            diferenciaSegundos += 24 * 3600;
        }
        return new Reloj(diferenciaSegundos);
    }
}
