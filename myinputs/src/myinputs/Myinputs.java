/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myinputs;

/**
 *
 * @author Francisco
 */
public class Myinputs {
 public static void main(String[] args) {
 System.out.println("Introduza uma string:");
 String s = Ler.umaString();
 System.out.println("A string que introduziu foi: " + s);
 int i=Integer.parseInt(s);
 System.out.println("Inteiro: " + i);
 System.out.println("Introduza um inteiro:");
 int inteiro = Ler.umInt();
     System.out.println("O inteiro que introduziu:" + inteiro);
     
  System.out.println("Introduza um double:");
 double d = Ler.umDouble();
     System.out.println("O double que introduziu:" + d );
 
   System.out.println("Introduza um float:");
 float f = Ler.umFloat();
     System.out.println("O float que introduziu:" + f );


  System.out.println("Introduza um boolean:");
 boolean b = Ler.umBoolean();
     System.out.println("O boolean que introduziu:" + b );
     
    System.out.println("Introduza um Byte:");
 Byte x = Ler.umByte();
     System.out.println("O Byte que introduziu:" + x );
     
     System.out.println("Introduza um Short:");
 Short y = Ler.umShort();
     System.out.println("O Short que introduziu:" + y );

    System.out.println("Introduza um Long:");
 Long z = Ler.umLong();
     System.out.println("O Long que introduziu:" + z );
}
}

