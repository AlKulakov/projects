#include <stdio.h>
#include <stdlib.h>   
#include <math.h>
double func(int c, int d, double x) {
    double result;
    result = pow(x,3) + c*pow(x,2)+ d;
    return result;
}
double func1(int c, int d, double x) {
    double result;
    result = 3*pow(x,2)+c*2*x;
    return result;
}
int main() {
double x,a,b,j;
int i=0, c,d;
printf("Print c,d:\n");
scanf("%d%d",&c,&d);
printf("Print x0:\n");
scanf("%lf", &a);
printf("accuracy: \n");
scanf("%lf", &j);
do {
x=a-func(c,d,a)/func1(c,d,a);
a=x;
i++;
} while(fabs(func(c,d,x))>j);
printf("iterations: %d, x: %.10f result: %.10f\n", i, x, func(c,d,x));
return 0;
}