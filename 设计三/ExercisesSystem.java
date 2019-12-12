import java.util.Scanner;
/**
 * 实验三的习题集系统
 * */
public class ExercisesSystem {
	public static void main(String[] arge) {
		Exercises ex=new Exercises();
		Scanner s=new Scanner(System.in);
		System.out.println("请选择：\n1随机生成题目 \n2.从文件读入");
		int chose=s.nextInt();
		if(chose==1) {
			ex.init(50);
		}else {
			System.out.println("请输入文件名:");
			s.nextLine();
			String name=s.nextLine();
			Files fp=new Files(name);
			
			ex.setList(fp.read());
			ex.setDone(fp.getDone());
			ex.setCorrect(fp.getCorrect());
		}
		ex.printAll(5);
		System.out.println("\n请选择:\n1.开始做题(过程中输入-1退出)\n2.输出所有答案");
		chose=s.nextInt();
		if(chose==1) {
			while(ex.getDone()!=50) {
				System.out.println("第"+(ex.getDone()+1)+"个题答案("+ex.getEquation(ex.getDone())+"):");
				int userAnswer=s.nextInt();
				ex.setDone(ex.getDone()+1);
				if(userAnswer==-1) {
					System.out.println("您正在退出\n1.确定并保存\n2.取消");
					if(s.nextInt()==1) {
						System.out.println("请输入保存的文件名:\n");
						s.nextLine();
						Files linfp=new Files(s.nextLine(),ex.getList());
						linfp.setCorrect(ex.getCorrect());
						linfp.setDone(ex.getDone()-1);
						linfp.write();
						System.out.println("\n保存成功!\n");
						break;	
					}
				}
				else if(userAnswer==ex.getEquation(ex.getDone()-1).getAnswer()) {
					ex.setCorrect(ex.getCorrect()+1);
					System.out.println("\n回答正确!\n");
				}else {
					System.out.println("\n回答错误!\n");
				}
			}
			System.out.println("答对了:"+ex.getCorrect()+"\n正确率:"+(ex.getCorrect()/50.0));
		}else {
			ex.printAnswer(5);
		}
		s.close();
		
	}
}
