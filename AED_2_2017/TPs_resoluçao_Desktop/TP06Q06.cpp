#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <err.h>
#define TAMANHO 5570
#define MAXTAM    200
#define LINETAM 5000
#define bool      short
#define true      1
#define false     0
//============================= TIPO SERIE =====================================

typedef struct Serie{
  char* nome;
  char* formato;
  char* duracao;
  char* paisDeOrigem;
  char* idiomaOriginal;
  char* emissoraDeTvOriginal;
  char* transmissaoOriginal;
  int numeroDeTemporadas;
  int numeroDeEpisodios;
} Serie;

Serie* start(){
  Serie* serie = (Serie*) malloc(sizeof(Serie));
  serie -> nome= NULL;
  serie -> formato= NULL;
  serie -> duracao= NULL;
  serie -> paisDeOrigem= NULL;
  serie -> idiomaOriginal= NULL;
  serie -> emissoraDeTvOriginal= NULL;
  serie -> transmissaoOriginal= NULL;
  serie -> numeroDeTemporadas= 0;
  serie -> numeroDeEpisodios= 0;
  return serie;
}

//==============================================================================

void imprimir(Serie* serie){
  printf("%s %s %s %s %s %s %s %d %d\n", serie -> nome, serie -> formato, serie -> duracao, serie -> paisDeOrigem, serie -> idiomaOriginal, serie -> emissoraDeTvOriginal, serie -> transmissaoOriginal, serie -> numeroDeTemporadas, serie -> numeroDeEpisodios);
}//fim imprimir

char* append(const char *orig, char c){
    size_t sz = strlen(orig);
    char *str = (char*)malloc(sz + 2);
    strcpy(str, orig);
    str[sz] = c;
    str[sz + 1] = '\0';
    return str;
}

char* arruma(char* linha, int x, int y){
  int pos = 0;
  char* novaLinha = (char*) malloc(10000 * sizeof(char));
  for(int i = 0; i < strlen(linha); i++){
    bool aux = i >= x && i <= y ? true: false;
    if(!aux){
      novaLinha[pos] = linha[i];
      pos++;
    }
  }
  return novaLinha;
}//fim arruma

//REMOVE TODAS AS TAGS
char* removeTags(char* linha){
  for(int inicio = strcspn(linha, "<"); strstr(linha, "<") && strstr(linha, ">"); inicio = strcspn(linha, "<")){
    int fim = strcspn(linha, ">");
    linha = arruma(linha, inicio, fim);
  }
  if((strstr(linha, "&#160;"))|| (strstr(linha, "&nbsp;"))){
    for(int inicio = strcspn(linha, "&"); strstr(linha, "&") && strstr(linha, ";"); inicio = strcspn(linha, "&")){
      int fim = strcspn(linha, ";");
      linha = arruma(linha, inicio, fim);
    }
  }
  linha[strcspn(linha, "\n")] = 0;
  return linha;
}//removeTags

//TIRA OS PARENTESES
char* tiraExcesso(char* linha){
    char* newLinha = (char*) malloc(10000 * sizeof(char));
    int fim = strcspn(linha, "(");
    for(int i = 0; i < fim - 1; i++){
      newLinha = append(newLinha, linha[i]);
    }
  return newLinha;
}

// ORGANIZA O NOME TIRANDO OS ESPACOS/ PARENTESES
char* limpaString(char* linha){
  char* newLinha = (char*) malloc(10000 * sizeof(char));
  if(strstr(linha, "\t")){
    char letra;
    for(int i = 0; i < strlen(linha); i++){
      letra = linha[i];
      if(letra != '\t'){
        newLinha = append(newLinha, linha[i]);
      }
    }
}
  if(strstr(newLinha, "(")){
    newLinha = tiraExcesso(newLinha);
  }
  return newLinha;
}

int pegaEp(char* linha){
  char* newLinha = (char*) malloc(10000 * sizeof(char));
  int fim = strcspn(linha, " ");
  for(int i = 0; i < fim; i++){
    newLinha = append(newLinha, linha[i]);
  }
  return atoi(newLinha);
}

//ABRE O HTML

Serie* trataHTML(Serie* serie, char tmp[MAXTAM]){
  char linha[LINETAM];
  char* newLinha;
  int valor;
  char endereco[] = "/tmp/";
  strcat(endereco,tmp);//junto o /tmp com o endereco
  FILE* ponteiro = fopen(endereco,"r");

  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,"<h1") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  //printf("%s\n", linha);
  newLinha = removeTags(linha);
  if(strstr(newLinha, "\t")){
    newLinha = limpaString(newLinha);
  }
  serie -> nome = newLinha;

  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">Formato<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> formato = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">Duração<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> duracao = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">País de origem<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> paisDeOrigem = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">Idioma original<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> idiomaOriginal = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">Emissora de televisão original<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> emissoraDeTvOriginal = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">Transmissão original<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  serie -> transmissaoOriginal = newLinha;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">N.º de temporadas<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  valor = atoi(newLinha);
  serie -> numeroDeTemporadas = valor;


  for(fgets(linha, LINETAM, ponteiro); (strstr(linha,">N.º de episódios<") == 0 ) && (!feof(ponteiro)); fgets(linha, LINETAM, ponteiro));
  fgets(linha, LINETAM, ponteiro);
  newLinha = removeTags(linha);
  valor = pegaEp(newLinha);
  serie -> numeroDeEpisodios = valor;


  fclose(ponteiro);
  return serie;
}//trataHTML

// LE A SERIE
Serie* ler(char* endereco){
  Serie* serie = (Serie*) malloc(sizeof(Serie));
  return trataHTML(serie, endereco);
}//fim ler

//=========================== PILHA FLEXIVEL EM C ==============================

/**
 * Pilha dinamica
 * @author Max do Val Machado adaptada por Stefany Gaspar
 * @version 2 01/2015
 */

//TIPO CELULA ===================================================================
typedef struct Celula {
    Serie* elemento;        // Elemento inserido na celula.
    struct Celula* prox; // Aponta a celula prox.
} Celula;

Celula* novaCelula(Serie* elemento) {
   Celula* nova = (Celula*) malloc(sizeof(Celula));
   nova -> elemento = elemento;
   nova -> prox = NULL;
   return nova;
}

//PILHA PROPRIAMENTE DITA =======================================================
Celula* topo; // Sem celula cabeca.


/**
 * Cria uma fila sem elementos.
 */
void startPilha () {
   topo = NULL;
}


/**
 * Insere elemento na pilha (politica FILO).
 * @param x int elemento a inserir.
 */
void inserir(Serie* x) {
   Celula* tmp = novaCelula(x);
   tmp->prox = topo;
   topo = tmp;
   tmp = NULL;
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Serie* remover() {
   if (topo == NULL) {
      errx(1, "Erro ao remover!");
   }

   Serie* resp = topo->elemento;
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
     imprimir(i -> elemento);
   }
}

char** splitES(char* sFrase){
	char** frase1 = (char**) malloc(16*sizeof(char*));
	char *naoAcabou;
	naoAcabou = strtok(sFrase, " ");
	int i = 0;
	while(naoAcabou){
		frase1[i] = (char*) malloc(sizeof(char*));
		frase1[i] = naoAcabou;
		naoAcabou = strtok('\0', " ");
		i++;
	}
	return frase1;
}

//==============================================================================

/**
 * @author Stefany Gaspar
 * @version 2 01/2015
 */

int main(){
  //setlocale(LC_COLLATE, "iso-8859-1");
  char* endereco = (char*) malloc(10000 * sizeof(char));
  char* codigo = (char*) malloc(10000 * sizeof(char));
  Serie* serie;
  int qtd = 0;
  int pos = 0;
  startPilha(); //inicia a pilha

  fgets(endereco, LINETAM, stdin);
  endereco[strcspn(endereco, "\n")] = 0;

  while(!strstr(endereco, "FIM")){
    serie = ler(endereco);
    inserir(serie);
    fgets(endereco, LINETAM, stdin);
    endereco[strcspn(endereco, "\n")] = 0;
  }
  scanf("%d\n", &qtd); // le a qtd de modificacoes
  while(qtd > 0){
    fgets(codigo, LINETAM, stdin);
    char** frase = splitES(codigo);
    if((strstr(codigo,"I")) != NULL){
      endereco = frase[1];
      endereco[strcspn(endereco, "\n")] = 0;
      inserir(ler(endereco));
    }
    else if((strstr(codigo,"R")) != NULL){
      Serie* serieI = remover();
      printf("(R) %s\n", serieI -> nome);
    }
    qtd--;
  }
  mostrar();
  //free(codigo);
  //free(endereco);
}//fim main
