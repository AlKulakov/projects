using System;
namespace C_Sharp
{
    class tme
    {
	private int h, m, s;
	public tme(int ho, int mi, int se) {
		if(se<60)
		s = se;
		else {
			se%=60;
			mi+=se/60;
			s = se;
		}
		if(mi<60)
		m = mi;
		else {
			mi%=60;
			ho+=mi/60;
			m=mi;
		}
		if(ho < 24)
		h = ho;
		else {
			ho%=24;
			h= ho;
		}
	}
	public void sethours(int h){
		if(h<24) {
			this.h = h;
		}
		else {
			this.h = h%24;
		}
	}
	public void setminutes(int m){
		if(m<60) {
		this.m = m;
		}
		else {
			this.m=m%60;
			h=h+m/60;
			if(h>=24)
				h%=24;
	}
	public void setseconds(int s){
		if(s<60) {
		this.s = s;
		}
		else {
			this.s=s%60;
			m=m+s/60;
			if(m>=60) {
			h+=m/60;
			m%=60;
			}
		}
	}
	public void settme(int h, int m, int s) 
	{
		if(s<60)
		this.s = s;
		else {
			s%=60;
			m+=s/60;
			this.s = s;
		}
		if(mi<60)
		this.m = m;
		else {
			m%=60;
			h+=m/60;
			this.m=m;
		}
		if(h < 24)
		this.h = h;
		else {
			h%=24;
			this.h= h;
		}
	}
	public void showtime()
	{
		Console.WriteLine(h + ":" + m + ":" + s);
	} 
    }	
    class Program
    {
        static void Main()
        {
		tme t1 = new tme(25, 342, 233);
		t1.showtime();
		t1.settme(21, 42, 25);
		t1.showtime();
	}
    }
}