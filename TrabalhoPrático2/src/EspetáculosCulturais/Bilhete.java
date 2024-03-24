/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspetáculosCulturais;

import java.io.Serializable;
import java.util.ArrayList;
import myinputs.Ler;


public class Bilhete implements Serializable{
    private char fila;
    private int lugarBanco;
    private String nomeDaPessoa;

     
    public Bilhete() {
        lugarBanco=0;
        nomeDaPessoa="";
    }

    public char getFila() {
        return fila;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public int getLugarBanco() {
        return lugarBanco;
    }

    public void setLugarBanco(int lugarBanco) {
        this.lugarBanco = lugarBanco;
    }

    public String getNomeDaPessoa() {
        return nomeDaPessoa;
    }

    public void setNomeDaPessoa(String nomeDaPessoa) {
        this.nomeDaPessoa = nomeDaPessoa;
    }

    @Override
    public String toString() {
        return "Bilhete:" + "\nFila=" + fila + "\nLugar: " + lugarBanco + "\nNome Do Cliente: " + nomeDaPessoa;
    }

    public static void ConsultarLugaresOcupados(ArrayList <Espetaculos> espetaculos) { 
        System.out.println("Consultar Lugares Ocupados: ");
        System.out.print("\n");
        
        int id;
        int aux=-1;
        
        do{
            System.out.print("* Introduza o ID do Espetaculo: ");
            id=Ler.umInt();   
        
            for(int i=0;i<espetaculos.size();i++){
                if(espetaculos.get(i).getIdEspetaculo()==id){
                    aux=i;
                }
            }
        }while(aux==-1);
        
        for(int o=0;o<espetaculos.get(aux).getBilhetesvendidos().size();o++){
            System.out.println("Lugares Ocupados: \nFila: "+espetaculos.get(aux).getBilhetesvendidos().get(o).getFila()+"\tLugar:"+espetaculos.get(aux).getBilhetesvendidos().get(o).getLugarBanco());
        }
    }
}
       
            
   
