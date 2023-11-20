/// Minha versão de um projeto (atividade) - simulação de conta bancária.
/// O que vamos fazer:
//            * Inicializar dados do cliente (pré-definido)
//            * Menu de opções
//            * Visualização do saldo
//            * Enviar valor
//            * Receber valor

import java.util.Scanner;
public class ContaBancaria {

    //método que exibe um menu de opções
    public static void minhaOperacao(){
        System.out.println("""
                Operações:
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                """);
    }
    public static void main(String[] args) {

        //scanner para realizar a leitura dos números de entrada
        Scanner leitura = new Scanner(System.in);

        System.out.println("*************************\n");
        System.out.println("Dados inciais do cliente");

        //declaração de variáveis do cliente

        String nome = "Miriã Machado de Camargo";
        String tipoDaConta = "Corrente";
        double saldoInicial = 2000.00;
        double valorDeposito;
        int numeroDigitadoOperacao;
        double movimentacao;

        boolean rodaPrograma = true;

        System.out.println("""
                Nome: %s
                Tipo da conta: %s
                Saldo Inicial: R$ %.2f reais
                                
                *************************
                 """.formatted(nome, tipoDaConta, saldoInicial));
        //loop que roda programa
        while(rodaPrograma) {
            //chamando o método
            minhaOperacao();
            System.out.println("Por favor, digite um número:\n");
            numeroDigitadoOperacao = leitura.nextInt();

            if (numeroDigitadoOperacao == 1) {
                System.out.println("""
                    Saldo total: R$ %.2f reais
                                        
                    """.formatted(saldoInicial));
            }
            if (numeroDigitadoOperacao == 4) {
                System.out.println("Você saiu, até mais.");
                leitura.close();
                rodaPrograma = false;

            } else if (numeroDigitadoOperacao >= 5) {
                System.out.println("Opção inválida.");

            } else if (numeroDigitadoOperacao == 3) {
                System.out.println("Informe o valor que deseja transferir:");
                valorDeposito = leitura.nextDouble();

                if (valorDeposito > saldoInicial){
                    System.out.println("Saldo insuficiente!");
                }
                if (valorDeposito < saldoInicial) {
                    movimentacao = saldoInicial - valorDeposito;
                    saldoInicial = movimentacao;

                    System.out.println("""
                        Saldo atualizado: R$ %.2f reais 
                        """.formatted(movimentacao));
                }
            } else if (numeroDigitadoOperacao == 2) {
                System.out.println("Informe o valor que deseja depositar:");
                valorDeposito = leitura.nextDouble();

                if (valorDeposito > 0) {
                    movimentacao = saldoInicial + valorDeposito;

                    saldoInicial = movimentacao;

                    System.out.println("""
                            Saldo atualizado: R$ %.2f reais 
                            """.formatted(movimentacao));

                    //fim.
                }
            }
        }
    }
}
