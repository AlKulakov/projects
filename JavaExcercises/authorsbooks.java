class authors {
	String authorcode;
	String fio;
	static String title;
	static void setTitle (String s) { title = s; }
	authors (String s) {
	/*
	DOCSTRING: Конструктор класса авторов
	INPUT: Название
	OUTPUT: Нет
	*/
		String r[] = s.split(", ");
		authorcode = r[0];
		fio = r[1];
	} @Override
	public String toString() {
		/*
	DOCSTRING: Приведение к строке
	INPUT: Нет
	OUTPUT: Возвращает строки с авторами
	*/
		String r[] = title.split(", ");
		return "| "+r[0]+" | "+r[1]+"|";
	}
	public static void show (authors s[]) {
		/*
		DOCSTRING: Вывод информации об авторах в консоль
		INPUT: Ввод авторов в виде элемента массива [s[]]
		OUTPUT: Нет
		*/
		System.out.println (s[0]);
		for (authors p: s){
			System.out.format("| %-3s | %-22s |\n",
			p.authorcode, p.fio);
		}
	}
}
class books {
	String ISBN;
	String authorcode;
	String bookname;
	int cost;
	static String title;
	static void setTitle (String s) { title = s; }
	books (String s) {
		/*
		DOCSTRING: Конструктор класса Книги
		INPUT: строка с информацией s
		OUTPUT: Нет
		*/
		String r[] = s.split(", ");
		ISBN = r[0];
		authorcode = r[1];
		bookname = r[2];
		cost = Integer.parseInt(r[3]);
	} @Override
	public String toString() {
		/*
		DOCSTRING: Приведение к строке
		INPUT: Нет
		OUTPUT: Данные в виде табличной строки
		*/
		String r[] = title.split(", ");
		return "| " + r[0] + " | " + r[1] + " | " + r[2] + " | " + r[3] + " |";
	}
	public static void show (books s[]) {
	/*
	DOCSTRING: Вывод информации на экран
	INPUT: Ввод данных книги в виде элемента массива
	OUTPUT: Нет
	*/
		System.out.println (s[0]);
		for (books k: s) {
			System.out.format ("| %15s | %3s | %-21s | %5d |\n",
			k.ISBN,
			k.authorcode,
			k.bookname,
			k.cost);
		}
	}
}
public class Main {
	public static void main(String[] args) {
		/*
		DOCSTRING: Главный метод main
		INPUT: Аргументы
		OUTPUT: Нет
		*/
		String[] author={
			"01, Иванов Сергей Степанович",
			"02, Сидорова Ольга Юрьевна",
			"03, Петров Иван Петрович"
			};
		String[] book={
			"978-5-388-00003, 01, Самоучитель JAVA, 300",
			"978-5-699-58103, 02, JAVA за 21 день, 600",
			"758-3-004-87105, 03, Сопромат, 350",
			"758-3-057-37854, 01, Механика, 780",
			"675-3-423-00375, 03, Физика, 450"
		};
		authors.setTitle(author[0]);
		authors WS[] = new authors[author.length-1];
		for (int i = 0; i < WS.length; i++)
			WS[i] = new authors (author[i+1]);
		authors.show(WS);
		books.setTitle (book[0]);
		books KL[] = new books[book.length-1];
		for (int i=0; i<KL.length; i++)
			KL[i] = new books(book[i+1]);
		books.show(KL);
	}
}
