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
/**
 * Arvore de arvore
 * @author Max do Val Machado adaptada por Stefany Gaspar
 */
class ArvoreArvore {
	public int comparacoes = 0;
	private No raiz; // Raiz da arvore.
	public char arr[] = {'D', 'R', 'Z', 'X', 'V', 'B', 'F', 'P', 'U', 'I', 'G', 'E',
	'J', 'L', 'H', 'T', 'A', 'W','S','O', 'M', 'N', 'K', 'C', 'Y', 'Q', 'A'};

	/**
	 * Construtor da classe.
	 */

	public ArvoreArvore() throws Exception{
		 raiz = null;
			for(int i = 0; i < arr.length; i++){
				inserirInicio(arr[i]);
			}
	}
/**
 * Metodo que insere as letras na primeira arvore

 */
	public void inserirInicio(char letra){
	 		raiz = inserirInicio(letra, raiz);
	}

	public No inserirInicio(char letra, No i){
	 		if(i == null){
	 			i = new No(letra);
	 		} else if(letra < i.elemento){
	 			i.esq = inserirInicio(letra, i.esq);
				comparacoes++;
	 		} else if(letra > i.elemento){
	 			i.dir = inserirInicio(letra, i.dir);
				comparacoes++;
	 		} else {
	 			//so podem ser iguais
	 		}
			return i;
	 	}

/**
 * Metodo que insere as Series
 */

	public void inserir(Serie s)throws Exception{
	 		 raiz = inserir(s, raiz);
	 	}

	private No inserir(Serie s, No i) throws Exception {
	 		 if (i == null) {
				 comparacoes++;
	 			i = new No(s.getNome().charAt(0)); // crio um novo no
				//MyIO.println("nao posso entrar aqui");
	 		 } else if (s.getNome().charAt(0) < i.elemento) { // se a primeira letra for menor que o elemento
				 comparacoes++;
	 			i.esq = inserir(s, i.esq);
	 		 } else if (s.getNome().charAt(0) > i.elemento) {
				 comparacoes++;
	 			i.dir = inserir(s, i.dir);

	 		 } else {
				 comparacoes++;
	 				i.outra = inserir(s, i.outra);
	 		 }
			 return i;
	 	}

	private No2 inserir(Serie s, No2 i) throws Exception {
	 	 			 if (i == null) {
						 comparacoes++;
	 	 				i = new No2(s);
	 	 		 } else if (s.getNome().compareTo(i.elemento.getNome()) < 0) {
					 comparacoes++;
	 	 				i.esq = inserir(s, i.esq);

	 	 		 } else if (s.getNome().compareTo(i.elemento.getNome()) > 0) {
					 comparacoes++;
	 	 				i.dir = inserir(s, i.dir);

	 	 		 } else {
	 	 				//throw new Exception("Erro ao inserir!");
	 	 		 }
	 	 			 return i;
	 	 	 }

	/**
	 * Metodo publico iterativo para pesquisar elemento.
	 * @param elemento Elemento que sera procurado.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */

	public boolean pesquisar(String elemento) {
		MyIO.print("raiz ");
		return pesquisar(raiz, elemento);
	}

 	private boolean pesquisar(No no, String x) {
  	boolean resp;
		if (no == null) {
			comparacoes++;
			resp = false;

		} else if (x.charAt(0) == no.elemento) {
			comparacoes++;
			MyIO.print("raiz ");
			resp = pesquisarSegundaArvore(no.outra, x);
		} else if (x.charAt(0) < no.elemento) {
			comparacoes++;
			MyIO.print("esq ");
		  resp = pesquisar(no.esq, x);
		} else {
			comparacoes++;
		  MyIO.print("dir ");
		 	resp = pesquisar(no.dir, x);
		}
		  return resp;
		}

	private boolean pesquisarSegundaArvore(No2 no, String x) {
		boolean resp;
		if (no == null) {
			comparacoes++;
		  resp = false;
		} else if (x.equals(no.elemento.getNome())){
			comparacoes++;
		  resp = true;
		} else if (x.compareTo(no.elemento.getNome()) < 0) {
			comparacoes++;
			MyIO.print("esq ");
		  resp = pesquisarSegundaArvore(no.esq, x);
    } else {
			comparacoes++;
 		 	MyIO.print("dir ");
		 	resp = pesquisarSegundaArvore(no.dir, x);
		}
		return resp;
	}

	/**
	 * Metodo publico iterativo para exibir elementos.
	 */
	public void mostrarCentral() {
			mostrarCentral(raiz);
	}

	/**
	 * Metodo privado recursivo para exibir elementos.
	 * @param i No em analise.
	 */
	private void mostrarCentral(No i) {
			if (i != null) {
					mostrarCentral(i.esq); // Elementos da esquerda.
					mostrarOutra(i.outra);
					mostrarCentral(i.dir); // Elementos da direita.
			} else {
			}
	}

	private void mostrarOutra(No2 i){
		if(i != null){
			mostrarOutra(i.esq);
			System.out.println(i.elemento.getNome());
			mostrarOutra(i.dir);
		}
	}//fim mostrarOutra

	/**
	  * Metodo publico iterativo para remover elemento.
	  * @param x Elemento a ser removido.
	  * @throws Exception Se nao encontrar elemento.
	  */
	 public void remover(String nome) throws Exception {
	    raiz = remover(nome, raiz);
	 }

	 /**
	  * Metodo privado recursivo para remover elemento.
	  * @param nome Elemento a ser removido.
	  * @param i No em analise.
	  * @return No em analise, alterado ou nao.
	  * @throws Exception Se nao encontrar elemento.
	  */
	 private No remover(String nome, No i) throws Exception {
	     if (i == null) { //se a raiz estiver vazia
	      //throw new Exception("Erro ao remover!");
	   } else if (nome.charAt(0) < i.elemento) {
	      i.esq = remover(nome, i.esq);
	   } else if (nome.charAt(0) > i.elemento) {
	      i.dir = remover(nome, i.dir);
	   } else {
	     i.outra = remover(nome, i.outra);
	   }
	     return i;
	 }

	 private No2 remover(String nome, No2 i) throws Exception {
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

	private No2 anterior(No2 i, No2 j) {

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

}//fim class ArvoreArvore
class No {
	public char elemento; // Conteudo do no.
	public No esq; // No da esquerda.
	public No dir; // No da direita.
  public No2 outra;

   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No(char elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
    this.outra = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No da esquerda.
	 * @param dir No da direita.
	 */
	No(char elemento, No esq, No dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
    this.outra = null;
	}
}

class No2 {
	public Serie elemento; // Conteudo do no.
	public No2 esq; // No da esquerda.
	public No2 dir; // No da direita.

   /**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 */
	No2(Serie elemento) {
		this.elemento = elemento;
		this.esq = this.dir = null;
	}

	/**
	 * Construtor da classe.
	 * @param elemento Conteudo do no.
	 * @param esq No2 da esquerda.
	 * @param dir No2 da direita.
	 */
	No2(Serie elemento, No2 esq, No2 dir) {
		this.elemento = elemento;
		this.esq = esq;
		this.dir = dir;
	}
}

public class TP07Q02{
	public static final int matricula = 582931;
  public static void main(String[] args) throws Exception{
  ArvoreArvore arvore = new ArvoreArvore();
	String str = " ";
	String endereco = MyIO.readLine();

  while(!endereco.equals("FIM")){
    arvore.inserir(Serie.ler(endereco));
    endereco = MyIO.readLine();
  }//fim while

	int qtd = MyIO.readInt();

  long comeco = System.currentTimeMillis();
  while(qtd != 0){
    str = MyIO.readString();
    if(str.equals("I")){
      endereco = MyIO.readLine();
      arvore.inserir(Serie.ler(endereco));
    }
    else if(str.equals("R")){
      endereco = MyIO.readLine();
      arvore.remover(endereco);
    }
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

public static void criarArq(long comeco, long fim, ArvoreArvore arvore){
	Arq.openWrite("matricula_arvoreArvore.txt");
	Arq.print(matricula + "\t");
	Arq.print(arvore.comparacoes + "\t");
	Arq.print((fim-comeco)/1000.0 + " s." + "\t");
	Arq.close();
}
}
