public class EquationTest{
	public static void main(String[] arge){//创建一个算式类的实体，对他进行一百次测试
		Equation e=new Equation();
		for(int i=0;i<100;i++){
			e.init();
			System.out.println(e.getMe());
			System.out.println(""+e.getFirst()+" "+e.getChars()+" "+e.getSecond());
			System.out.println(e.getAnswer()+"\n");
			
		}
	}
}