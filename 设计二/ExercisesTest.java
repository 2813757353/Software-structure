public class ExercisesTest{
	public static void main(String[] arge){
		Exercises e=new Exercises();
		e.init(50,0);//生成50道减法
		e.printAll(5);
		e.printAnswer(5);
		e.init(50,1);//生成50道加法
		e.printAll(5);
		e.printAnswer(5);
		e.init(50);//生成50道混合
		e.printAll(5);
		e.printAnswer(5);
	}
}