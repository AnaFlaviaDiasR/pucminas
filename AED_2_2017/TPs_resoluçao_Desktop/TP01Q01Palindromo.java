public class TP01Q01Palindromo{
	/*
		O metodo Palindromo recebe uma String por parametro
		e verifica se ela eh um palindromo ou nao
	*/	
	public static boolean palindromo (String palavra){
		for (int i=0; i<palavra.length(); i++){
			if (palavra.charAt(i) != palavra.charAt(palavra.length()-1-i)){
				return false;
			}
		}
		return true;
	}//fim palindromo()

	/*
		O metodo Flag recebe uma String por parametro e 
		verifica se essa eh a palavra "FIM", se falso, 
		ele retornara falso e verificara a proxima palavra
	*/
	public static boolean flag (String p){
		boolean efetividade= false;
		String flag= "FIM";
		if (p.length() == flag.length()){
			for (int i=0; i<p.length();i++){
				if (p.charAt(i) != flag.charAt(i)){
					return false;
				}
				else{
					efetividade= true;
				}
			}
		}
		return efetividade;
	}//fim flag()

	public static void main (String[]args){
		String[] palavra= new String[1000];
		int qt=0;
		boolean verifica= false;
		do{
			palavra[qt]= MyIO.readLine();
			verifica= flag(palavra[qt]);
			qt++;
		}while(verifica == false);
		qt--; //Desconsidera a palavra FIM
		for (int i=0; i<qt; i++){
			if (palindromo(palavra[i]) == false){
				MyIO.println("NAO");
			}
			else{
				MyIO.println("SIM");
			}
		}
	}//fim main
}//fim class
