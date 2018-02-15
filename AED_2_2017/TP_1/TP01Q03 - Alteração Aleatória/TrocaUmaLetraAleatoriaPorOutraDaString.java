/**
    * Alteracao Aleatoria de uma letra por outra de uma string
    * @author Ana Flavia Dias Rodrigues
*/
import java.util.Random;

class TrocaUmaLetraAleatoriaPorOutraDaString{

    /**
        * Troca a letra aleatoria na String
        * @param s String
        * @param ran Random
        * @return nova String
    */
    public static String trocaAleatoria(String s, Random ran){
        char antes = (char)('a' + (Math.abs(ran.nextInt()) % 26)); 
        char depois = (char)('a' + (Math.abs(ran.nextInt()) % 26));
        String nova = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == antes){
                nova += depois;
            }
            else{
                nova += s.charAt(i);
            }//fim else

        }//fim for    
        return nova;
    }//fim ciframento()


    public static void main(String[] args){
        Random gerador = new Random();
        gerador.setSeed(4);

        String[] entrada = new String[1000]; 
        int numEntrada = 0;
        
        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("FIM")); //verifica a proxima linha
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            MyIO.println(trocaAleatoria(entrada[i],gerador));
        }//fim for
    } //fim main() 

}//fim class