/*
         ---------------------------
        | Calculadora de Polinômios |
         ---------------------------
            IDE:	IntelliJ IDEA
       Language:	Java 8

      Developer:	Lucas Marra Rebello
        Contact:	lucasmrebello@yahoo.com.br
  Last modified:	13/05/2021 - 05:10 pm

*/
package br.com.polinomio;

import java.util.Scanner;

public class Main {
    //Classe cliente
    public static void main(String[] args) {
        int opc, grau;
        double aux;
        Scanner ler = new Scanner(System.in);

        while (true) {

            //Menu
            System.out.println("__________________________________");
            System.out.println("\n -------------------------");
            System.out.println(" CALCULADORA DE POLINÔMIOS");
            System.out.println(" -------------------------\n");
            System.out.println("Escolha uma das opções abaixo:\n");
            System.out.println("0 - Sair.");
            System.out.println("1 - Calcular valor do polinômio.");
            System.out.println("2 - Soma de polinômios.");
            System.out.println("3 - Multiplicação de polinômios.\n");

            System.out.print("Digite o número da opção escolhida: ");
            opc = ler.nextInt();

            switch (opc) {

                case 0:
                    // Sair (encerra programa)
                    System.out.println("Até logo!");
                    return;

                // Resolve polinômio através de x
                case 1:
                    System.out.print("\nDigite o valor do grau do polinômio: ");
                    grau = ler.nextInt();
                    System.out.print("\n");
                    Polinomio p1 = new Polinomio(grau);

                    // Preenche o polinômio
                    for (int i = grau; i >= 0; --i) {
                        System.out.print("Digite o valor do termo que acompanha x^" + i + ": ");
                        aux = ler.nextDouble();
                        p1.preencheTermos(aux, i);
                    }

                    p1.mostra();

                    System.out.print("Digite o valor de x: ");
                    double x = ler.nextDouble();

                    System.out.println("\n" + p1.resultPoli(x));

                    break;

                // Soma polinômios
                case 2:
                    System.out.print("\nDigite o valor do grau do primeiro polinomio: ");
                    grau = ler.nextInt();
                    System.out.print("\n");
                    p1 = new Polinomio(grau);

                    // Preenche primeiro polinômio
                    for (int i = grau; i >= 0; --i) {
                        System.out.print("Digite o valor do termo que acompanha x^" + i + ": ");
                        aux = ler.nextDouble();
                        p1.preencheTermos(aux, i);
                    }

                    System.out.print("\nDigite o valor do grau do segundo polinomio: ");
                    grau = ler.nextInt();
                    System.out.print("\n");
                    Polinomio p2 = new Polinomio(grau);

                    // Preenche segundo polinômio
                    for (int i = grau; i >= 0; --i) {
                        System.out.print("Digite o valor do termo que acompanha x^" + i + ": ");
                        aux = ler.nextDouble();
                        p2.preencheTermos(aux, i);
                    }

                    Polinomio result = p1.soma(p2);
                    result.mostra();

                    break;

                // Multiplicação de polinômios
                case 3:
                    System.out.print("\nDigite o valor do grau do primeiro polinomio: ");
                    grau = ler.nextInt();
                    System.out.print("\n");
                    p1 = new Polinomio(grau);

                    // Preenche primeiro polinômio
                    for (int i = grau; i >= 0; --i) {
                        System.out.print("Digite o valor do termo que acompanha x^" + i + ": ");
                        aux = ler.nextDouble();
                        p1.preencheTermos(aux, i);
                    }

                    System.out.print("\nDigite o valor do grau do segundo polinomio: ");
                    grau = ler.nextInt();
                    System.out.print("\n");
                    p2 = new Polinomio(grau);

                    // Preenche segundo polinômio
                    for (int i = grau; i >= 0; --i) {
                        System.out.print("Digite o valor do termo que acompanha x^" + i + ": ");
                        aux = ler.nextDouble();
                        p2.preencheTermos(aux, i);
                    }

                    result = p1.multiplicacao(p2);
                    result.mostra();

                    break;

                default:
                    System.out.println("\nOpção Inválida!");
            }
        }
    }
}