package trial_1_1;

import java.util.*;

public class Calculate {
	static int N = 50;
	static int M = 100;
	static boolean [][][] arrays_q = new boolean[100][100][2]; //去除重复的算式
	static int [] arrays_one = new int[51]; // 存减数
	static int [] arrays_two = new int[51]; // 存被减数
	static char [] arrays_op = new char[51]; // 存运算符
	static int [] arrays_ans = new int[51]; // 存答案
	
	public static void view_1() { // 显示算式
		System.out.println("**************************************************");
		System.out.println("- 程序输出50道100以内的加减法算式的习题 -");
		System.out.println("- 每次运行程序可得到一套50道题的习题及答案 -");
		System.out.println("**************************************************");
		System.out.println("");
		for (int i = 1; i <= N; i++) { //输出算式
			System.out.printf("%3d", arrays_one[i]);
			System.out.print(" " + arrays_op[i]);
			System.out.printf("%3d", arrays_two[i]);
			System.out.print(" = ?  ");
			if (i % 5 == 0) 
				System.out.println("");
		}
	}
	
	public static void view_2() { // 显示答案
		System.out.println("");
		System.out.println("**************************************************");
		System.out.println("- 下面是习题的参考答案");
		System.out.println("**************************************************");
		System.out.println("");
		for (int i = 1; i <= N; i++) { 
			System.out.printf("%3d", arrays_one[i]);
			System.out.print(" " + arrays_op[i]);
			System.out.printf("%3d", arrays_two[i]);
			System.out.printf(" = %d\t", arrays_ans[i]);
			if (i % 5 == 0) 
				System.out.println("");
		}
	}
	public static void main(String[] args) {
		int cnt = 1; 
		while(cnt <= N) {
			Random r1 = new Random(); 
			Random r2 = new Random();
			Random r3 = new Random();
			int a = r1.nextInt(M); //获取减数
			int b = r2.nextInt(M); // 获取被减数
			int opt = r3.nextInt(2); //获取运算符
			if (arrays_q[a][b][opt]) continue; 
			if (a + b > M || a - b < 0) continue; //中间过程不符合条件
			arrays_one[cnt] = a;
			arrays_two[cnt] = b;
			char optt;
			if(opt == 0) {
				optt = '+';
				arrays_ans[cnt] = a + b;
			}
			else {
				optt = '-';
				arrays_ans[cnt] = a - b;
			}
			arrays_op[cnt] = optt;
			cnt++;
		}
		view_1();
		view_2();
	}
}
