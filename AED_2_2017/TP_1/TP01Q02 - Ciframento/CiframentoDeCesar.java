/**
    * Ciframento de Cesar com chave 3
    * @author Ana Flavia Dias Rodrigues
*/
class CiframentoDeCesar{

    /**
        * Metodo para realizar o ciframento
        * @param s String
        * @return cifrado String
    */
    public static String ciframento(String s){
        String cifrado= ""; //"vetor de char"

        for (int i = 0; i < s.length(); i++) {

            cifrado += (char)(s.charAt(i)+3); //transforma em char o valor int na tabela ascii 

        }//fim for    
        return cifrado;
    }//fim ciframento()


    public static void main(String[] args){
        String[] entrada = new String[1000]; 
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("FIM")); //verifica a proxima linha
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            MyIO.println(ciframento(entrada[i]));
        }//fim for
    } //fim main() 

}//fim class