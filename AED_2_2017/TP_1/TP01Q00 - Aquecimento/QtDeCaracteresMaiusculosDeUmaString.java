/**
    * Conta quantas letras maiusculas existem em uma string
    * @author Ana Flavia Dias Rodrigues
*/
class QtDeCaracteresMaiusculosDeUmaString{

    /**
        * Metodo para contar a quantidade de ocorrencias de letras maiusculas de uma palavra
        * @param s String
        * @return cont int
    */
    public static int qtMaiusculas(String s){
        int cont = 0;
        for (int i = 0; i < s.length(); i++) {

            if( (s.charAt(i) >= 'A') && (s.charAt(i) <= 'Z') ){
                cont++;
            }//fim if

        }//fim for
        return cont;
    }//fim QtMaiusculas()


    public static void main(String[] args){
        String[] entrada = new String[1000];  
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("FIM")); //enquanto a proxima linha for diferente de FIM
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            MyIO.println(qtMaiusculas(entrada[i])); //envia a string i para o metodo
        }//fim for
    } // Fim main()

}//fim class