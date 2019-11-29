import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class EquationTest {
	private int first;
	private int second;
	private char chars;
	private int answer;
	Equation bo1;
	Equation bo2;
	public EquationTest(int first,int second,char chars,int answer) {
		this.first=first;
		this.second=second;
		this.chars=chars;
		this.answer=answer;
	}
	@Before
	public void setUp() {
		bo1=new EquationAdd();
		bo2=new EquationReles();
	}
	@Parameters
	public static Collection<Object[]> data(){ 
		return Arrays.asList(new Object[][]{
		{0,100,'+',100},
		{99,1,'+',100},
		{100,1,'-',99},
		{100,0,'-',99},
		{99,1,'+',98},
		{110,2,'+',55},
		{10,29,'-',10},
		{10,9,'*',10},
		});
	}
	
	@Test
	public void equTest() {
		if(chars=='+') {
			bo1.setEquation(first, second, chars);
			int result1=bo1.getAnswer();
			assertEquals(answer,result1);
		}else {
			bo2.setEquation(first, second, chars);
			int result2=bo2.getAnswer();
			assertEquals(answer,result2);
		}
	}
}
