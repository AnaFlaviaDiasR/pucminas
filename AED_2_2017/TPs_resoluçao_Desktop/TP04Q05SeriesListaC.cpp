#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
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

void imprimir(Series* series){
  printf("%s %s %s %s %s %s %s %d %d/n",series->nome,series->formato,series->duracao,series->paisDeOrigem,series->idiomaOriginal,series->emissoraDeTvOriginal,series->transmissaoOriginal,
series->numeroDeTemporadas,series->numeroDeEpisodios);
}

char* removeTagsNome(char* linha){
  char* newLinha= NULL;
  int comeco= strcspn(linha, "<i>");
  for (int i= comeco + 3; linha[i] != '<'; i++){
    newLinha += linha[i];
  }
  return newLinha;
}



void lerSeries(Series* series, char* html){
    char arquivo[]= "/tmp/";
    strcat(arquivo, html);
    FILE *p = fopen (arquivo, "r");
    int* i;
    int* j;

}

int main(){
  char teste[]= "<td style=\"vertical-align: top; text-align: left;\"><a href=\"/wiki/S%C3%A9rie_de_televis%C3%A3o\" title=\"Série de televisão\">Série</a></td>";
  char* nome= removeTagsNome(teste);
  printf("%s", nome);

  return 0;
}
