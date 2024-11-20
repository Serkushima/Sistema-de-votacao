public class Partido {
    private String numero;
    private int votos;

    public Partido(String numero) {
        this.numero = numero;
        this.votos = 0;
    }


    public String getNumero() {
        return numero;
    }

    public int getVotos() {
        return votos;
    }

    public void adicionarVoto() {
        this.votos++;
    }
}