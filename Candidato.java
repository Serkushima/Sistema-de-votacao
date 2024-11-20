public class Candidato implements Votavel {
    private String nome;
    private Partido partido;
    private int numero;
    private int votos;
    private TipoCandidato tipoCandidato;

    public Candidato(String nome, Partido partido, int numero, TipoCandidato tipoCandidato){
        this.nome=nome;
        this.partido = partido;
        this.numero = numero;
        this.tipoCandidato = tipoCandidato;
        this.votos = 0;
    }
    @Override
    public void adicionarVoto(){
        this.votos++;
        if(this.tipoCandidato == TipoCandidato.Vereador){
            this.partido.adicionarVoto();
        }
    }

    @Override
    public int getVotos(){
        return this.votos;
    }

    public String getNome(){
        return this.nome;
    }

    public Partido getPartido(){
        return this.partido;
    }

    public int getNumero(){
        return this.numero;
    }

    public TipoCandidato getTipoCandidato() {
        return this.tipoCandidato;
    }
}
