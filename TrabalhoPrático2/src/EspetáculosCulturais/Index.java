/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspetáculosCulturais;
import java.io.*;
import static EspetáculosCulturais.Bilhete.ConsultarLugaresOcupados;
import static EspetáculosCulturais.Espetaculos.ConsultarEspetaculo;
import static EspetáculosCulturais.Espetaculos.ConsultarEspetaculoArtista;
import static EspetáculosCulturais.Espetaculos.EliminarEspetaculo;
import static EspetáculosCulturais.Espetaculos.comprarBilhete;
import static EspetáculosCulturais.Espetaculos.criarEspetaculo;
import static EspetáculosCulturais.Estatistica.BilhetesVendidos;
import static EspetáculosCulturais.Estatistica.DuracaoMedia;
import static EspetáculosCulturais.Estatistica.Lucro;
import static EspetáculosCulturais.Estatistica.MelhorCliente;
import static EspetáculosCulturais.Estatistica.PrecoMedioBilhete;
import static EspetáculosCulturais.Estatistica.Salariomedio;
import static EspetáculosCulturais.Estatistica.numeroDeEspetaculosPeloDiaDaSemana;
import static EspetáculosCulturais.Estatistica.numerodeEspetaculosPorPessoa;
import java.util.ArrayList;
import myinputs.Ler;

public class Index{
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    public static int ultimoDoFicheiro=0;
    public static int ultimoArtistaDoFicheiro=0;
    
    public static void menu(){ //Menu principal//
        System.out.println(""+ANSI_YELLOW+"\nMenu - Espetáculos Culturais: "+ANSI_RESET+""               
                + ANSI_YELLOW+"\n1 " +ANSI_RESET+"- Área STAFF!"
                + ANSI_YELLOW+"\n2 " +ANSI_RESET+"- Área CLIENTE!"
                + ANSI_YELLOW+"\n0 " +ANSI_RESET+"- Saír!");
    }
    
    public static void menuSub1() { //Sub-Menu 1//
        System.out.println(""+ANSI_YELLOW+"\n1"+ANSI_RESET+" - Área STAFF"
                + ANSI_YELLOW+"\n\t1"+ANSI_RESET+" - Consultar Espetáculos: "              
                + ANSI_YELLOW+"\n\t2"+ANSI_RESET+" - Criar Espetáculo: "
                + ANSI_YELLOW+"\n\t3"+ANSI_RESET+" - Eliminar Espetáculo: "
                + ANSI_YELLOW+"\n\t4"+ANSI_RESET+" - Adicionar Artista: "
                + ANSI_YELLOW+"\n\t5"+ANSI_RESET+" - Eliminar Artista: "
                + ANSI_YELLOW+"\n\t6"+ANSI_RESET+" - Estatísticas: "
                + ANSI_YELLOW+"\n\t0"+ANSI_RESET+" - Cancelar");
    }
    
    public static void menuSub2() { //Sub-Menu 2//
        System.out.println(""+ANSI_YELLOW+"\n1"+ANSI_RESET+" - Área CLIENTE"
                + ANSI_YELLOW+"\n\t1"+ANSI_RESET+" - Consultar Espetáculos: "
                + ANSI_YELLOW+"\n\t2"+ANSI_RESET+" - Consultar Espetáculo pelo id: "
                + ANSI_YELLOW+"\n\t3"+ANSI_RESET+" - Consultar Espetáculo pelo Artista: "
                + ANSI_YELLOW+"\n\t4"+ANSI_RESET+" - Bilhetes: "
                + ANSI_YELLOW+"\n\t0"+ANSI_RESET+" - Cancelar");
    }
    
    public static void menuSub_Sub1(){
        System.out.println(""+ANSI_YELLOW+"\n8"+ANSI_RESET+" - Estatísticas:"
                + ANSI_YELLOW+"\n\t1"+ANSI_RESET+" - Lucro: "
                + ANSI_YELLOW+"\n\t2"+ANSI_RESET+" - Bilhetes Disponiveis: "
                + ANSI_YELLOW+"\n\t3"+ANSI_RESET+" - Preço Médio Bihete: "
                + ANSI_YELLOW+"\n\t4"+ANSI_RESET+" - Salário Médio: "
                + ANSI_YELLOW+"\n\t5"+ANSI_RESET+" - Duração Média Espetáculo "
                + ANSI_YELLOW+"\n\t6"+ANSI_RESET+" - Número Espetáculos Dia Da Semana: "
                + ANSI_YELLOW+"\n\t7"+ANSI_RESET+" - Número de Espetáculos Por Pessoa: "
                + ANSI_YELLOW+"\n\t8"+ANSI_RESET+" - Melhor Cliente: "
                + ANSI_YELLOW+"\n\t0"+ANSI_RESET+" - Cancelar");
    }
    
    public static void menuSub_Sub2(){
        System.out.println(""+ANSI_YELLOW+"\n3"+ANSI_RESET+" - Bilhetes:"
                + ANSI_YELLOW+"\n\t1"+ANSI_RESET+" - Comprar Bilhete: "
                + ANSI_YELLOW+"\n\t2"+ANSI_RESET+" - Lugares Ocupados: "
                + ANSI_YELLOW+"\n\t0"+ANSI_RESET+" - Cancelar");
    }
    
    public static void main(String[] args){
        ArrayList<Espetaculos> espetaculos = new ArrayList<Espetaculos>();
        
        try{
            ObjectInputStream is=new ObjectInputStream(new FileInputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
            espetaculos= (ArrayList <Espetaculos>) is.readObject();

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch ( ClassNotFoundException e) {
        System.out.println(e.getMessage());
        }
        
        int maiorid=0;
        
        if(espetaculos.size()>0){
            Espetaculos espetaculoTemp = espetaculos.get(espetaculos.size()-1);
            ultimoDoFicheiro = espetaculoTemp.getIdEspetaculo();
            
                
        for(int a=0;a<espetaculos.size();a++){
              for(int b=a;b<espetaculos.size();b++){ 
                  if(espetaculos.get(a).getArtistas().get(espetaculos.get(a).getArtistas().size()-1).getID()>maiorid){
                   maiorid=espetaculos.get(a).getArtistas().get(espetaculos.get(a).getArtistas().size()-1).getID();
              }
            }
            }
        }
            ultimoArtistaDoFicheiro = maiorid;
            ultimoArtistaDoFicheiro++;

        
        
        int controlador=1;           
        int opcao, opcao1, opcao2, opcao3, opcao4;
        menu();
        do{
             opcao=Ler.umInt();
             switch(opcao){
                 case 0:
                     controlador=0;
                     break;
                 case 1:                   
                    do{
                        menuSub1();
                        opcao1 = Ler.umInt();  
                        switch(opcao1){
                            
                        case 0:
                            menu();
                            controlador=0;
                        
                        break;      
                        
                        case 1:                   
                            System.out.println(espetaculos.toString());                               
                    break;
                        
                        case 2:  
                            ultimoDoFicheiro++;
                            
                            criarEspetaculo(espetaculos,ultimoDoFicheiro);
                                     
                    break;
                        
                        case 3:
                            
                            EliminarEspetaculo(espetaculos);
                            System.out.println(espetaculos);
                    
                    
                    break;
                        case 4:
                            Artista A = new Artista();
                            
                            System.out.println("Introduza o nome do artista: ");
                            String nomeArtista = Ler.umaString();
                            A.setNome(nomeArtista);
                            
                            System.out.println("Introduza o salário do artista: ");
                            double salarioArtista = Ler.umInt();
                            while(salarioArtista<700 || salarioArtista>3000){
                            System.out.println("Insira o salário do Artista: (com valor minimo de 700 euros e valor maximo de  3000)");
                            salarioArtista = Ler.umDouble();   
                            }
                            
                            A.setSalario(salarioArtista);
                            int idEsp;
                            int aux1=-1;
                            do{
                            System.out.print("* Introduza o ID do Espetaculo: ");
                            idEsp=Ler.umInt();   
        
                            for(int i=0;i<espetaculos.size();i++){
                            if(espetaculos.get(i).getIdEspetaculo()==idEsp){
                            aux1=i;
                            }
                            }                    
                            }while(aux1==-1);
                            
                            espetaculos.get(aux1).adicionarArtista(A);
                            
                            try{
                            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
                            os.writeObject(espetaculos);
                            os.flush(); 
                            System.out.println("Ficheiro guardado");
                            }catch(IOException e){
                            System.out.println(e.getMessage());
                            }
                            
                            break;
                            
                        case 5:
                            Artista B = new Artista();
                            System.out.println("Introduza o nome do artista: ");
                            String nameArtista = Ler.umaString();
                            B.setNome(nameArtista);
                            
                            int id;
                            int aux2=-1;
                            
                            do{
                            System.out.print("* Introduza o ID do Espetaculo: ");
                            id=Ler.umInt();   
        
                            for(int i=0;i<espetaculos.size();i++){
                            if(espetaculos.get(i).getIdEspetaculo()==id){
                            aux2=i;
                            }
                            }                    
                            }while(aux2==-1);
                            
                            for(int o=0;o<espetaculos.get(aux2).getArtistas().size();o++){
                            if(espetaculos.get(aux2).getArtistas().get(o).getNome().equals(nameArtista)){
                                espetaculos.get(aux2).getArtistas().remove(o);
                            }
                            }

                            
                            try{
                            ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
                            os.writeObject(espetaculos);
                            os.flush(); 
                            System.out.println("Ficheiro guardado");
                            }catch(IOException e){
                            System.out.println(e.getMessage());
                            }
                            break;                          
                            
                        case 6:
                            do{
                                menuSub_Sub1();
                                opcao3 = Ler.umInt(); 
                        
                                switch(opcao3){
                                
                                    case 0:
                                        menuSub1();
                                        controlador = 0;
                                        break;
                                    case 1:
                                            System.out.println(Lucro(espetaculos));
                                                                
                                        break;
                                    case 2:
                                            System.out.println(BilhetesVendidos(espetaculos));
                                            
                                                                        
                                        break;
                                    case 3:
                                            System.out.println(PrecoMedioBilhete(espetaculos));
                                                                
                                        break;
                                        
                                    case 4:
                                            System.out.println(Salariomedio(espetaculos));
                                        
                                        break;
                                        
                                    case 5:
                                            System.out.println(DuracaoMedia(espetaculos));
                                        break;
                                        
                                    case 6:
                                            ArrayList <String> semana =new ArrayList <String>();
                                            semana.add("Segunda");
                                            semana.add("Terca");
                                            semana.add("Quarta");
                                            semana.add("Quinta");
                                            semana.add("Sexta");
                                            semana.add("Sabado");
                                            semana.add("Domingo");        

                                            System.out.print("Dia da Semana: ");

                                            String dia = Ler.umaString();
                                            while(!semana.contains(dia)){
                                                System.out.println("Erro! Digite um dia da semana! \nExemplo: Segunda");
                                                dia = Ler.umaString();
                                            }
                                            System.out.println(dia+" há "+numeroDeEspetaculosPeloDiaDaSemana(espetaculos, dia)+" espetaculos culturais");
                                        
                                        break;
                                        
                                    case 7:
                                            System.out.println("Introduza o nome do cliente que pretende procurar: ");
                                            String nome = Ler.umaString();
                                            System.out.println("O cliente: "+nome+" tem bilhetes para "+numerodeEspetaculosPorPessoa(espetaculos, nome)+" espetaculos culturais");
                                            System.out.println("");
                                        
                                        break;
                                    
                                    case 8:
                                            
                                            System.out.println("O Cliente com mais bilhetes é: "+MelhorCliente(espetaculos));
                                        
                                        break;
                                    
                                    default:
                                System.out.println(""+ANSI_RED+"\n---Operação Inválida---\n"+ANSI_RESET+"");
                            }
                        
                            }while(opcao3 != 0);
                            
                            break;
                    
                default:
                    System.out.println(""+ANSI_RED+"\n---Operação Inválida---\n"+ANSI_RESET+"");
                    }
            
                }while(opcao1!=0);
                     break;
                     
                 case 2:
                    
                    do{
                        menuSub2();
                        opcao2 = Ler.umInt();  
                        switch(opcao2){
                            
                        case 0:
                        menu();
                        controlador=0;
                        break; 
                            
                        case 1:                   
                            System.out.println(espetaculos.toString());                            
                            break;
                        
                        case 2:  
                            ConsultarEspetaculo(espetaculos);
                                   
                            break;
       
                        case 3:
                            ConsultarEspetaculoArtista(espetaculos);
                            break;
                        
                        case 4:
                            do{
                                menuSub_Sub2();
                                opcao4 = Ler.umInt(); 
                        
                                switch(opcao4){
                                    case 0:
                                        menuSub2();
                                        controlador = 0;
                                        break;
                                        
                                    case 1:
                                   
                                    comprarBilhete(espetaculos);
                                
                                        break;
                                    case 2:
                                    ConsultarLugaresOcupados(espetaculos);
                                    
                                    break;
                                  
                                    default:
                                  
                                    System.out.println(""+ANSI_RED+"\n---Operação Inválida---\n"+ANSI_RESET+"");
                            }
                        
                            }while(opcao4 != 0);
                    
                    
                            break;
                    
                        default:
                            System.out.println(""+ANSI_RED+"\n---Operação Inválida---\n"+ANSI_RESET+"");
                        }
            
                    }while(opcao2!=0);
                        break;
                     
                 default:
                     System.out.println (ANSI_RED+"---Operação Inválida---\n"+ANSI_RESET);
                }
            }while(opcao!=0);
        try{
           ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
            os.writeObject(espetaculos);
            os.flush(); 
            System.out.println("Ficheiro guardado");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }  
}