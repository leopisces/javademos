package day02;

class TestAdd{
	public static void main(String[] args){
		int m = 1;
		m = ++m;
	}
}
/*
 public static void main(java.lang.String[]);
   Code:
      0: iconst_1
      1: istore_1
      2: iinc          1, 1
      5: iload_1
      6: istore_1
      7: return
*/