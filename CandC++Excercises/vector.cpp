#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
class furniture {
protected:
	int nom_num;
	string furn_name;
	int price;
public:
	furniture(int nom_num, string furn_name, int price) {
	/*
	DOCSTRING: Конструктор класса мебели
	INPUT: Ном. номер, имя мебели, цена изделия
	OUTPUT: Нет
	*/
		this->nom_num = nom_num;
		this->furn_name = furn_name;
		this->price = price;
	}
	int getNomNum() {
	/*
	DOCSTRING: Получить номенкулатурный номер
	INPUT: Нет
	OUTPUT: Номеркулатурный номер
	*/
		return nom_num;
	}
	string getFurnName() {
	/*
	DOCSTRING: Получить название мебели
	INPUT: Нет
	OUTPUT: Название мебели
	*/
		return furn_name;
	}
	int getPrice() {
	/*
	DOCSTRING: Получить цену изделия
	INPUT: Нет
	OUTPUT: Цена изделия
	*/
		return price;
	}
	void show() {
	/*
	DOCSTRING: Вывод информации
	INPUT: Нет
	OUTPUT: Нет
	*/
		cout << "[-] " << nom_num << "\t" << furn_name << "\t" << price << "\n";
	}
};
bool compareFunction1(furniture& a, furniture& b) { 
	/*
	DOCSTRING: Сравнение цены изделий
	INPUT: Изделия [a] и [b]
	OUTPUT: Результат сравнения цены
	*/
	return a.getPrice() < b.getPrice(); 
}
bool compareFunction2(furniture& a, furniture& b) { 
	/*
	DOCSTRING: Сравнение имени изделий
	INPUT: Изделия [a] и [b]
	OUTPUT: Результат сравнения имен
	*/
return a.getFurnName() < b.getFurnName(); 
}
int main() {
	/*
	DOCSTRING: Главный метод main, создание векторов и сортировка информации
	INPUT: Нет
	OUTPUT: 0
	*/
	setlocale(LC_ALL, "Russian");
	vector<furniture>obj1;
	vector<furniture>obj2;
	vector<furniture>obj;
	furniture table1[] = {
			 furniture(101, "Стол компьютерный", 3500),
			 furniture(102, "Доска ученическая", 5000),
			 furniture(103, "Горшок с цветком", 700)
	};
	furniture table2[] = {
			 furniture(104, "Стул\t\t", 1200),
			 furniture(107, "Компьютер\t", 21000),
			 furniture(108, "Настольная лампа", 800)
	};
	for (int i = 0; i < 3; i++) {
		obj1.push_back(table1[i]);
		obj2.push_back(table2[i]);
	}
	copy(obj1.begin(), obj1.end(), std::back_inserter(obj));
	copy(obj2.begin(), obj2.end(), std::back_inserter(obj));
	std::sort(obj.begin(), obj.end(), compareFunction2);
	std::sort(obj.begin(), obj.end(), compareFunction1);
	for (auto it = obj.begin(); it != obj.end(); ++it)
	{
		it->show();
	}

	return 0;
}