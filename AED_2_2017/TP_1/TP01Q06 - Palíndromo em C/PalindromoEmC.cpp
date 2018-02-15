#include <stdio.h>
#include <stdlib.h>
#include <string.h>
/**
    * Verifica se a palavra eh um palindromo na linguagem C
    * @author Ana Flavia Dias Rodrigues
*/
class PalindromoEmC{

    /**
        * Metodo para verificar se a palavra eh um palindromo
        * @param s String
        * @return palindromo boolean
    */
    int palindromo(char *s){
        int tamanho= strlen(s);
        int i,j;
        int resp = 1;

        for (i = 0, j = tamanho -1; i < tamanho / 2 ; ++i, j--) 
        {

            if (s[i] != s[j]) 
            {    
                resp = 0;
                i = tamanho;
            }//fim if

        }//fim for    
        return resp;
    }//fim palindromo()


    int main(int argc, char *argv[])
    {
        char *linha = (char*) malloc(1000 * sizeof(char));   
        
        scanf("%[^\n]%*c", linha);

        while (strcmp(linha, "FIM") != 0) 
        {
            if (palindromo(linha) == 1) 
            {
                printf("%s\n", "SIM");
                scanf("%[^\n]%*c", linha);
            }//fim if
            else if (palindromo(linha) == 0) 
            {
                printf("%s\n", "NAO");
                scanf("%[^\n]%*c", linha);
            }//fim else if
        }
    } //fim main() 

}//fim class