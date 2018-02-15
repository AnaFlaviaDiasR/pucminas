import java.util.*;

public class Ex1{
	public static int[] array= {5,2,7,4,6,5,2,7,9,8,3,1};
	public static void main(String[] args) {
		int x= 1; //valor array
		boolean procurando= procuraValorArray(x);
		if (procurando == true)
			System.out.print("tem");
		else
			System.out.print("NAO tem");

	}

	public static boolean procuraValorArray(int x){
		boolean a= false;
		for (int i=0; i < array.length; i++){
			if (array[i] == x){
				a= true;
			} 
		}
		return a;
	}
}