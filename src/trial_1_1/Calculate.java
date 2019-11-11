package trial_1_1;

import java.util.*;

public class Calculate {
	static int N = 50;
	static int M = 100;
	static boolean [][][] arrays_q = new boolean[100][100][2]; //ȥ���ظ�����ʽ
	static int [] arrays_one = new int[51]; // �����
	static int [] arrays_two = new int[51]; // �汻����
	static char [] arrays_op = new char[51]; // �������
	static int [] arrays_ans = new int[51]; // ���
	
	public static void view_1() { // ��ʾ��ʽ
		System.out.println("**************************************************");
		System.out.println("- �������50��100���ڵļӼ�����ʽ��ϰ�� -");
		System.out.println("- ÿ�����г���ɵõ�һ��50�����ϰ�⼰�� -");
		System.out.println("**************************************************");
		System.out.println("");
		for (int i = 1; i <= N; i++) { //�����ʽ
			System.out.printf("%3d", arrays_one[i]);
			System.out.print(" " + arrays_op[i]);
			System.out.printf("%3d", arrays_two[i]);
			System.out.print(" = ?  ");
			if (i % 5 == 0) 
				System.out.println("");
		}
	}
	
	public static void view_2() { // ��ʾ��
		System.out.println("");
		System.out.println("**************************************************");
		System.out.println("- ������ϰ��Ĳο���");
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
			int a = r1.nextInt(M); //��ȡ����
			int b = r2.nextInt(M); // ��ȡ������
			int opt = r3.nextInt(2); //��ȡ�����
			if (arrays_q[a][b][opt]) continue; 
			if (a + b > M || a - b < 0) continue; //�м���̲���������
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
