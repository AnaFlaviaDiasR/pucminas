/**
 *TP02Q03 -> Alteracao Aleatoria
 *@author: Ana Flávia Dias Rodrigues
 *31/08/2017
 */
import java.util.Random;
public class TP02Q03AlteracaoAleatoria{
  /**
   *Metodo String para iniciar o metodo recursivo
   *@param frase String
   *@param ran Random
   *@return chamada do metodo aleatorio
   */
   public static String iniAleatorio(String frase, Random ran){
     char x= (char)('a' + (Math.abs(ran.nextInt()) % 26));
     char y= (char)('a' + (Math.abs(ran.nextInt()) % 26));
     return aleatorio(frase, x, y, 0);
   }//fim iniAleatorio()

   /**
    *Metodo String recursivo que altera as letras sorteadas da String passada por parametro
    *@param frase String
    *@param c char
    *@param y char
    *@param i int
    *@return newFrase String
    */
   public static String aleatorio(String frase, char x, char y, int i){
     String newFrase= "";
     if(i<frase.length()){
       if(frase.charAt(i) == x){
         newFrase+= y + aleatorio(frase, x, y, i+1);
       }
       else{
         newFrase+= newFrase + frase.charAt(i) + aleatorio(frase, x, y, i+1);
       }
     }
     return newFrase;
   }//fim aleatorio()

  /**
		* O metodo inicializa o metodo recursivo para verificar a flag
    * @param p String
    * @return iguais boolean
	*/
  public static boolean iniFlag(String p){
    boolean iguais = false;
    String fim= "FIM";
    if(p.length() == fim.length()){
     iguais = flag(p,fim,0);
    }
    return iguais;
  }

  /**
		* O metodo recursivo verifica se a palavra passada por parametro eh igual a condicao de parada
    * @param palavra String
    * @return metodo recursivo
	*/
  public static boolean flag(String p, String fim, int i){
    boolean iguais = true;
    if(i < fim.length()){
      iguais = (p.charAt(i) == fim.charAt(i)) ? flag(p,fim,i+1) : false;
    }//fim if
    return iguais;
  }//fim

  public static void main (String[]args){
    Random gerador= new Random();
    gerador.setSeed(4);
    String[] frase= new String[1000];
    int qt=0;
    boolean verifica= false;
    do{
			frase[qt]= MyIO.readLine();
			verifica= iniFlag(frase[qt]);
			qt++;
		}while(verifica == false);
		qt--; //Desconsidera a palavra FIM
    for (int i=0; i<qt; i++){
      MyIO.println(iniAleatorio(frase[i],gerador));
    }
  }//fim main

}//fim class
