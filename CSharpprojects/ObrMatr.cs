using System;
namespace C_Sharp
{
	class matrix 
	{
	private double[,] mass = new double[3,3];
	public matrix(double[,] mass) {
 	for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                this.mass[i,j] = mass[i,j];
            }
 	    }
 	}
    public void show() {
        Console.WriteLine("\n[-] Massive show: \n");
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                Console.Write(mass[i,j]+" ");
            }
            Console.WriteLine("");
 	    }
    }
    public void matrixPlus(double[,] array) {
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                mass[i,j] += array[i,j];
            }
 	    }
    }
    public void matrixMinus(double[,] array) {
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                mass[i,j] -= array[i,j];
            }
 	    }
    }
    public void numberPlus(double number) {
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                mass[i,j] += number;
            }
 	    }
    }
    public void numberMinus(double number) {
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                mass[i,j] -= number;
            }
 	    }
    }
    public void equal(double[,] array) {
        int count = 0;
        int flag = 0;
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                if(array[i,j]!=mass[i,j]){
                    Console.WriteLine("[-] Матрицы не равны");
                    flag = 1;
                    break;
                }
                count++;
            }
            if(flag == 1) break;
 	    }
 	    if(count == 9) {
 	        Console.WriteLine("[-] Матрицы равны");
 	    }
    }
    public double getElement(int i, int j) {
        return mass[i,j];
    }
    public void transp() {
        double e;
        for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                if(i>j){
                e = mass[i,j];
                mass[i,j] = mass[j,i];
                mass[j,i] = e;
                }
            }
        }
    }
    public void reverse() {
        double det;
        double [,] minor = new double [3,3];
        det = mass[0,0]*mass[1,1]*mass[2,2] + mass[2,0]*mass[0,2]*mass[1,2] + mass[1,0]*mass[2,1]*mass[0,2] - mass[2,0]*mass[1,1]*mass[0,2] - mass[1,0]*mass[0,1]*mass[2,2] - mass[0,0]*mass[1,2]*mass[2,1];
        if(det!=0) {
            minor[0,0]=mass[1,1]*mass[2,2] - mass[2,1]*mass[1,2];
            minor[0,1]=mass[1,0]*mass[2,2] - mass[1,2]*mass[2,0];
            minor[0,2]=mass[1,0]*mass[2,1] - mass[1,1]*mass[2,0];
            minor[1,0]=mass[0,1]*mass[2,2] - mass[0,2]*mass[2,1];
            minor[1,1]=mass[0,0]*mass[2,2] - mass[0,2]*mass[2,0];
            minor[1,2]=mass[0,0]*mass[2,1] - mass[0,1]*mass[2,0];
            minor[2,0]=mass[0,1]*mass[1,2] - mass[1,1]*mass[0,2];
            minor[2,1]=mass[0,0]*mass[1,2] - mass[0,2]*mass[1,0];
            minor[2,2]=mass[0,0]*mass[1,1] - mass[0,1]*mass[1,0];
            for(int i=0;i<3; i++) {
                for(int j=0;j<3;j++){
                    mass[i,j]=minor[i,j];
                }
            }
            if(mass[0,1]>0){
            mass[0,1] = 0-mass[0,1];
            } else mass[0,1] = Math.Abs(mass[0,1]);
            
            if(mass[1,0]>0){
            mass[1,0] = 0-mass[1,0];
            } else mass[1,0] = Math.Abs(mass[1,0]);
            
            if(mass[1,2]>0){
            mass[1,2] = 0-mass[1,2];
            } else mass[1,2] = Math.Abs(mass[1,2]);

            if(mass[2,1]>0){
            mass[2,1] = 0-mass[2,1];
            } else mass[2,1] = Math.Abs(mass[2,1]);
            transp();
            for(int i=0;i<3; i++) {
                for(int j=0;j<3;j++){
                    mass[i,j]=1/det*mass[i,j];
                }
            }
        }
        else Console.WriteLine("[-] Нет обратной матрицы");
    }
} 
	class program {
	    static void Main() {
	    Random rand = new Random();
	    
	    double[,] arr1 = new double[3,3];
	    double[,] arr2 = new double[3,3];
	    for(int i=0;i<3; i++) {
            for(int j=0;j<3;j++){
                arr1[i,j] = rand.Next(1,99);
                arr2[i,j] = rand.Next(1,99);
            }
 	    }
		matrix m1 = new matrix(arr1);
		m1.show();
		m1.matrixPlus(arr2);
		m1.show();
		m1.equal(arr2);
		double el = m1.getElement(2,1);
		Console.WriteLine("[-] Element: " + el);
		m1.transp();
		m1.show();
		matrix m2 = new matrix(arr2);
		m2.show();
		m2.reverse();
		m2.show();
	}
}
}