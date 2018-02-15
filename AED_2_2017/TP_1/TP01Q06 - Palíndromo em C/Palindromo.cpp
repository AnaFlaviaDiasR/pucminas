#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int verifica_palindromo(char *palavra) {

	int tamanho = strlen(palavra);
	int resposta = 1;

	int i, j;

	for (i = 0, j = tamanho - 1; i < tamanho / 2; ++i, j--)
	{
		if (palavra[i] != palavra[j])
		{
			resposta = 0;
			i = tamanho;
		}
	}
	return resposta;
}

int main(int argc, char *argv[])
{
	char *linha = (char*) malloc(1000 * sizeof(char));

	scanf("%[^\n]%*c", linha);

	while (strcmp(linha, "FIM") != 0) {

		if (verifica_palindromo(linha) == 1) {
			printf("%s\n", "SIM");
			scanf("%[^\n]%*c", linha);
		}
		else if (verifica_palindromo(linha) == 0) {
			printf("%s\n", "NAO");
			scanf("%[^\n]%*c", linha);
		}
	}
}