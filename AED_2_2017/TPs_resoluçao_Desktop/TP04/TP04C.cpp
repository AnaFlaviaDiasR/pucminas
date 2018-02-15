#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#define MAX_LENGTH 200
#define MAXTAM    106


typedef struct Serie{

	char *nome;
	char *duracao;
	char *formato;
	char *pais;
	char *idioma;
	char *emissora;
	char *transmissao;
	int temporadas;
	int eps;

} Serie;
/*
Costrutor vazio
*/
Serie* newSerie (){
	Serie* serie = (Serie*) malloc(sizeof(Serie));

	serie->nome = NULL;
	serie->formato = NULL;
	serie->duracao = NULL;
	serie->pais = NULL;
	serie->idioma = NULL;
	serie->emissora = NULL;
	serie->transmissao = NULL;
	serie->temporadas = 0;
	serie->eps = 0;
	return serie;
}

Serie* newSerie (char *nomeS, char *formatoS, char *duracaoS, char *paisS, char *idiomaS, char *emissoraS, char *transmissaoS, int temporadasS, int epsS){
	Serie* serie = (Serie*) malloc(sizeof(Serie));

	strcpy(serie->nome, nomeS);
	strcpy(serie->formato, formatoS);
	strcpy(serie->duracao, duracaoS);
	strcpy(serie->pais, paisS);
	strcpy(serie->idioma, idiomaS);
	strcpy(serie->emissora, emissoraS);
	strcpy(serie->transmissao, transmissaoS);
	serie -> temporadas = temporadasS;
	serie -> eps = epsS;
	return serie;
}
char* substring(char str[], int start, int end) {
    int i, j;
    char *sub;
    // Verifica valores incompatíveis e
    // retorna NULL
    if(start >= end || end > strlen(str)) {
        return NULL;
    }
    // Aloca memória para a substring
    sub = (char *) malloc(sizeof(char) * (end - start + 1));
    // Copia a substring para a variável
    for(i = start, j = 0; i < end; i++, j++) {
        sub[j] = str[i];
    }
    // Terminador de string
    sub[j] = '\0';
    return sub;
}


char* clear (char* line,int pos1, int pos2){
	int index = 0;
	char* newLine = (char*)malloc(50000*sizeof(char));
	char* x = substring(line, pos1, pos2);
	//printf("%s\n", x);
	for (int i = 0; i < strlen(line); i++){
		bool aux = i >= pos1 && i <= pos2 ? true : false;
		if(!aux){
			newLine[index] = line[i];
			index++;
		}
	}
	return newLine;
}// End delete()




char* replace(char* str, char find, char replace){
    char *current_pos = strchr(str,find);
    while (current_pos){
        *current_pos = replace;
        current_pos = strchr(current_pos,find);
    }
    return strdup(str);
}

// strstr = contains
// strcspn = indexof
// strcpy = copiar uma cadeia em uma "String"
char* removeTag (char* line){
	char* aux;
	char aux2 [] = "";
	for (int pos1 = strcspn(line, "<");strstr(line, "<") && strstr(line, ">"); pos1 = strcspn(line, "<")){
		int pos2 = strcspn(line, ">");
		line = clear(line, pos1, pos2);
	}
	return line;
}

void removerEspecial(char *target, const char *needle, const char *replacement)
{
    char buffer[1024] = { 0 };
    char *insert_point = &buffer[0];
    const char *tmp = target;
    size_t needle_len = strlen(needle);
    size_t repl_len = strlen(replacement);
    while (1) {
        const char *p = strstr(tmp, needle);
        // walked past last occurrence of needle; copy remaining part
        if (p == NULL) {
            strcpy(insert_point, tmp);
            break;
        }
        // copy part before needle
        memcpy(insert_point, tmp, p - tmp);
        insert_point += p - tmp;
        // copy replacement string
        memcpy(insert_point, replacement, repl_len);
        insert_point += repl_len;
        // adjust pointers, move on
        tmp = p + needle_len;
    }
    // write altered string back to target
    strcpy(target, buffer);
}



Serie* lerArquivo(char* nome){
	Serie* serie = newSerie();
	char* aux;
	char link[] = "/tmp/";
	char str[10000];
	strcat(link, nome);
	FILE *file = fopen(link, "r");
	char* line;
	bool flag = true;

	if (strstr(nome, ".html")){
		nome = replace(nome, '_',' ');
		for (int i = 0; i < strlen(nome); ++i){
			if (nome[i] == '.')	{
				nome[i] = '\0';
			}
		}
		serie->nome = nome;
	}

	while(flag){

		line = fgets(str, 5000, file);

		if (strstr(line, ">Formato</td>")) {
			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->formato = aux;

		}
		else if (strstr(line, ">Duração</td>")) {
			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->duracao = aux;
		}
		else if (strstr(line, ">País de origem</td>")) {
			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->pais = aux;
		}
		else if (strstr(line, ">Idioma original</td>")) {
			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->idioma = aux;
		}
		else if (strstr(line, ">Emissora de televisão original</td>")) {
			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->emissora = aux;
		}
		else if (strstr(line, ">Transmissão original</td>")) {

			line = fgets(str, 5000, file);
	  		line[strlen(line) - 1] = '\0';
			aux = removeTag(line);
			removerEspecial(aux, "&nbsp;", "");
			removerEspecial(aux, "&#160;", "");
			serie->transmissao = aux;
		}
		else if (strstr(line, ">N.º de temporadas</td>")) {

			line = fgets(str, 5000, file);
			char* linha = removeTag(line);
			if (strstr(linha," ")){
				int x = strcspn(line, " ");
				linha = substring(linha, 0, x);
			}
			serie->temporadas = atoi(linha);
		}
		else if (strstr(line, ">N.º de episódios</td>")) {
			line = fgets(str, 5000, file);
			char* linha = removeTag(line);
			if (strstr(linha," ")){
				int x = strcspn(line, " ");
				linha = substring(linha, 0, x);
			}
			serie->eps = atoi(linha);
			flag = false;
		}
	}
	fclose(file);
	return serie;
}
void imprime(Serie* s){
	printf("%s %s %s %s %s %s %s %d %d\n", s->nome, s->formato, s->duracao, s->pais, s->idioma, s->emissora, s->transmissao, s->temporadas, s->eps);
}

int equals (char  *palavra, char *palavra2){
	bool resp = true;
	for(int i = 0; '\0' !=  palavra[i]; i++){
		if(palavra[i] != palavra2[i]){
			resp = false;
			return resp;
		}
	}
	return resp;
}

/**
 * Lista estatica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
Serie* array[MAXTAM];   // Elementos da pilha
int n;               // Quantidade de array.
/**
 * Inicializacoes
 */
void start(){
   n = 0;
}

/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Serie* x) {
   int i;

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }

   //levar elementos para o fim do array
   for(i = n; i > 0; i--){
      array[i] = array[i-1];
   }

   array[0] = x;
   n++;
}
/**
 * Insere um elemento na ultima posicao da
 * @param x int elemento a ser inserido.
 */
void inserirFim(Serie* x) {

   //validar insercao
   if(n >= MAXTAM){
      printf("Erro ao inserir!");
      exit(1);
   }

   array[n] = x;
   n++;
}
/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(Serie* x, int pos) {
   int i;

   //validar insercao
   if(n >= MAXTAM || pos < 0 || pos > n){
      printf("Erro ao inserir!");
      exit(1);
   }

   //levar elementos para o fim do array
   for(i = n; i > pos; i--){
      array[i] = array[i-1];
   }

   array[pos] = x;
   n++;
}
/**
 * Remove um elemento da primeira posicao da lista e movimenta
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
Serie* removerInicio() {
   int i;
   Serie* resp;

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[0];
   n--;

   for(i = 0; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}
/**
 * Remove um elemento da ultima posicao da
 * @return resp int elemento a ser removido.
 */
Serie* removerFim() {

   //validar remocao
   if (n == 0) {
      printf("Erro ao remover!");
      exit(1);
   }

   return array[--n];
}
/**
 * Remove um elemento de uma posicao especifica da lista e
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
Serie* remover(int pos) {
   int i;
   Serie* resp;

   //validar remocao
   if (n == 0 || pos < 0 || pos >= n) {
      printf("Erro ao remover!");
      exit(1);
   }

   resp = array[pos];
   n--;

   for(i = pos; i < n; i++){
      array[i] = array[i+1];
   }

   return resp;
}
/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;

   for(i = 0; i < n; i++){
      imprime(array[i]);
   }
}
/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(Serie* x) {
   bool retorno = false;
   int i;

   for (i = 0; i < n && retorno == false; i++) {
      retorno = (array[i] == x);
   }
   return retorno;
}
void operacao(char* nome){
	Serie* s;
	char* newName;
	int pos;
	if (nome[0] == 'I' && nome[1] == 'I'){

		newName = substring(nome, 3, strlen(nome));
		s = lerArquivo(newName);
		inserirInicio(s);
	}
	else if (nome[0] == 'I' && nome[1] == 'F'){
		newName = substring(nome, 3, strlen(nome));
		s = lerArquivo(newName);
		inserirFim(s);

	}
	else if (nome[0] == 'I' && nome[1] == '*'){
		pos = atoi(substring(nome,3,5));
		newName = substring(nome, 6, strlen(nome));
		s = lerArquivo(newName);
		inserir(s, pos);
	}
	else if (nome[0] == 'R' && nome[1] == 'I'){
		s = removerInicio( );
		printf("(R) %s\n", s->nome);
	}
	else if (nome[0] == 'R' && nome[1] == 'F'){
		s = removerFim( );
		printf("(R) %s\n", s->nome);
	}
	else if (nome[0] == 'R' && nome[1] == '*'){
		pos = atoi(substring(nome,3,5));

		s = remover(pos);
		printf("(R) %s\n", s->nome);

	}
}
int main( ){

	/*Serie* s;
	char x[] = "Outlander.html";
	s = lerArquivo(x);
	imprime(s);
	*/
	Serie* s;
	char flag[] = "FIM";
	char line[100];
	scanf("%[^\n]%*c", line);
	for (char* i = line; !equals(i, flag); i = line){
		s = lerArquivo(line);
		inserirFim(s);
		scanf("%[^\n]%*c", line);
	}
	scanf("%[^\n]%*c", line);
	int op = atoi(line);
	for (int i = 0; i < op; ++i){
		scanf("%[^\n]%*c", line);
		operacao(line);
	}



	mostrar();
	

	return 0;
}
