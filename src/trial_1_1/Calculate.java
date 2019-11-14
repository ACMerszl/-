package trial_1_1;

import java.util.*;

public class Calculate {
	/************************************************
	数组存储说明
	
	************************************************/
	
	static int N = 50;
	static int M = 100;
	static boolean [][][] arrays_q = new boolean[M][M][2]; //去除重复的算式
	static int [] arrays_one = new int[N + 1]; // 存减数
	static int [] arrays_two = new int[N + 1]; // 存被减数
	static char [] arrays_op = new char[N + 1]; // 存运算符
	static int [] arrays_ans = new int[N + 1]; // 存答案
	
	
	/************************************************
	该方法主要是整齐的显示算式
	
	************************************************/
	public static void view_1() { // 显示算式
		System.out.println("**************************************************");
		System.out.println("- 程序输出" + N + "道" + M + "以内的加减法算式的习题 -");
		System.out.println("- 每次运行程序可得到一套" + N + "道题的习题及答案 -");
		System.out.println("**************************************************");
		System.out.println("");
		for (int i = 1; i <= N; i++) { 
			System.out.printf("%3d", arrays_one[i]);
			System.out.print(" " + arrays_op[i]);
			System.out.printf("%3d", arrays_two[i]);
			System.out.print(" = ?  ");
			if (i % 5 == 0) 
				System.out.println("");
		}
	}
	
	
	/************************************************
	该方法主要是整齐的带有答案的算式
	
	************************************************/
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
	
	
	/************************************************
	该方法主要是获取随机数及运算符
	
	************************************************/
	public static int getRandom(int x) {
		Random r = new Random();
		return r.nextInt(x);
	}
	
	
	/************************************************
	该方法主要是判断生成的方法是否合法
	
	************************************************/
	public static boolean check(int a, int b, int opt) {
		if (arrays_q[a][b][opt]) return false; //已经出现过
		if (a + b > M || a - b < 0) return false; //结果不符合条件
		return true;
	}
	
	
	/************************************************
	该方法主要是获取算式，并存储运算结果
	
	************************************************/
	public static void cal() { 
		int cnt = 1; 
		while(cnt <= N) {
			int a = getRandom(M); //获取减数
			int b = getRandom(M); // 获取被减数
			int opt = getRandom(2); //获取运算符
			if (check(a, b, opt) == false) continue; // 不符合条件
			arrays_one[cnt] = a;
			arrays_two[cnt] = b;
			arrays_q[a][b][opt] = true; //出现过
			if (opt == 0) arrays_q[b][a][opt] = true; // a + b = b + a
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
	}
	
	
	public static void main(String[] args) {
		cal();
		view_1();
		view_2();
	}
}
