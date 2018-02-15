#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <err.h>
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
 * Pilha dinamica
 * @author Max do Val Machado
 * @version 2 01/2015
 */
 typedef struct Celula{
 	Series* elemento;        // Elemento inserido na celula.
 	struct Celula* prox; // Aponta a celula prox.
 }Celula;


 Celula* novaCelula(Series* elemento) {
    Celula* nova = (Celula*) malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
 }

 //PILHA PROPRIAMENTE DITA =======================================================
 Celula* topo; // Sem celula cabeca.

 /**
  * Cria uma fila sem elementos.
  */
 void inicio () {
    topo = NULL;
 }


 /**
  * Insere elemento na pilha (politica FILO).
  * @param x int elemento a inserir.
  */
 void inserir(Series* x) {
    Celula* tmp = novaCelula(x);
    tmp->prox = topo;
    topo = tmp;
    tmp = NULL;
 }

 /**
  * Remove elemento da pilha (politica FILO).
  * @return Elemento removido.
  */
  Series* remover() {
    if (topo == NULL) {
       errx(1, "Erro ao remover!");
    }

    Series* resp = topo->elemento;
    Celula* tmp = topo;
    topo = topo->prox;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    return resp;
 }


 /**
  * Mostra os elementos separados por espacos, comecando do topo.
  */
 void mostrar() {
    Celula* i;
    for(i = topo; i != NULL; i = i->prox) {
       imprimir(i->elemento);
    }
 }

int main(){
  Series* series;
  Series* s;
  char* newName;
  char flag[]= "FIM";
  char* linha = (char*) malloc(10000*sizeof(char));
  scanf("%[^\n]%*c", linha);

  for (char* i = linha; !compareTo(i, flag); i = linha){
  	series = lerSeries(linha);
		inserir(series);
		scanf("%[^\n]%*c", linha);
  }

	scanf("%[^\n]%*c", linha);
	int op = atoi(linha);

  while(op > 0){
    scanf("%[^\n]%*c", linha);
    if(strstr(linha, "I")){
      newName = substring(linha, 2, strlen(linha));
      s= lerSeries(newName);
      inserir(s);
    }
    else if(strstr(linha, "R")){
      s= remover();
      printf("(R) %s\n", s->nome);
    }
    op--;
	}

	mostrar();

	return 0;
}
