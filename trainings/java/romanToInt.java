public class Main
{
    public static final char[] chars = {
        'I', 'V', 'X', 'L', 'C', 'D', 'M'
    };
    public static final int[] vals = {
        1, 5, 10, 50, 100, 500, 1000
    };
    /**
     * Функция main
     * @param args
     */
	public static void main(String[] args) {
	    int result = romanToInt("MCMXCIV");
	    if(result!=-1)
		    System.out.println("Арабское число: " + result);
		else {
		    System.out.println("Ошибка ввода!");
		}
	}
	
	/**
     * Функция перевода из римских чисел в арабские
     * @param s Римское число в виде строки
     * @return Арабское число
     */
	public static int romanToInt(String s) {
        char[] values = s.toCharArray();
        int result = 0;
        if(values.length==1){
            return values[0];
        }
        if(checkRomanSymbols(values))
        for(int i = 0; i < values.length; i++){
            try {
                
            
            if(findCharsIndex(values[i])<findCharsIndex(values[i+1])) {
                result-=vals[findCharsIndex(values[i])];
            }
            else
                result+=vals[findCharsIndex(values[i])];
            } catch(Exception e) {
                result+=vals[findCharsIndex(values[i])];
                
            }
        } else result=-1;
        return result;
    }
    /**
     * Находит индекс символа
     * @param c Символ в виде римской цифры
     * @return номер индекса в массиве chars[]
     */
    public static int findCharsIndex(char c){
        int result=-1; 
        for(int i = 0; i < chars.length; i++){
            if(chars[i]==c)
                result = i;
        }
        return result;
    }
    /**
     * Проверка валидности риского числа
     * @param c Массив символов римского числа
     * @return Булевый результат о валидности числа
     */
    public static boolean checkRomanSymbols(char[] c) {
        for(char ch : c){
            if(findCharsIndex(ch)==-1){
                return false;
            }
        }
        return true;
    }
}