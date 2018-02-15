public class TP02Q01Palindromo{
	/**
		* O metodo inicializa o metodo recursivo
    * @param palavra String
    * @return metodo recursivo
	*/
  public static boolean iniPalindromo (String palavra){
    return palindromo(palavra, 0, palavra.length()-1);
  }

  /**
		* O metodo verifica recursivamente se a String passada por parametro eh um palindromo
    * @param palavra String
    * @param i int
    * @param j int
    * @return resultado boolean
	*/
  public static boolean palindromo(String palavra, int i, int j){
      boolean resultado= true;
      if(i<j){
        if(palavra.charAt(i) == palavra.charAt(j)){
          resultado= palindromo(palavra, i+1, j-1);
        }
        else{
          resultado= false;
        }
      }
      return resultado;
  }//fim resultado()

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
		String[] palavra= new String[1000];
		int qt=0;
		boolean verifica= false;
		do{
			palavra[qt]= MyIO.readLine();
			verifica= iniFlag(palavra[qt]);
			qt++;
		}while(verifica == false);
		qt--; //Desconsidera a palavra FIM
		for (int i=0; i<qt; i++){
			if (iniPalindromo(palavra[i])==false){
				MyIO.println("NAO");
			}
			else{
				MyIO.println("SIM");
			}
		}
	}//fim main
}//fim class
