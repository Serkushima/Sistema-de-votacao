import java.util.ArrayList;
import java.util.List;

public class SistemaVotacao {

    private List<Candidato> candidatos;
    private List<Partido> partidos;

    public SistemaVotacao(){
        this.candidatos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void adicionarPartido(Partido partido){
        this.partidos.add(partido);
    }

    public void adicionarCandidato(Candidato candidato){
        this.candidatos.add(candidato);
    }

    public Partido buscarPartidoPorNumero(String numeroPartido){
        for (Partido partido : partidos){
            if(partido.getNumero().equals(numeroPartido)){
                return partido;
            }
        }
        return null;
    }

    public void votar(int numeroCandidato){
        for (Candidato candidato : candidatos){
            if ( candidato.getNumero()== numeroCandidato){
                candidato.adicionarVoto();
                System.out.println("Voto registrado para " + candidato.getNome() + " como " + candidato.getTipoCandidato());
                return;
            }
        }
        System.out.println("Candidato não encontrado.");
    }

    public void exibirResultados(){
        if (candidatos.isEmpty()){
            System.out.println("Nenhum candidato registrado.");
            return;
        }

        Candidato vereadorVencedor = null;
        Candidato prefeitoVencedor = null;

        for (Candidato candidato: candidatos){
            if (candidato.getTipoCandidato() == TipoCandidato.Vereador){
                if(vereadorVencedor == null || candidato.getVotos() > vereadorVencedor.getVotos()){
                    vereadorVencedor = candidato;
                }
            } else if (candidato.getTipoCandidato() == TipoCandidato.Prefeito) {
                if(prefeitoVencedor == null || candidato.getVotos() > prefeitoVencedor.getVotos()){
                    prefeitoVencedor = candidato;
                }

            }
        }

        if(vereadorVencedor != null) {
            System.out.println("Vereador vencedor: " + vereadorVencedor.getNome());
        } else {
            System.out.println("Nenhum vereador registrado.");
        }

        if(prefeitoVencedor != null){
            System.out.println("Prefeito vencedor: " + prefeitoVencedor.getNome());
        } else {
            System.out.println("Nenhum prefeito registrado.");
        }
    }
}
