/**
 * Classe Serie
 * @author Stefany Gaspar
 * 07/09/2017
 */
class Serie{

  private String nome;
  private String formato;
  private String duracao;
  private String paisDeOrigem;
  private String idiomaOriginal;
  private String emissoraDeTvOriginal;
  private String transmissaoOriginal;
  private int numeroDeTemporadas;
  private int numeroDeEpisodios;

  /**
   *  Construtor Vazio
   */

  public Serie(){
    this.nome = "";
    this.formato = "";
    this.duracao = "";
    this.paisDeOrigem = "";
    this.idiomaOriginal = "";
    this.emissoraDeTvOriginal = "";
    this.transmissaoOriginal = "";
    this.numeroDeTemporadas = 0;
    this.numeroDeEpisodios = 0;
  }// fim Serie

  /**
   *  Construtor que recebe parametros
   * @param nome String
   * @param formato String
   * @param duracao String
   * @param paisDeOrigem String
   * @param idiomaOriginal String
   * @param emissoraDeTvOriginal String
   * @param transmissaoOriginal String
   * @param numeroDeTemporadas String
   * @param numeroDeEpisodios String
   */

  public Serie(String nome, String formato, String duracao, String paisDeOrigem,
  String idiomaOriginal, String emissoraDeTvOriginal, String transmissaoOriginal,
  int numeroDeTemporadas, int numeroDeEpisodios){
    this.nome = nome;
    this.formato = formato;
    this.duracao = duracao;
    this.paisDeOrigem = paisDeOrigem;
    this.idiomaOriginal = idiomaOriginal;
    this.emissoraDeTvOriginal = emissoraDeTvOriginal;
    this.transmissaoOriginal = transmissaoOriginal;
    this.numeroDeTemporadas = numeroDeTemporadas;
    this.numeroDeEpisodios = numeroDeEpisodios;
  }// fim Serie

  /**
   * metodo que pega o nome
   * @return nome
   */

  public String getNome(){
    return this.nome;
  }//fim getNome

  /**
   * metodo que seta o nome
   * @param nome String
   */

  public void setNome(String nome){
    this.nome = nome;
  }//fim setNome

  /**
   * metodo que pega o formato
   * @return formato
   */

  public String getFormato(){
    return this.formato;
  }//fim getFormato

  /**
   * metodo que seta o formato
   * @param formato String
   */

  public void setFormato(String formato){
    this.formato = formato;
  }//fim setFormato

  /**
   * metodo que pega o duracao
   * @return duracao
   */

  public String getDuracao(){
    return this.duracao;
  }//fim getDuracao

  /**
   * metodo que seta o duracao
   * @param duracao String
   */

  public void setDuracao(String duracao){
    this.duracao = duracao;
  }//fim setDuracao

  /**
   * metodo que pega o paisDeOrigem
   * @return paisDeOrigem
   */

  public String getPaisDeOrigem(){
    return this.paisDeOrigem;
  }//fim getPaisDeOrigem

  /**
   * metodo que seta o paisDeOrigem
   * @param paisDeOrigem String
   */

  public void setPaisDeOrigem(String paisDeOrigem){
    this.paisDeOrigem = paisDeOrigem;
  }//fim setPaisDeOrigem

  /**
   * metodo que pega o idiomaOriginal
   * @return idiomaOriginal
   */

  public String getIdiomaOriginal(){
    return this.idiomaOriginal;
  }//fim getIdiomaOriginal

  /**
   * metodo que seta o idiomaOriginal
   * @param idiomaOriginal String
   */

  public void setIdiomaOriginal(String idiomaOriginal){
    this.idiomaOriginal = idiomaOriginal;
  }//fim setIdiomaOriginal

  /**
   * metodo que pega o emissoraDeTvOriginal
   * @return emissoraDeTvOriginal
   */

  public String getEmissoraDeTvOriginal(){
    return this.emissoraDeTvOriginal;
  }//fim getEmissoraDeTvOriginal

  /**
   * metodo que seta o emissoraDeTvOriginal
   * @param emissoraDeTvOriginal String
   */

  public void setEmissoraDeTvOriginal(String emissoraDeTvOriginal){
    this.emissoraDeTvOriginal = emissoraDeTvOriginal;
  }//fim setEmissoraDeTvOriginal

   /**
    * metodo que pega o transmissaoOriginal
    * @return transmissaoOriginal
    */

  public String getTransmissaoOriginal(){
    return this.transmissaoOriginal;
  }//fim getTransmissaoOriginal

  /**
   * metodo que seta o transmissaoOriginal
   * @param transmissaoOriginal String
   */

  public void setTransmissaoOriginal(String transmissaoOriginal){
    this.transmissaoOriginal = transmissaoOriginal;
  }//fim setTransmissaoOriginal

   /**
    * metodo que pega o numeroDeTemporadas
    * @return numeroDeTemporadas
    */

  public int getNumeroDeTemporadas(){
    return this.numeroDeTemporadas;
  }//fim getNumeroDeTemporadas

  /**
   * metodo que seta o numeroDeTemporadas
   * @param numeroDeTemporadas String
   */

  public void setNumeroDeTemporadas(int numeroDeTemporadas){
    this.numeroDeTemporadas = numeroDeTemporadas;
  }//fim setNumeroDeTemporadas

  /**
   * metodo que pega o numeroDeEpisodios
   * @return numeroDeEpisodios
   */

  public int getNumeroDeEpisodios(){
    return this.numeroDeEpisodios;
  }//fim getNumeroDeEpisodios

  /**
   * metodo que seta o numeroDeEpisodios
   * @param numeroDeEpisodios String
   */

  public void setNumeroDeEpisodios(int numeroDeEpisodios){
    this.numeroDeEpisodios = numeroDeEpisodios;
  }//fim setNumeroDeEpisodios

  /**
   * Metodo imprimir
   */

  public void imprimir(){
    MyIO.print(getNome() +" "+ getFormato() +" "+ getDuracao() +" "+
    getPaisDeOrigem() +" "+ getIdiomaOriginal() +" "+ getEmissoraDeTvOriginal() +" "+
    getTransmissaoOriginal() +" "+ getNumeroDeTemporadas() +" "+ getNumeroDeEpisodios()+"\n");
  } // fim imprimir

  /**
   * Metodo clone
   */

  public Serie clone(){
    return new Serie(getNome(), getFormato(), getDuracao(),
    getPaisDeOrigem(), getIdiomaOriginal(), getEmissoraDeTvOriginal(),
    getTransmissaoOriginal(), getNumeroDeTemporadas(), getNumeroDeEpisodios());
  }// fim clone

  /**
   * Metodo que le o nome da Serie e manda para o trataHTML
   * @param series Serie[]
   * @return i quantidade de Series
   */

  public static Serie ler(String endereco){
      Serie serie = new Serie();
      return trataHTML(serie, endereco);
  }//fim ler

  /**
   * Metodo que abre o arquivo HTML e trata o texto
   * @param serie Serie
   * @param endereco String
   */

  public static Serie trataHTML(Serie serie, String endereco) {
    String linha;
	  int valor;
    Arq.openRead("/tmp/" + endereco);

    for(linha = Arq.readLine(); (linha.contains("<h1") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = removeTagsNome(linha);
    serie.setNome(linha.trim());

    for(linha = Arq.readLine(); (linha.contains(">Formato<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();// PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setFormato(linha);

    for(linha = Arq.readLine(); (linha.contains(">Duração<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setDuracao(linha);

    for(linha = Arq.readLine(); (linha.contains(">País de origem<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setPaisDeOrigem(linha);

    for(linha = Arq.readLine(); (linha.contains(">Idioma original<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setIdiomaOriginal(linha);

    for(linha = Arq.readLine(); (linha.contains(">Emissora de televisão original<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setEmissoraDeTvOriginal(linha);

    for(linha = Arq.readLine(); (linha.contains(">Transmissão original<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    linha = removeTags(linha);
    serie.setTransmissaoOriginal(linha);

    for(linha = Arq.readLine(); (linha.contains(">N.º de temporadas<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    valor = removeTagsNumT(linha);
    serie.setNumeroDeTemporadas(valor);

    for(linha = Arq.readLine(); (linha.contains(">N.º de episódios<") == false && Arq.hasNext()); linha = Arq.readLine());
    linha = Arq.readLine();//PEGA A PROXIMA LINHA
    valor = removeTagsNumE(linha);
    serie.setNumeroDeEpisodios(valor);

    Arq.close();
    return serie;
  }//fim trataHTML


  /**
   * Metodo que remove as Tags da linha onde esta o nome
   * @param linha String
   * @return newLinha
   */

  public static String removeTagsNome(String linha){
    String newLinha = "";
    int comeco = linha.indexOf("<i>");
    for(int i = comeco + 3; linha.charAt(i) != '<'; i++){
      newLinha += linha.charAt(i);
    }// fim for
    return newLinha;
  }//removeTagsNome

  /**
   * Metodo que remove as Tags da linha onde esta o numeroDeTemporadas
   * @param linha String
   * @return frase
   */

  public static int removeTagsNumT(String linha){
    String newLinha = "";
    String frase = "";
    int i = 0;
    linha = removeTags(linha);
    int comeco = linha.indexOf(">") + 1;
    while((comeco < linha.length())&&(linha.charAt(comeco) != '-')){
      newLinha += linha.charAt(comeco);
      comeco++;
    }//fim while
    while(i < newLinha.length() && newLinha.charAt(i) != ' '){
      frase += newLinha.charAt(i);
      i++;
    }//fim while
    return Integer.parseInt(frase);
  }//removeTagsNumT

  /**
   * Metodo que remove as Tags da linha onde esta o numeroDeEpisodios
   * @param linha String
   * @return frase
   */

  public static int removeTagsNumE(String linha){
    String newLinha = "";
    String frase = "";
    int i = 0;
    linha = removeTags(linha);
    int comeco = linha.indexOf(">") + 1;
    while((comeco < linha.length())&&(linha.charAt(comeco) != '+')){
      newLinha += linha.charAt(comeco);
      comeco++;
    }//fim while
    while(i < newLinha.length() && newLinha.charAt(i) != ' '){
      frase += newLinha.charAt(i);
      i++;
    }//fim while
    return Integer.parseInt(frase);
  }//removeTagsNumE

  /**
   * Metodo que remove todas as Tags
   * @param linha String
   * @return frase
   */

  public static String removeTags(String linha){
    String frase = "";
    String subFrase = "";
    linha = linha.replaceAll("&#160;","");
    linha = linha.replaceAll("&nbsp;","");
    String[] sub;
    sub = linha.split("<");
    for(int i = 0; i < sub.length; i++){
      subFrase = sub[i];
      for(int j = subFrase.indexOf(">") + 1; j < subFrase.length(); j++){
        frase += subFrase.charAt(j);
      }//fim primeiro for
    }//fim segundo for
    return frase.trim();
  }//removeTags

}//fim class

 /**
  * Lista estatica
  * @author Max do Val Machado Adaptado por Stefany Gaspar
  * @version 3 09/2017
  */

class Lista{
  private Serie[] array;
  private int n; //quantidade de elementos
  public int comparacoes = 0;
  public int movimentacoes = 0;

  /**
   * Construtor vazio
   */

  public Lista(){
    this(6);
  }//fim Lista

  public Lista(int tamanho){
    array = new Serie[tamanho];
    n = 0;
  }//fim Lista

  /**
   * Insere um elemento na primeira posicao da lista e move os demais
   * elementos para o fim da lista.
   * @param serie Serie elemento a ser inserido.
   * @throws Exception Se a lista estiver cheia.
   */

   public void inserirInicio(Serie x) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      //levar elementos para o fim do array
      for(int i = n; i > 0; i--){
         array[i] = array[i-1];
      }

      array[0] = x;
      n++;
   }

  /**
   * Insere um elemento na ultima posicao da lista.
   * @param serie Serie elemento a ser inserido.
   * @throws Exception Se a lista estiver cheia.
   */

   public void inserirFim(Serie x) throws Exception {

      //validar insercao
      if(n >= array.length){
         throw new Exception("Erro ao inserir!");
      }

      array[n] = x;
      n++;
   }

  /**
   * Insere um elemento em uma posicao especifica e move os demais
   * elementos para o fim da lista.
   * @param serie Serie elemento a ser inserido.
   * @param pos Posicao de insercao.
   * @throws Exception Se a lista estiver cheia ou a posicao invalida.
   */

   public void inserir(Serie x, int pos) throws Exception {

      //validar insercao
      if(n >= array.length || pos < 0 || pos > n){
         throw new Exception("Erro ao inserir!");
      }

      //levar elementos para o fim do array
      for(int i = n; i > pos; i--){
         array[i] = array[i-1];
      }

      array[pos] = x;
      n++;
   }

  /**
   * Remove um elemento da primeira posicao da lista e movimenta
   * os demais elementos para o inicio da mesma.
   * @return resp Serie elemento a ser removido.
   * @throws Exception Se a lista estiver vazia.
   */

   public Serie removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Serie resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


  /**
   * Remove um elemento da ultima posicao da lista.
   * @return resp Serie elemento a ser removido.
   * @throws Exception Se a lista estiver vazia.
   */

   public Serie removerFim() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      return array[--n];
   }


  /**
   * Remove um elemento de uma posicao especifica da lista e
   * movimenta os demais elementos para o inicio da mesma.
   * @param pos Posicao de remocao.
   * @return resp Serie elemento a ser removido.
   * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
   */

   public Serie remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Serie resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

  /**
   * Mostra todos od elementos da lista.
   */

  public void mostrar(){
    for(int pos = 0; pos < n; pos++){
      array[pos].imprimir();
    }//fim for
  }// fim mostrar

  /**
   * Ordenacao heapsort
   */

  public void constroi(int tam){
     for(int i = tam; (i > 1) && (myCompare(array[i], array[i/2]) == 1); i /= 2){
        swap(i, i/2);
     }
  }

  public void reconstroi(int tamHeap){
      int i = 1, filho;
      while(i <= (tamHeap/2)){

         if ((myCompare(array[2*i] , array[2*i+1]) == 1) || ( 2*i == tamHeap)){
            filho = 2*i;
         } else {
            filho = 2*i + 1;
         }

         if(myCompare(array[i] , array[filho]) == -1){
            swap(i, filho);
            i = filho;
         }else{
            i = tamHeap;
         }
      }
   }

  /**
  * Algoritmo de ordenacao Heapsort.
  */

public void heapsort() {
  //Alterar o vetor ignorando a posicao zero
  Serie[] aux = new Serie[n+1];
  for(int i = 0; i < n; i++){
     aux[i+1] = array[i];
  }
  array = aux;

  //Contrucao do heap
  for(int tamHeap = 2; tamHeap <= n; tamHeap++){
     constroi(tamHeap);
  }

  //Ordenacao propriamente dita
  int tamHeap = n;
  while(tamHeap > 1){
     swap(1, tamHeap--);
     reconstroi(tamHeap);
  }

  //Alterar o vetor para voltar a posicao zero
  aux = array;
  array = new Serie[n];
  for(int i = 0; i < n; i++){
     array[i] = aux[i+1];
  }
}// fim heapsort
  /**
  * @param i
  * @param j
  */
   public void swap(int i, int j){
     movimentacoes += 3;
     Serie temp = array[i];
     array[i] = array[j];
     array[j] = temp;
   }

     public boolean maiorQueInt(int a, int b){
       comparacoes++;
       return(a > b);
     }
     public boolean menorQueInt(int a, int b){
       comparacoes++;
       return(a < b);
     }
     public boolean igualInt(int a, int b){
       comparacoes++;
       return(a == b);
     }
     public int igual(String a, String b){
       comparacoes++;
       return(a.compareTo(b));
     }

     /*
      * return -1 se menor, return 0 se igual, return 1 se maior
      */
     public int myCompare(Serie a, Serie b){
       int resp = 0;
       String formatoA = a.getFormato();
       String formatoB = b.getFormato();
       if(formatoA.compareTo(formatoB) > 0){
         comparacoes++;
         resp = 1;
       } else if(formatoA.compareTo(formatoB) < 0){
         comparacoes++;
         resp = -1;
       } else if (formatoA.compareTo(formatoB) == 0){
         comparacoes++;
         String nomeA = a.getNome();
         String nomeB = b.getNome();
         if(nomeA.compareTo(nomeB) > 0){
           comparacoes++;
           resp = 1;
         } else if(nomeA.compareTo(nomeB) < 0){
           comparacoes++;
           resp = -1;
         }
       }
       return resp;
     }


}//fim class Lista

/**
 * public class TP05Q07
 * @author Stefany Gaspar
 * 25/10/2017
 */

public class TP05Q07{

  public static final int matricula = 582931;

  public static void main(String[] args) throws Exception{
    MyIO.setCharset("UTF-8");
    Lista lista = new Lista(200);
    Serie serie;

    String endereco = MyIO.readLine();
    while(!endereco.equals("FIM")){
      lista.inserirFim(Serie.ler(endereco));
      endereco = MyIO.readLine();
    }//fim while

    long comeco = System.currentTimeMillis();
    lista.heapsort();
    long fim = System.currentTimeMillis();
    lista.mostrar();
    criaArq(comeco, fim, lista);
  }//fim main

  /**
   *
   * @param comeco
   * @param fim
   * @param lista
   */

  public static void criaArq(long comeco, long fim, Lista lista){
    Arq.openWrite("matricula_heapsort.txt");
    Arq.print(matricula + "\t");
    Arq.print((fim-comeco)/1000.0 + " s." + "\t");
    Arq.print(lista.comparacoes + "\t");
    Arq.print(lista.movimentacoes);
    Arq.close();
  }//fim criaArq

}// fim TP05Q07
