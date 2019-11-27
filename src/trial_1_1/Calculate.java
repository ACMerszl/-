package trial_1_1;

import java.util.*;

abstract class BinaryOperation{
	
	/***************************************
	 * 声明成员变量
	 **************************************/
	static final int UPPER = 100;
	static final int LOWER = 0;
	private int left_operand = 0;
	private int right_operand = 0;
	private int value = 0;
	private char operator = '+';
	
	
	/****************************************
	 * 生成合法的算式成分，调用者负责输出合法参数
	 ****************************************/
	protected void generateBinaryOperation (char anOperator) {
		Random random = new Random();
		int left, right, result;
		left = random.nextInt(UPPER + 1);
		do {
			right = random.nextInt(UPPER + 1);
			result = calculate(left, right);
		} while (!(checkingCalculation(result)));
		left_operand = left;
		right_operand = right;
		operator = anOperator;
		value = result;
	}
	
	/*****************************************
	 * 定义抽象方法：计算方法以及检查运算结果是否合法
	 ***************************************/
	abstract boolean checkingCalculation(int anInteger);
	abstract int calculate(int left, int right);
	
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
	
	public int getUpper() {
		return UPPER;
	}
	
	public int LOWER() {
		return LOWER;
	}
	
	/*****************************************
	 * 比较对象是否相同
	 *****************************************/
	public boolean equals (BinaryOperation anOperation) {
		return left_operand == anOperation.left_operand && 
			   right_operand == anOperation.getRightOperand() && 
			   operator == anOperation.getOperator();
	}
}


class AdditionOperation extends BinaryOperation {
	AdditionOperation() {
		generateBinaryOperation('+');
	}
	
	/****************************************
	 * 重写父类的抽象方法
	 ****************************************/
	boolean checkingCalculation(int anInteger) {
		return anInteger <= UPPER;
	}
	
	int calculate(int left, int right) {
		return left + right;
	}
}


class SubstractOperation extends BinaryOperation {
	SubstractOperation() {
		generateBinaryOperation('-');
	}
	
	/****************************************
	 * 重写父类的抽象方法
	 ****************************************/
	boolean checkingCalculation(int anInteger) {
		return anInteger >= LOWER;
	}
	
	int calculate(int left, int right) {
		return left - right;
	}
}

class Exercise {
	
	/***********************************************
	 * 使用列表存储算式
	 **********************************************/
	private ArrayList<BinaryOperation> operationList = new ArrayList<BinaryOperation>();
	private int current = 0;  //遍历使用
	
	
	/***********************************************
	 * 产生加减法混合的算式
	 **********************************************/
	public void generateAdditionExercise(int operationCount) {
		BinaryOperation anOperation;
		while (operationCount > 0) {
			do {
				anOperation = generateOperation();
			} while (contains(anOperation));
			
			operationList.add(anOperation);
			operationCount--;
			
		}
	}
	
	/***********************************************
	 * 产生加法算式
	 **********************************************/
	public void generateSubstractExercise(int operationCount) {
		BinaryOperation anOperation;
		while (operationCount > 0) {
			do {
				anOperation = generateOperation();
			} while (contains(anOperation));
			
			operationList.add(anOperation);
			operationCount--;
			
		}
	}
	
	/***********************************************
	 * 产生减法算式
	 **********************************************/
	public void generateBinaryExercise(int operationCount) {
		BinaryOperation anOperation;
		while (operationCount > 0) {
			do {
				anOperation = generateOperation();
			} while (contains(anOperation));
			
			operationList.add(anOperation);
			operationCount--;
			
		}
	}
	
	/*************************************
	 * 随机产生加法或减法算式
	 ************************************/
	private BinaryOperation generateOperation() {
		Random random = new Random();
		int opValue = random.nextInt(2);
		if (opValue == 1) 
			return new SubstractOperation();
		else 
			return new AdditionOperation();
	}
	
	
	/***********************************
	 * 算式去重
	 ************************************/
	private boolean contains(BinaryOperation anOperation) {
		boolean found = false;
		if (operationList.contains(anOperation) == true)
			found = true;
		return found;
	}
	
	/**************************************
	 * 私用变量，提供公开方法来修改，方便输出带答案的算式
	 **************************************/
	public void setCurrent() {
		current = 0;
	}
	
	public boolean hasNext() {
		return current <= operationList.size() - 1;
	}
	
	public BinaryOperation next() {
		return operationList.get(current++);
	}
	
}


class ExerciseSheet {
	
	private static final int COLUMN_NUMBER = 5;
	
	/************************************
	 * 格式化的输出算式
	 ************************************/
	public void formattedDisplay(Exercise ex, int columns) {
		System.out.println("生成的练习题目如下：");
		System.out.println("------------------------------------------------");
		int current = 0;
		while (ex.hasNext()) {
			System.out.print(asString(ex.next()));
			current++;
			if (current % columns == 0) 
				System.out.println("");
		}
		
		System.out.println("");
		System.out.println("练习题答案：");
		System.out.println("------------------------------------------------");
		
		current = 0;
		ex.setCurrent();
		while (ex.hasNext()) {
			System.out.print(fullString(ex.next()));
			current++;
			if (current % columns == 0) 
				System.out.println("");
		}
	}
	
	public void formattedDisplay(Exercise ex) {
		formattedDisplay(ex, COLUMN_NUMBER);
	}
	
	public String asString(BinaryOperation operation) {
		String left, right, str;
		left = String.format("%3d", operation.getLeftOperand());
		right = String.format("%3d", operation.getRightOperand());	
		str = left + " " + operation.getOperator() + " " + right + " = ?\t";
		return str; 
	}
	
	public String fullString(BinaryOperation operation) {
		String left, right, str;
		left = String.format("%3d", operation.getLeftOperand());
		right = String.format("%3d", operation.getRightOperand());	
		str = left + " " + operation.getOperator() + " " + right + " = " + operation.getResult() + "\t";
		return str; 
	}
}

class Calculate {
	public static void main(String args[]) {
		ExerciseSheet ex_sheet = new ExerciseSheet();
		Exercise ex = new Exercise();
		ex.generateBinaryExercise(50);
		ex_sheet.formattedDisplay(ex);
	}
}

