package trial_1_1;

import java.util.*;

class BinaryOperation {
	
	/***************************************
	 * ������Ա����
	 **************************************/
	private static final int UPPER = 100;
	private static final int LOWER = 0;
	private int left_operand = 0;
	private int right_operand = 0;
	private int value = 0;
	private char operator = '+';
	
	
	/***************************************
	 *ʵ�ʲ���BinaryOperatation���� 
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
	 * ����һ���ӷ���ʽ
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
	 * ����һ��������ʽ
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
	 * ������ɼӼ�����ʽ
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
	 * �Ƚ϶����Ƿ���ͬ
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
	 * ������Ŀ�����Լ������ʽ��ʹ�ö�������洢��ʽ
	 *****************************************/
	private static final int OPERATION_NUMBER = 50;
	private static final int COLOMU_NUMBER = 5;
	private BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];
	
	/*****************************************
	 *��ȡһ�ײ��ظ��ļӼ��������ϰ��
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
	 *��ȡһ�ײ��ظ��ļӷ������ϰ��
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
	 *��ȡһ�ײ��ظ��ļ��������ϰ��
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
	 *����Ƿ�֮ǰ���ֹ�
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
	 *��ʽ�����
	 *****************************************/
	void formateAndDisplay() {
		System.out.println("���ɵ���ϰ��Ŀ���£�");
		System.out.println("------------------------------------------------");
		for (int i = 0; i < OPERATION_NUMBER; i++) {
			System.out.print(operationList[i].asString());
			if ((i + 1) % COLOMU_NUMBER == 0) System.out.println("");
		}
		
		System.out.println("");
		System.out.println("��ϰ��𰸣�");
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

