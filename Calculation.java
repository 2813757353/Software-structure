import java.util.Random;
public class Calculation{
	static Random r=new Random();
	static int addOrLess(){									//生成运算符 0作为+ 1作为-
		int addOrLess=r.nextInt(2);
		return addOrLess;
	}
	/**
	避免以后改需求两个操作数取值范围不一样，将两个操作数的生成写成两个不同的函数
	*/
	static int firstCount(){								//生成第一个数字
		int firstCount=r.nextInt(101);
		return firstCount;
	}
	static int secondCount(){								//生成第二个数字
		int secondCount=r.nextInt(101);
		return secondCount;
	}
	static boolean check(int max ,int min,int first ,int second,int chars){//判断两个数经过运算结果是否符合标准 第一个参数最大值 第二个参数最小值 第三个参数运算数 第四个运算数 第五个参数运算方法(1加法 0减法)
		int resalte=0;
		if(chars==0){
			resalte=first-second;
		}else{
			resalte=first+second;
		}
		if(resalte>=min&&resalte<=max)
			return true;
		else
			return false;
	}
	static void creater(int[] chars,int[] first,int[] second,String[] strings,int count){	//生成算式
		while(true){				
			String linString="";							//临时字符串记录当前生成的算式
			chars[count]=addOrLess();
			first[count]=firstCount();
			second[count]=secondCount();					
			linString+=first[count];			
			if(chars[count]==0){				//判断算式是否属于100以内正数加减法
				if(!check(100,0,first[count],second[count],1))
					continue;
				linString+="+";
				
			}else{
				if(!check(100,0,first[count],second[count],0))
					continue;
				linString+="-";
			}
			linString+=second[count];
			
			int flag=0;
			for(int k=0;k<count;k++){						//判断式子有没有重复
				if(strings[k].equals(linString)){
					flag=1;
					break;
				}
			}
			if(flag==1)continue;else{
				strings[count]=linString;
			}
			count++;
			if(count==50)break;							//生成50个跳出
		}
	}
	static void printer(int[] chars,int[] first,int[] second,String[] strings,int count){	//输出
		for(int k=0;k<10;k++){
			for(int j=0;j<5;j++){
				System.out.format("  第%2d个算式:%7s",k*5+j+1,strings[k*5+j]);
			}
			System.out.println("");
		}
		System.out.format("\n\n");
		for(int k=0;k<10;k++){
			for(int j=0;j<5;j++){
				int answer=0;
				if(chars[k*5+j]==0){						
					answer=first[k*5+j]+second[k*5+j];
				}else{
					answer=first[k*5+j]-second[k*5+j];
				}
				System.out.format("  第%2d题答案:%3d",k*5+j+1,answer);
			}
			System.out.println("");
		}
	}
	public static void main(String[] arge){							//主函数
		int [] chars=new int[50];							//记录符号
		int [] first=new int[50];							//记录第一个运算数
		int [] second=new int[50];							//记录第二个运算数
		String [] strings=new String[50];						//记录算式
		int count=0;									//记录生成了几个算式
		creater(chars,first,second,strings,count);
		printer(chars,first,second,strings,count);
	}
}