/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspetáculosCulturais;

import static EspetáculosCulturais.Index.ultimoArtistaDoFicheiro;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import myinputs.Ler;


public class Espetaculos implements Serializable{
    private String nomeEspetaculo;
    private String tipoEspetaculo;
    private int idEspetaculo;
    private static int ultimo = 0;
    private ArrayList<Artista> artistas;
    private ArrayList<Bilhete> bilhetesvendidos; 
    private String data;
    private String hora;
    private int capacidade;
    private int duracao;
    private double preco;

    public Espetaculos(){
        nomeEspetaculo = "";
        tipoEspetaculo = "";
        ultimo = ultimo + 1;
        idEspetaculo = ultimo;
        artistas = new ArrayList<Artista>();
        bilhetesvendidos = new ArrayList<Bilhete>();
        data="";
        hora = ""; 
        capacidade = 0;
        duracao=0;
        preco=0.0;
        
    }

    public String getNomeEspetaculo() {
        return nomeEspetaculo;
    }

    public void setNomeEspetaculo(String nomeEspetaculo) {
        this.nomeEspetaculo = nomeEspetaculo;
    }

    public String getTipoEspetaculo() {
        return tipoEspetaculo;
    }

    public void setTipoEspetaculo(String tipoEspetaculo) {
        this.tipoEspetaculo = tipoEspetaculo;
    }

    public int getIdEspetaculo() {
        return idEspetaculo;
    }

    public void setIdEspetaculo(int idEspetaculo) {
        this.idEspetaculo = idEspetaculo;
    }

    public static int getUltimo() {
        return ultimo;
    }

    public static void setUltimo(int ultimo) {
        Espetaculos.ultimo = ultimo;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(ArrayList<Artista> artistas) {
        this.artistas = artistas;
    }

    public ArrayList<Bilhete> getBilhetesvendidos() {
        return bilhetesvendidos;
    }

    public void setBilhetesvendidos(ArrayList<Bilhete> bilhetesvendidos) {
        this.bilhetesvendidos = bilhetesvendidos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "\nNome do Espetaculo: " + this.nomeEspetaculo +
                "\nTipo de Espetaculo: " + this.tipoEspetaculo +
                "\nId do Espetaculo: " + this.idEspetaculo +
                "\nArtistas: " +this.artistas +
                "\nBilhetesvendidos: " + this.bilhetesvendidos +
                "\nData: " + this.data +
                "\nHora: " + this.hora +
                "\nCapacidade: " + this.capacidade +
                "\nDuração: " + this.duracao +
                "\nPreço: "+this.preco;
    }

    public boolean verificarArtista(Artista ArtistaVerificar){    
        for(int i=0; i<artistas.size();i++){
            if(artistas.get(i).equals(ArtistaVerificar)){
                return true;  
            }    
        }
        return false;
    }
    
    public void adicionarArtista(Artista novoArtista){
        if(verificarArtista(novoArtista) == false){
            novoArtista.setID(ultimoArtistaDoFicheiro);
            ultimoArtistaDoFicheiro++;
            artistas.add(novoArtista);
        }
    }
     
    public static void criarEspetaculo(ArrayList<Espetaculos> espetaculos, int ultimoID){
        
        System.out.println(" ## Criar Espetáculo ##");
        System.out.println("");
   
        System.out.println("Insira o número correspondente ao tipo de espetáculo que deseja criar: ");
        
        int escolha;
        String tipoEspetaculo = "";
        
        do {
            System.out.println("\t1-Espetáculos Musicais");
            System.out.println("\t2-Espetáculos Teatrais");
            System.out.println("\t3-Espetáculos de Dança");
            System.out.println("\t4-Espetáculos de Cinema");
        
            escolha = Ler.umInt();       
        
            switch (escolha){
            
            case 1:
                tipoEspetaculo = "Espetáculo Musical";            
                break;

            case 2: 
                tipoEspetaculo = "Espetáculos Teatrais";
                break;

            case 3: 
                tipoEspetaculo = "Espetáculos de Dança"; 
                break;

            case 4:
                tipoEspetaculo = "Espetáculos de Cinema";
                break;

            default:
                System.out.println("Erro! Digite um número entre 1 e 4!");
            }   
        }while(escolha!=1 && escolha!=2 && escolha!=3 && escolha!=4);
        
        
        ArrayList<Artista> InfoArtistas =new ArrayList<Artista>();
        
        System.out.println("Insira o Número de Artistas: (maximo 30)");
        int numeroArtistas = Ler.umInt();
        
        while(numeroArtistas<0 || numeroArtistas>30){
            System.out.println("Insira o Número de Artistas: (maximo 30)");
            numeroArtistas = Ler.umInt();  
            }
        
        for(int i=0;i<numeroArtistas;i++){
            Artista B = new Artista();
            
            System.out.print("Insira o nome do Artista: ");
            String nomeAtor = Ler.umaString();
        
            System.out.print("Insira o salário do Artista: ");
            double salario = Ler.umDouble();
            
            while(salario<700 || salario>3000){
            System.out.print("Insira o salário do artista (com valor mínimo de 700 euros e valor máximo de 3000): ");
            salario = Ler.umDouble();   
            }
            
            B.setID(ultimoArtistaDoFicheiro);
            ultimoArtistaDoFicheiro++;
            B.setNome(nomeAtor);
            B.setSalario(salario);
            InfoArtistas.add(B); 
        }
            
        Espetaculos A = new Espetaculos();
        System.out.print("Nome do Espetáculo: ");
        String nomeEspetaculo=Ler.umaString();
        
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
               
        
        System.out.println("Horário:");
        
        System.out.print("\tHoras: ");
        int horas = Ler.umInt();
        while(horas < 0 || horas > 24){
            System.out.println("Erro! Digite uma hora entre 0 e 24!");
            horas = Ler.umInt();
        }
        
        System.out.print("\tMinutos: ");
        int minutos = Ler.umInt();
        while(minutos < 0 || minutos > 60){
            System.out.println("Erro! Digite minutos entre 0 e 60!");
            minutos = Ler.umInt();
        }
        
        String hora = horas + "h" + ":"  + minutos + "min";
        
        System.out.print("Insira a capacidade do espetáculo (máximo 500): ");
        int capacidade = Ler.umInt();
        
        while(capacidade < 0 || capacidade > 500){
            System.out.print("Erro! Digite um valor entre 0 e 500! ");
            capacidade = Ler.umInt();
        }
        
        System.out.print("Insira a duração do espetáculo em minutos: ");
        int duracao=Ler.umInt();

        while(duracao < 0 || duracao > 200){
            System.out.print("Erro! Digite um valor entre 0 e 200! ");
            duracao = Ler.umInt();
        }
        System.out.print("Insira o preço para assitir ao espetaculo (máximo 30): ");
        double preco=Ler.umDouble();
        
        
        while(preco < 0 || preco > 30){
            System.out.print("Erro! Digite um valor entre 0 e 30! ");
            preco = Ler.umInt();
        }
        
        A.setNomeEspetaculo(nomeEspetaculo);
        A.setTipoEspetaculo(tipoEspetaculo);
        A.setArtistas(InfoArtistas);
        A.setData(dia);
        A.setHora(hora);
        A.setCapacidade(capacidade);
        A.setDuracao(duracao);
        A.setPreco(preco);
        A.setIdEspetaculo(ultimoID);
        espetaculos.add(A);   
        
        try{
           ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
            os.writeObject(espetaculos);
            os.flush(); 
            System.out.println("Ficheiro Guardado");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        System.out.println(A.toString());  
        
    }

     
    public static void ConsultarEspetaculo(ArrayList <Espetaculos> espetaculos){
        
        if(espetaculos.size()!=0){
        System.out.println("*Consultar espetáculos pelo ID*");
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
        System.out.println(espetaculos.get(aux).toString());
    }
    
         else{
            System.out.println("Não existem espetaculos:");
        }
    }
    
    public static void ConsultarEspetaculoArtista(ArrayList <Espetaculos> espetaculos) { 
        
        System.out.println("Consultar Espetáculos pelo Artista");
        System.out.print("\n");
        
        String nome;
        int aux=-1;
        
        do{
            System.out.print("* Introduza o nome do artista: ");
            nome=Ler.umaString();  
        
                for(int i=0;i<espetaculos.size();i++){
                    for(int k=0;k<espetaculos.get(i).getArtistas().size();k++){   
                        if(espetaculos.get(i).getArtistas().get(k).getNome().equals(nome)){
                            aux=i;
                        }
                    }
                }
                
        }while(aux==-1);
        
        for(int i=0;i<espetaculos.size();i++){
            for(int k=0;k<espetaculos.get(i).getArtistas().size();k++){   
                if(espetaculos.get(i).getArtistas().get(k).getNome().equals(nome)){
                    System.out.println("Espetaculos cujo o artista"+nome+"encontra-se:"+espetaculos.get(i));
                }
            }
        }
    }

    public static void EliminarEspetaculo(ArrayList <Espetaculos> espetaculos){
        System.out.println("Eliminar Espetáculo pelo ID");
        System.out.print("\n");
        
        int id;
        int aux=-1;
        do{
            System.out.print("Introduza o ID do espetáculo: ");
            id=Ler.umInt();   
        
            for(int i=0;i<espetaculos.size();i++){
                if(espetaculos.get(i).getIdEspetaculo()==id){
                aux=i;
                }
            }
        }while(aux==-1);
        
        espetaculos.remove(espetaculos.get(aux));
        
        try{
           ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
            os.writeObject(espetaculos);
            os.flush(); 
            System.out.println("Ficheiro guardado");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
        
    public static void comprarBilhete(ArrayList <Espetaculos> espetaculos){
        int id;
        int aux=-1;
        
        do{
            System.out.print("Introduza o ID do Espetáculo: ");
            id=Ler.umInt();   
        
            for(int i=0;i<espetaculos.size();i++){
                if(espetaculos.get(i).getIdEspetaculo()==id){
                aux=i;
                }
            }
        }while(aux==-1);
        
        ArrayList <Bilhete> a= new ArrayList <Bilhete>();
        a=espetaculos.get(aux).getBilhetesvendidos();  
        
        System.out.print("Introduza quantos bilhetes pretende comprar: ");
        
        int numerobilhetes = Ler.umInt();        
        while(numerobilhetes>espetaculos.get(aux).getCapacidade()){
            System.out.print("Introduza quantos bilhetes pretende comprar: ");
            numerobilhetes = Ler.umInt();    
        }
        
        for(int k=0;k<numerobilhetes;k++){

            espetaculos.get(aux).setCapacidade(espetaculos.get(aux).getCapacidade()-1);    

            System.out.print("Introduza o nome do cliente: ");
            String nome = Ler.umaString();


            System.out.print("Introduza a fila: ");
            char fila = Ler.umChar();

            System.out.print("Introduza o lugar (lugares variam entre 1 e 10): ");
            int lugar = Ler.umInt();
            
            if(lugar<1 || lugar>10){
                do{
                    System.out.print("Introduza o lugar: ");
                    lugar = Ler.umInt();    
                }while(lugar<1 || lugar>10);
            }
            int aux2=-1;
            
            do{
                aux2=0;
                
                for(int j=0;j<espetaculos.get(aux).getBilhetesvendidos().size();j++){
                    if(fila==espetaculos.get(aux).getBilhetesvendidos().get(j).getFila() && lugar==espetaculos.get(aux).getBilhetesvendidos().get(j).getLugarBanco()){
                        System.out.println("Lugar Ocupado");
                        aux2=-1;
                        
                        System.out.println("Introduza a fila:");
                        fila = Ler.umChar();
                        
                        System.out.println("Introduza o lugar::");
                        lugar = Ler.umInt();   
                    }
                }
            }while(aux2==-1);
                                
            Bilhete A=new Bilhete();
            A.setFila(fila);
            A.setLugarBanco(lugar);
            A.setNomeDaPessoa(nome);
            a.add(A);           
            espetaculos.get(aux).setBilhetesvendidos(a);
            
            try{
                ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("C:\\Users\\Francisco\\Desktop\\TrabalhoPrático2\\espetaculos.dat"));
                os.writeObject(espetaculos);
                os.flush(); 
                System.out.println("Ficheiro guardado");
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }       
        System.out.println(espetaculos.toString());
    }
}

    

