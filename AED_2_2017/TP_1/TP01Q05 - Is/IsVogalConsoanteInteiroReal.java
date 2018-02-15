/**
    * Verifica se a string eh composta somente por vogais ou consoantes
    * e se eh um numero inteiro e/ou real
    * @author Ana Flavia Dias Rodrigues
*/
class IsVogalConsoanteInteiroReal{

    /**
        * Metodo para verificar se a string eh somente vogal
        * @param s String
        * @return vogal booleano
    */
    public static boolean soVogal(String s){
        String nova= s.trim();
        boolean vogal= true;

        for (int i = 0; i < nova.length(); i++) {

            if( (nova.charAt(i) == 'A') || (nova.charAt(i) == 'a') || (nova.charAt(i) == 'E') || (nova.charAt(i) == 'e') 
                || (nova.charAt(i) == 'I') || (nova.charAt(i) == 'i') || (nova.charAt(i) == 'O') || (nova.charAt(i) == 'o')
                || (nova.charAt(i) == 'U') || (nova.charAt(i) == 'u')){
                vogal = true;
            }//fim if
            else{
                vogal= false;
                i= s.length()+1;
            }

        }//fim for
        return vogal;
    }//fim soVogal()

    /**
        * Metodo para verificar se a string eh somente consoante
        * @param s String
        * @return consoante booleano
    */
    public static boolean soConsoante(String s){
        String nova= s.trim();
        boolean consoante= false;

        
        for (int i = 0; i < nova.length(); i++) {
            if ((soVogal(s)) && (ehNumero(s.charAt(i)))){
                consoante = true;
            }
        }        
        return consoante;
    }


    /**
        * Metodo para verificar se a string possui somente numeros
        * @param x char
        * @return booleano
    */
    public static boolean ehNumero(char x){
        if ((x >=48) && (x <= 57)){
            return true;
        }
        return false;
    }//fim ehNumero

    /**
        * Metodo para verificar se a string eh um numero inteiro
        * @param s String
        * @return inteiro booleano
    */
    public static boolean soInteiro(String s){
        boolean inteiro= false;

        for (int i = 0; i < s.length(); i++) {
            if (ehNumero(s.charAt(i))) {
                inteiro = true;
            }//fim if
            else{
                inteiro = false;
                i= s.length()+1;
            }
        }//fim for
        return inteiro;
    }//fim soInteiro()    


    /**
        * Metodo para verificar se a string eh um numero real
        * @param s String
        * @return real booleano
    */
    public static boolean ehReal(String s){
        boolean real= false;
        int cont= 0; //conta quantos pontos ou virgulas tem na string

        if(soInteiro(s)){
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            if ( !ehNumero(s.charAt(i)) ){
                if ((s.charAt(i) == '.' || s.charAt(i) == ',')) {
                    real = true;
                    cont++;
                }
                else
                    return false;
            }//fim if

        }//fim for
        if(cont > 1){ 
            real = false;
        }
        return real;
    }//fim ehReal()  


    public static void main(String[] args){
        String[] entrada = new String[1000];  
        int numEntrada = 0;

        do{
            entrada[numEntrada] = MyIO.readLine();
        }while(!entrada[numEntrada++].equals("FIM")); //enquanto a proxima linha for diferente de FIM
        
        numEntrada--; //desconsidera a palavra FIM

        for (int i = 0; i < numEntrada; i++){
            if(soVogal(entrada[i]) == true){
                MyIO.print("SIM ");
            }
            else if(soVogal(entrada[i]) == false){
                MyIO.print("NAO ");
            }
            if(soConsoante(entrada[i]) == true){
                MyIO.print("SIM ");
            }
            else if(soConsoante(entrada[i]) == false){
                MyIO.print("NAO ");
            }
            if(soInteiro(entrada[i]) == true){
                MyIO.print("SIM ");
            }
            else if(soInteiro(entrada[i]) == false){
                MyIO.print("NAO ");
            }
            if(ehReal(entrada[i]) == true){
                MyIO.print("SIM ");
            }
            else if(ehReal(entrada[i]) == false){
                MyIO.print("NAO ");
            }
            MyIO.println("");
        }//fim for
    } // Fim main()

}//fim class