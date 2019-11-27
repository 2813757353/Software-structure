import java.util.Random;
abstract class Equation{
	public abstract void init();
	public abstract int getFirst();
	public abstract int getSecond();
	public abstract int getChars();
	public abstract String getMe();
	public abstract int getAnswer();
}
class EquationReles extends Equation{
	int first=0;
	int second=0;
	final int chars=0;
	public  void init(){
		Random r=new Random();
		first=r.nextInt(101);
		second=r.nextInt(101);
	}
	public int getFirst(){
		return first;
	}
	public  int getSecond(){
		return second;
	}
	public  int getChars(){
		return chars;
	}
	public String getMe(){
		return ""+first+"-"+second;
	}
	public  int getAnswer(){
		return first-second;
	}
}
class EquationAdd extends Equation{
	int first=0;
	int second=0;
	final int chars=1;
	public  void init(){
		Random r=new Random();
		first=r.nextInt(101);
		second=r.nextInt(101);
	}
	public int getFirst(){
		return first;
	}
	public  int getSecond(){
		return second;
	}
	public  int getChars(){
		return chars;
	}
	public String getMe(){
		return ""+first+"+"+second;
	}
	public  int getAnswer(){
		return first+second;
	}
}