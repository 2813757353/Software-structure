import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class ExercisesTest {
	Exercises bo;
	Exercises bo1;
	private char theChar='+';
	@Before
	public void setUp() {
		bo=new Exercises();
		bo1=new Exercises();
	}
	public ExercisesTest(char Char){
		theChar=Char;
	}
	@Parameters
	public static Collection<Object[]> data(){ 
		return Arrays.asList(new Object[][]{
		{'+'},
		{'+'},
		{'-'},
		{'-'},
		{'+'},
		{'+'},
		{'-'},
		{'+'},
		});
	}
	@Test
	public void equTest() {//判断习题集生成算式正负号与要求是否相符
		bo.init(50,theChar);//指定的
		for(int k=0;k<bo.size();k++) {
			assertEquals(bo.getChar(k),theChar);
		}
		bo1.init(50);//随机的 
		for(int k=0;k<bo1.size();k++) {
			assertEquals(bo1.getChar(0),theChar);
		}
	}
}
