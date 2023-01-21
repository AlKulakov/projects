#include <stdio.h>
#include <math.h>
#include <stdlib.h>
double func(int c, int d, double x) {
	/*
	DOCSTRING: Решение уравнения
	INPUT: Переменные c,d, x
	OUTPUT: Результат [result]
	*/
    double result;
    result = log2(c*x) - d;
    return result;
}
int main() {
	/*
	DOCSTRING: Главный метод main
	INPUT: Нет
	OUTPUT: 0
	*/
    int c,d,i=0;
    double a, b, x, result, h, m,n,e,s;
    printf("[+] Print c, d\n");
    scanf("%d%d", &c, &d);
    do{
    printf("[+] rint  a,b\n");
    scanf("%lf%lf", &a, &b);
    m=func(c,d,a);
    n=func(c,d,b);
    if((m>0 && n<0) || (m<0 && n>0)) {
            printf("[+] ccuracy: ");
            scanf("%lf", &s);
            do{
            h=(a+b)/2;
            e=func(c,d,h);
            if((e>0 && n>0) || (e<0 && n<0)) {
                b=h;
            }
            else if((e<0 && m<0) || (e>0 && m>0)) {
                a=h;
            }
            i++;
            } while(fabs(func(c,d,h))>s) ;
        printf("[-] Iterations: %d, x: %.10f, result: %.10f\n", i, h, func(c,d,h));
        break;
    }
    else {
        printf("[-] Your function results in a,b have same sign, try again\n");
        continue;
    }
    }
    while (m!=0 || n!=0);
    return 0;
}