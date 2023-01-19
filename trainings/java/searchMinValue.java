import java.util.Random;
public class searchMinValue 
{
	public static void main(String[] args) {
		int array[] = new int[10];
		int min;
		Random rand = new Random();
		for(int i = 0; i < 10; i++){
		    array[i] = rand.nextInt(100)+1;
		    System.out.println(array[i]);
		}
		min = array[0];
		for(int i = 0; i< 10; i++)
		    if(min > array[i])
		        min = array[i];
		        
		System.out.println(min);
	}
}