#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#define MAX_LENGTH 200
#define MAXTAM  106

typedef struct Series{
  //metodos privados
  char* nome;
  char* formato;
  char* duracao;
  char* paisDeOrigem;
  char* idiomaOriginal;
  char* emissoraDeTvOriginal;
  char* transmissaoOriginal;
  int numeroDeTemporadas;
  int numeroDeEpisodios;
}Series;

Series* start(){
  Series* series= (Series*) malloc(sizeof(Series));
  series->nome= NULL;
  series->formato= NULL;
  series->duracao= NULL;
  series->paisDeOrigem= NULL;
  series->idiomaOriginal= NULL;
  series->emissoraDeTvOriginal= NULL;
  series->transmissaoOriginal= NULL;
  series->numeroDeTemporadas= 0;
  series->numeroDeEpisodios= 0;

  return series;
}

Series* startSeries(char* nomeS, char* formatoS, char* duracaoS, char* paisDeOrigemS, char* idiomaOriginalS, char* emissoraDeTvOriginalS,
char* transmissaoOriginalS, int numeroDeTemporadasS, int numeroDeEpisodiosS){
  Series* series= (Series*) malloc(sizeof(Series));
  series->nome= nomeS;
  series->formato= formatoS;
  series->duracao= duracaoS;
  series->paisDeOrigem= paisDeOrigemS;
  series->idiomaOriginal= idiomaOriginalS;
  series->emissoraDeTvOriginal= emissoraDeTvOriginalS;
  series->transmissaoOriginal= transmissaoOriginalS;
  series->numeroDeTemporadas= numeroDeTemporadasS;
  series->numeroDeEpisodios= numeroDeEpisodiosS;
}//fim construtor 2


char* substring(char str[], int inicio, int fim) {
    int x, y;
    char *sub;
    // Verifica valores incompatíveis e retorna NULL
    if(inicio >= fim || fim > strlen(str)) {
        return NULL;
    }
    // Aloca memória para a substring
    sub= (char*) malloc (sizeof(char) * (fim - inicio + 1));
    // Copia a substring para a variável
    for(x= inicio, y= 0; x < fim; x++, y++) {
        sub[y] = str[x];
    }
    // Terminador de string
    sub[y] = '\0';
    return sub;
}
//clear
char* arruma(char* linha, int x, int y){
  int pos= 0;
  char* novaLinha= (char*) malloc(50000 * sizeof(char));
  for(int i= 0; i < strlen(linha); i++){
    bool aux= i >= x && i <= y ? true: false;
    if(!aux){
      novaLinha[pos]= linha[i];
      pos++;
    }
  }
  return novaLinha;
}

char* replace(char* str, char find, char replace){
    char *current_pos = strchr(str,find);
    while (current_pos){
        *current_pos = replace;
        current_pos = strchr(current_pos,find);
    }
    return strdup(str);
}

char* removeTags(char* linha){
  char* tmp;
  char tmp2[]= "";
  for(int i= strcspn(linha, "<"); strstr(linha, "<") && strstr(linha, ">"); i= strcspn(linha, "<")){
    int j= strcspn(linha, ">");
    linha= arruma(linha, i, j);
  }
  return linha;
}

void removeOutros(char *target, const char *needle, const char *replacement){
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

Series* lerSeries(char* html){
    Series* series= start();
    char* aux;
    char arquivo[]= "/tmp/";
    char string[10000];
    strcat(arquivo, html);
    FILE *arq = fopen (arquivo, "r");
    char* linha;
    int* valor;
    bool flag= true;

    //leitura do nome série
    if(strstr(html, ".html")){
        html= replace(html, '_',' ');
        for(int i= 0; i < strlen(html); ++i){
          if(html[i] == '.'){
            html[i] = '\0';
          }
        }
        series->nome= html;
    }

    while(flag){
      linha= fgets(string, 5000, arq);

      if (strstr(linha, ">Formato</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
  			removeOutros(aux, "&#160;", "");
        series->formato= aux;
      }

      else if (strstr(linha, ">Duração</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
  			removeOutros(aux, "&#160;", "");
        series->duracao= aux;
      }

      else if (strstr(linha, ">País de origem</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
        removeOutros(aux, "&#160;", "");
        series->paisDeOrigem= aux;
      }

      else if (strstr(linha, ">Idioma original</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
        removeOutros(aux, "&#160;", "");
        series->idiomaOriginal= aux;
      }

      else if (strstr(linha, ">Emissora de televisão original</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
        removeOutros(aux, "&#160;", "");
        series->emissoraDeTvOriginal= aux;
      }

      else if (strstr(linha, ">Transmissão original</td>")){
        linha= fgets(string, 5000, arq);
        linha[strlen(linha) - 1]= '\0';
        aux= removeTags(linha);
        removeOutros(aux, "&nbsp;", "");
        removeOutros(aux, "&#160;", "");
        series->transmissaoOriginal= aux;
      }

      else if (strstr(linha, ">N.º de temporadas</td>")){
        linha= fgets(string, 5000, arq);
        aux= removeTags(linha);
        if (strstr(aux," ")){
          int i= strcspn(linha, " ");
          aux= substring(aux, 0, i);
        }
        series->numeroDeTemporadas= atoi(aux);
      }

      else if (strstr(linha, ">N.º de episódios</td>")){
        linha= fgets(string, 5000, arq);
        aux= removeTags(linha);
        if(strstr(aux, " ")){
          int i= strcspn(linha, " ");
          aux= substring(aux, 0, i);
        }
        series->numeroDeEpisodios= atoi(aux);
        flag= false;
      }
    }
    fclose(arq);
    return series;
}

void imprimir(Series* series){
  printf("%s %s %s %s %s %s %s %d %d\n",series->nome,series->formato,series->duracao,series->paisDeOrigem,series->idiomaOriginal,series->emissoraDeTvOriginal,series->transmissaoOriginal,
series->numeroDeTemporadas,series->numeroDeEpisodios);
}


int compareTo(char *str1, char *str2){
	bool resp= true;
	for(int i = 0; '\0' !=  str1[i]; i++){
		if(str1[i] != str2[i]){
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
Series* array[MAXTAM];   // Elementos da pilha
int n;               // Quantidade de array.
/**
 * Inicializacoes
 */
void inicio(){
   n = 0;
}

/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Series* x) {
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
void inserirFim(Series* x) {

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
void inserir(Series* x, int pos) {
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
Series* removerInicio() {
   int i;
   Series* resp;

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
Series* removerFim() {

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
Series* remover(int pos) {
   int i;
   Series* resp;

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
      imprimir(array[i]);
   }
}
/**
 * Procura um array e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o array existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisar(Series* x) {
   bool retorno = false;
   int i;

   for (i = 0; i < n && retorno == false; i++) {
      retorno = (array[i] == x);
   }
   return retorno;
}
void operacoes(char* nome){
	Series* s;
	char* newName;
	int pos;
	if (nome[0] == 'I' && nome[1] == 'I'){

		newName = substring(nome, 3, strlen(nome));
		s = lerSeries(newName);
		inserirInicio(s);
	}
	else if (nome[0] == 'I' && nome[1] == 'F'){
		newName = substring(nome, 3, strlen(nome));
		s = lerSeries(newName);
		inserirFim(s);

	}
	else if (nome[0] == 'I' && nome[1] == '*'){
		pos = atoi(substring(nome,3,5));
		newName = substring(nome, 6, strlen(nome));
		s = lerSeries(newName);
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

int main(){
  Series* series;
  char flag[]= "FIM";
  char linha[100];
  scanf("%[^\n]%*c", linha);
  //while(!compareTo(linha, flag)){
  for (char* i = linha; !compareTo(i, flag); i = linha){
  	series = lerSeries(linha);
		inserirFim(series);
		scanf("%[^\n]%*c", linha);
	}
	scanf("%[^\n]%*c", linha);
	int op = atoi(linha);
	for (int i = 0; i < op; ++i){
		scanf("%[^\n]%*c", linha);
		operacoes(linha);
	}

	mostrar();

	return 0;
}
