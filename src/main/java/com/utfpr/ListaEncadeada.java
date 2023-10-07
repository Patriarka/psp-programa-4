package com.utfpr;

public class ListaEncadeada {
        private final Cabeca cabeca;

        public ListaEncadeada() {
                cabeca = new Cabeca();
        }

        public void adicionarNo(double dado, int posicao) {
                validarPosicao(posicao);

                No novo = new No(dado);
                No noAtual = obterNo(posicao);

                if (posicao == 0) {
                        if (listaVazia()) {
                                cabeca.setPrimeiro(novo);
                        } else {
                                novo.setProximo(cabeca.getPrimeiro());
                                cabeca.setPrimeiro(novo);
                        }
                } else {
                        novo.setProximo(noAtual.getProximo());
                        noAtual.setProximo(novo);
                }
        }

        private static void validarPosicao(int posicao) {
                if (posicao < 0) {
                        throw new IllegalArgumentException("Posição não pode ser negativa.");
                }
        }

        private No obterNo(int posicao) {
                No noAtual = cabeca.getPrimeiro();

                int posicaoAtual = 0;

                while (posicaoAtual < posicao - 1 && noAtual.getProximo() != null) {
                        posicaoAtual++;
                        noAtual = noAtual.getProximo();
                }

                return noAtual;
        }

        public double obterElemento(int posicao) {
                if (posicao >= tamanho()) {
                        throw new IndexOutOfBoundsException("Posição maior ou igual ao tamanho da lista");
                }

                No noAtual = cabeca.getPrimeiro();
                int posicaoAtual = 0;

                while (posicaoAtual < posicao) {
                        noAtual = noAtual.getProximo();
                        posicaoAtual++;
                }

                return noAtual.getDado();
        }

        public void adicionarNoFinalLista(double dado) {
                adicionarNo(dado, tamanho());
        }

        public double mediaLista() {
                int qtdeElementos = tamanho();

                double soma = calcularSomaLista();

                return qtdeElementos == 0 ? 0 : soma / qtdeElementos;
        }

        private double calcularSomaLista() {
                double soma = 0;

                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        soma += noAtual.getDado();
                        noAtual = noAtual.getProximo();
                }

                return soma;
        }

        public double desvioPadraoAmostralLista() {
                if (listaVazia()) {
                        return 0;
                }

                return Math.sqrt(varianciaLista());
        }

        private boolean listaVazia() {
                return cabeca.getPrimeiro() == null;
        }

        public int tamanho() {
                int tamanho = 0;

                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        tamanho++;
                        noAtual = noAtual.getProximo();
                }
                return tamanho;
        }

        public void converterListaParaLogNormal() {
                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        noAtual.dado = Math.log(noAtual.dado);
                        noAtual = noAtual.getProximo();
                }
        }

        public double varianciaLista() {
                double dividendo = 0;
                double divisor = 0;
                double media = mediaLista();

                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        dividendo += Math.pow(noAtual.dado - media, 2);
                        noAtual = noAtual.getProximo();
                        divisor++;
                }

                return dividendo / (divisor - 1);
        }

        private class No {
                private double dado;

                private No proximo;

                public No(double dado) {
                        this.dado = dado;
                        this.proximo = null;
                }

                public double getDado() {
                        return dado;
                }

                public No getProximo() {
                        return proximo;
                }

                public void setProximo(No proximo) {
                        this.proximo = proximo;
                }
        }

        private class Cabeca {
                private No primeiro;

                public Cabeca() {
                        this.primeiro = null;
                }

                public No getPrimeiro() {
                        return primeiro;
                }

                public void setPrimeiro(No proximo) {
                        this.primeiro = proximo;
                }
        }
}
