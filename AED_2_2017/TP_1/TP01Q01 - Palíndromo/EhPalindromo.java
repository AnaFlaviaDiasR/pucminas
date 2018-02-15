/**
    * Verifica se a palavra eh um palindromo
    * @author Ana Flavia Dias Rodrigues
*/
class EhPalindromo{

    /**
        * Metodo para verificar se a palavra eh um palindromo
        * @param s String
        * @return palindromo boolean
    */
    public static boolean palindromo(String s){
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != (s.charAt(s.length()-1-i)) ){
                return false;
            }//fim if

        }//fim for    
        return true;
    }//fim palindromo()


    public static void main(String[] args){
        String[] entrada = new String[1000]; 
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("FIM")); //verifica a proxima linha
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            if (palindromo(entrada[i]) == false) {
                MyIO.println("NAO");
            }//fim if           
            else {
                MyIO.println("SIM");    
            }//fim else

        }//fim for
    } //fim main() 

}//fim class