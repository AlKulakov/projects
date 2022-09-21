using System;
namespace C_Sharp
{
	class program {
	    static void Main() {
	        double[,] mass = new double[10,10];
	        fill(mass);
	        show(mass);
	        double[,] mass2 = new double[10,10];
	        newmass(mass,mass2);
	        Console.WriteLine("\n\n\n");
	        show(mass2);
	        Console.WriteLine(sum(mass2));
	    }
	    static void fill(double[,] mass) {
	        Random rand = new Random();
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                mass[i,j] = rand.Next(0,10);
	            }
	        }
	    }
	    static void show(double[,] mass) {
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                Console.Write(mass[i,j]+" ");
	            }
	            Console.WriteLine("");
	        }
	    }
	    static void newmass(double[,] mass, double[,] mass2) {
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                mass2[i,j] = mass[i,j];
	            }
	        }
	        for(int i = 1; i<9; i++) {
	            for(int j = 1; j<9; j++) {
	                mass2[i,j] = (mass[i-1,j-1]+mass[i-1,j]+mass[i-1,j+1]+mass[i,j-1]+mass[i,j]+mass[i,j+1]+mass[i+1,j-1]+mass[i+1,j]+mass[i+1,j+1])/9;
	            }
	        }
	    }
	    static double sum(double[,] mass) {
	        double sum = 0;
	        for(int i = 0; i<10; i++) {
	            for(int j = 0; j<10; j++) {
	                if(i>j) {
	                    sum+=mass[i,j];
	                }
	            }
	        }
	        return sum;
	    }
	}
}