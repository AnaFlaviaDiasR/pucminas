/**
 * TP06Q08
 * @author Stefany Gaspar
 * @version 1 12/11
 */
 #include <stdlib.h>
 #include <stdio.h>
 #include <string.h>

typedef struct Celula{
  int elemento;
  struct Celula* esq;
  struct Celula* dir;
  struct Celula* inf;
  struct Celula* sup;
} Celula;

Celula* novaCelula(int elemento){
  Celula* nova = (Celula*) malloc(sizeof(Celula));
  nova -> elemento = elemento;
  nova -> esq = NULL;
  nova -> dir = NULL;
  nova -> inf = NULL;
  nova -> sup = NULL;
  return nova;
}

typedef struct Matriz{
  Celula* inicio;
  int linha;
  int coluna;
}Matriz;

Celula* juntaLinha(Celula* i, Celula* j, int col) {
    Celula* k = j;
    for (int x = 0; x < col; x++) {
        i -> inf = j;
        j -> sup = i;
        i = i -> dir;
        j = j -> dir;
    }
    return k;
}

Celula* criaLinha(Celula* i, int coluna){
  Celula* comeco = i;
  for(int x = 1; x < coluna; x++){
    i -> dir = novaCelula(0); //cria a nova Celula
    i -> dir -> esq = i; //faz com que ligue os ponteiros na ida e na volta
    i = i -> dir; //ando com a Celula
  }//fim for
  return comeco;
}

Matriz* novaMatriz(int linha, int coluna){
  Matriz* novaMatriz = (Matriz*) malloc(sizeof(Matriz));
  novaMatriz -> linha = linha;
  novaMatriz -> coluna = coluna;
  novaMatriz -> inicio = novaCelula(0);
  Celula* i = criaLinha(novaMatriz -> inicio,coluna);
  //printf("passo Aqui");
  for(int j = 1; j < linha; j++){
    Celula* x = novaCelula(0);
    x = criaLinha(x,coluna);
    i = juntaLinha(i,x,coluna);
  }//fim for
  return novaMatriz;
}//fim novaMatriz

void mostrar(Matriz* m){
  Celula* i;
  for(i = m -> inicio; i!= NULL; i = i -> inf){
    for(Celula* j = i; j != NULL; j = j -> dir){
      printf("%d ", j -> elemento);
    }//fim for
    printf("\n");
  }//fim for
}

void leMatriz(Matriz* m){
  Celula* i;
  int x = 0;
  for(i = m -> inicio; i!= NULL; i = i -> inf){
    for(Celula* j = i; j != NULL; j = j -> dir){
      scanf("%d", &x);
      j -> elemento = x;
    }//fim for
  }//fim for
}//leMatriz

void mostrarDiagonalPrincipal(Matriz* m){
  int a = 0;
  int b = 0;
  for(Celula* i = m -> inicio; i!= NULL; i = i -> inf, a++){
    for(Celula* j = i; j != NULL; j = j -> dir, b++){
      if(a == b){
        printf("%d ", j -> elemento);
      }
    }//fim for
    b = 0;
  }//fim for
  printf("\n");
}

void mostrarDiagonalSecundaria(Matriz* m) {
  Celula* i;
  Celula* j;
  for(i = m -> inicio; (i -> dir) != NULL; i = i -> dir);
    for (j = i; j -> inf != NULL; j = j -> inf -> esq) {
      printf("%d ",j -> elemento );
    }
    printf("%d\n",j -> elemento );
}

void somaMatriz(Matriz* m1, Matriz* m2, Matriz* m){
  Celula* a = m1 -> inicio;
  Celula* b = m2 -> inicio;
  Celula* i ;
  for(i = m -> inicio; i != NULL ; i = i -> inf, a = a -> inf, b = b -> inf){
    Celula* c = a;
    Celula* d = b;
    for(Celula* j = i; j != NULL; j = j -> dir, c = c -> dir, d = d -> dir){
      j -> elemento = (c -> elemento + d -> elemento);
    }//fim for de dentro
  }//fim for de fora
}

  void multiplicacao(Matriz* m1, Matriz* m2, Matriz* m){
    Celula* tx = m1 -> inicio;
    Celula* mx = m2 -> inicio;
    Celula* rx = m -> inicio;

    for (Celula* i = tx; i != NULL; i = i -> inf) {
      Celula* rp = rx;
      for (Celula* j = mx; j != NULL; j = j -> dir) {
        int soma = 0;
        Celula* tp = i;
        Celula* mp = j;
        while(tp != NULL){
          soma += (tp -> elemento * mp -> elemento);
          tp = tp -> dir;
          mp = mp -> inf;
        }
        rp -> elemento = soma;
        rp = rp -> dir;
      }
      rx = rx -> inf;
    }
  }

int main(){
  int numCasos = 0;
  int linha = 0;
  int coluna = 0;
  scanf("%d\n",&numCasos);
  while(numCasos > 0){
    //leio a primeira Matriz
    scanf("%d\n",&linha);
    scanf("%d\n",&coluna);
    Matriz* primeira = novaMatriz(linha,coluna);
    leMatriz(primeira);
    //leio a primeira Matriz
    scanf("%d\n",&linha);
    scanf("%d\n",&coluna);
    Matriz* segunda = novaMatriz(linha,coluna);
    leMatriz(segunda);
    mostrarDiagonalPrincipal(primeira);
    mostrarDiagonalSecundaria(primeira);
    //somo as matrizes
    Matriz* soma = novaMatriz(linha,coluna);
    somaMatriz(primeira, segunda, soma);
    mostrar(soma);
    //multiplica as matrizes
    Matriz* mult = novaMatriz(linha,coluna);
    multiplicacao(primeira, segunda, mult);
    mostrar(mult);
    numCasos--;
  }//fim While
}
