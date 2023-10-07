package com.utfpr;

public class ListaEncadeada {
        private static String mensagemExcecao = "Posição maior ou igual ao tamanho da lista";

        private final Cabeca cabeca;

        public ListaEncadeada() {
                cabeca = new Cabeca();
        }

        public void adicionarNo(double dado, int posicao) {
                if (posicao < 0) {
                        throw new IllegalArgumentException("Posição não pode ser negativa.");
                }

                No novo = new No(dado);
                No noAtual = obterNo(posicao);

                if (posicao == 0) {
                        if (cabeca.getPrimeiro() == null) {
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
                        throw new IndexOutOfBoundsException(mensagemExcecao);
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
                if (cabeca.getPrimeiro() == null) {
                        return 0;
                }

                double media = mediaLista();
                double soma = 0;
                int qtdeElementos = 0;

                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        soma += Math.pow((noAtual.getDado() - media), 2);

                        qtdeElementos++;
                        noAtual = noAtual.getProximo();
                }

                return Math.sqrt(soma / (qtdeElementos - 1));
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
                double auxiliar = 0;

                No noAtual = cabeca.getPrimeiro();

                while (noAtual != null) {
                        auxiliar += noAtual.dado - media;
                        dividendo += Math.pow(auxiliar, 2);
                        noAtual = noAtual.getProximo();
                        divisor++;
                        auxiliar = 0;
                }

                return dividendo / (divisor - 1);
        }

        public double desvioPadraoLista() {
                return Math.sqrt(varianciaLista());
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
