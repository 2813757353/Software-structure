import java.util.Random;
import java.util.ArrayList;
import java.util.List;
/**
 * 在这个版本中对习题类添加了四个方法 getDone setDone setList getList getCorrect setCorrect为配合文件读写
 * */
public class Exercises{
	private int done=0;
	private int correct=0;
	private List<Equation> equs=new ArrayList<Equation>();//记录算式
	public int getDone() {//获取做了几题
		return done;
	}
	public void setCorrect(int correct) {
		this.correct=correct;
	}
	public int getCorrect() {
		return correct;
	}
	public void setDone(int done) {//设置已经做了几题
		this.done=done;
	}
	public void setList(List<Equation>list) {//设置算式
		equs=list;
	}
	public List<Equation> getList(){//获取算式
		return equs;
	}
	public Equation getEquation(int index) {//获取一个算式
		return equs.get(index);
	}
	public void init(int count){//初始化所有算式count代表算式个数
		equs.clear();
		Random r=new Random();
		int firstLin=0;
		int secondLin=0;
		char charsLin;
		for(int k=0;k<count;k++) {
			if(r.nextInt(2)==0) {
				charsLin='-';
			}else {
				charsLin='+';
			}
			Equation lin;
			if(charsLin=='+') {
				lin=new EquationAdd();
			}else {
				lin=new EquationReles();
			}
			firstLin=r.nextInt(101);
			secondLin=r.nextInt(101);
			lin.setEquation(firstLin, secondLin,charsLin);
			if(isBeing(lin.toString())||lin.getAnswer()>100||lin.getAnswer()<0) {
				k--;
				continue;
			}
			equs.add(lin);
		}
	}
	public int size() {
		return equs.size();
	}
	public void init(int count,char chars){//初始化所有算式count代表算式个数 charsL代表符号
		Random r=new Random();
		int firstLin=0;
		int secondLin=0;
		char charsLin=chars;
		for(int k=0;k<count;k++) {
			Equation lin;//临时变量
			if(chars=='+') {
				lin=new EquationAdd();
			}else {
				lin=new EquationReles();
			}
			firstLin=r.nextInt(101);
			secondLin=r.nextInt(101);
			lin.setEquation(firstLin, secondLin,charsLin);
			if(isBeing(lin.toString())||lin.getAnswer()>100||lin.getAnswer()<0) {
				k--;
				continue;
			}
			equs.add(lin);
		}
	}
	public char getChar(int index) {//获取一个算式是加法还是减法
		return equs.get(index).getChars();
	}
	public boolean isBeing(String str) {//判断一个式子是否已经存在于链表里
		for(int k=0;k<equs.size();k++) {
			if(equs.toString().equals(str))
				return true;
		}
		return false;
	}
	public void printAll(){//输出所有的式子
		System.out.format("\n*******************************************");
		System.out.format("\n**                 习题生成                                        **");
		System.out.format("\n*******************************************\n");
		for(int k=0;k<equs.size();k++) {
			System.out.format("%7s  ",equs.get(k).toString());
		}
		
	}
	public void printAll(int turn){//输出所有的式子 每行输出turn 个式子
		System.out.format("\n*******************************************");
		System.out.format("\n**                 习题生成                                        **");
		System.out.format("\n*******************************************");
		for(int k=0;k<equs.size();k++) {
			if(k%5==0)System.out.println();
			System.out.format("%7s  ",equs.get(k).toString());
		}
	}
	public void printAnswer(){//输出所有答案
		System.out.format("\n*******************************************");
		System.out.format("\n**                 答案生成                                        **");
		System.out.format("\n*******************************************\n");
		for(int k=0;k<equs.size();k++) {
			System.out.format("% 3d  ",equs.get(k).getAnswer());
		}
	}
	public void printAnswer(int turn){//输出所有答案 每行输出turn 个答案
		System.out.format("\n*******************************************");
		System.out.format("\n**                 答案生成                                        **");
		System.out.format("\n*******************************************");
		for(int k=0;k<equs.size();k++) {
			if(k%5==0)System.out.println();
			System.out.format("% 3d  ",equs.get(k).getAnswer());
		}
	}
}