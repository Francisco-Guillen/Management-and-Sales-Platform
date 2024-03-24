/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspetáculosCulturais;

import java.util.ArrayList;
import myinputs.Ler;

public class Estatistica {
    public static double Lucro(ArrayList <Espetaculos> espetaculos){
        double ganho=0;
        double despesa=0;   
        
        for(int i=0;i<espetaculos.size();i++){
            for(int j=0;j<espetaculos.get(i).getBilhetesvendidos().size();j++){
                ganho=ganho+espetaculos.get(i).getPreco();
            }
        }
  
        for(int i=0;i<espetaculos.size();i++){
            for(int j=0;j<espetaculos.get(i).getArtistas().size();j++){
                despesa=despesa+espetaculos.get(i).getArtistas().get(j).getSalario();
            }
        }
        
        double lucro=ganho-despesa;
        return lucro;
    }
    
    public static int BilhetesVendidos(ArrayList <Espetaculos> espetaculos){
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
        
        int numeroVendidos=0;
        int numeroBilhetes=0;
        int bilhetesdisponiveis=0;
   
        numeroBilhetes=numeroBilhetes+espetaculos.get(aux).getCapacidade();
        
        return numeroBilhetes;
        
    }
    
    public static double PrecoMedioBilhete(ArrayList <Espetaculos> espetaculos){
        double soma=0;
        for(int i=0;i<espetaculos.size();i++){
            soma=soma+espetaculos.get(i).getPreco();
        }
         
        double media=soma/espetaculos.size();
        return media;
     }
     
    public static double Salariomedio(ArrayList<Espetaculos> espetaculos) {
        double total=0;
        double numerodeartistas=0;
        for(int i=0;i<espetaculos.size();i++){
            numerodeartistas=numerodeartistas+espetaculos.get(i).getArtistas().size();
            for(int k=0;k<espetaculos.get(i).getArtistas().size();k++){
                total=total+espetaculos.get(i).getArtistas().get(k).getSalario();
            }  
        }
        return total/numerodeartistas;
    }
      
    public static double DuracaoMedia(ArrayList<Espetaculos> espetaculos) {
        double total=0;
        for(int i=0;i<espetaculos.size();i++){
            total=total+espetaculos.get(i).getDuracao();
        }  
        return total/espetaculos.size();
    }
      
    public static int numeroDeEspetaculosPeloDiaDaSemana(ArrayList<Espetaculos> espetaculos,String dia) {
        ArrayList <Espetaculos> EspetaculosPeloDia= new ArrayList<>();
        for(int i=0;i<espetaculos.size();i++){
            if(dia.equals(espetaculos.get(i).getData())){
                EspetaculosPeloDia.add(espetaculos.get(i));
            }  
        }
        return EspetaculosPeloDia.size();  
    }
      
    public static int numerodeEspetaculosPorPessoa(ArrayList<Espetaculos> espetaculos,String nome) {
        ArrayList <Espetaculos> EspetaculosPeloPessoa= new ArrayList<>();
        for(int i=0;i<espetaculos.size();i++){
            for(int j=0;j<espetaculos.get(i).getBilhetesvendidos().size();j++){
                if(nome.equals(espetaculos.get(i).getBilhetesvendidos().get(j).getNomeDaPessoa())){
                    EspetaculosPeloPessoa.add(espetaculos.get(i));
                }  
            }
        }
      return EspetaculosPeloPessoa.size();  
    }
    
    public static String MelhorCliente(ArrayList<Espetaculos> espetaculos) {
        String nome;
        int maior=0;
        String melhorCliente;
        melhorCliente=espetaculos.get(0).getBilhetesvendidos().get(0).getNomeDaPessoa();
        int aux=0;
        
        
        for(int i=0;i<espetaculos.size();i++){
            for(int j=0;j<espetaculos.get(i).getBilhetesvendidos().size();j++){
                nome=espetaculos.get(i).getBilhetesvendidos().get(j).getNomeDaPessoa();
                if(numerodeEspetaculosPorPessoa(espetaculos,nome)>maior){
                    melhorCliente=nome;
                }  
            }
        }
        
      return melhorCliente; 
    }
    public static String ArtistaMaisEspetaculos(ArrayList<Espetaculos> espetaculos) {
        String nome;
        int maior=0;
        String melhorartista;
        int cont=0;
        int cont2=0;
        int pos=0;
        int pos2=0;
        String ArtistaMaisEspeatculos;
        
        
        for(int i=0;i<espetaculos.size();i++){
            for(int j=i;j<espetaculos.size();j++){
               for(int k=0;k<espetaculos.get(i).getArtistas().size();k++){ 
                   for(int m=0;m<espetaculos.get(j).getArtistas().size();m++){
               
                if(espetaculos.get(i).getArtistas().get(k).getNome().equals(espetaculos.get(j).getArtistas().get(m).getNome())){
                cont2++;
                }  
                if(cont2>cont){
                pos=i;
                pos2=k;
                cont=cont2;
                }
            }
        }
            }
        }
         ArtistaMaisEspeatculos=espetaculos.get(pos).getArtistas().get(pos2).getNome();
        
      return ArtistaMaisEspeatculos; 
    }
    
    
}   

    