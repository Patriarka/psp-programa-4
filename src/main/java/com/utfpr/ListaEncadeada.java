package com.utfpr;

public class ListaEncadeada {
        private final String mensagemExcecao = "Posição maior ou igual ao tamanho da lista";

        private Cabeca cabeca;

        public ListaEncadeada() {
                cabeca = new Cabeca();
        }

        public void adicionarNo(double dado, int posicao) {
                if (posicao < 0) {
                        throw new IllegalArgumentException("Posição não pode ser negativa.");
                }

                No novo = new No(dado);
                No no_atual = cabeca.getPrimeiro();

                int posicao_atual = 0;

                while (posicao_atual < posicao - 1 && no_atual.getProximo() != null) {
                        posicao_atual++;
                        no_atual = no_atual.getProximo();
                }

                if (posicao == 0 && cabeca.getPrimeiro() == null) {
                        cabeca.setPrimeiro(novo);
                        cabeca.setUltimo(novo);

                } else if (posicao == 0 && cabeca.getPrimeiro() != null) {
                        novo.setProximo(cabeca.getPrimeiro());
                        cabeca.setPrimeiro(novo);

                } else if (no_atual.getProximo() == null) {
                        no_atual.setProximo(novo);
                        cabeca.setUltimo(novo);

                } else {
                        novo.setProximo(no_atual.getProximo());
                        no_atual.setProximo(novo);
                }
        }

        public double obterElemento(int posicao) {
                if (posicao >= tamanho()) {
                        throw new IndexOutOfBoundsException(mensagemExcecao);
                }

                No no_atual = cabeca.getPrimeiro();
                int posicao_atual = 0;

                while (posicao_atual < posicao) {
                        no_atual = no_atual.getProximo();
                        posicao_atual++;
                }

                return no_atual.getDado();
        }

        public void adicionarNoFinalLista(double dado) {
                adicionarNo(dado, tamanho());
        }

        public double mediaLista() {
                if (cabeca.getPrimeiro() == null) {
                        return 0;
                }

                double soma = 0;
                int qtde_elementos = 0;

                No no_atual = cabeca.getPrimeiro();

                while (no_atual != null) {
                        soma += no_atual.getDado();
                        qtde_elementos++;
                        no_atual = no_atual.getProximo();
                }

                return (double) soma / qtde_elementos;
        }

        public double desvioPadraoAmostralLista() {
                if (cabeca.getPrimeiro() == null) {
                        return 0;
                }

                double media = mediaLista();
                double soma = 0;
                int qtde_elementos = 0;

                No no_atual = cabeca.getPrimeiro();

                while (no_atual != null) {
                        soma += Math.pow((no_atual.getDado() - media), 2);

                        qtde_elementos++;
                        no_atual = no_atual.getProximo();
                }

                return (double) Math.sqrt(soma / (qtde_elementos - 1));
        }

        public int tamanho() {
                int tamanho = 0;

                No no_atual = cabeca.getPrimeiro();

                while (no_atual != null) {
                        tamanho++;
                        no_atual = no_atual.getProximo();
                }
                return tamanho;
        }

        public void converterListaParaLogNormal() {
                No no_atual = cabeca.getPrimeiro();

                while (no_atual != null) {
                        no_atual.dado = Math.log(no_atual.dado);
                        no_atual = no_atual.getProximo();
                }
        }

        public double varianciaLista() {
                double dividendo = 0;
                double divisor = 0;
                double media = mediaLista();
                double auxiliar = 0;

                No no_atual = cabeca.getPrimeiro();

                while (no_atual != null) {
                        auxiliar += no_atual.dado - media;
                        dividendo += Math.pow(auxiliar, 2);
                        no_atual = no_atual.getProximo();
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

                private No ultimo;

                public Cabeca() {
                        this.primeiro = null;
                        this.ultimo = null;
                }

                public No getPrimeiro() {
                        return primeiro;
                }

                public void setPrimeiro(No proximo) {
                        this.primeiro = proximo;
                }

                public void setUltimo(No proximo) {
                        this.ultimo = proximo;
                }
        }
}
