package com.catolica;
import java.util.Scanner;
public class App {

        final static int SIZE = 10000;
        final static int[] data = new int[SIZE];

        final static int NOT_FOUND = -1;

        private static final void popular() {
            for (int i = 0; i < data.length; i++) {
                data[i] = i * 2;
            }
        }


        /**
         * Implementar a busca binária
         * @param value
         * @return
         */
        private static final int procurar( int valor, int posicaoInicial, int posicaoFinal ) {
            int position = NOT_FOUND;
// procurar o valor digitado pelo usuário
            if (posicaoFinal >= posicaoInicial){
                int meio = (int) Math.floor(posicaoInicial + ((posicaoFinal - posicaoInicial) /2));
                if (data[meio] == valor)
                    return meio;
                if (data[meio] > valor)
                    return procurar(valor, posicaoInicial, meio - 1);
                return procurar(valor, meio + 1, posicaoFinal);
            }
            return position;
        }

        private static final int procurar( int valor ) {
            return procurar(valor, 0, data.length );
        }

        public static void main(String[] args) {
            System.out.println("Digite o valor que deve ser procurado: ");
            Scanner scan = new Scanner(System.in);
            int valor = scan.nextInt();
            System.out.println("Preenchendo o array com valores");
            popular();
            System.out.println("Procurando o valor " + valor);
            int posicao = procurar( valor );

            if( posicao == NOT_FOUND) {
                System.out.println("Não foi encontrado o valor no array " + valor);
            } else {
                System.out.println("O valor foi encontrado na posição " + posicao);
            }
        }
    }


