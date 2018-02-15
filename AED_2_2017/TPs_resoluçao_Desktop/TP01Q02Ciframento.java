class TP01Q02Ciframento{
  /*
    O metodo ciframento recebe uma String por parametro
    e retorna uma String cifrada com chave de ciframento 3
  */
  public static String ciframento (String entrada){
      String cifra= "";
      for (int i=0; i<entrada.length(); i++){
        cifra += (char)(entrada.charAt(i) + 3);
      }
      return cifra;
  }//fim ciframento()
  /*
    O metodo flag recebe uma String por parametro e
    verifica se essa eh a palavra "FIM", se falso,
    ele retornara falso e verifica a proxima palavra
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
      MyIO.println(ciframento(palavra[i]));
    }
  }//fim main
}//fim class
