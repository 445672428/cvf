package others.down10;

import java.math.BigInteger;

public class BigIntegerDemo {
	public static void main(String[] args) {
		String num1 = "9999999999999999999999999999999999";
		String num2 = "9999999999999999999999999999999998";
		BigInteger big1 = new BigInteger(num1); // ʵ��BigInteger����
		BigInteger big2 = new BigInteger(num2); // ʵ��BigInteger����
		System.out.println("�ӷ�������" + big1.add(big2));
		System.out.println("����������" + big1.subtract(big2));
		System.out.println("�˷�������" + big1.multiply(big2));
		System.out.println("�������" + big1.divide(big2));
		BigInteger result[] = big1.divideAndRemainder(big2);// ���д���������������
		System.out.println("���֮������ǣ�" + result[0]);
		System.out.println("���֮��������ǣ�" + result[1]);
	}

}
