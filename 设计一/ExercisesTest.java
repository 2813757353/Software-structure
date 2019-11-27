public class ExercisesTest{
	public static void main(String[] arge){//创建一个算式类的实体，对他进行一百次测试
		Exercises e=new Exercises();
		for(int i=0;i<100;i++){
			System.out.println("");
			e.init();
			e.printAll();
			System.out.println("");
			e.printAll(5);
			System.out.println("");
			e.printAnswer();
			System.out.println("");
			e.printAnswer(5);
		}
	}
}