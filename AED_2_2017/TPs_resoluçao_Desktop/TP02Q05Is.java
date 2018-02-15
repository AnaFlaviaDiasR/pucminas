/**
 *TP02Q05 -> Is
 *@author: Ana Flávia Dias Rodrigues
 * 31/08/2017
 */

public class TP01Q05Is{
  /**
   *Metodo booleano que verifica se a palavra passada por parametro eh feita somente por vogais.
   *@param palavra String
   *@return only boolean
   */

   public static boolean iniProcuraLetras(String palavra, char letra){
     return procuraLetras(palavra, letra, 0);
   }

   public static boolean procuraLetras(String palavra, char letra, int i){
      boolean resp = false;
      if(i<palavra.length()){
        if(letra == palavra.charAt(i)){
          resp= true;
          resp= procurarLetras(palavra, letra, i+1);
        }
        else{
          resp= false;
          resp= procurarLetras(palavra, letra, i+1);
        }
      }
      return resp;
   }



   public static boolean iniSoVogal(String palavra){
      return soVogal(palavra, 0);
   }

   public static boolean soVogal(String palavra, int i){
      boolean resp = true;
      String vogais = "aeiouAEIOU";

      if (i < palavra.length()){
         if(!iniProcuraLetras(vogais, palavra.charAt(i))){
            resp= false;
         }
         else{
            resp = soVogal(cadeia, i+1);
         }
      }

      return resultado;
   }

--------------------------------------------------------------
   public static boolean ehVogal(char letra){
      boolean resp = true;
      if (letra != 'a' && letra != 'á' && letra != 'e' &&
          letra != 'é' && letra != 'i' && letra != 'í' &&
          letra != 'o' && letra != 'ó' && letra != 'u' && letra != 'ú'){
         resp = false;
      }

      return resp;
   }//fim ehVogal()

   public static boolean iniSoVogais(String palavra){
     return soVogais(palavra, i);
   }

   public static boolean soVogais(String palavra, int i){
     boolean only= false;
     if(i<palavra.length()){
       if(ehVogal(palavra.charAt(i))){
         only= true;
         only= soVogais(palavra, i+1);
       }
       else{
         only= false;
      }
    }
    return only;
  }//fim soVogais()

  /**
    *Metodo booleano que verifica se o carcter passado por parametro eh um numero.
    *@param palavra String
    *@return boolean
    */
    public static boolean iniNumero(char letra){
      return numero(letra);
    }//fim iniNumero()

    public static boolean numero(char letra){
      boolean resp= false;
      if ((letra >=48) && (letra <= 57)){
        resp= true;
      }
      else{
        resp= false;
      }
      return resp;
    }//fim numero()


   /**
     *Metodo booleano que verifica se a string passada por parametro eh somente um numero inteiro.
     *@param palavra String
     *@return only boolean
     */
     public static boolean iniSoInteiro(String palavra){
       return soInteiro(palavra,0);
     }//fim iniSoInteiro()

     public static boolean soInteiro (String palavra, int i){
       boolean only= false;
       if(i<palavra.length()){
         if(iniNumero(palavra.charAt(i))){
           only= true;
           only= soInteiro(palavra, i+1);
         }
         else{
           only= false;
         }
      }
      return only;
    }//fim soInteiro()

    public static int iniContPontuacao(String palavra){
      return contPontuacao(palavra, ',', '.' , 0);
   }//fim iniContPontuacao()

   public static int contPontuacao(String palavra, char virgula, char ponto, int i){
      int qt = 0;
      if (i < palavra.length()){
         if ((palavra.charAt(i) == virgula) || (palavra.charAt(i) == ponto)){
              qt += 1 + contPontuacao(palavra, virgula, ponto, i+1);
         }
         else {
            qt = contPontuacao(palavra, virgula, ponto, i+1);
         }
      }

      return qt;
   }//fim contPontuacao()

   /**
     *Metodo booleano que verifica se a string passada por parametro eh um numero real.
     *@param palavra String
     *@return only boolean
     */
       public static boolean iniSoReal(String palavra){
         return soReal(palavra,0);
       }//fim iniSoReal()

       public static boolean soReal (String palavra, int i){
         boolean only= false;
         int cont= 0;
        if(soInteiro(palavra)){
          return true;
        }
        if(i<palavra.length()){
          if((numero(palavra.charAt(i))) && (iniContPontuacao(palavra.charAt(i)) <= 1)){
            only= true;
            only= soReal(palavra,i+1);
          }
          else{
            only= false;
          }
        }
        return only;
      }//fim soReal()

  /**
   *Metodo booleano que verifica se a palavra passada por parametro eh feita somente por consoantes.
   *@param palavra String
   *@return only boolean
   */
   public static boolean iniSoConsoantes(String palavra){
     return soConsoantes(palavra,0);
   }//fim iniConsoantes()

   public static boolean soConsoantes (String palavra, int i){
     boolean only= false;
     if(i<palavra.length()){
       if((!iniSoVogais(palavra)) || (!iniNumero(palavra.charAt(i)))){
         only= true;
         only= soConsoantes(palavra, i+1);
       }
       else{
         only= false;
       }
   }
   return only;

 /**
   *Metodo void de saida na tela.
   *@param palavra String
   *@return prints
   */
  public static void saida(String palavra){
    if(iniSoVogais(palavra)){
      MyIO.print("SIM ");
    }
    else{
      MyIO.print("NAO ");
    }
    if(iniSoConsoantes(palavra)){
      MyIO.print("SIM ");
    }
    else {
      MyIO.print("NAO ");
    }
    if(iniSoInteiro(palavra)){
      MyIO.print("SIM ");
    }
    else{
      MyIO.print("NAO ");
    }
    if(inisoReal(palavra)){
      MyIO.print("SIM ");
    }
    else{
      MyIO.print("NAO ");
    }
    MyIO.println("");
  }//fim saida()

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

  public static void main(String[]args){
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
      saida(palavra[i]);
    }
  }//fim main()
}//fim classe
