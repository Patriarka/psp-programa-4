package com.utfpr;

public class ListaEncadeada {
        private final Cabeca cabeca;

        public ListaEncadeada() {
                this.cabeca = new Cabeca();
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

        public No obterNo(int posicao) {
                No noAtual = cabeca.getPrimeiro();

                int posicaoAtual = 0;

                while (posicaoAtual < posicao - 1 && noAtual.getProximo() != null) {
                        posicaoAtual++;
                        noAtual = noAtual.getProximo();
                }

                return noAtual;
        }

        public boolean listaVazia() {
                return cabeca.getPrimeiro() == null;
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

        public int tamanho() {
                int tamanho = 0;

                ListaEncadeada.No noAtual = obterNo(0);

                while (noAtual != null) {
                        tamanho++;
                        noAtual = noAtual.getProximo();
                }
                return tamanho;
        }

        public class No {
                private double dado;

                private No proximo;

                public No(double dado) {
                        this.dado = dado;
                        this.proximo = null;
                }

                public double getDado() {
                        return dado;
                }

                public void setDado(double valorDado) {
                        this.dado = valorDado;
                }

                public No getProximo() {
                        return proximo;
                }

                public void setProximo(No proximo) {
                        this.proximo = proximo;
                }
        }

        public class Cabeca {
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
