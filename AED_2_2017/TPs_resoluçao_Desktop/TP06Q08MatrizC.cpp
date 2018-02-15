#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>
#include <err.h>
#define MAX_LENGTH 200

typedef struct Celula{
  int elemento;
  Celula* sup;
  Celula* inf;
  Celula* esq;
  Celula* dir;
}Celula;

Celula* criaCelula(int elemento){
  Celula* celula= (Celula*) malloc(sizeof(Celula));
  celula->elemento= elemento;
  celula->sup= NULL;
  celula->inf= NULL;
  celula->esq= NULL;
  celula->dir= NULL;
  return celula;
}

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

typedef struct Matriz{
  Celula *inicio;
  int linha;
  int coluna;
}Matriz;

Celula* primeira;

Matriz* criaMatriz(int linha, int coluna){
  Matriz* matriz= (Matriz*)malloc(sizeof(Matriz));
  matriz->linha= linha;
  matriz->coluna= coluna;
  primeira= inicio;
  Celula* l;
  Celula* c;

  for(int i=0; i < matriz->linha; ++i){
    for(int j=0; j < matriz->coluna; ++j){

      if((i == 0) && (j == 0)){
        matriz->inicio= criaCelula(0);
        c= matriz->inicio;
        l= matriz->inicio;
      }

      else if(j != 0){
        c->dir= criaCelula(0);
        c->dir->esq= c;
        c= c->dir;
        if(i != 0){
          c->esq->sup->dir->inf= c;
          c->sup= c->esq->sup->dir;
        }//fim if
      }//fim else if

    }//fim for j

    if(i + 1 < matriz->linha){
      l->inf= criaCelula(0);
      l->inf->sup= l;
      l= l->inf;
      c= l;
    }//fim if
  }//fim for i

}//fim Matriz

int pesquisa(int* lin, int* col){
  Celula* where= primeira;
  for(int i= 0; i < lin; i++){
    where= where->inf;
  }

  for(int j=0; j < col; j++){
    where= where->dir;
  }
  return where->elemento;
}//fim pesquisa

void inserir(int* lin, int* col, int* elemento){
  Celula* aux= matriz->inicio;
  for(int i= 0; i < lin; i++){
    aux= aux->inf;
  }
  for(int j=0; j < col; j++){
    aux= aux->dir;
  }
  aux->elemento= elemento;
}//fim inserir

Matriz* soma(Matriz* m){
  Matriz* resp= NULL;
  int elemento;

  if((matriz->linha == m->linha) && (matriz->coluna == m->coluna)){
    resp= criaMatriz(m->linha, m->coluna);

    for(int i= 0; i < m->linha; i++){
      for(int j=0; j < m->coluna; j++){
        elemento= matriz->pesquisa(i, j) + m->pesquisa(i, j);
        resp->inserir(i, j, elemento);
      }
    }
  }//fim if
  return resp;
}

int mostrarMatriz(int contL, int contC){
  Celula* aux= matriz->inicio;
  for(int i=0; i < contL; i++, aux= aux->inf);
  for(int j=0; j < contC; j++, aux= aux->dir);
  return aux->elemento;
}

int main(){
  int* linha = (int*) malloc(1000*sizeof(int));
  int qtCasos= scanf("%[^\n]%d", linha);
  int lin1, col1;
  int lin2, col2;
  char* data;
  char modificado[];
  int transf;

  do{
    lin1= scanf("%[^\n]%d", linha);
    col1= scanf("%[^\n]%d", linha);

    Matriz* m1= criaMatriz(lin1, col1);

    for(int i=0; i < lin1; i++){
      data= scanf("%[^\n]%*c", linha);
      modificado= substring(data, 2, strlen(data));
      for(int j= 0; j < col1; j++){
        transf= atoi(modificado[j]);
        m1->inserirElemento(i, j, transf);
      }
    }

    lin2= scanf("%[^\n]%d", linha);
    col2= scanf("%[^\n]%d", linha);

    Matriz* m2= criaMatriz(lin2, col2);

    for(int i=0; i < lin2; i++){
      data= scanf("%[^\n]%*c", linha);
      modificado= substring(data, 2, strlen(data));
      for(int j= 0; j < col2; j++){
        transf= atoi(modificado[j]);
        m2->inserirElemento(i, j, transf);
      }
    }

    Matriz* matSoma= m1->soma(m2);

    for (int i = 0; i < lin1; i++) {
      for (int j = 0; j < col1; j++) {
        printf("%d \n",matSoma->mostrarMatriz(i, j));
      }
      println("");
    }


  }while(qtCasos > 0);

}//fim main
