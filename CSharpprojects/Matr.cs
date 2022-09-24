using System;
namespace C_Sharp
{
	class program {
	    static void Main() {
	        double[,] massive = new double[10,10];
	        fill(massive);
	        show(massive);
	        double[,] massive2 = new double[10,10];
	        newmassive(massive,massive2);
	        Console.WriteLine("\n\n\n");
	        show(massive2);
	        Console.WriteLine("\n[-] Summary: \n" + Summary(massive2));
	    }
	    static void fill(double[,] massive) {
	        Random rand = new Random();
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                massive[i,j] = rand.Next(0,10);
	            }
	        }
	    }
	    static void show(double[,] massive) {
			Console.WriteLine("[-] Massive: \n";
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                Console.Write(massive[i,j]+" ");
	            }
	            Console.WriteLine("");
	        }
	    }
	    static void newmassive(double[,] massive, double[,] massive2) {
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                massive2[i,j] = massive[i,j];
	            }
	        }
	        for(int i = 1; i<9; i++) {
	            for(int j = 1; j<9; j++) {
	                massive2[i,j] = (massive[i-1,j-1]+massive[i-1,j]+massive[i-1,j+1]+massive[i,j-1]+massive[i,j]+massive[i,j+1]+massive[i+1,j-1]+massive[i+1,j]+massive[i+1,j+1])/9;
	            }
	        }
	    }
	    static double Summary(double[,] massive) {
	        double Summary = 0;
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                if(i>j) {
	                    Summary+=massive[i,j];
	                }
	            }
	        }
	        return Summary;
	    }
	}
}