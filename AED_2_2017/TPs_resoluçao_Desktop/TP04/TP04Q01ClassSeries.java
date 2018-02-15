import java.util.*;
import java.io.*;
import java.net.*;;
import java.io.IOException;;
/**
 *TP04Q01-> Classe Series
 *@author: Ana Flavia Dias
 *10/09/2017
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
   public void lerHTML(String html){
     Arq.openRead(html);//abre o arquivo da url
     int i;//ponteiro 1
     int j;//ponteiro 2
     String temp;
     for(String linha = Arq.readLine(); Arq.hasNext(); linha = Arq.readLine()){//for que percorre toda o html

       if(linha.contains("class=\"firstHeading\"")){//if que pega o nome da serie
         i = linha.indexOf("<i>");
         j = linha.indexOf("</i>");
         setNome(linha.substring(i+3, j));
         nome = nome.trim();
       }
       if(linha.contains("\">Formato<")){//if que acha o formato da serie
         linha = Arq.readLine();
         if(linha.contains("title=")){
           i = linha.indexOf("title=");
           j = linha.indexOf("</a>");
           setFormato(linha.substring(i, j));
           i = formato.indexOf(">");
           setFormato(formato.substring(i+1, formato.length()));
           formato = formato.trim();
           setFormato(formato);
         }
         else if(linha.contains("<a>")){
           i = linha.indexOf("<a>");
           j = linha.indexOf("</a>");
           setFormato(linha.substring(i+3, j));
           formato = formato.trim();
           setFormato(formato);
         }
       }

       if(linha.contains("\">Duração</td>")){//if que acha a duracao da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         duracao = duracao.trim();
         setDuracao(temp);
       }

       if(linha.contains(">País de origem<")){//if que acha a origem da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         paisDeOrigem = paisDeOrigem.trim();
         setPaisDeOrigem(temp);
       }

       if(linha.contains(">Idioma original<")){//if que acha o idioma da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         idiomaOriginal= idiomaOriginal.trim();
         setIdiomaOriginal(temp);
       }

       if(linha.contains(">Emissora de televisão original<")){//if que acha a emissora da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         emissoraDeTvOriginal= emissoraDeTvOriginal.trim();
         setEmissoraDeTvOriginal(temp);
       }

       if(linha.contains(">Transmissão original<")){//if que acha a transmissao da serie
         linha = Arq.readLine();
         temp = linha.replaceAll("\\<[^>]*>","");
         temp = temp.replaceAll("&#160;","");
         temp = temp.replaceAll("&nbsp;","");
         transmissaoOriginal = transmissaoOriginal.trim();
         setTransmissaoOriginal(temp);
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
         setNumeroDeTemporadas(i);
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
         setNumeroDeEpisodios(i);
       }
     }//fim for
     Arq.close();//fecha o arquivo da url
   }//fim lerHTML

}//fim class Series

//-----------------------------------------------------------------------------------------------------

public class TP04Q01ClassSeries{
	public static void main (String[]args){
		String [] string= new String[1000];
		int qt= 0;
		Series series= new Series();//referente a classe Series
		MyIO.setCharset("UTF-8");
		//leitura de string padrao
		do{
			string[qt]= MyIO.readLine();
		}while(flag(string[qt++],"FIM") == false);
		qt--;//desconsidera a palavra FIM

		for(int i= 0; i<qt; i++){
			String html= "/tmp/"+string[i];
			series.lerHTML(html);
			series.imprimeHTML();
		}
	}

	/**
	 *Metodo que verifica se a string passada por parametro eh igual a condicao de parada
   *@param string String
   *@param fim String
   *@return flag boolean
	*/
	public static boolean flag(String string, String fim){
		boolean flag = true;
		if(string.length() == fim.length()){
			for(int i = 0; i < string.length(); i++){
				if(string.charAt(i) != fim.charAt(i)){
					flag = false;
					i = string.length()-1;
				}
			}//fim for
		}
		else{
			flag = false;
		}
		return flag;
	}//fim flag

}//fim TP04Q01ClassSeries
