public class Player {
	int number = 0;
	public void guess() {
	/*
	DOCSTRING: Угадывания
	INPUT: Нет
	OUTPUT: Нет
	*/
		number = (int) (Math.random() * 10);
		System.out.println("I think number is "+ number);
	}
}
