/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dojointercalacao;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
     * Executa o algoritmo Intercalação Ótima
     * @param nomeParticoes array com os nomes dos arquivos que contêm as partições de entrada
     * @param nomeArquivoSaida nome do arquivo de saída resultante da execução do algoritmo
     */
public class Intercalacao {

    public void executa(List<String> nomeParticoes, String nomeArquivoSaida) throws Exception {
        Arvore ipeRoxo = new Arvore();
        DataInputStream part;
        for (int i = 0; i < nomeParticoes.size(); i++) {
           No verdinha = new No();
           part = new DataInputStream(new BufferedInputStream(new FileInputStream(nomeParticoes.get(i))));
           verdinha.codigo=part.readInt();
           verdinha.nomeParticao = nomeParticoes.get(i);
           verdinha.dir = null;
           verdinha.esq = null;
           verdinha.pai = null;
           ipeRoxo.add(verdinha);
  
        }

    }

}
