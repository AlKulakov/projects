
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class Main {
    static public int get_number() {
    /*
    DOCSTRING: Получение числа в консоли
    INPUT: Нет
    OUTPUT: Число оценок
    */
        int N;
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число оценок: ");
            try {
                N = scanner.nextInt();
            }
            catch(Exception e){
                System.out.println("Неправильный ввод, попробуйте снова!");
                continue;
            }
            break;
        }
        return N;
    }
    public static void grad_fill(int graduates[], int N){
        /*
    DOCSTRING: Заполнение и вывод оценок
    INPUT: Массив и число оценок
    OUTPUT: Нет
    */
        for(int i = 0; i < N; i++){
            graduates[i] = ThreadLocalRandom.current().nextInt(2,6);
            System.out.print(graduates[i]);
        }
        System.out.println("");
    }
    public static float average_grad(int graduates[]){
    /*
    DOCSTRING: Получение среднего балла
    INPUT: Массив оценок
    OUTPUT: Средний балл
    */
        float sum = 0;
        for(int i : graduates){
            sum+=i;
        }
        return sum/graduates.length;
    }

    public static void main(String[] args) {
    /*
    DOCSTRING: Главный метод main
    INPUT: args
    OUTPUT: Нет
    */
        int N = get_number();
        int graduates[] = new int[N];
        grad_fill(graduates, N);
        System.out.println("Средний балл: " + average_grad(graduates));
    }
}