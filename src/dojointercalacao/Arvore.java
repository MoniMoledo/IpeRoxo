/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dojointercalacao;

import java.util.ArrayList;

/**
 *
 * @author Carlos Daniel, Fernando D., João M., Jonatha N., Monique M.
 */
public class Arvore {
    ArrayList<No> raizes = new ArrayList<No>();
    ArrayList<No> folhas = new ArrayList<No>();
    


    public void add(No no){
        folhas.add(no);
    }

    public No cria(){
        if(folhas.size() == 0){
           return null;
        }
        else if(folhas.size() == 1){
            raizes.add(folhas.get(0));
        }
        else{
            No NoVencedor;
            No sozinho = null;
            //se o numero de folhas for impar, guardar a folha que irá sobrar
                if((folhas.size()%2) == 1){
                    sozinho = folhas.get(folhas.size() -1);
                }
            do{    
                for (int i = 0; i < folhas.size()-1; i+=2) {
                    if(folhas.get(i).cliente.codCliente < folhas.get(i+1).cliente.codCliente)
                        NoVencedor = folhas.get(i);
                    else
                        NoVencedor = folhas.get(i+1);

                    NoVencedor.dir = folhas.get(i);
                    NoVencedor.esq = folhas.get(i+1);
                    folhas.get(i).pai = NoVencedor;
                    folhas.get(i+1).pai = NoVencedor;
                    raizes.add(NoVencedor);
                }
                folhas = raizes;
                if(sozinho!=null)
                    folhas.add(sozinho);
                raizes = new ArrayList<No>();
            }while(folhas.size()>1);
        }
        return raizes.get(0);
    }
    
    public void attSubArvore(No pai, String particao){}
}

