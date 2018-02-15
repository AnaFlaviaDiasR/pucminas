import java.util.*;
import java.io.*;
import java.net.*; //;
import java.io.IOException; //;
/**
 *TP04Q04-> Fila Circular
 *@author: Ana Flavia Diass
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
         serie.setPaisDeOrigem(temp);
       }

       if(linha.contains(">Idioma original<")){//if que acha o idioma da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         idiomaOriginal= idiomaOriginal.trim();
         serie.setIdiomaOriginal(temp);
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

}//fim class Series

//----------------------------------------------------------------------
class Fila {
   private Series[] array;
   private int primeiro; // Remove do indice "primeiro".
   private int ultimo; // Insere no indice "ultimo".


   /**
    * Construtor da classe.
    */
   public Fila () {
      this(6);
   }


   /**
    * Construtor da classe.
    * @param tamanho Tamanho da fila.
    */
   public Fila (int tamanho){
      array = new Series[tamanho+1];
      primeiro = ultimo = 0;
   }


   /**
    * Insere um elemento na ultima posicao da fila.
    * @param x int elemento a ser inserido.
    * @throws Exception Se a fila estiver cheia.
    */
   public void inserir(Series x) throws Exception {
      //validar insercao
      if (((ultimo + 1) % array.length) == primeiro) {
         Series s= remover();
      }

      array[ultimo] = x;
      ultimo = (ultimo + 1) % array.length;
   }


   /**
    * Remove um elemento da primeira posicao da fila e movimenta
    * os demais elementos para o primeiro da mesma.
    * @return resp int elemento a ser removido.
    * @throws Exception Se a fila estiver vazia.
    */
   public Series remover() throws Exception {

      //validar remocao
      if (primeiro == ultimo) {
         throw new Exception("Erro ao remover!");
      }

      Series resp = array[primeiro];
      primeiro = (primeiro + 1) % array.length;
      return resp;
   }

   /**
    * Faz a media do numero de temporadas das series presentes no array
    */
   public void media(){
     double media;
     int qt= 0;
     int soma=0;
     for(int i=primeiro; i != ultimo; i=((i+1)%array.length)){
       qt+= array[i].getNumeroDeTemporadas();
       soma++;
     }
     media= (double)qt / (double)soma;
     MyIO.println((int)Math.round(media));
   }

}
//-----------------------------------------------------------------------------------------------------

class TP04Q04FilaCircular{

	public static void main (String[]args) throws Exception{
    MyIO.setCharset("UTF-8");
    //String [] string= new String[1000];
		int qt= 0;
    int pos= 0;
    String codigo= "";
    String html= MyIO.readLine();
    Fila fila= new Fila(5);//referente a classe fila
    Series series= new Series();//referente a classe Series
		//leitura de string padrao

    while(!html.equals("FIM")){
      series.lerHTML(series, html);
      fila.inserir(series);
      fila.media();
      qt++;
      html= MyIO.readLine();
      series= new Series();
    }
    int total= MyIO.readInt();
    Series removida;


    while(total > 0){
      codigo= MyIO.readString();

      //inserir da Fila
      if(codigo.equals("I")){
        html= MyIO.readString();
        series= new Series();
        series = series.lerHTML(series, html);
        fila.inserir(series);
        fila.media();
      }

      //remover da Fila
      else if(codigo.equals("R")){
        removida= fila.remover();

      }

      total--;
    }//fim while

	}//fim main


}//fim TP04Q04FilaCircular
