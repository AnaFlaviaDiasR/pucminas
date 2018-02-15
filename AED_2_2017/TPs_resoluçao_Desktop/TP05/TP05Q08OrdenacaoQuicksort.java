import java.util.*;
import java.io.*;
import java.net.*;;
import java.io.IOException;;
/**
 *TP05Q08-> Ordenacao Quicksort
 *@author: Ana Flavia Dias
 */
class Series{
  //metodos privados
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
	 *Primeiro Construtor para inicializar os metodos privados
	 */
  public Series(){
    nome="";
    formato="";
    duracao="";
    paisDeOrigem="";
    idiomaOriginal="";
    emissoraDeTvOriginal="";
    transmissaoOriginal="";
    numeroDeTemporadas=0;
    numeroDeEpisodios=0;
  }//fim construtor 1


  /**
	 *Segundo Construtor para atribuir valores aos  metodos privados
   *@param atributos da classe Series
	 */
  public Series(String nome, String formato, String duracao, String paisDeOrigem, String idiomaOriginal, String emissoraDeTvOriginal,
  String transmissaoOriginal, int numeroDeTemporadas, int numeroDeEpisodios){
    this.nome= nome;
    this.formato= formato;
    this.duracao= duracao;
    this.paisDeOrigem= paisDeOrigem;
    this.idiomaOriginal= idiomaOriginal;
    this.emissoraDeTvOriginal= emissoraDeTvOriginal;
    this.transmissaoOriginal= transmissaoOriginal;
    this.numeroDeTemporadas= numeroDeTemporadas;
    this.numeroDeEpisodios= numeroDeEpisodios;
  }//fim construtor 2


  /**
	 *Metodo que protege a classe Objeto
   *@return nova instancia da classe
	 */
  public Series clone(){
    return new Series(getNome(), getFormato(), getDuracao(), getPaisDeOrigem(), getIdiomaOriginal(), getEmissoraDeTvOriginal(),
    getTransmissaoOriginal(), getNumeroDeTemporadas(), getNumeroDeEpisodios());
  }//fim clone


  /**
	 *Metodos GET e SET
   *GETTERS
   *@return os atributos
   *SETTERS
   *@param atributos
	 */

  public String getNome(){
    return nome;
  }//fim getNome
  public void setNome(String nome){
    this.nome= nome;
  }//fim setNome


  public String getFormato(){
    return formato;
  }//fim getFormato
  public void setFormato(String formato){
    this.formato= formato;
  }//fim setFormato


  public String getDuracao(){
    return duracao;
  }//fim getDuracao
  public void setDuracao(String duracao){
    this.duracao= duracao;
  }//fim setDuracao


  public String getPaisDeOrigem(){
    return paisDeOrigem;
  }//fim getPaisDeOrigem
  public void setPaisDeOrigem(String paisDeOrigem){
    this.paisDeOrigem= paisDeOrigem;
  }//fim setPaisDeOrigem


  public String getIdiomaOriginal(){
    return idiomaOriginal;
  }//fim getIdiomaOriginal
  public void setIdiomaOriginal(String idiomaOriginal){
    this.idiomaOriginal= idiomaOriginal;
  }//fim setIdiomaOriginal


  public String getEmissoraDeTvOriginal(){
    return emissoraDeTvOriginal;
  }//fim getEmissoraDeTvOriginal
  public void setEmissoraDeTvOriginal(String emissoraDeTvOriginal){
    this.emissoraDeTvOriginal= emissoraDeTvOriginal;
  }//fim setEmissoraDeTvOriginal


  public String getTransmissaoOriginal(){
    return transmissaoOriginal;
  }//fim getTransmissaoOriginal
  public void setTransmissaoOriginal(String transmissaoOriginal){
    this.transmissaoOriginal= transmissaoOriginal;
  }//fim setTransmissaoOriginal


  public int getNumeroDeTemporadas(){
    return numeroDeTemporadas;
  }//fim getNumeroDeTemporadas
  public void setNumeroDeTemporadas(int numeroDeTemporadas){
    this.numeroDeTemporadas= numeroDeTemporadas;
  }//fim setNumeroDeTemporadas


  public int getNumeroDeEpisodios(){
    return numeroDeEpisodios;
  }//fim getNumeroDeEpisodios
  public void setNumeroDeEpisodios(int numeroDeEpisodios){
    this.numeroDeEpisodios= numeroDeEpisodios;
  }//fim setNumeroDeEpisodios


  /**
	 *Metodo que imprime o que foi lido na url
	 */
  public void imprimeHTML(){
    MyIO.println(getNome()+" "+getFormato()+" "+getDuracao()+" "+getPaisDeOrigem()+" "+getIdiomaOriginal()+" "+getEmissoraDeTvOriginal()+" "+getTransmissaoOriginal()+" "+getNumeroDeTemporadas()+" "+getNumeroDeEpisodios());
  }


  /**
	 *Metodo que abre e le o HTML
	 *@param html String
	 */
   public Series lerHTML(Series serie, String html){
     Arq.openRead("/tmp/" + html);//abre o arquivo da url
     int i;//ponteiro 1
     int j;//ponteiro 2
     String temp = Arq.readString();

     for(String linha = Arq.readLine(); Arq.hasNext(); linha = Arq.readLine()){//for que percorre toda o html

       if(linha.contains("class=\"firstHeading\"")){//if que pega o nome da serie
         i = linha.indexOf("<i>");
         j = linha.indexOf("</i>");
         serie.setNome(linha.substring(i+3, j));
         nome = nome.trim();
       }
       if(linha.contains("\">Formato<")){//if que acha o formato da serie
         linha = Arq.readLine();
         if(linha.contains("title=")){
           i = linha.indexOf("title=");
           j = linha.indexOf("</a>");
           serie.setFormato(linha.substring(i, j));
           i = formato.indexOf(">");
           serie.setFormato(formato.substring(i+1, formato.length()));
           formato = formato.trim();
           serie.setFormato(formato);
         }
         else if(linha.contains("<a>")){
           i = linha.indexOf("<a>");
           j = linha.indexOf("</a>");
           serie.setFormato(linha.substring(i+3, j));
           formato = formato.trim();
           serie.setFormato(formato);
         }
       }

       if(linha.contains("\">Duração</td>")){//if que acha a duracao da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         duracao = duracao.trim();
         serie.setDuracao(temp);
       }

       if(linha.contains(">País de origem<")){//if que acha a origem da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         paisDeOrigem = paisDeOrigem.trim();
         serie.setPaisDeOrigem(temp.trim());
       }

       if(linha.contains(">Idioma original<")){//if que acha o idioma da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         idiomaOriginal= idiomaOriginal.trim();
         serie.setIdiomaOriginal(temp.trim());
       }

       if(linha.contains(">Emissora de televisão original<")){//if que acha a emissora da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         emissoraDeTvOriginal= emissoraDeTvOriginal.trim();
         serie.setEmissoraDeTvOriginal(temp);
       }

       if(linha.contains(">Transmissão original<")){//if que acha a transmissao da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         transmissaoOriginal = transmissaoOriginal.trim();
         serie.setTransmissaoOriginal(temp);
       }

       if(linha.contains("\">N.º de temporadas<")){//if que acha o numero de temporadas da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         linha = temp;
         if(linha.contains(" ")){
           i = linha.indexOf(" ");
           linha = linha.substring(0, i);
         }
         i = Integer.parseInt(linha);
         serie.setNumeroDeTemporadas(i);
       }

       if(linha.contains("\">N.º de episódios<")){//if que acha o numero de episodios da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         linha = temp;
         if(linha.contains(" ")){
           i = linha.indexOf(" ");
           linha = linha.substring(0, i);
         }
         i = Integer.parseInt(linha);
         serie.setNumeroDeEpisodios(i);
       }
     }//fim for
     Arq.close();//fecha o arquivo da url
     return serie;
   }//fim lerHTML

   public boolean compara(Series serie){
     boolean resp= false;
     if(serie.getNome().equals(getNome())){
       resp= true;
     }
     return resp;
   }

}//fim class Series

//------------------------------------
class Lista {
   private Series[] array;
   private int n;
   
   /**
    * Construtor da classe.
    */
   public Lista () {
      this(6);
   }

   /**
    * Construtor da classe.
    * @param tamanho Tamanho da lista.
    */
   public Lista (int tamanho){
      array = new Series[tamanho];
      n = 0;
   }


   /**
    * Insere um elemento na primeira posicao da lista e move os demais
    * elementos para o fim da lista.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirInicio(Series x) throws Exception {

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
    * @param x int elemento a ser inserido.
    * @throws Exception Se a lista estiver cheia.
    */
   public void inserirFim(Series x) throws Exception {

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
    * @param x int elemento a ser inserido.
    * @param pos Posicao de insercao.
    * @throws Exception Se a lista estiver cheia ou a posicao invalida.
    */
   public void inserir(Series x, int pos) throws Exception {

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
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Series removerInicio() throws Exception {

      //validar remocao
      if (n == 0) {
         throw new Exception("Erro ao remover!");
      }

      Series resp = array[0];
      n--;

      for(int i = 0; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }


   /**
    * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia.
    */
   public Series removerFim() throws Exception {

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
    * @return resp int elemento a ser removido.
    * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
    */
   public Series remover(int pos) throws Exception {

      //validar remocao
      if (n == 0 || pos < 0 || pos >= n) {
         throw new Exception("Erro ao remover!");
      }

      Series resp = array[pos];
      n--;

      for(int i = pos; i < n; i++){
         array[i] = array[i+1];
      }

      return resp;
   }

   /**
    * Mostra os elementos da lista separados por espacos.
    */

   public void mostrar (){
      for(int i = 0; i < n; i++){
         array[i].imprimeHTML();
      }
   }

   /**
    * Algoritmo de ordenacao Quicksort
    */
    public void quicksort()throws Exception{
      quicksort(0,n-1);
    }

    /**
     * Metodo recursivo para ordenar o arrnajo com o algoritmo Quicksort
     * @param esq int
     * @param dir int
    */
    private void quicksort(int esq, int dir) {
      int i= esq;
      int j= dir;
      Series pivo = array[(dir+esq)/2];

      while (i <= j){

         while (compara(array[i], pivo) == -1){
           i++;
         }

         while (compara(array[j], pivo) == 1){
           j--;
         }

         if (i <= j) {
           swap(i, j);
           i++;
           j--;
         }
      }

      if (esq < j)
        quicksort(esq, j);

      if (i < dir)
        quicksort(i, dir);

    }//fim quicksort

    /**
     * Metodo que compara os paises de origem e se necessario o nome das series passadas por parametro
     * @param x Series
     * @param y Series
     * @return resp int
     * se resp= -1 se menor, resp= 0 se igual, resp= 1 se maior
     */
    public int compara(Series x, Series y){
      int resp= 0;
      String paisX= x.getPaisDeOrigem();
      String paisY= y.getPaisDeOrigem();

      if(paisX.compareTo(paisY) > 0){
        resp= 1;
      }

      else if(paisX.compareTo(paisY) < 0){
        resp= -1;
      }

      else if (paisX.compareTo(paisY) == 0){
        String nomeX = x.getNome();
        String nomeY = y.getNome();

        if(nomeX.compareTo(nomeY) > 0){
          resp= 1;
        }
        else if(nomeX.compareTo(nomeY) < 0){
          resp= -1;
        }
      }

      return resp;
    }//fim compara

    /**
    * Inverte os parametros de posicao
    * @param i
    * @param j
    */
     public void swap(int i, int j){
       Series temp = array[i];
       array[i] = array[j];
       array[j] = temp;
     }
}
//-----------------------------------------------------------------------------------------------------

class TP05Q08OrdenacaoQuicksort{

	public static void main (String[]args) throws Exception{
    MyIO.setCharset("UTF-8");
    //String [] string= new String[1000];
		//int qt= 0;
    //int pos= 0;
    //String codigo= "";
    String html= MyIO.readLine();
    Lista lista= new Lista(2000);//referente a classe Lista
    Series series= new Series();//referente a classe Series
		//leitura de string padrao

    while(!html.equals("FIM")){
      series.lerHTML(series, html);
      lista.inserirFim(series);
      html= MyIO.readLine();
      series= new Series();
    }

    lista.quicksort();
    lista.mostrar();

  }//fim main

}//fim TP05Q08OrdenacaoQuicksort
