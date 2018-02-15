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

void imprimir(Municipio i){
    printf("%d %s %s %d %d %d %d %s %s %d %s %d %s\n",
            i.id, i.nome, i.uf, i.codigoUF, i.populacao, i.numeroFuncionarios,
            i.numeroComissionados, i.escolaridade, i.estagio, i.atualizacaoPlano,
            i.regiao, i.atualizacaoCadastro, i.consorcio ? "true" : "false");
}

typedef struct Celula{
    Municipio elemento;
    struct Celula* prox;
} Celula;

Celula* novaCelula(Municipio m){
    Celula* nova = (Celula *)malloc(sizeof(Celula));
    nova -> elemento = m;
    nova -> prox = NULL;

    return nova;
}

Celula* topo;

void start(){
    topo = NULL;
}

void inserir(Municipio m){
    Celula* tmp = novaCelula(m);
    tmp -> prox = topo;
    topo = tmp;
    tmp = NULL;
}

Municipio remover(){
    if(topo == NULL){
        errx(1, "Erro ao remover!");
    }

    Municipio resp = topo -> elemento;
    Celula* tmp = topo;
    topo = topo -> prox;
    tmp -> prox = NULL;
    free(tmp);
    tmp = NULL;

    return resp;
}


void mostrarRec(Celula* i){
    if(i != NULL){
        mostrarRec(i -> prox);
        imprimir(i -> elemento);
    }
}

void mostrar(){
    mostrarRec(topo);
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
        inserir(vet[atoi(linha) - 1]);
        scanf("%s", linha);
    }

    scanf("%s", linha);

    int cont = atoi(linha);

    while(cont > 0){
        scanf("%s", linha);

        if(strcmp(linha, "I") == 0){
            scanf("%s", linha);
            inserir(vet[atoi(linha) - 1]);
        }else{
            printf("(R) %s\n", remover().nome);
        }

        cont --;
    }

    mostrar();
}
