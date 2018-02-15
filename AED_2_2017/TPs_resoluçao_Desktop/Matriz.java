/**
 * Classe Celula
 */
class Celula {
	public int elemento;
	public Celula sup, inf, esq, dir;

	public Celula() {
		this(0);
	}

	public Celula(int x) {
		this(x, null, null, null, null);
	}

	public Celula(int x, Celula sup, Celula inf, Celula esq, Celula dir) {
		this.elemento = x;
		this.sup = sup;
		this.inf = inf;
		this.esq = esq;
		this.dir = dir;
	}
}

class MatrizDinamica {
	private Celula inicio;
	private int linha, coluna;

	/**
	 * Construtor da matriz dinamica.
	 * @param linha número de linhas que a matriz terá.
	 * @param coluna número de colunas que a matriz terá.
	 */
	public MatrizDinamica(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;

		// initializes pointers (avoids "variable might not have been initialized")
		Celula col = null;
		Celula lin = null;

		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if (i == 0 && j == 0) {
					inicio = new Celula();
					col = inicio;
					lin = inicio;
				} else if (j != 0) {
					col.dir = new Celula();
					col.dir.esq = col;
					col = col.dir;
					if (i != 0) {
						col.esq.sup.dir.inf = col;
						col.sup = col.esq.sup.dir;
					}
				}
			}

			if (i + 1 < linha) {
				lin.inf = new Celula();
				lin.inf.sup = lin;
				lin = lin.inf;
				col = lin;
			}
		}
	}

	/**
	 * Busca e retorna um elemento desta matriz dinamica, numa certa posicao.
	 * @param lin Em qual linha o elemento se encontra
	 * @param col Em qual coluna o elemento se encontra
	 * @return O elemento que se encontra na posicao [lin][col] desta matriz;
	 */
	public int getElemento(int lin, int col) {

		Celula where = this.inicio;

		for (int i = 0; i < lin; i++) {
			where = where.inf;
		}

		for (int j = 0; j < col; j++) {
			where = where.dir;
		}

		return where.elemento;
	}

	/**
	 * Metodo para inserir um elemento numa posicao da matriz.
	 * @param linha linha em que deseja inserir um elemento
	 * @param coluna coluna em que deseja inserir um elemento
	 * @param elemento elemento que deseja inserir na matriz
	 */
	public void inserirElemento(int linha, int coluna, int elemento) {

		Celula aux = inicio;

		for (int i = 0; i < linha; i++) {
			aux = aux.inf;
		}

		for (int j = 0; j < coluna; j++) {
			aux = aux.dir;
		}

		aux.elemento = elemento;
	}

	/**
	 * Método que soma os elementos de duas matrizes dinamicas quaisquer e
	 * retorna uma terceira matriz contendo os resultados.
	 * @return Matriz resp resultante da soma das duas matrizes de entrada.
	 */
	public MatrizDinamica soma(MatrizDinamica m) {
		MatrizDinamica resp = null;
		int elemento;

		if (this.linha == m.linha && this.coluna == m.coluna) {
			resp = new MatrizDinamica(m.linha, m.coluna);

			for (int i = 0; i < m.linha; i++) {
				for (int j = 0; j < m.coluna; j++) {
					elemento = this.getElemento(i, j) + m.getElemento(i, j);
					resp.inserirElemento(i, j, elemento);
				}
			}
		}

		return resp;
	}

	/**
	 * Método que multiplica duas matrizes e retorna uma terceira matriz
	 * resultante da operação.
	 * @param m Matriz a multiplicar com a primeira.
	 * @return resp Matriz resultante da operação de multiplicacação.
	 */
	public MatrizDinamica multiplicacao(MatrizDinamica m) {

		MatrizDinamica resp = new MatrizDinamica(this.linha, m.coluna);

		int soma;

		for (int i = 0; i < this.linha; i++) {
			for (int j = 0; j < this.coluna; j++) {
				soma = 0;
				for (int k = 0; k < this.linha; k++) {
					soma += this.getElemento(i, k) * m.getElemento(k, j);
				}
				resp.inserirElemento(i, j, soma);
			}
		}

		return resp;
	}

	/**
	 * Método que verifica se uma matriz é quadrada ou não.
	 * @return boolean resp valor lógico que diz respeito à matriz ser quadrada ou não.
	 */
	public boolean isQuadrada() {
		return (this.linha == this.coluna);
	}

	/**
	 * Método para mostrar a diagonal principal de uma matriz qualquer.
	 */
	public int[] mostrarDiagonal() {
		Celula tmp = this.inicio;
		int diagonal[] = new int[this.linha];
		int arrayPos = 0;

		do {
			diagonal[arrayPos] = tmp.elemento;
			tmp = tmp.dir.inf;
			arrayPos++;
		} while (tmp.inf != null);

		diagonal[arrayPos] = tmp.elemento;

		return diagonal;
	}

	/**
	 * Método para mostrar a diagonal secundaria de uma matriz qualquer.
	 */
	public int[] mostrarDiagonalSecundaria() {
		Celula tmp = inicio;
		int diagonalSec[] = new int[this.linha];
		int arrayPos = 0;

		// caminha para o final da primeira linha
		while (tmp.dir != null) {
			tmp = tmp.dir;
		}

		do {
			diagonalSec[arrayPos] = tmp.elemento;
			tmp = tmp.esq.inf;
			arrayPos++;
		} while (tmp.inf != null);

		diagonalSec[arrayPos] = tmp.elemento;

		return diagonalSec;
	}

	/**
	 * Método que mostra na saida padrao uma matriz
	 */
	public void mostrarLinhaPorLinha() {

		Celula aLin;
		Celula aCol;

		for (aLin = inicio; aLin != null; aLin = aLin.inf) {
			for (aCol = aLin; aCol != null; aCol = aCol.dir) {
				System.out.printf("%d ", aCol.elemento);
			}
			System.out.println();
		}
	}

	/**
	 * Função que mostra um elemento em uma determinada posicao da matriz.
	 * @param contLin posicao da linha em que o elemento se encontra.
	 * @param contCol posicao da coluna em que o elemento se encontra.
	 * @return O elemento que está na posição [contLin][contCol] da matriz.
	 */
	public int mostrarMatriz(int contLin, int contCol) {

		Celula aux = this.inicio;

		for (int i = 0; i < contLin; i++, aux = aux.inf)
			;
		for (int j = 0; j < contCol; j++, aux = aux.dir)
			;

		return aux.elemento;
	}
}

public class Matriz {

	public static void main(String[] args) {

		int caseAmount = MyIO.readInt();
		int lin1, col1, lin2, col2;
		String data;
		String splitted[];

		do {

			lin1 = MyIO.readInt();
			// MyIO.println("Lin1: " + lin1);
			col1 = MyIO.readInt();
			// MyIO.println("Col1: " + col1);

			MatrizDinamica m1 = new MatrizDinamica(lin1, col1);
			// MyIO.println("Montou a matriz 1");

			for (int i = 0; i < lin1; i++) {
				data = MyIO.readLine();
				splitted = data.split(" ");
				for (int j = 0; j < col1; j++) {
					m1.inserirElemento(i, j, Integer.parseInt(splitted[j]));
				}
			}

			lin2 = MyIO.readInt();
			// MyIO.println("Lin2: " + lin2);
			col2 = MyIO.readInt();
			// MyIO.println("Col2: " + col2);

			MatrizDinamica m2 = new MatrizDinamica(lin2, col2);
			// MyIO.println("Montou a matriz 2");

			for (int i = 0; i < lin2; i++) {
				data = MyIO.readLine();
				splitted = data.split(" ");
				for (int j = 0; j < col2; j++) {
					m2.inserirElemento(i, j, Integer.parseInt(splitted[j]));
				}
			}
/*
			int diagonal[] = m1.mostrarDiagonal(); //ok
			int diagonalSec[] = m1.mostrarDiagonalSecundaria(); //ok

			for (int pos = 0; pos < diagonal.length; pos++) {
				System.out.printf("%d ", diagonal[pos]);
			}
			System.out.println("");

			for (int pos = 0; pos < diagonalSec.length; pos++) {
				System.out.printf("%d ", diagonalSec[pos]);
			}
			System.out.println("");
*/
			MatrizDinamica matSoma = m1.soma(m2);
			for (int i = 0; i < lin1; i++) {
				for (int j = 0; j < col1; j++) {
					MyIO.print(matSoma.mostrarMatriz(i, j) + " ");
				}
				MyIO.println("");
			}
/*
			MatrizDinamica matMult = m1.multiplicacao(m2);
			matMult.mostrarLinhaPorLinha();

			caseAmount--;*/
		} while (caseAmount > 0);
	}
}
