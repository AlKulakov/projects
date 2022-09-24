public class Main
{
	public static void main(String[] args) {
		String s = "abcd sdfcs as 123 vbxc dklfd";
		String[] mass = s.split(" ");
		String a;
		int count = 1;
		for(int i = 1; i<mass.length; i++) {
		for(int j = mass.length-1; j>i; j--) {
		        if(mass[j].length()>mass[j-1].length()){
		            a=mass[j-1];
		            mass[j-1] = mass[j];
		            mass[j] = a;
		        }
		    }
		}
		for(int i=0; mass[i]==mass[i+1];i++)
		{
		    count++;
		}
		for(int j = 0; j<mass.length; j++) {
		        System.out.println(mass[j] + " ");
		}
		System.out.println("[-] Количество: " + count);
	}
}