/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EspetáculosCulturais;

import java.io.Serializable;


public class Artista implements Serializable{

    private String Nome;
    private double Salario;
    private int id;
    private static int ultimo = 0;

    public Artista() {
        this.Nome = "";
        this.Salario = 0.0;
        ultimo = ultimo + 1;
        id = ultimo;
    }
    
    public Artista(String Nome, double Salario) {
        this.Nome = Nome;
        this.Salario = Salario;
        ultimo = ultimo + 1;
        id = ultimo;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "\n\tNome: " + Nome + "\n\tSalário: " +Salario+ "\n\tID Artista: " + id;
    }  
}

