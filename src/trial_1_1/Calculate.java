package trial_1_1;

import java.util.*;

class BinaryOperation {
	
	/***************************************
	 * 声明成员变量
	 **************************************/
	private static final int UPPER = 100;
	private static final int LOWER = 0;
	private int left_operand = 0;
	private int right_operand = 0;
	private int value = 0;
	private char operator = '+';
	
	
	/***************************************
	 *实际产生BinaryOperatation对象 
	 ***************************************/
	private void construct(int left, int right, char op) {
		left_operand = left;
		right_operand = right;
		operator = op;
		if (op == '+')
			value = left + right;
		else 
			value = left - right;
	}
	
	/*****************************************
	 * 生成一个加法算式
	 *****************************************/
	public BinaryOperation generateAdditionOperation() {
		Random random = new Random();
		int left, right, result;
		left = random.nextInt(UPPER + 1);
		do {
			right = random.nextInt(UPPER + 1);
			result = left + right;
		} while (result > UPPER);
		BinaryOperation bop = new BinaryOperation();
		bop.construct(left, right, '+');
		return bop;
	}
	
	/*****************************************
	 * 生成一个减法算式
	 *****************************************/
	public BinaryOperation generateSubstractOperation() {
		Random random = new Random();
		int left, right, result;
		left = random.nextInt(UPPER + 1);
		do {
			right = random.nextInt(UPPER + 1);
			result = left + right;
		} while (result < LOWER);
		BinaryOperation bop = new BinaryOperation();
		bop.construct(left, right, '-');
		return bop;
	}
	
	/*****************************************
	 * 随机生成加减法算式
	 *****************************************/
	public BinaryOperation generateBinaryOperation() {
		Random random = new Random();
		int left, right, result, opt;
		left = random.nextInt(UPPER + 1);
		do {
			right = random.nextInt(UPPER + 1);
			result = left + right;
		} while (result > UPPER || result < LOWER);
		BinaryOperation bop = new BinaryOperation();
		opt = random.nextInt(2);
		if (opt == 0)  
			bop.construct(left, right, '+');
		else 
			bop.construct(left, right, '-');
		return bop;
	}
	
	public int getLeftOperand() {
		return left_operand;
	}
	
	public int getRightOperand() {
		return right_operand;
	}
	
	public char getOperator() {
		return operator;
	}
	
	public int getResult() {
		return value;
	}
	
	/*****************************************
	 * 比较对象是否相同
	 *****************************************/
	public boolean equals (BinaryOperation anOperation) {
		return left_operand == anOperation.left_operand && 
			   right_operand == anOperation.getRightOperand() && 
			   operator == anOperation.getOperator();
	}
	
	
	public String asString() {
		String left, right, str;
		left = String.format("%3d", left_operand);
		right = String.format("%3d", right_operand);	
		str = left + " " + operator + " " + right + " = \t";
		return str; 
	}
	
	public String fullString() {
		String left, right, str;
		left = String.format("%3d", left_operand);
		right = String.format("%3d", right_operand);	
		str = left + " " + operator + " " + right + " = ?\t";
		return str; 
	}
	
}


class Exercise {
	/*****************************************
	 * 定义题目总量以及输出格式，使用对象数组存储算式
	 *****************************************/
	private static final int OPERATION_NUMBER = 50;
	private static final int COLOMU_NUMBER = 5;
	private BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];
	
	/*****************************************
	 *获取一套不重复的加减法混合练习题
	 *****************************************/
	public void generateBinaryExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			anOperation = opCreator.generateBinaryOperation();
			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateBinaryOperation();
			}
			operationList[i] = anOperation;
		}
	}
	
	/*****************************************
	 *获取一套不重复的加法混合练习题
	 *****************************************/
	public void generateAdditExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			anOperation = opCreator.generateBinaryOperation();
			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateBinaryOperation();
			}
			operationList[i] = anOperation;
		}
	}
	
	/*****************************************
	 *获取一套不重复的减法混合练习题
	 *****************************************/
	public void generateSubstractExercise() {
		BinaryOperation anOperation, opCreator = new BinaryOperation();
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			anOperation = opCreator.generateBinaryOperation();
			while (contains(anOperation, i - 1)) {
				anOperation = opCreator.generateBinaryOperation();
			}
			operationList[i] = anOperation;
		}
	}
	
	/*****************************************
	 *检查是否之前出现过
	 *****************************************/
	private boolean contains(BinaryOperation anOperation, int length) {
		boolean found = false;
		for (int i = 0; i <= length; i++) {
			if (anOperation.equals(operationList[i])) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	/*****************************************
	 *格式化输出
	 *****************************************/
	void formateAndDisplay() {
		System.out.println("生成的练习题目如下：");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			System.out.print(operationList[i].asString());
			if ((i + 1) % COLOMU_NUMBER == 0) System.out.println("");
		}
		
		System.out.println("");
		System.out.println("练习题答案：");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			System.out.print(operationList[i].fullString());
			if ((i + 1) % COLOMU_NUMBER == 0) System.out.println("");
		}
	}
	
}

class Calculate {
	public static void main(String args[]) {
		Exercise ex = new Exercise();
		ex.generateBinaryExercise();
		ex.formateAndDisplay();
	}
}

