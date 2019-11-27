import java.util.Random;
public class Equation{
	int first;
	int second;
	int chars;
	public void init(){//生成随机数
		Random r=new Random();
		first=r.nextInt(101);
		second=r.nextInt(101);
		chars=r.nextInt(2);
	}
	public int getFirst(){//获取第一个数
		return first;
	}
	public int getSecond(){//获取第二个数
		return second;
	}
	public int getChars(){//获取符号
		return chars;
	}
	public String getMe(){//获取算式
		if(chars==0)
			return ""+first+"-"+second;
		else
			return ""+first+"+"+second;
	}
	public int getAnswer(){//获取答案
		if(chars==0)
			return first-second;
		else
			return first+second;
	}
}