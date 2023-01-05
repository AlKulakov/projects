import java.util.*;


public class Geometry {
	/*
	 * DOCSTRING: Функция main
	 * INPUT: Нет
	 * OUTPUT: Нет
	 * */
	public static void main(String[] args) {
		launch();
	}
	public static void launch() {
		/*
		 * DOCSTRING: Функция, запускающая операции
		 * INPUT: Нет
		 * OUTPUT: Нет
		 * */ //Хранит массив из двух чисел типа double для x и y
		Point p1 = new Point(), p2 = new Point();

		p1.setCoords("первой");
		p2.setCoords("второй");
		
		if (p1.pointEqualityTo(p2)) {
			System.out.println("Точки равны");
		}
		else {
			
			System.out.println("Первая точка: " + p1);
			System.out.println("Вторая точка: " + p2);
			System.out.println("Длина прямой: " + p1.distanceTo(p2));
		}
	}
}
class Point {
	
	double x;
	double y;
	int count = 1;
	
	public Point() {
		/*
		 * DOCSTRING: Функция, реализующая конструктор 1
		 * INPUT: Нет
		 * OUTPUT: Нет
		 * */
		x = 0; x= 0;
	}
	public Point(double x, double y) {
		/*
		 * DOCSTRING: Функция, реализующая конструктор 2
		 * INPUT: x, y
		 * OUTPUT: Нет
		 * */
		this.x = x;
		this.y = y;
	}
	
	
	double distanceTo(Point point) {
		/*
		 * DOCSTRING: Функция, осуществляющая рассчет расстояния до точки
		 * INPUT: Точка
		 * OUTPUT: Расстояние до точки
		 * */
		return Math.sqrt(Math.pow(this.x - point.x, 2) + Math.pow(this.y - point.y, 2));
	}
	void setCoords(String number) {
		/*
		 * DOCSTRING: Функция, осуществляющая ввод пользователем координат в консоль
		 * INPUT: Строка с номером точки
		 * OUTPUT: Массив из 2 чисел типа double, содержащий координаты x y
		 * */
		while (true) {
			try {
				System.out.print("Напечатайте координаты " + number + " точки в виде x y: ");
				Scanner scanner = new Scanner(System.in);
				this.x = scanner.nextDouble();
				this.y = scanner.nextDouble();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Error! " + e.getMessage());
				continue;
			}
			catch(NoSuchElementException e) {
				System.out.println("Error! " + e.getMessage());
				continue;
			}
			catch(IllegalStateException e) {
				System.out.println("Error! " + e.getMessage());
				continue;
			}
		}
	}
	boolean pointEqualityTo(Point point) {
		/*
		 * DOCSTRING: Функция, проверяющая равенство одной точки к другой
		 * INPUT: Точка
		 * OUTPUT: Булевое значение равенства
		 * */
		return this.x == point.x && this.y == point.y;
	}
	@Override
	public String toString() {
		/*
		 * DOCSTRING: Функция, возвращающая координаты точки
		 * INPUT: Нет
		 * OUTPUT: Координаты точки в виде (x, y)
		 * */
		return "(" + this.x + ", " + this.y + ")";
	}
}