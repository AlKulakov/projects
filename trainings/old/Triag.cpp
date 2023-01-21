#include <iostream>
#include <string.h>
using namespace std;
class treug {
public:
	int Ax, Ay, Bx, By, Bx, By, Cx, Cy;
	treug(int Mx, int My, int Nx, int Ny, int Kx, int Ky) {
	/*
	DOCSTRING: Конструктор класса, принимающий на вход координаты вершин треугольника
	INPUT: Нет
	OUTPUT: Нет
	*/
		Ax = Mx;
		Ay = My;
		Bx = Nx;
		By = Ny;
		Cx = Kx;
		Cy = Ky;
	}
	double AB = sqrt(pow((Bx - Ax), 2) + pow((By - Ay), 2));
	double BC = sqrt(pow((Cx - Bx), 2) + pow((Cy - By), 2));
	double AC = sqrt(pow((Cx - Ax), 2) + pow((Cy - Ay), 2));
	double per() {
	/*
	DOCSTRING: Подсчет периметра треугольника
	INPUT: Нет
	OUTPUT: Периметр [per]
	*/
		double per = AB + BC + AC;
		return per;
	}
	double sqr() {
	/*
	DOCSTRING: Подсчет площади треугольника
	INPUT: Нет
	OUTPUT: Площадь [sqr]
	*/
		double p = per(AB, BC, AC) / 2;
		double sqr = sqrt(p * (p - AB) * (p - BC) * (p - AC));
		return sqr;
	}
	double high() {
	/*
	DOCSTRING: Подсчет высот треугольника
	INPUT: Нет
	OUTPUT: Высоты треугольника [h1], [h2], [h3]
	*/
		double h1, h2, h3;
		h1 = 2 * sqr(AB, BC, AC) / AB;
		h2 = 2 * sqr(AB, BC, AC) / BC;
		h3 = 2 * sqr(AB, BC, AC) / AC;
		return h1, h2, h3;
	}
	double med() {
	/*
	DOCSTRING: Подсчет медиан треугольника
	INPUT: Нет
	OUTPUT: медианы треугольника [m1], [m2], [m3]
	*/
		double m1, m2, m3;
		m1 = sqrt(2 * pow(AB, 2) + 2 * pow(BC, 2) - pow(AC, 2)) / 2;
		m2 = sqrt(2 * pow(AB, 2) + 2 * pow(AC, 2) - pow(BC, 2)) / 2;
		m3 = sqrt(2 * pow(BC, 2) + 2 * pow(AC, 2) - pow(AB, 2)) / 2;
		return m1, m2, m3;
	}
	double bis() {
	/*
	DOCSTRING: Подсчет биссектрис треугольника
	INPUT: Нет
	OUTPUT: Биссектрисы треугольника [b1], [b2], [b3]
	*/
		double b1, b2, b3;
		b1 = sqrt(AB * BC * (AB + BC + AC) * (AB + BC - AC)) / (AB + BC);
		b2 = sqrt(AB * AC * (AB + BC + AC) * (AB + AC - BC)) / (AB + AC);
		b3 = sqrt(AC * BC * (AB + BC + AC) * (AC + BC - AB)) / (AC + BC);
		return b1, b2, b3;
	}
	double rad() {
	/*
	DOCSTRING: Подсчет радиусов окружностей треугольника
	INPUT: Нет
	OUTPUT: Радиусы внешней и внутренней окружностей [r1], [r2]
	*/
		double r1, r2;
		double p = per(AB, BC, AC) / 2;
		r1 = sqrt(sqr(AB, BC, AC) / p);
		r2 = AB * BC * AC / 4 * sqrt(p * (p - AB) * (p - BC) * (p - AC));
		return r1, r2;
	}
	void type() {
	/*
	DOCSTRING: Принадлежность треугольника треугольника
	INPUT: Нет
	OUTPUT: Нет
	*/
		int A[2];
		if (AB == BC == AC) {
			cout << "Равносторонний ";
		}
		if (AB == BC || AB == AC || AC == BC) {
			cout << "Равнобедренный ";
		}
		if (pow(AB, 2) == pow(BC, 2) + pow(AC, 2) || pow(AC, 2) == pow(AB, 2) + pow(BC, 2) || pow(BC, 2) == pow(AB, 2) + pow(AC, 2)) {
			cout << "Прямоугольный ";
		}
		if (pow(AB, 2) > pow(BC, 2) + pow(AC, 2) || pow(AC, 2) > pow(AB, 2) + pow(BC, 2) || pow(BC, 2) > pow(AB, 2) + pow(AC, 2)) {
			cout << "Тупоугольный ";
		}
		if (pow(AB, 2) < pow(BC, 2) + pow(AC, 2) || pow(AC, 2) < pow(AB, 2) + pow(BC, 2) || pow(BC, 2) < pow(AB, 2) + pow(AC, 2)) {
			cout << "Остроугольный ";
		}
	}
	void povorotA(int ugol) {
	/*
	DOCSTRING: Поворот треугольника вокруг вершины A
	INPUT: Нет
	OUTPUT: Нет
	*/
		Bx = (Bx - Ax) * cos(ugol) - (By - Ay) * sin(ugol) + Ax;
		By = (Bx - Ax) * sin(ugol) + (By - Ay) * cos(ugol) + Ay;
		Cx = (Cx - Ax) * cos(ugol) - (Cy - Ay) * sin(ugol) + Ax;
		Cy = (Cx - Ax) * sin(ugol) + (Cy - Ay) * cos(ugol) + Ay;
		cout << "[-] Новые координаты вершин B, C : \n" << "B: (" << Bx << "," << By << ")\n" << "C: (" << Cx << "," << Cy << ")\n";
	}
	void povorotB(int ugol) {
	/*
	DOCSTRING: Поворот треугольника вокруг вершины B
	INPUT: Нет
	OUTPUT: Нет
	*/
		Ax = (Ax - Bx) * cos(ugol) - (Ay - By) * sin(ugol) + Bx;
		Ay = (Ax - Bx) * sin(ugol) + (Ay - By) * cos(ugol) + By;
		Cx = (Cx - Bx) * cos(ugol) - (Cy - By) * sin(ugol) + Bx;
		Cy = (Cx - Bx) * sin(ugol) + (Cy - By) * cos(ugol) + By;
		cout << "[-] Новые координаты вершин A, C : \n" << "B: (" << Ax << "," << Ay << ")\n" << "C: (" << Cx << "," << Cy << ")\n";
	}
	void povorotC(int ugol) {
	/*
	DOCSTRING: Поворот треугольника вокруг вершины C
	INPUT: Нет
	OUTPUT: Нет
	*/
		Ax = (Ax - Cx) * cos(ugol) - (Ay - Cy) * sin(ugol) + Cx;
		Ay = (Ax - Cx) * sin(ugol) + (Ay - Cy) * cos(ugol) + Cy;
		Bx = (Bx - Cx) * cos(ugol) - (By - Cy) * sin(ugol) + Cx;
		By = (Bx - Cx) * sin(ugol) + (By - Cy) * cos(ugol) + Cy;
		cout << "[-] Новые координаты вершин A, B : \n" << "A: (" << Ax << "," << Ay << ")\n" << "B: (" << Bx << "," << By << ")\n";
	}
	void povorotOkr(int ugol) {
	/*
	DOCSTRING: Поворот треугольника по окружности
	INPUT: Нет
	OUTPUT: Нет
	*/
		double Ox, Oy, D;
		D = 2 * (Ax * (By - Cy) + Bx * (Cy - Ay) + Cx * (Ay - By));
		Ox = ((pow(Ax, 2) + pow(Ay, 2)) * (By - Cy) + (pow(Bx, 2) + pow(By, 2)) * (Cy - Ay) + (pow(Cx, 2) + pow(Cy, 2)) * (Ay - By)) / D;
		Oy = ((pow(Ax, 2) + pow(Ay, 2)) * (Cx - Bx) + (pow(Bx, 2) + pow(By, 2)) * (Ax - Cx) + (pow(Cx, 2) + pow(Cy, 2) * (Bx - Ax)) / D;
		Ax = (Ax - Ox) * cos(ugol) - (Ay - Oy) * sin(ugol) + Ox;
		Ay = (Ax - Ox) * sin(ugol) + (Ay - Oy) * cos(ugol) + Oy;
		Bx = (Bx - Ox) * cos(ugol) - (By - Oy) * sin(ugol) + Ox;
		By = (Bx - Ox) * sin(ugol) + (By - Oy) * cos(ugol) + Oy;
		Cx = (Cx - Ox) * cos(ugol) - (Cy - Oy) * sin(ugol) + Ox;
		Cy = (Cx - Ox) * sin(ugol) + (Cy - Oy) * cos(ugol) + Oy;
		cout << "[-] Новые координаты вершин A, C : \n" << "A: (" << Ax << "," << Ay << ")\n" << "B: (" << Bx << "," << By << ")\n" << "C: (" << Cx << ", " << Cy << ")\n";
	}
};
int main()
{
	/*
	DOCSTRING: Главный метод main, треугольники и их координаты
	INPUT: Нет
	OUTPUT: 0
	*/
	treug A(1, 2, 3, 5, 2, 5);
	cout << per();
	cout << sqr();
	cout << high();
	cout << med();
	cout << bis();
	cout << rad();
	type();
	povorotA(42);
	povorotB(23);
	povorotC(53);
	povorotOkr(61);
	return 0;
}