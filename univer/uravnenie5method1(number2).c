#include <stdio.h>
#include <math.h>
#include <stdlib.h>
double func(int c, int d, double x) {
	/*
	DOCSTRING: Решение уравнения
	INPUT: Переменные [c],[d], [x]
	OUTPUT: Результат
	*/
    double result;
    result = pow(x,4) + c*pow(x,3) - d*x;
    return result;
}
int main() {
	/*
	DOCSTRING: Главный метод main
	INPUT: Нет
	OUTPUT: 0
	*/
    int c,d,i=0;
    double a, b, x, result, h, m,n,e,eps;
    printf("[+] Print c, d\n");
    scanf("%d%d", &c, &d);
    do{
    printf("[+] Print  a,b\n");
    scanf("%lf%lf", &a, &b);
    m=func(c,d,a);
    n=func(c,d,b);
    if((m>0 && n<0) || (m<0 && n>0)) {
            printf("[+] Accuracy: ");
            scanf("%lf", &eps);
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
            } while(fabs(func(c,d,h))>eps) ;
        printf("[-] Iterations: %d, result: %.20f\n", i, func(c,d,h));
        break;
    }
    else {
        printf("[-] Iterations: %d, x: %.10f, result: %.10f\n", i, h, func(c,d,h));
        continue;
    }
    }
    while (m!=0 || n!=0);
    return 0;
}