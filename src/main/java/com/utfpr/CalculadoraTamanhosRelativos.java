package com.utfpr;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraTamanhosRelativos {
        private ListaEncadeada lista;

        CalculadoraTamanhosRelativos(ListaEncadeada lista) {
                this.lista = lista;
        }

        private double calcularPp(double media, double desvioPadrao) {
                return media - (2 * desvioPadrao);
        }

        private double calcularP(double media, double desvioPadrao) {
                return media - desvioPadrao;
        }

        private double calcularM(double media, double desvioPadrao) {
                return media;
        }

        private double calcularG(double media, double desvioPadrao) {
                return media + desvioPadrao;
        }

        private double calcularGg(double media, double desvioPadrao) {
                return media + (2 * desvioPadrao);
        }

        public List<Double> calcularTamanhosRelativos() {
                List<Double> resultados = new ArrayList<>();
                double media;
                double desvioPadrao;

                lista.converterListaParaLogNormal();

                media = lista.mediaLista();
                desvioPadrao = lista.desvioPadraoLista();

                resultados.add(Math.exp(calcularPp(media, desvioPadrao)));
                resultados.add(Math.exp(calcularP(media, desvioPadrao)));
                resultados.add(Math.exp(calcularM(media, desvioPadrao)));
                resultados.add(Math.exp(calcularG(media, desvioPadrao)));
                resultados.add(Math.exp(calcularGg(media, desvioPadrao)));

                return resultados;
        }
}
