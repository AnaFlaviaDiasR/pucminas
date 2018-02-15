/**
 *TP01Q03 -> Alteracao Aleatoria
 *@author: Ana Flávia Dias Rodrigues
 *27/08/2017
 */

import java.util.Random;
public class TP01Q03AlteracaoAleatoria{

  /**
   *Metodo String que recebe como parametro uma string e um caracter aleatorio retornando uma nova string alterada
   *@param frase String
   *@param ran Random
   *@return newFrase String
   */
  public static String aleatorio(String frase, Random ran){
    char x= (char)('a' + (Math.abs(ran.nextInt()) % 26));
    char y= (char)('a' + (Math.abs(ran.nextInt()) % 26));
    String newFrase= "";
    for (int i=0; i<frase.length(); i++){
      if(frase.charAt(i) == x)
        newFrase+= y;
      else{
          newFrase+= frase.charAt(i);
      }
    }
    return newFrase;
  }//fim aleatorio()

  /**
   *Metodo Booleano que verifica se a String passada por parametro eh igual a condicao de parada "FIM"
   *@param p String
   *@return efetividade Boolean
   */
  public static boolean flag (String p){
      boolean efetividade= false;
      String flag= "FIM";
      if (p.length() == flag.length()){
        for (int i=0; i<p.length(); i++){
          if (p.charAt(i) != flag.charAt(i)){
            return false;
          }
          else{
            efetividade= true;
          }
        }
     }
    return efetividade;
  }//fim flag()

  public static void main (String[]args){
    Random gerador= new Random();
    gerador.setSeed(4);
    String[] frase= new String[1000];
    int qt=0;
    boolean verifica= false;
    do{
      frase[qt]= MyIO.readLine();
      verifica= flag(frase[qt]);
      qt++;
    }while(verifica == false);
    qt--; //Desconsidera a palavra FIM
    for (int i=0; i<qt; i++){
      MyIO.println(aleatorio(frase[i],gerador));
    }
  }//fim main

}//fim class
