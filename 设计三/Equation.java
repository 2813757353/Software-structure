abstract class Equation{
	int first=0;
	int second=0;
	char chars='+';
	public void setEquation(int first,int second,char chars){
		if(chars!='-'&&chars!='+')
			throw new RuntimeException("运算符不合法");
		this.first=first;
		this.second=second;
		this.chars=chars;
	}
	public int getFirst() {
		return first;
	}
	public int getSecond() {
		return second;
	}
	public char getChars() {
		return chars;
	}
	public String toString() {
		return ""+first+chars+second;
	}
	public int getAnswer() {
		if(chars=='+') {
			return first+second;
		}else {
			return first-second;
		}
	}
}

