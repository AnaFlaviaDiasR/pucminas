/**
    * Retorna um valor booleano para informar se a expressao eh verdadeira ou falsa
    * @author Ana Flavia Dias Rodrigues
*/
class AlgebraBooleana{

    /**
        * Metodo para verificar se a palavra eh um resultadoExpressao
        * @param s String
        * @return resultadoExpressao boolean
    */
    public static boolean doisValores(String s){
        //int quantidade= s.charAt(0); //primeiro caracter da expressao que informa quantos elementos serao comparados
        int a, b;//, val3;   //elementos
        char aux;
        int resultado;
        String nova= s.trim(); //tirar espacos

        //if(quantidade == 2){
            a= (int)s.charAt(1);
            b= (int)s.charAt(2);

            if (s.contains("and")){ //----------------------------------------------------and
                if (s.contains("not")){
                    aux= s.substring('(', ')');
                    if (aux == "A"){
                        a= metodoNot(a); //------------------criar metodo not
                    else{
                        b= metodoNot(b);
                    }
                }
                resultado= metodoAnd(a,b); //------------------criar metodo and
            }
            


                //if (s.contains("not(A)")){
                  //if (val1 == 0) val1= 1;
                  //  else val1= 0;
                //}
                //else if (s.contains("not(B)")){
                   // if (val2 == 0) val2= 1;
                  //  else val2= 0;
                //}
                


                
            }
        //}

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != (s.charAt(s.length()-1-i)) ){
                return false;
            }//fim if

        }//fim for    
        return true;
    }//fim resultadoExpressao()


    public static void main(String[] args){
        String[] entrada = new String[1000]; 
        String linha; 
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("0")); //verifica a proxima linha
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            if (resultadoExpressao(entrada[i]) == false) {
                MyIO.println("0");
            }//fim if           
            else {
                MyIO.println("1");    
            }//fim else

        }//fim for
    } //fim main() 

}//fim class