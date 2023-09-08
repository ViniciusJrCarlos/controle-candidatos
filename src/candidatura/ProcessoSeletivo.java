package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {

        System.out.println("*** Processo Seletivo ***");
        //selecaoCandidatos();
        //imprimirSelecionados();

        String[] candidatos = {"felipe", "marcia", "julia", "paulo", "augusto"};

        for (String candidato: candidatos) {

            entrandoEmContato(candidato);

        }

    }

    static void entrandoEmContato(String candidato) {

        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {

            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {

                tentativasRealizadas++;

            } else {

                System.out.println("CONTATO REALIZADO COM SUCESSSO");
            }

        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {

            System.out.println("CONSEGUIMOS O CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
            System.out.println("");
        } else {

            System.out.println("NAO CONSEGUIMOS O CONTATO COM " + candidato +", NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas + " TENTATIVA");
            System.out.println("");
        }

    }
    static boolean atender() {

        return new Random().nextInt(3) ==1;
    }

    static void imprimirSelecionados() {

        String[] candidatos = {"felipe", "marcia", "julia", "paulo", "augusto"};
        System.out.println("imprimindo a lista de candidatos o indice dos elementos");

        for (int i = 0; i < candidatos.length; i++) {

            System.out.println("O candidato de nº " + (i+1) + " é o " + candidatos[i]);
        }
    }

    static void selecaoCandidatos() {

        String[] candidatos = {"felipe", "marcia", "julia", "paulo", "augusto", "monica", "fabricio", "mirela", "daniela", "jorge"};

        int candidadosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while(candidadosSelecionados < 5 && candidatosAtual < candidatos.length) {

            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " digitou este valor de salário: R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido){

                System.out.println("O candidato " + candidato + " foi selecionado para vaga");
                candidadosSelecionados++;

            }else {
                System.out.println("o candidato não foi selecionado");
            }
            candidatosAtual++;
        }
    }


    static double valorPretendido() {

        return ThreadLocalRandom.current().nextDouble(1800, 2200);

    }

    static void analisarCandidato(double salarioPretendido) {

        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {

            System.out.println("LIGAR PARA O CANDIDATO ");

        } else if (salarioBase == salarioPretendido) {

            System.out.println("LIGAR PARA O CANDIDATO COM A CONTRA PROPOSTA");

        } else {

            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }

}