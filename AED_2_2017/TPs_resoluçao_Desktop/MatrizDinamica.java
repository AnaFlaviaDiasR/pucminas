/*
AEDs 2 1/2017
Nome:Otto Wilke Diniz Mariani Bittencourt
Ajuda:Guilherme Derze, Felipe Megale and g0d Google
Matricula:504654
*/

import java.io.*;
import java.*;
import java.nio.charset.*;
import java.util.Formatter;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.UnsupportedEncodingException;

class MyIO {

   private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));
   private static String charset = "ISO-8859-1";

   public static void setCharset(String charset_) {
      charset = charset_;
      in = new BufferedReader(new InputStreamReader(System.in, Charset.forName(charset)));
   }

   public static void print() {
   }

   public static void print(int x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void print(double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void print(String x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void print(boolean x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void print(char x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void println() {
   }

   public static void println(int x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void println(double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void println(String x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void println(boolean x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void println(char x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.println(x);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static void printf(String formato, double x) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.printf(formato, x);// "%.2f"
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
   }

   public static double readDouble() {
      double d = -1;
      try {
         d = Double.parseDouble(readString().trim().replace(",", "."));
      } catch (Exception e) {}
      return d;
   }

   public static double readDouble(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readDouble();
   }

   public static float readFloat() {
      return (float) readDouble();
   }

   public static float readFloat(String str) {
      return (float) readDouble(str);
   }

   public static int readInt() {
      int i = -1;
      try {
         i = Integer.parseInt(readString().trim());
      } catch (Exception e) {}
      return i;
   }

   public static int readInt(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readInt();
   }

   public static String readString() {
      String s = "";
      char tmp;
      try {
         do {
            tmp = (char)in.read();
            if (tmp != '\n' && tmp != ' ' && tmp != 13) {
               s += tmp;
            }
         } while (tmp != '\n' && tmp != ' ');
      } catch (IOException ioe) {
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readString(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readString();
   }

   public static String readLine() {
      String s = "";
      char tmp;
      try {
         do {
            tmp = (char)in.read();
            if (tmp != '\n' && tmp != 13) {
               s += tmp;
            }
         } while (tmp != '\n');
      } catch (IOException ioe) {
         System.out.println("lerPalavra: " + ioe.getMessage());
      }
      return s;
   }

   public static String readLine(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readLine();
   }

   public static char readChar() {
      char resp = ' ';
      try {
         resp  = (char)in.read();
      } catch (Exception e) {}
      return resp;
   }

   public static char readChar(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readChar();
   }

   public static boolean readBoolean() {
      boolean resp = false;
      String str = "";

      try {
         str = readString();
      } catch (Exception e) {}

      if (str.equals("true") || str.equals("TRUE") || str.equals("t") || str.equals("1") ||
            str.equals("verdadeiro") || str.equals("VERDADEIRO") || str.equals("V")) {
         resp = true;
      }

      return resp;
   }

   public static boolean readBoolean(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      return readBoolean();
   }

   public static void pause() {
      try {
         in.read();
      } catch (Exception e) {}
   }

   public static void pause(String str) {
      try {
         PrintStream out = new PrintStream(System.out, true, charset);
         out.print(str);
      } catch (UnsupportedEncodingException e) { System.out.println("Erro: charset invalido"); }
      pause();
   }
}
class Celula {
   public int elemento;
   public Celula inf, sup, esq, dir;

   /**
    * construtor padrao do celula
    */
   public Celula() {
      this(0, null, null, null, null);
   }

   /**
    * construtor do celula
    * @param  elemento insercao do elemento no no
    */
   public Celula(int elemento) {
      this(elemento, null, null, null, null);
   }

   /**
    * Constrtor de celula com os ponteiros   
    * @param  elemento elemento a ser inserido na Celula
    * @param  inf      ponteiro para a celula inferior
    * @param  sup      ponteiro para a celula superior
    * @param  esq      ponteiro para a celula esquerda
    * @param  dir      ponteiro para a celula direita
    */
   public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir) {
      this.elemento = elemento;
      this.inf = inf;
      this.sup = sup;
      this.esq = esq;
      this.dir = dir;
   }
}

class Matriz {
   private Celula inicio;
   private int linhas, colunas;

   /**
    * construtor padrao da matriz
    * @param  size tamanho 
    */
   public Matriz (int size) {
      this.linhas = this.colunas = size;
   }

   /**
    * Construtor da matriz
    * @param  linhas  numero de linhas
    * @param  colunas numero de colunas
    */
   public Matriz (int linhas, int colunas) {

      this.linhas = linhas;
      this.colunas = colunas;
      Celula col = null;
      Celula lin = null;

      for (int i = 0; i < linhas; i++) {
         for (int j = 0; j < colunas; j++) {

            if (i == 0 && j == 0) {

               inicio = new Celula();
               col = inicio;
               lin = inicio;
            }

            else if (j != 0) {

               col.dir = new Celula();
               col.dir.esq = col;
               col = col.dir;


               if (i != 0) {

                  col.esq.sup.dir.inf = col;
                  col.sup = col.esq.sup.dir;
               }
            }
         }
         if (i + 1 != linhas) {

            lin.inf = new Celula();
            lin.inf.sup = lin;
            lin = lin.inf;
            col = lin;
         }
      }
   }

   /**
    * metodo de insercao dos elementos
    */
   public void inserir() {
      String[] aux = new String[linhas];
      for (int k = 0; k < linhas; k++) {
         aux[k] = MyIO.readLine();
      }
      int i = 0;
      int j = 0;
      for (Celula line = inicio; line != null; line = line.inf, j++) {
         String[] valor = aux[j].split(" ");
         i = 0;
         for (Celula column = line; column != null; column = column.dir, i++) {
            column.elemento = Integer.parseInt(valor[i]);
         }
      }
   }

   /**
    * metodo de mostrar a matriz
    */
   public void mostar() {

      for (Celula line = inicio; line != null; line = line.inf) {
         for (Celula column = line; column != null; column = column.dir) {
            System.out.print(column.elemento + " ");
         }
         System.out.println();
      }
   }

   /**
    * metodo de soma de todos os elementos da matriz
    * @return retorno da resp
    */
   public int soma() {

      int resp = 0;

      for (Celula line = inicio; line != null; line = line.inf) {
         for (Celula column = line; column != null; column = column.dir) {
            resp += column.elemento;
         }
      }
      return resp;
   }

   /**
    * mostra a diagonal principal(metodo principal)
    */
   public void mostrarDiagonalPrincipal() {
      mostrarDiagonalPrincipal(inicio);
      System.out.println();
   }

   /**
    * mostra a diagonal principal(metodo recursivo)   
    * @param cel celula a ser analisada
    */
   public void mostrarDiagonalPrincipal(Celula cel) {

      System.out.print(cel.elemento + " ");

      if ((cel.dir != null) && (cel.dir.inf != null)) {
         mostrarDiagonalPrincipal(cel.dir.inf);
      }
   }

   /**
    * mostra a diagonal secundaria(metodo principal)
    */
   public void mostrarDiagonalSecundaria() {

      Celula endLine;

      for (endLine = inicio; endLine.dir != null; endLine = endLine.dir);

      mostrarDiagonalSecundaria(endLine);
      System.out.println();

   }

   /**
    * mostra a diagonal secundaria(metodo recursivo)   
    * @param cel celula a ser analisada
    */
   public void mostrarDiagonalSecundaria(Celula cel) {

      System.out.print(cel.elemento + " ");

      if ((cel.esq != null) && (cel.esq.inf != null)) {
         mostrarDiagonalSecundaria(cel.esq.inf);
      }
   }

   /**
    * Metodo para fazer a multiplicacao de 2 matrizes
    * @param  matriz1 matriz1
    * @param  matriz2 matriz2
    * @return         retorno da matriz multiplicada
    */
   public static Matriz multiplicacao(Matriz matriz1, Matriz matriz2) {

      Matriz resp = new Matriz(matriz1.linhas, matriz2.colunas);
      int mult = 0;

      for (Celula line = resp.inicio , lineA = matriz1.inicio; line != null; line = line.inf , lineA = lineA.inf) {
         for (Celula column = line , columnB = matriz2.inicio; column != null; column = column.dir , columnB = columnB.dir) {
            mult = 0;
            for (Celula columnA = lineA , lineB = columnB; columnA != null; columnA = columnA.dir , lineB = lineB.inf) {
               mult += columnA.elemento * lineB.elemento;
            }
            column.elemento = mult;
         }
      }
      return resp;
   }

   /**
    * Metodo para soma dos elementos da matriz
    * @param  matriz1 matriz1
    * @param  matriz2 matriz2
    * @return         retorno da matriz somada
    */
   public static Matriz somatorio(Matriz matriz1, Matriz matriz2) {
      Matriz resp = new Matriz(matriz1.linhas, matriz2.colunas);

      for (Celula line = resp.inicio, linha1 = matriz1.inicio, linha2 = matriz2.inicio; line != null; line = line.inf, linha1 = linha1.inf, linha2 = linha2.inf) {
         for (Celula column = line, coluna1 = linha1, coluna2 = linha2; column != null; column = column.dir, coluna1 = coluna1.dir, coluna2 = coluna2.dir) {
            column.elemento = coluna1.elemento + coluna2.elemento;
         }
      }
      return resp;
   }

}
class MatrizDinamica {

   /**
    * Metodo principal da classe
    * @param args 
    */
   public static void main(String[] args) {

      int numeroCasos = Integer.parseInt(MyIO.readLine());
      int linhas = 0;
      int colunas = 0;

      for (int i = 0; i < numeroCasos; i++) {
         linhas = Integer.parseInt(MyIO.readLine());
         colunas = Integer.parseInt(MyIO.readLine());
         Matriz matriz1 = new Matriz(linhas, colunas);
         matriz1.inserir();
         linhas = Integer.parseInt(MyIO.readLine());
         colunas = Integer.parseInt(MyIO.readLine());
         Matriz matriz2 = new Matriz(linhas, colunas);
         matriz2.inserir();

         matriz1.mostrarDiagonalPrincipal();
         matriz1.mostrarDiagonalSecundaria();
         Matriz.somatorio(matriz1, matriz2).mostar();
         Matriz.multiplicacao(matriz1, matriz2).mostar();
      }


   }

}