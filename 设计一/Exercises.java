public class Exercises{
	Equation[] equs=new Equation[50];
	public void init(){//初始化所有五十个算式
		for(int i=0;i<50;i++){
			equs[i]=new Equation();
			equs[i].init();
			while(true){
				int flag=0;
				for(int j=0;j<i;j++){
					if(equs[i].getFirst()==equs[j].getFirst())//第一个数相同
						if(equs[i].getSecond()==equs[j].getSecond())//第二个数相同
							if(equs[i].getChars()==equs[j].getChars()){//符号相同
								flag=1;
								break;
							}
				}
				if(equs[i].getAnswer()>100||equs[i].getAnswer()<0){//判断答案是否在0-100内(含0和100)
					flag=1;
				}
				if(flag==0)//式子合法进行下一个
					break;
				else
					equs[i].init();//如果式子不合法重新生成
			}
		}
	}
	public void printAll(){//输出所有的式子
		for(int i=0;i<50;i++){
			System.out.print("  "+equs[i].getMe());
		}
	}
	public void printAll(int turn){//输出所有的式子 每行输出turn 个式子
		for(int i=0;i<50;i++){
			if(turn>0)if(i%turn==0)System.out.print("\n");
			System.out.print("  "+equs[i].getMe());
		}
	}
	public void printAnswer(){//输出所有答案
		for(int i=0;i<50;i++){
			System.out.print("  "+equs[i].getAnswer());
		}
	}
	public void printAnswer(int turn){//输出所有答案 每行输出turn 个答案
		for(int i=0;i<50;i++){
			if(turn>0)if(i%turn==0)System.out.print("\n");
			System.out.print("  "+equs[i].getAnswer());
		}
	}
}