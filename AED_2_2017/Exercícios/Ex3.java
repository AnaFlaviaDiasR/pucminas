import java.util.*;

public class Ex3{
	public static int[] array= {5,2,7,4,6,5,2,7,9,8,3,1};	
	public static void main(String[] args) {
		int maior= procuraMaior(array);
		int menor= procuraMenor(array);

		System.out.print("MAIOR: "+maior);
		System.out.print("\nMENOR: "+menor);

	}

	public static int procuraMaior(int[] arrray){
		int maior= array[0];
		for (int i= 0; i < array.length; i++){
			if(maior < array[i])
				maior= array[i];
		}
		return maior;
	}

	public static int procuraMenor(int[] arrray){
		int menor= array[0];
		for (int i= 0; i < array.length; i++){
			if(menor > array[i])
				menor= array[i];
		}
		return menor;
	}
}