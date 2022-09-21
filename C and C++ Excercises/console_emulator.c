#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void command10(char *[],int);
void command11(char *[],int);
int command30(char *[], char *, int i);
int command31(char *[], char *, int i);
int command32(char *[], char *, int i);
typedef struct {
    int A[100];
} opers;
typedef struct {
    char *word;
    opers ops;
}accum;
int main() {
    FILE *log;
    log=fopen("log.txt", "a+");
    printf("Добро пожаловать!\n Это эмулятор комьютера, созданный на языке C. \n ");
    char *ram[10]; 
    char command2[30];
    int i=0,j,k,a=0,b,u=0, o;
    int command;
    for(k=0;k<10;k++)
        ram[k]=(char*)malloc(15*sizeof(int));
    accum acc = {"",{}};
    acc.word = malloc(20);
    while(command/100!=43 && u<10 && a<100 && i<10){
        printf("cmd:>");
        scanf("%s", command2);
        command=atoi(command2);
        if(command/100==10) {
            command10(ram,i);
            i++;
            u++;
        }
        else if(command/100==11) {
            command11(ram,u);
        }
        else if(command/100==43) {
            printf("exit!\n");
        }
        else if(command/100==20) {
            printf("word memory cell number: ");
            scanf("%d",&j);
            strcpy(acc.word, ram[j]);
            printf("done!\n");
        }
        else if(command/100==21) {
            printf("word memory cell number: ");
            scanf("%d",&j);
            strcpy(ram[j], acc.word);
            printf("done!\n");
        }
        else if(command/100==22) {
            printf("accumulator word: %s\n", acc.word);
        }
        else if(command/100==30) {
            printf("word cell number: ");
            scanf("%d", &j);
            printf("word's sum: %d\n", command30(ram,acc.word,j));
            acc.ops.A[a]=command30(ram,acc.word,j);
            a++;
        }
        else if(command/100==31) {
            printf("word cell number: ");
            scanf("%d", &j);
            printf("word's diff: %d\n", command31(ram,acc.word,j));
            acc.ops.A[a]=command31(ram,acc.word,j);
            a++;
        }
        else if(command/100==32) {
            printf("word cell number: ");
            scanf("%d", &j);
            if(j>u) {
                printf("Error!\n");
                continue;
            }
            printf("word's div: %d\n", command32(ram,acc.word,j));
            acc.ops.A[a]=command32(ram,acc.word,j);
            a++;
        }
        else if(command/100==40) {
            printf("word memory cell: ");
            scanf("%d", &o);
            if(o<10) {
                i=o;
            }
        }
        else if(command/100==41) {
            for(b=0;b<a;b++) {
                if(acc.ops.A[b]<0) {
                    printf("word memory cell: ");
                scanf("%d", &o);
                    if(o<10) {
                        i=o;
                    }
                }
            }
        }
        else if(command/100==42) {
            for(b=0;b<a;b++) {
                if(acc.ops.A[b]==0) {
                    printf("word memory cell: ");
                scanf("%d", &o);
                    if(o<10) {
                        i=o;
                    }
                }
            }
        }
        else {
            printf("wrong command!\n"); 
        }
        fprintf(log, "command: %d\n", command);
    }
    printf("accumulator results:\n");
    for(b=0;b<a;b++) {
        printf("%d,", acc.ops.A[b]);
    }
    printf("\n");
    free(acc.word);
    fclose(log);
    return 0;
}
void command10(char *ram[], int i) {
    printf("memory cell %d word:",i);
    scanf("%s", ram[i]);
}
void command11(char *ram[], int i) {
    int j;
    printf("memory cell number: ");
    scanf("%d", &j);
    printf("memory cell %d word:  %s\n",j, ram[j]);
}
int command30(char *ram[], char *acc, int i) {
    int sum= *ram[i] + *acc;
    return sum;
}
int command31(char *ram[], char *acc, int i) {
    int razn= *acc - *ram[i];
    return razn;
}
int command32(char *ram[], char *acc, int i) {
    int div= *acc / *ram[i];
    return div;
}
