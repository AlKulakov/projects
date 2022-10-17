import java.text.*;
import java.util.Date;
import java.util.Calendar;
class dat {
    int day;
    int month;
    int year;
    static String title;
    static void setTitle (String s) { title = s; }
    dat (String s) {
	/*
	DOCSTRING: Конструктор класса даты
	INPUT: Дата [s]
	OUTPUT: Нет
	*/
        String r[] = s.split("-");
        for(int i = 0; i < r.length; i++) {
            char charAtZero = r[i].charAt(0);
            if(charAtZero=='0') {
                r[i]=r[i].substring(1);
            }
        }
        day = Integer.parseInt(r[0]);
        month = Integer.parseInt(r[1]);
        year = Integer.parseInt(r[2]);
    }
    public void raznost(dat raz) {
	/*
	DOCSTRING: Разность дат
	INPUT: Дата
	OUTPUT: Нет
	*/
        int razd = day-raz.day;
        int razm = month-raz.month;
        int razy = year-raz.year;
        System.out.println("[-] Разность дат:" + razd + "-" + razm + "-" + razy);
    }
    public void sumday(int plusday) {
	/*
	DOCSTRING: Прибавить дни
	INPUT: Дни
	OUTPUT: Нет
	*/
        int sday = day+plusday;
        int mmonth=month;
        int yyear=year;
        if(sday > 31){
            mmonth=mmonth+sday/31;
            sday=sday%31;
            if(sday==0){
                sday++;
            }
            if(mmonth > 12){
                yyear=yyear+mmonth/12;
                mmonth=mmonth%12;
                if(mmonth==0){
                mmonth++;
            }
            }
        }
        System.out.println("[-] Результат сложения дней: " + sday + "-" + mmonth + "-" + yyear);
    }
    public void summonth(int plusmonth) {
	/*
	DOCSTRING: Прибавить месяцы
	INPUT: Месяцы
	OUTPUT: Нет
	*/
        int smonth=month+plusmonth;
        int yyear=year;
            if(smonth > 12){
                yyear=yyear+smonth/12;
                smonth=smonth%12;
                if(smonth==0){
                smonth++;
            }
        }
        System.out.println("[-] Результат сложения месяцев: " + day + "-" + smonth + "-" + yyear);
    }
    public void sumyear(int plusyear) {
	/*
	DOCSTRING: Прибавить года
	INPUT: Года
	OUTPUT: Нет
	*/
        int yyear=year+plusyear;
        System.out.println("[-] Результат сложения месяцев: " + day + "-" + month + "-" + yyear);
    }
    public void daysandweeks() {
	/*
	DOCSTRING: Посчитать время с начала года
	INPUT: Нет
	OUTPUT: Нет
	*/
        Date datee = new Date();
		SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("[-] Текущая дата: " + formatForDateNow.format(datee));
        String currentDate=formatForDateNow.format(datee).toString();
		Date yearStartTime = new Date();
		yearStartTime.setHours(0);
        yearStartTime.setMinutes(0);
        yearStartTime.setSeconds(0);
        yearStartTime.setDate(1);
        yearStartTime.setMonth(0);
        Date currentTime = new Date();
        long msTimeDistance = currentTime.getTime() - yearStartTime.getTime();
        long msDay = 24 * 60 * 60 * 1000;
        int dayCount = (int) (msTimeDistance/msDay);
        System.out.println("[-] Дней прошло с начала года: " + dayCount);
        System.out.println("[-] Недель прошло с начала года: " + dayCount/7);
    }
}
public class Main
{
	public static void main(String[] args) {
	/*
	DOCSTRING: Метод main
	INPUT: Аргументы
	OUTPUT: Нет
	*/
		String date1 = "23-05-2012";
		String date2 = "03-03-2010";
		Date date = new Date();
		dat D = new dat(date1);
		dat S = new dat(date2);
		D.raznost(S);
		D.sumday(1000);
		D.summonth(1000);
		D.sumyear(1000);
		D.daysandweeks();
	}
}