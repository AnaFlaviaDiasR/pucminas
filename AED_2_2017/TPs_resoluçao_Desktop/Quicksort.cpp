#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <err.h>

typedef struct Municipio{
    int id;//OK
    char nome[200];//OK
    char uf[100];//OK
    int codigoUF;//OK
    int populacao;//OK
    int numeroFuncionarios;//OK
    int numeroComissionados;//OK
    char     escolaridade[200];//OK
    char estagio[200];//OK
    int atualizacaoPlano;//OK
    char regiao[100];//OK
    int atualizacaoCadastro;//OK
    bool consorcio;//OK
} Municipio;

Municipio* ler(){
    Municipio* a = (Municipio *) calloc(6000, sizeof(Municipio));

    int cont = 0;
    char linha[10000];

    FILE* arq;
    arq = fopen("/tmp/variaveisexternas.txt", "r");

    cont = 0;

    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL) {
        int inf = 0;
        char array[7][500];
        char* tok = strtok(linha, "\t");

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        a[cont].id = atoi(array[0]);
        strcpy(a[cont].regiao, array[1]);
        a[cont].codigoUF = atoi(array[2]);
        strcpy(a[cont].uf, array[3]);
        strcpy(a[cont].nome, array[4]);
        a[cont].populacao = atoi(array[6]);

        cont++;
    }

    arq = fopen("/tmp/recursoshumanos.txt", "r");

    cont = 0;
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL) {
        int inf = 0;
        char array[17][500];
        char* tok = strtok(linha, "\t");

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        if(strcmp(array[4], "-") != 0 && strcmp(array[4], "Não soube informar*") != 0 && strcmp(array[4], "Não informado") != 0 && strcmp(array[4], "Recusa") != 0){
            a[cont].numeroFuncionarios = atoi(array[4]);
        }

        if(strcmp(array[7], "-") != 0 && strcmp(array[7], "Não soube informar*") != 0 && strcmp(array[7], "Não informado") != 0 && strcmp(array[7], "Recusa") != 0){
            a[cont].numeroComissionados = atoi(array[7]);
        }

        cont++;
    }

    arq = fopen("/tmp/planejamentourbano.txt", "r");

    cont = 0;
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL) {
        int inf = 0;
        char* tok = strtok(linha, "\t");
        char array[17][500];

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        strcpy(a[cont].escolaridade, array[5]);
        if(strcmp(array[8], "-") != 0 && strcmp(array[8], "Não soube informar*") != 0 && strcmp(array[8], "Não informado") != 0 && strcmp(array[8], "Recusa") != 0){
            a[cont].atualizacaoPlano = atoi(array[8]);
        }

        cont++;
    }

    arq = fopen("/tmp/gestaoambiental.txt", "r");

    cont = 0;
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL) {
        int inf = 0;
        char* tok = strtok(linha, "\t");
        char array[15][500];

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        strcpy(a[cont].estagio, array[7]);

        cont++;
    }

    arq = fopen("/tmp/recursosparagestao.txt", "r");

    cont = 0;
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL) {
        int inf = 0;
        char* tok = strtok(linha, "\t");
        char array[15][500];

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        if(strcmp(array[6], "-") != 0 && strcmp(array[6], "Não soube informar*") != 0 && strcmp(array[6], "Não informado") != 0 && strcmp(array[6], "Recusa") != 0){
            a[cont].atualizacaoCadastro = atoi(array[6]);
        }
        cont++;
    }

    arq = fopen("/tmp/articulacaoointerinstitucional.txt", "r");

    cont = 0;
    fgets(linha, sizeof(linha), arq);
    while (fgets(linha, sizeof(linha), arq) != NULL){
        int inf = 0;
        char* tok = strtok(linha, "\t");
        char array[51][500];

        while(tok != NULL){
            strcpy(array[inf], tok);
            inf++;
            tok = strtok(NULL, "\t");
        }

        if(strcmp(array[5], "Sim") == 0){
            a[cont].consorcio = true;
        }else{
            a[cont].consorcio = false;
        }

        cont++;
    }

    return a;
}

Municipio clone(Municipio m){
    Municipio resp;
    resp.id = m.id;//OK
    strcpy(resp.nome, m.nome);//OK
    strcpy(resp.uf, m.uf);//OK
    resp.codigoUF = m.codigoUF;//OK
    resp.populacao = m.populacao;//OK
    resp.numeroFuncionarios = m.numeroFuncionarios;//OK
    resp.numeroComissionados = m.numeroComissionados;//OK
    strcpy(resp.escolaridade, m.escolaridade);//OK
    strcpy(resp.estagio, m.estagio);//OK
    resp.atualizacaoPlano = m.atualizacaoPlano;//OK
    strcpy(resp.regiao, m.regiao);//OK
    resp.atualizacaoCadastro = m.atualizacaoCadastro;//OK
    resp.consorcio = m.consorcio;//OK
    return resp;
}

void imprimir(Municipio i){
    printf("%d %s %s %d %d %d %d %s %s %d %s %d %s\n",
            i.id, i.nome, i.uf, i.codigoUF, i.populacao, i.numeroFuncionarios,
            i.numeroComissionados, i.escolaridade, i.estagio, i.atualizacaoPlano,
            i.regiao, i.atualizacaoCadastro, i.consorcio ? "true" : "false");
}

typedef struct Celula{
    Municipio elemento;
    struct Celula* prox;
    struct Celula* ant;
} Celula;

Celula* novaCelula(Municipio m){
    Celula* nova = (Celula *)malloc(sizeof(Celula));
    nova -> elemento = m;
    nova -> prox = NULL;
    nova -> ant = NULL;

    return nova;
}

Celula* primeiro;
Celula* ultimo;

void start(){
    Municipio m;
    primeiro = novaCelula(m);
    ultimo = primeiro;
}

int tamanho(){
    int tamanho = 0;
    for(Celula* i = primeiro; i != ultimo; i = i -> prox, tamanho++);
    return tamanho;
}

void inserirInicio(Municipio m){
    Celula* tmp = novaCelula(m);
    tmp -> ant = primeiro;
    tmp -> prox = primeiro -> prox;
    primeiro -> prox = tmp;

    if(primeiro == ultimo){
        ultimo = tmp;
    }else{
        tmp -> prox -> ant = tmp;
    }

    tmp = NULL;
}

void inserirFim(Municipio m){
    Celula* tmp = novaCelula(m);
    tmp -> ant = ultimo;
    ultimo -> prox = tmp;
    ultimo = tmp;
}

Municipio removerInicio(){
    if(primeiro == ultimo){
        errx(1, "Erro ao remover!");
    }
    Celula* tmp = primeiro;
    primeiro = primeiro -> prox;
    Municipio resp = primeiro -> elemento;
    tmp -> prox = NULL;
    primeiro -> ant = NULL;
    free(tmp);

    return resp;
}

Municipio removerFim(){
    if(primeiro == ultimo){
        errx(1, "Erro ao remover!");
    }

    Celula* tmp = ultimo;
    Municipio resp = tmp -> elemento;
    ultimo = ultimo -> ant;
    tmp -> ant = NULL;
    ultimo -> prox = NULL;
    free(tmp);

    return resp;
}

void inserir(Municipio m, int pos){
    int t = tamanho();

    if(pos < 0 || pos > t){
        errx(1, "Erro ao inserir!");
    }else if(pos == 0){
        inserirInicio(m);
    }else if(pos == t){
        inserirFim(m);
    }else{
        Celula* i = primeiro;

        for(int j = 0; j < pos; j++){
            i = i -> prox;
        }

        Celula* tmp = novaCelula(m);
        tmp -> ant = i;
        tmp -> prox = i -> prox;
        i -> prox = tmp;
        tmp -> prox -> ant = tmp;
    }
}

Municipio remover(int pos){
    Municipio resp;
    int t = tamanho();

    if(primeiro == ultimo){
        errx(1, "Erro ao remover!");
    }else if(pos < 0 || pos >= t){
        errx(1, "Erro ao remover. Posicao invalida!");
    }else if(pos == 0){
        resp = removerInicio();
    }else if(pos == t - 1){
        resp = removerFim();
    }else{
        Celula* i = primeiro -> prox;

        for(int j = 0; j < pos; j++){
            i = i -> prox;
        }

        i -> ant -> prox = i -> prox;
        i -> prox -> ant = i -> ant;
        resp = i -> elemento;
        i -> ant = NULL;
        i -> prox = NULL;

        free(i);

    }

    return resp;
}

void mostrar(){
    for(Celula* i = primeiro -> prox; i != NULL; i = i -> prox){
        imprimir(i -> elemento);
    }
}

void swap(int i, int j){
    Municipio aux;

    Celula* cel_i = primeiro -> prox;
    Celula* cel_j = ultimo;

    for(int k = 0; k < i; k++){
        cel_i = cel_i -> prox;
    }
    for(int k = tamanho() - 1; k > j; k--){
        cel_j = cel_j -> ant;
    }

    aux = clone(cel_i -> elemento);
    cel_i -> elemento = clone(cel_j -> elemento);
    cel_j -> elemento = clone(aux);
}

void quicksortRec(int esq, int dir){
    int i = esq, j = dir;
    int pos_pivo = (i + j) / 2;

    Celula* cel_aux = primeiro -> prox;
    for(int k = 0; k < pos_pivo; k++){
        cel_aux = cel_aux -> prox;
    }

    int pivo = cel_aux -> elemento.populacao;

    Celula* cel_i = primeiro -> prox;
    for(int k = 0; k < i; k++){
        cel_i = cel_i -> prox;
    }
    Celula* cel_j = ultimo;
    for(int k = tamanho() - 1; k > j; k--){
        cel_j = cel_j -> ant;
    }

    while(i <= j){
        while(cel_i -> elemento.populacao < pivo){
            cel_i = cel_i -> prox;
            i++;
        }
        while(cel_j -> elemento.populacao > pivo){
            cel_j = cel_j -> ant;
            j--;
        }

        if(i <= j){
            swap(i, j);
            i++;
            cel_i = cel_i -> prox;
            j--;
            cel_j = cel_j -> ant;
        }
    }

    if(esq < j){
        quicksortRec(esq, j);
    }
    if(i < dir){
        quicksortRec(i, dir);
    }
}

void quicksort(){
    quicksortRec(0, tamanho() - 1);
}

int main(){
    start();

    Municipio* vet;
    vet = ler();

    char linha[100] = "";
    char aux[2][10];

    int num_linha;
    int pos;

    scanf("%s", linha);

    while(strcmp(linha, "0") != 0){
        inserirFim(vet[atoi(linha) - 1]);
        scanf("%s", linha);
    }

    quicksort();
    mostrar();
}
