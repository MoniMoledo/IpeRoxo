/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dojointercalacao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        DataOutputStream saida;
        //colocar try/finally
        for (int i = 0; i < nomeParticoes.size(); i++) {
           No verdinha = new No();
           part = new DataInputStream(new BufferedInputStream(new FileInputStream(nomeParticoes.get(i))));
           verdinha.cliente = new Cliente(part.readInt(), part.readUTF(), part.readUTF());
           verdinha.nomeParticao = nomeParticoes.get(i);
           verdinha.dir = null;
           verdinha.esq = null;
           verdinha.pai = null;
           ipeRoxo.add(verdinha);
        }
        
        try{
            saida = new DataOutputStream( new BufferedOutputStream( new FileOutputStream(nomeArquivoSaida)));
            No teste = ipeRoxo.cria(); 
            while(teste != null && teste.cliente.codCliente != Integer.MAX_VALUE){
                
                saida.writeInt(teste.cliente.codCliente);
                saida.writeUTF(teste.cliente.nome);
                saida.writeUTF(teste.cliente.dataNascimento);
            //ver a particao desse cara e ler o proximo da fila para att a subarvore
                ipeRoxo.attSubArvore(teste.pai, teste.nomeParticao);
                teste = ipeRoxo.cria();
            }
        }
        finally{}
        

    }

}
