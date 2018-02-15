/**
 * NO
 * @author Stefany Gaspar
 * @version 1/ 24/11/17
 */

class No{
   public No esq;
   public No dir;
   public Serie elemento;


   /**
    * Construtor passando apenas o elemento (raiz)
    * @param elemento
    */

    public No(Serie elemento){
      this(elemento, null, null);
    }//fim No

    /**
     * Construtor da classe
     * @param elemento
     * @param esq No da esquerda
     * @param dir No da direita
     */

     public No(Serie elemento, No esq, No dir){
       this.elemento = elemento;
       this.esq = esq;
       this.dir = dir;
     }//fim No

 }

 /**
  * Arvore binaria de pesquisa
  * @author Max do Val Machado
  */

class ArvoreBinaria{
  public No raiz;
  public int comparacoes = 0;

  public ArvoreBinaria(){
    raiz = null;
  }

  public boolean pesquisar(String x){
    MyIO.print("raiz ");
    return pesquisar(x, raiz);
  }//fim pesquisar

  private boolean pesquisar(String x, No i){
    boolean resp;
    if(i == null){
      resp = false;
    } else if(x.compareTo(i.elemento.getNome()) == 0){
      resp = true;
    } else if(x.compareTo(i.elemento.getNome()) < 0){
      MyIO.print("esq ");
      resp = pesquisar(x, i.esq); // se o x for menor que o elemento do No chamo novamente passando o No da esquerda
    } else {
      MyIO.print("dir ");
      resp = pesquisar(x, i.dir); //se for maior que o elemendo do No chamo novamente passando o No da direita
    }
  return resp;
}//fim pesquisar

/**
 * Metodo para exibir os elementos
 */

public void mostrar(){
  mostrar(raiz);
}

private void mostrar(No i){
  if(i != null){
    mostrar(i.esq);
    System.out.print(i.elemento.getNome() + " ");
    mostrar(i.dir);
  }
}

/**
 * Metodo privado recursivo para inserir elemento
 * @param x elemento a ser inserido
 * @param i No em analise
 * @return No em analise, alterado ou nao
 * @throws Exception Se o elemento existir
 */
 public void inserir(Serie x)throws Exception{
   raiz = inserir(x, raiz);
 }

 private No inserir(Serie x, No i) throws Exception{
   String nome = x.getNome();
   if(i == null){
     i = new No(x); //se estiver i = null crio um novo no
   } else if (nome.compareTo(i.elemento.getNome()) < 0){
     i.esq = inserir(x, i.esq);
   } else if (nome.compareTo(i.elemento.getNome()) > 0){
     i.dir = inserir(x, i.dir);
   } else {
     throw new Exception("Erro!!");
   }
   return i;
 }

 /**
   * Metodo publico iterativo para remover elemento.
   * @param x Elemento a ser removido.
   * @throws Exception Se nao encontrar elemento.
   */
  public void remover(String x) throws Exception {
      raiz = remover(x, raiz);
  }

  /**
   * Metodo privado recursivo para remover elemento.
   * @param x Elemento a ser removido.
   * @param i No em analise.
   * @return No em analise, alterado ou nao.
   * @throws Exception Se nao encontrar elemento.
   */
  private No remover(String nome, No i) throws Exception {
      if (i == null) { //se a raiz estiver vazia
       //throw new Exception("Erro ao remover!");
    } else if (nome.compareTo(i.elemento.getNome()) < 0) {
       i.esq = remover(nome, i.esq);

    } else if (nome.compareTo(i.elemento.getNome()) > 0) {
       i.dir = remover(nome, i.dir);

    // Sem no a direita.
    } else if (i.dir == null) {
       i = i.esq;

    // Sem no a esquerda.
    } else if (i.esq == null) {
       i = i.dir;

    // No a esquerda e no a direita.
    } else {
       i.esq = anterior(i, i.esq);
    }
      return i;

  }

/**
 * Metodo para trocar no removido pelo antecessor.
 * @param i No que teve o elemento removido.
 * @param j No da subarvore esquerda.
 * @return No em analise, alterado ou nao.
 */

 private No anterior(No i, No j) {

     // Existe no a direita.
       if (j.dir != null) {
        // Caminha para direita.
           j.dir = anterior(i, j.dir);

     // Encontrou o maximo da subarvore esquerda.
       } else {
           i.elemento = j.elemento; // Substitui i por j.
           j = j.esq; // Substitui j por j.ESQ.
       }
       return j;
   }

 private int myCompare(Serie a, Serie b){
   int resp = 0;
   String nomeA = a.getNome();
   String nomeB = b.getNome();
   if(nomeA.compareTo(nomeB) > 0){
     resp = 1;
   } else if(nomeA.compareTo(nomeB) < 0){
     resp = -1;
   }
   comparacoes++;
   return resp;
 }
}

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
     serie.setFormato(linha.trim());

     for(linha = Arq.readLine(); (linha.contains(">Duração<") == false && Arq.hasNext()); linha = Arq.readLine());
     linha = Arq.readLine();//PEGA A PROXIMA LINHA
     linha = removeTags(linha);
     serie.setDuracao(linha.trim());

     for(linha = Arq.readLine(); (linha.contains(">País de origem<") == false && Arq.hasNext()); linha = Arq.readLine());
     linha = Arq.readLine();//PEGA A PROXIMA LINHA
     linha = removeTags(linha);
     serie.setPaisDeOrigem(linha.trim());

     for(linha = Arq.readLine(); (linha.contains(">Idioma original<") == false && Arq.hasNext()); linha = Arq.readLine());
     linha = Arq.readLine();//PEGA A PROXIMA LINHA
     linha = removeTags(linha);
     serie.setIdiomaOriginal(linha.trim());

     for(linha = Arq.readLine(); (linha.contains(">Emissora de televisão original<") == false && Arq.hasNext()); linha = Arq.readLine());
     linha = Arq.readLine();//PEGA A PROXIMA LINHA
     linha = removeTags(linha);
     serie.setEmissoraDeTvOriginal(linha.trim());

     for(linha = Arq.readLine(); (linha.contains(">Transmissão original<") == false && Arq.hasNext()); linha = Arq.readLine());
     linha = Arq.readLine();//PEGA A PROXIMA LINHA
     linha = removeTags(linha);
     serie.setTransmissaoOriginal(linha.trim());

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
     return frase;
   }//removeTags

 }//fim class

public class TP07Q01{
  public static final int matricula = 582931;
  public static void main(String[] args) throws Exception {
    ArvoreBinaria arvore = new ArvoreBinaria();
    String str = "";
    String endereco = MyIO.readLine();
    long comeco = System.currentTimeMillis();
    while(!endereco.equals("FIM")){
      arvore.inserir(Serie.ler(endereco));
      endereco = MyIO.readLine();
    }

    int qtd = MyIO.readInt();
    while(qtd != 0){
      str = MyIO.readString();//leio o que devo fazer
      if(str.equals("I")){
        endereco = MyIO.readLine();//leio o nome da Serie
        arvore.inserir(Serie.ler(endereco));
      } else if(str.equals("R")){
        endereco = MyIO.readLine();//leio o nome da Serie
        //endereco = endereco.replaceAll(" ", "_");
        //endereco = endereco + ".html";
        arvore.remover(endereco);
      }// fim if/else
      qtd--;
    }
    endereco = MyIO.readLine();//leio o nome da Serie

    while(!endereco.equals("FIM")){
      if(arvore.pesquisar(endereco)){
        MyIO.println("SIM");
      } else {
        MyIO.println("NAO");
      }
      endereco = MyIO.readLine();
    }

    long fim = System.currentTimeMillis();

    criarArq(comeco, fim, arvore);
  }
  /**
   *
   * @param comeco
   * @param fim
   * @param arvore
   */

  public static void criarArq(long comeco, long fim, ArvoreBinaria arvore){
    Arq.openWrite("matricula_arvoreBinaria.txt");
    Arq.print(matricula + "\t");
    Arq.print(arvore.comparacoes + "\t");
    Arq.print((fim-comeco)/1000.0 + " s." + "\t");
    Arq.close();
  }
}
