#include <stdio.h>
#include <stdlib.h>   
#include <math.h>
double func(int c, int d, double x) {
	/*
	DOCSTRING: Решение первого уравнения
	INPUT: Переменные [c],[d], [x]
	OUTPUT: Результат
	*/
    double result;
    result = pow(x,4) + c*pow(x,3) - d*x;
    return result;
}
double func1(int c, int d, double x) {
	/*
	DOCSTRING: Решение второго уравнения
	INPUT: Переменные [c],[d], [x]
	OUTPUT: Результат
	*/
    double result;
    result = 4*pow(x,3)+c*3*pow(x,2)-d;
    return result;
}
int main() {
	/*
	DOCSTRING: Главный метод main
	INPUT: Нет
	OUTPUT: 0
	*/
double x,a,b,eps;
int i=0, c,d;
printf("[+] Print c,d:\n");
scanf("%d%d",&c,&d);
printf("[+] Print x0:\n");
scanf("%lf", &a);
printf("[+] Accuracy: \n");
scanf("%lf", &eps);
do {
x=a-func(c,d,a)/func1(c,d,a);
a=x;
i++;
} while(fabs(func(c,d,x))>eps);
printf("[-] Iterations: %d, x: %.10f result: %.10f\n", i, x, func(c,d,x));
return 0;
}