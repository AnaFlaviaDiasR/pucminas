
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


/**
 * No da arvore binaria
 * @author Max do Val Machado adaptada por Stefany Gaspar
 */
class No {
    public Serie elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public int nivel; // Numero de niveis abaixo do no

    /**
     * Construtor da classe.
     *
     * @param elemento
     *            Conteudo do no.
     */
    No(Serie elemento) {
        this(elemento, null, null, 1);
    }

    /**
     * Construtor da classe.
     * @param elemento
     * @param esq
     * @param dir
     */
    No(Serie elemento, No esq, No dir, int nivel) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.nivel = nivel;
    }

    // Cálculo do número de níveis a partir de um vértice
    public No setNivel() {
        this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
        return this;
    }

    // Retorna o número de níveis a partir de um vértice
    public static int getNivel(No no) {
        return (no == null) ? 0 : no.nivel;
    }
}

  /**
   * AVL - arvore Binaria de Pesquisa com algoritmo de balanceamento AVL.
   * @author Max do Val Machado adaptada por Stefany Gaspar
   */
  class AVL {
    public int comparacoes = 0;
  	private No raiz; // Raiz da arvore.

  	/**
  	 * Construtor da classe.
  	 */
  	public AVL() {
  		raiz = null;
  	}

  	public int getAltura() {
  		return nivel(raiz) - 1;
  	}

    public int getNivel(No no){
      return nivel(raiz);
    }

    private int nivel(No no) {
  		return (no == null) ? 0 : (1 + Math.max(nivel(no.esq), nivel(no.dir)));
  	}



  /**
   * Metodo pesquisar
   */
    public boolean pesquisar(String x){
      MyIO.print("raiz ");
      return pesquisar(x, raiz);
    }//fim pesquisar

    private boolean pesquisar(String x, No no){
      boolean resp;
      if(no== null){
        resp = false;
      } else if(x.compareTo(no.elemento.getNome()) == 0){
        comparacoes++;
        resp = true;
      } else if(x.compareTo(no.elemento.getNome()) < 0){
        comparacoes++;
        MyIO.print("esq ");
        resp = pesquisar(x, no.esq); // se o x for menor que o elemento do No chamo novamente passando o No da esquerda
      } else {
        MyIO.print("dir ");
        resp = pesquisar(x, no.dir); //se for maior que o elemendo do No chamo novamente passando o No da direita
      }
    return resp;
  }//fim pesquisar

  	/**
  	 * Metodo publico iterativo para inserir elemento.
  	 * @param x Elemento a ser inserido.
  	 * @throws Exception Se o elemento existir.
  	 */
  	public void inserir(Serie x) throws Exception {
  		raiz = inserir(raiz, x);
  	}

  	/**
  	 * Metodo privado recursivo para inserir elemento.
  	 *
  	 * @param no
  	 *            No em analise.
  	 * @param x
  	 * Elemento a ser inserido.
  	 * @return No em analise, alterado ou nao.
  	 * @throws Exception
  	 * Se o elemento existir.
  	 */
     private No inserir(No no, Serie x) throws Exception {
       String nome = x.getNome();
       if(no== null){
         comparacoes++;
         no = new No(x); //se estiver no= null crio um novo no
       } else if (nome.compareTo(no.elemento.getNome()) < 0){
         comparacoes++;
         no.esq = inserir(no.esq, x);
       } else if (nome.compareTo(no.elemento.getNome()) > 0){
         comparacoes++;
         no.dir = inserir(no.dir, x);
       } else {
         throw new Exception("Erro!!");
       }
       no = balancear(no);
       return no;
     }

  	private No balancear(No no) throws Exception {
  		if (no != null) {
  			int fator = No.getNivel(no.dir) - no.getNivel(no.esq);

  			// Se balanceada
  			if (Math.abs(fator) <= 1) {
  				no = no.setNivel();

  				// Se desbalanceada para a direita
  			} else if (fator == 2) {

  				int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);

  				// Se o filho a direita tambem estiver desbalanceado
  				if (fatorFilhoDir == -1) {
  					no.dir = rotacionarDir(no.dir);
  				}
  				no = rotacionarEsq(no);

  				// Se desbalanceada para a esquerda
  			} else if (fator == -2) {

  				int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);

  				// Se o filho a esquerda tambem estiver desbalanceado
  				if (fatorFilhoEsq == 1) {
  					no.esq = rotacionarEsq(no.esq);
  				}
  				no = rotacionarDir(no);

  			} else {
  				throw new Exception("Erro fator de balanceamento (" + fator + ") invalido!");
  			}
  		}

  		return no;
  	}

  	private No rotacionarDir(No no) {
  		No noEsq = no.esq;
  		No noEsqDir = noEsq.dir;

  		noEsq.dir = no;
  		no.esq = noEsqDir;

  		no.setNivel();
  		noEsq.setNivel();

  		return noEsq;
  	}

  	private No rotacionarEsq(No no) {
  		No noDir = no.dir;
  		No noDirEsq = noDir.esq;

  		noDir.esq = no;
  		no.dir = noDirEsq;

  		no.setNivel();
  		noDir.setNivel();
  		return noDir;
  	}

  	/**
  	 * Metodo publico iterativo para remover elemento.
  	 * @param elemento
  	 * @throws Exception
  	 */
  	public void remover(String x) throws Exception {
  		raiz = remover(raiz, x);
  	}

  	/**
  	 * Metodo privado recursivo para remover elemento.
  	 * @param i
  	 * @param x
  	 * @return No em analise, alterado ou nao.
  	 * @throws Exception
  	 *             Se nao encontrar elemento.
  	 */
  	private No remover(No no, String nome) throws Exception {

  		if (no == null) {
        comparacoes++;

  		} else if (nome.compareTo(no.elemento.getNome()) < 0) {
        comparacoes++;
  			no.esq = remover(no.esq, nome);

  		} else if (nome.compareTo(no.elemento.getNome()) > 0) {
        comparacoes++;
  			no.dir = remover(no.dir, nome);

  			// Sem no a direita.
  		} else if (no.dir == null) {
        comparacoes++;
  			no = no.esq;

  			// Sem no a esquerda.
  		} else if (no.esq == null) {
        comparacoes++;
  			no = no.dir;

  			// No a esquerda e no a direita.
  		} else {
  			no.esq = antecessor(no, no.esq);
  		}

  		no = balancear(no);
  		return no;
  	}

  	/**
  	 * Metodo para trocar no removido pelo antecessor.
  	 * @param n1
  	 * @param n2
  	 * @return No em analise, alterado ou nao.
  	 */
  	private No antecessor(No n1, No n2) {

  		// Existe no a direita.
  		if (n2.dir != null) {
  			// Caminha para direita.
  			n2.dir = antecessor(n1, n2.dir);

  			// Encontrou o maximo da subarvore esquerda.
  		} else {
  			n1.elemento = n2.elemento; // Substitui N1 por N2.
  			n2 = n2.esq; // Substitui N2 por N2.ESQ.
  		}
  		return n2;
  	}
  }

public class TP07Q03{
  public static final int matricula = 582931;
  public static void main(String[] args) throws Exception {
    AVL arvore = new AVL();
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

  public static void criarArq(long comeco, long fim, AVL arvore){
    Arq.openWrite("matricula_avl.txt");
    Arq.print(matricula + "\t");
    Arq.print(arvore.comparacoes + "\t");
    Arq.print((fim-comeco)/1000.0 + " s." + "\t");
    Arq.close();
  }
}
