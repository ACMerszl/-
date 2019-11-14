package trial_1_1;

import java.util.*;

public class Calculate {
	/************************************************
	����洢˵��
	
	************************************************/
	
	static int N = 50;
	static int M = 100;
	static boolean [][][] arrays_q = new boolean[M][M][2]; //ȥ���ظ�����ʽ
	static int [] arrays_one = new int[N + 1]; // �����
	static int [] arrays_two = new int[N + 1]; // �汻����
	static char [] arrays_op = new char[N + 1]; // �������
	static int [] arrays_ans = new int[N + 1]; // ���
	
	
	/************************************************
	�÷�����Ҫ���������ʾ��ʽ
	
	************************************************/
	public static void view_1() { // ��ʾ��ʽ
		System.out.println("**************************************************");
		System.out.println("- �������" + N + "��" + M + "���ڵļӼ�����ʽ��ϰ�� -");
		System.out.println("- ÿ�����г���ɵõ�һ��" + N + "�����ϰ�⼰�� -");
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
	�÷�����Ҫ������Ĵ��д𰸵���ʽ
	
	************************************************/
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
	
	
	/************************************************
	�÷�����Ҫ�ǻ�ȡ������������
	
	************************************************/
	public static int getRandom(int x) {
		Random r = new Random();
		return r.nextInt(x);
	}
	
	
	/************************************************
	�÷�����Ҫ���ж����ɵķ����Ƿ�Ϸ�
	
	************************************************/
	public static boolean check(int a, int b, int opt) {
		if (arrays_q[a][b][opt]) return false; //�Ѿ����ֹ�
		if (a + b > M || a - b < 0) return false; //�������������
		return true;
	}
	
	
	/************************************************
	�÷�����Ҫ�ǻ�ȡ��ʽ�����洢������
	
	************************************************/
	public static void cal() { 
		int cnt = 1; 
		while(cnt <= N) {
			int a = getRandom(M); //��ȡ����
			int b = getRandom(M); // ��ȡ������
			int opt = getRandom(2); //��ȡ�����
			if (check(a, b, opt) == false) continue; // ����������
			arrays_one[cnt] = a;
			arrays_two[cnt] = b;
			arrays_q[a][b][opt] = true; //���ֹ�
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
