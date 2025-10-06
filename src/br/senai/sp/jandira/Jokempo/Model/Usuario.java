package br.senai.sp.jandira.Jokempo.Model;

import java.util.Random;
import java.util.Scanner;

public class Usuario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] opcoes = {"Pedra", "Papel", "Tesoura"};

        System.out.println("---------- Bem-vindo ao Jokenpô! -------------");

        while (true) {
            System.out.println("\nEscolha sua jogada:");
            System.out.println("-------------------------------");
            System.out.println("1 - Pedra");
            System.out.println("2 - Papel");
            System.out.println("3 - Tesoura");
            System.out.println("-------------------------------");
            System.out.print("Sua escolha: ");

            int escolhaUsuario = -1;
            while (escolhaUsuario < 1 || escolhaUsuario > 3) {
                String entrada = scanner.nextLine();

                try {
                    escolhaUsuario = Integer.parseInt(entrada);
                    if (escolhaUsuario < 1 || escolhaUsuario > 3) {
                        System.out.println("Opção inválida. Escolha entre 1, 2 ou 3.");
                        System.out.print("Sua escolha: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número (1, 2 ou 3).");
                    System.out.print("Sua escolha: ");
                }
            }

            int escolhaMaquina = random.nextInt(3);
            int indiceUsuario = escolhaUsuario - 1;

            System.out.println("\n------------------------------------");
            System.out.println("Você escolheu: " + opcoes[indiceUsuario]);
            System.out.println("A máquina escolheu: " + opcoes[escolhaMaquina]);
            System.out.println("------------------------------------");

            if (indiceUsuario == escolhaMaquina) {
                System.out.println("Resultado: Deu EMPATE, mas não desista e tenta de novo :)!");
            } else if ((indiceUsuario == 0 && escolhaMaquina == 2) ||
                    (indiceUsuario == 1 && escolhaMaquina == 0) ||
                    (indiceUsuario == 2 && escolhaMaquina == 1)) {
                System.out.println("Resultado: PARABÉNS! Voce ganhou, tente de novo talvez voce consiga ganhar novamente!");
            } else {
                System.out.println("Resultado: Que pena! Você perdeu mas Deveria tentar de novo.");
            }

            System.out.print("\nDeseja jogar novamente? (s/n): ");
            String jogarNovamente = scanner.nextLine();

            if (!jogarNovamente.trim().equalsIgnoreCase("s")) {
                break;
            }
        }

        System.out.println("\nObrigado por jogar! Até a próxima.");
        scanner.close();
    }
}