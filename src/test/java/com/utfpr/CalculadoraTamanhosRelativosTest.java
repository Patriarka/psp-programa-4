package com.utfpr;

import java.util.Arrays;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

class CalculadoraTamanhosRelativosTest extends TestCase {
        private ListaEncadeada lista;

        private CalculadoraTamanhosRelativos calculadora;

        @Before
        public void setUp() {
                this.lista = new ListaEncadeada();
                this.calculadora = new CalculadoraTamanhosRelativos(lista);
        }

        @Test
        public void casoTestePrimeiro() {
                lista.adicionarNo(18 / 3f, 0);
                lista.adicionarNo(18 / 3f, 1);
                lista.adicionarNo(25 / 3f, 2);
                lista.adicionarNo(31 / 3f, 3);
                lista.adicionarNo(37 / 3f, 4);
                lista.adicionarNo(82 / 5f, 5);
                lista.adicionarNo(82 / 4f, 6);
                lista.adicionarNo(87 / 4f, 7);
                lista.adicionarNo(89 / 4f, 8);
                lista.adicionarNo(230 / 10f, 9);
                lista.adicionarNo(85 / 3f, 10);
                lista.adicionarNo(87 / 3f, 11);
                lista.adicionarNo(558 / 10f, 12);

                List<Double> listaEsperada = Arrays.asList(4.3953, 8.5081, 16.4696, 31.8811, 61.7137);
                List<Double> listaTamanhosRelativos = calculadora.calcularTamanhosRelativos();

                assertEquals(listaTamanhosRelativos.size(), listaEsperada.size(), 0.001);

                for (int i = 0; i < listaTamanhosRelativos.size(); i++) {
                        assertEquals(listaTamanhosRelativos.get(i), listaEsperada.get(i), 0.001);
                }
        }

        @Test
        public void casoTesteSegundo() {
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

                List<Double> listaEsperada = Arrays.asList(6.3375, 8.4393, 11.2381, 14.9650, 19.9280);
                List<Double> listaTamanhosRelativos = calculadora.calcularTamanhosRelativos();

                assertEquals(listaTamanhosRelativos.size(), listaEsperada.size(), 0.001);

                for (int i = 0; i < listaTamanhosRelativos.size(); i++) {
                        assertEquals(listaTamanhosRelativos.get(i), listaEsperada.get(i), 0.001);
                }
        }
}
