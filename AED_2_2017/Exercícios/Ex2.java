import java.util.*;

public class Ex2{
	public static int[] array= {1,2,3,4,5,6,7,8,9,10};
	public static void main(String[] args) {
		int x= 3; //valor array
		int pivo= array.length/2;
		boolean procurando= false;
	
		if (x < pivo){
			procurando= procuraValorArray(x, 0, pivo);
		}
		else 
			procurando= procuraValorArray(x, pivo, array.length);
		
		if (procurando == true)
			System.out.print("tem");
		else
			System.out.print("NAO tem");

	}

	public static boolean procuraValorArray(int x, int inicio, int fim){
		boolean a= false;
		for (int i=inicio; i < fim; i++){
			if (array[i] == x){
				a= true;
			} 
		}
		return a;
	}
}