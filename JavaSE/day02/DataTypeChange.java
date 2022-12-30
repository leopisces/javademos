package day02;

/*
基本数据类型的转换问题？
（1）自动类型转换（隐式转换）
A：当把存储范围小的值（常量值、变量值、表达式的结果值）
赋值给存储范围大的变量时，就会发生自动类型转换
byte->short->int->long->float->double
      char->
B：boolean不参与
C：当多种数据类型的数据混合运算时，会自动提升为它们中最大的
D：当byte与byte，short与short，char与char，或者它们三个混合运算，
会自动提升为int类型。

（2）强制类型转换（显式转换）
A：当把存储范围大的值（常量值、变量值、表达式的结果值）
赋值给存储范围小的变量时，就需要进行强制类型转换
格式：(存储范围小的数据类型)值

这种强制类型转换会有风险，出现了溢出或损失精度。

*/
public class DataTypeChange{
	public static void main(String[] args){
		//左边d变量是double类型，右边1常量是int类型
		double d = 1;//自动类型转换，隐式转换
		System.out.println(d);
		
		int i = 1;
		short s = 2;
		char c = 'a';
		
		int result = i + s + c;//提升为int
		//int sum = i + s + c + d;//提升为double
		
		byte b1 = 127;
		byte b2 = 2;
		int b3 = b1 + b2; //b1+b2自动提升为int
		System.out.println(b3);
		
		System.out.println("---------------------");
		byte b4 = (byte)(b1 + b2);//从int强制转换为byte类型
		System.out.println(b4);//-127
		/*
		b1是127，二进制  0111 1111
		b2是2，  二进制  0000 0010
		b1+b2    00000000 00000000 00000000 0111 1111
				 00000000 00000000 00000000 0000 0010
				 00000000 00000000 00000000 1000 0001  按照int类型129
				 
		(byte)(b1 + b2)截断：	1000 0001（补码）	最高位是1，说明是负数，补码要经过处理，得到原码
							    1000 0000（反码）
								1111 1111（原码） -127
		*/
	}
}