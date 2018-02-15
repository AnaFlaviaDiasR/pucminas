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
    * @return no quantidade de Series
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
class Hash{
   public int m1; // AREA NORMAL
   public int m2; // AREA RESERVA
   public int m; // AREA TOTAL
   public Serie tabela[];
   public int reserva;
   final Serie NULO = new Serie();
   public int comparacoes = 0;

   public Hash(){
     this(21,9);
   }

   public Hash(int m1, int m2){
     this.m1 = m1;
     this.m2 = m2;
     this.m = m1 + m2;
     this.tabela = new Serie[this.m];
     for(int i = 0; i < m; i++){
        tabela[i] = NULO;
     }
     reserva  = 0;
   }

   public int h(String nome){
     int soma = 0;
     for(int i = 0; i < nome.length(); i++){
       soma += nome.charAt(i);
     }
     return soma % m1;
   }

   public boolean pesquisar(String s){
     int pos = h(s);
     boolean resp = false;
     if(tabela[pos].getNome().compareTo(s) == 0){
       comparacoes++;
       resp = true;
     } else {
       for(int i = m1; i < m; i++){
         if(tabela[i].getNome().compareTo(s) == 0){
           comparacoes++;
           resp = true;
           pos = i;
           i = m;
         } else {
           resp = false;
         }
       }//fim for
     }//fim else
     if(resp){
       MyIO.println(pos + " SIM");
     } else {
       MyIO.println("NAO");
     }
     return resp;
   }

   public boolean inserir(Serie serie){
     int pos = h(serie.getNome());
     boolean resp = false;

     if(tabela[pos] == NULO){
       comparacoes++;
       tabela[pos] = serie;
       resp = true;
     } else if(reserva < m2){
       tabela[m1+reserva] = serie;
       resp = true;
       reserva++;
     } else{
     }
     return resp;
   }

   public Serie remover (String elemento)throws Exception{
     int pos = h(elemento);
     int aux = 0;
     Serie resp = new Serie();
     if(tabela[pos].getNome().compareTo(elemento) != 0){ // se a pos da tabela nn conter o elemento
       for(int i = m1; i < m; i++){// procuro na area reserva
         if(elemento.compareTo(tabela[i].getNome()) == 0){ // pego o elemento do arranjo reserva
           resp = tabela[i];
           tabela[i] = tabela[m-1];
           tabela[m-1] = NULO;
         }
       }//fim for
     } else {
       resp = tabela[pos]; // pego o elemento do arranjo normal
       if(reserva != 0){
         int i = m1;
         while(pos != h(tabela[i].getNome()) && i < m){
            i++;
         }
         if(pos == h(tabela[i].getNome())){
           tabela[pos] = tabela[i];
           tabela[i] = tabela[m-1];
           tabela[m-1] = NULO;
         }
       }
     }
    return resp;
   }

 }
public class TP07Q05{
  public static final int matricula = 582931;
  public static void main(String[] args) throws Exception {
    Hash hash = new Hash();
    String str = "";
    String endereco = MyIO.readLine();
    long comeco = System.currentTimeMillis();
    while(!endereco.equals("FIM")){
      hash.inserir(Serie.ler(endereco));
      endereco = MyIO.readLine();
    }

    int qtd = MyIO.readInt();

    while(qtd != 0){
      str = MyIO.readString();//leio o que devo fazer
      if(str.equals("I")){
        endereco = MyIO.readLine();//leio o nome da Serie
        hash.inserir(Serie.ler(endereco));
      } else if(str.equals("R")){
        endereco = MyIO.readLine();//leio o nome da Serie
        //hash.remover(endereco);
      }// fim if/else
      qtd--;
    }
    endereco = MyIO.readLine();//leio o nome da Serie

    while(!endereco.equals("FIM")){
      hash.pesquisar(endereco);
/*
      if(hash.pesquisar(endereco)){
        MyIO.println("SIM");
      } else {
        MyIO.println("NAO");
      }
*/
      endereco = MyIO.readLine();
    }

    long fim = System.currentTimeMillis();

    criarArq(comeco, fim, hash);
  }
  /**
   *
   * @param comeco
   * @param fim
   * @param Hash
   */

  public static void criarArq(long comeco, long fim, Hash hash){
    Arq.openWrite("matricula_hashReserva.txt");
    Arq.print(matricula + "\t");
    Arq.print(hash.comparacoes + "\t");
    Arq.print((fim-comeco)/1000.0 + " s." + "\t");
    Arq.close();
  }
}
