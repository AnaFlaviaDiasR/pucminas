/**
 *TP01Q05 -> Is
 *@author: Ana Flávia Dias Rodrigues
 * 23/08/2017
 */

public class TP01Q05Is{
  /**
   *Metodo booleano que verifica se a palavra passada por parametro eh feita somente por vogais.
   *@param palavra String
   *@return only boolean
   */
  public static boolean soVogais (String palavra){
    boolean only= false;
    for(int i = 0; i < palavra.length(); i++){

      if((palavra.charAt(i) == 'A') || (palavra.charAt(i) == 'a') || (palavra.charAt(i) == 'E') || (palavra.charAt(i) == 'e') || (palavra.charAt(i) == 'I') ||
(palavra.charAt(i) == 'i') || (palavra.charAt(i) == 'O') || (palavra.charAt(i) == 'o') || (palavra.charAt(i) == 'U') || (palavra.charAt(i) == 'u')){

        only= true;
      }
      else{
        only= false;
        i= palavra.length() +1;
      }
    }
    return only;
  }//fim vogais()

  /**
   *Metodo booleano que verifica se a palavra passada por parametro eh feita somente por consoantes.
   *@param palavra String
   *@return only boolean
   */
  public static boolean soConsoantes (String palavra){
    boolean only= true;
    for(int i=0; i<palavra.length(); i++){
      if((!soVogais(palavra) == true) || (!numero(palavra.charAt(i)))){
        only= false;
      }
    }
    return only;
  }//fim soConsoantes()

 /**
   *Metodo booleano que verifica se o carcter passado por parametro eh um numero.
   *@param palavra String
   *@return boolean
   */
  public static boolean numero(char lett){
    if ((lett >=48) && (lett <= 57)){
      return true;
    }
    return false;
  }//fim numero

 /**
   *Metodo booleano que verifica se a string passada por parametro eh somente um numero inteiro.
   *@param palavra String
   *@return only boolean
   */
  public static boolean soInteiro (String palavra){
    boolean only= false;
    for(int i = 0; i < palavra.length(); i++){
      if(numero(palavra.charAt(i))){
			     only = true;
		}
      else{
        only= false;
        i= palavra.length() +1;
      }
    }
    return only;
  }//fim soInteiro()

 /**
   *Metodo booleano que verifica se a string passada por parametro eh um numero real.
   *@param palavra String
   *@return only boolean
   */
  public static boolean soReal (String palavra){
    boolean only= false;
    int cont= 0;
    if(soInteiro(palavra)){
      return true;
    }
    for(int i = 0; i < palavra.length(); i++){
      if(!numero(palavra.charAt(i))){
        if(palavra.charAt(i) == ',' || palavra.charAt(i) == '.'){
          cont++;
          only= true;
        }
        else{
          return false;
        }
      }
    }
    if(cont > 1){
      only= false;
    }
    return only;
  }//fim soReal()

 /**
   *Metodo void de saida na tela.
   *@param palavra String
   *@return prints
   */
  public static void saida(String palavra){
    if(soVogais(palavra) == true){
      MyIO.print("SIM ");
    }
    else if(soVogais(palavra) == false){
      MyIO.print("NAO ");
    }
    if(soConsoantes(palavra) == true){
      MyIO.print("SIM ");
    }
    else if(soConsoantes(palavra) == false){
      MyIO.print("NAO ");
    }
    if(soInteiro(palavra) == true){
      MyIO.print("SIM ");
    }
    else if(soInteiro(palavra) == false){
      MyIO.print("NAO ");
    }
    if(soReal(palavra) == true){
      MyIO.print("SIM ");
    }
    else if(soReal(palavra) == false){
      MyIO.print("NAO ");
    }
    MyIO.println("");
  }//fim saida()

 /**
   *Metodo booleano que verifica se a palavra passada por parametro eh igual a condicao de parada.
   *@param palavra String
   *@return only boolean
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

  public static void main(String[]args){
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
      saida(palavra[i]);
    }
  }//fim main()
}//fim classe
