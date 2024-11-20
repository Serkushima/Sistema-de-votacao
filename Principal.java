import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SistemaVotacao sistema = new SistemaVotacao();

        while (true){
            System.out.println("Menu: ");
            System.out.println("1. Criar Partido");
            System.out.println("2. Criar Candidato");
            System.out.println("3. Votar");
            System.out.println("4. Exibir Resultados");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch(opcao){
                case 1:
                    System.out.println("Digite o número do partido: ");
                    String numeroPartidoStr = scanner.nextLine();
                    Partido partido = new Partido (numeroPartidoStr);
                    sistema.adicionarPartido(partido);
                    System.out.println("partido "+ numeroPartidoStr + " criado com sucesso");
                    break;
                case 2:
                    System.out.println("Digite o nome do candidato: ");
                    String nomeCandidato = scanner.nextLine();
                    System.out.println("Digite o numero do candidato: ");
                    String numeroCandidatoStr = scanner.nextLine();

                    TipoCandidato tipoCandidato;
                    Partido partidoCandidato=null;

                    if (numeroCandidatoStr.length() == 2) {
                        tipoCandidato = TipoCandidato.Prefeito;
                    } else if (numeroCandidatoStr.length() == 5) {
                        tipoCandidato = TipoCandidato.Vereador;
                        String numeroPartido = numeroCandidatoStr.substring(0, 2);
                        partidoCandidato = sistema.buscarPartidoPorNumero(numeroPartido);
                        if (partidoCandidato == null) {
                            System.out.println("Partido não encontrado. Crie o partido primeiro.");
                            break;
                        }
                    } else {
                        System.out.println("Número de candidato inválido. Prefeito deve ter 2 dígitos e vereador 5 dígitos.");
                        break;
                    }

                    Candidato candidato = new Candidato(nomeCandidato, partidoCandidato, Integer.parseInt(numeroCandidatoStr), tipoCandidato);
                    sistema.adicionarCandidato(candidato);

                    String tipoCandidatoStr = tipoCandidato == TipoCandidato.Vereador ? "Vereador" : "Prefeito";
                    System.out.println("Candidato " + nomeCandidato + " criado como " + tipoCandidatoStr + " com sucesso!");
                    break;

                case 3:
                    System.out.println("Digite o número do candidato para votar: ");
                    int numeroVotoCandidato = scanner.nextInt();
                    sistema.votar(numeroVotoCandidato);
                    break;
                case 4:
                    sistema.exibirResultados();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
