#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h> 
#include <stdlib.h> 
#define SIZE 6

int main()
{
	system("chcp 1251");
	system("cls");
	int a[SIZE][SIZE] = { {0, 9, 1, 5, 10, 9},
			      {7, 0, 9, 7, 9, 4},
			      {4, 10, 0, 4, 8, 6},
			      {5, 0, 9, 0, 2, 7},	
			      {4, 0, 10, 5, 0, 0},	
			      {10, 2, 5, 2, 3, 0}};
	int d[SIZE];
	int v[SIZE];
	int tmp, minindex, min;
	int begin_index = 0;
	for (int i = 0; i < SIZE; i++)
	{
		a[i][i] = 0;
		for (int j = i + 1; j < SIZE; j++) {
			printf("[+] Введите расстояние %d - %d: ", i + 1, j + 1);
			scanf("%d", &temp);
			a[i][j] = tmp;
			a[j][i] = tmp;
		}
	}
	for (int i = 0; i < SIZE; i++)
	{
		for (int j = 0; j < SIZE; j++)
			printf("%5d ", a[i][j]);
		printf("\n");
	}
	for (int i = 0; i < SIZE; i++)
	{
		d[i] = 10000;
		v[i] = 1;
	}
	d[begin_index] = 0;
	do
	{
		minindex = 10000;
		min = 10000;
		for (int i = 0; i < SIZE; i++)
		{
			if ((v[i] == 1) && (d[i] < min))
			{
				min = d[i];
				minindex = i;
			}
		}
		if (minindex != 10000)
		{
			for (int i = 0; i < SIZE; i++)
			{
				if (a[minindex][i] > 0)
				{
					tmp = min + a[minindex][i];
					if (tmp < d[i])
					{
						d[i] = temp;
					}
				}
			}
			v[minindex] = 0;
		}
	} while (minindex < 10000);
	printf("\n[-] Кратчайшие расстояния до вершин: \n");
	for (int i = 0; i < SIZE; i++)
		printf("%5d ", d[i]);
	int ver[SIZE];
	int end = 5;
	ver[0] = end + 1;
	int k = 1;
	int weight = d[end];

	while (end != begin_index)
	{
		for (int i = 0; i < SIZE; i++)
		{
			if (a[i][end] != 0)
			{
				int tmp = weight - a[i][end];
				if (tmp == d[i])
				{
					weight = tmp;
					end = i;
					ver[k] = i + 1;
					k++;
				}
			}
		}
	}
	printf("\n[-] Вывод кратчайшего пути\n");
	for (int i = k - 1; i >= 0; i--)
		printf("%3d", ver[i]);
	getchar(); getchar();
	return 0;
}
