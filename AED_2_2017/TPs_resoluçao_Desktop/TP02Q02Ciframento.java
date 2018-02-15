/**
* @author Ana Flavia Dias Rodrigues
* @version TP02Q02Ciframento - 31/08/2017
*/

class TP02Q02Ciframento{
  /**
   * Metodo String que inicia o metodo recursivo.
   * @param entrada String
   * @param chave int
   * @return cifra String
   */
  public static String iniciarCiframento(String entrada, int chave){
    return ciframento(entrada, chave, 0);
  }

  /**
   * Metodo String recursivo que retorna a entrada cifrada
   * @param entrada String
   * @param chave int
   * @param i int
   * @return cifra String
  */
  public static String ciframento (String entrada, int chave, int i){
      String cifra= "";
      if ( i <entrada.length()){
        cifra += (char)(entrada.charAt(i) + chave) + ciframento(entrada, chave, i+1);
      }
      return cifra;
  }//fim ciframento()

  /**
  * O metodo flag recebe uma String por parametro e verifica se eh a condicao de parada
  * @param p String
  * @return boolean
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
    String[] palavra= new String[1000];
    int qt=0;
    boolean verifica= false;
    do{
      palavra[qt]= MyIO.readLine();
      verifica= flag(palavra[qt]);
      qt++;
    }while(verifica == false);
    qt--; //Desconsidera a palavra FIM
    for (int i=0; i<qt; i++){
      MyIO.println(iniciarCiframento(palavra[i], 3));
    }
  }//fim main
}//fim class
