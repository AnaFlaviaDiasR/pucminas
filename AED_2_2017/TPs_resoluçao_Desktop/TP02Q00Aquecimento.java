class TP02Q00Aquecimento {
   public static int maiusculos(String s){
      return contarLetrasMaiusculas(s, 0);
   }
   public static int contarLetrasMaiusculas (String s, int x){
      int resp = 0;

      if (x < s.length()){
         if(((s.charAt(x) >= 'A') && (s.charAt(x) <= 'Z')) == true){
            resp = 1 + contarLetrasMaiusculas(s, x +1);
         } else {
            resp = contarLetrasMaiusculas(s, x +1);
         }
      }
      return resp;
   }

   public static void main (String[] args){
      String linha= "";
      int numEntrada = 0;
      linha= MyIO.readLine();	
      while (linha.equals("FIM") != true){
         numEntrada= maiusculos(linha);
         MyIO.println(numEntrada);
         linha = MyIO.readLine();
      }
   }
}
