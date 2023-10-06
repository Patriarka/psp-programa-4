package com.utfpr;

public class Main {
        public static void main(String[] args) {
                ListaEncadeada lista = new ListaEncadeada();

                lista.adicionarNo(7, 0);
                lista.adicionarNo(12, 1);
                lista.adicionarNo(10, 2);
                lista.adicionarNo(12, 3);
                lista.adicionarNo(10, 4);
                lista.adicionarNo(12, 5);
                lista.adicionarNo(12, 6);
                lista.adicionarNo(12, 7);
                lista.adicionarNo(12, 8);
                lista.adicionarNo(8, 9);
                lista.adicionarNo(8, 10);
                lista.adicionarNo(8, 11);
                lista.adicionarNo(20, 12);
                lista.adicionarNo(14, 13);
                lista.adicionarNo(18, 14);
                lista.adicionarNo(12, 15);

                CalculadoraTamanhosRelativos calculadora = new CalculadoraTamanhosRelativos(lista);
                System.out.println(calculadora.calcularTamanhosRelativos());
        }
}
