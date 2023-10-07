package com.utfpr;

public class Calculadora {
        private final ListaEncadeada lista;

        public Calculadora(ListaEncadeada lista) {
                this.lista = lista;
        }

        public double mediaLista() {
                int qtdeElementos = lista.tamanho();

                double soma = calcularSomaLista();

                return qtdeElementos == 0 ? 0 : soma / qtdeElementos;
        }

        private double calcularSomaLista() {
                double soma = 0;

                ListaEncadeada.No noAtual = lista.obterNo(0);

                while (noAtual != null) {
                        soma += noAtual.getDado();
                        noAtual = noAtual.getProximo();
                }

                return soma;
        }

        public double desvioPadraoAmostralLista() {
                if (lista.listaVazia()) {
                        return 0;
                }

                return Math.sqrt(varianciaLista());
        }

        public void converterListaParaLogNormal() {
                ListaEncadeada.No noAtual = lista.obterNo(0);

                while (noAtual != null) {
                        noAtual.setDado(Math.log(noAtual.getDado()));
                        noAtual = noAtual.getProximo();
                }
        }

        public double varianciaLista() {
                double dividendo = 0;
                double divisor = 0;
                double media = mediaLista();

                ListaEncadeada.No noAtual = lista.obterNo(0);

                while (noAtual != null) {
                        dividendo += Math.pow(noAtual.getDado() - media, 2);
                        noAtual = noAtual.getProximo();
                        divisor++;
                }

                return dividendo / (divisor - 1);
        }
}
