import java.util.Arrays;


public class T03_01_Fraction {

	public static void main(String[] args) {
		Fraction[] arr = {
				new Fraction(4, 5),
				new Fraction(1, 10),
				new Fraction(2, 4),
				new Fraction(3, 4),
				new Fraction(3, 7)
		};
		
		print(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Fraction.sum(arr));
	}
	
	public static void print(Fraction[] array) {
		for (Fraction a: array) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}


class Fraction {
	private int m, n;
	
	Fraction(int _m, int _n) {
		m = _m;
		n = _n;
		reduce();
	}
	
	Fraction() {
		this(0, 1);
	}
	
	public String toString() {
		return m + "/" + n;
	}
	
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
	
	private void reduce() {
		int k = gcd(m, n);
		m /= k;
		n /= k;
	}
	
	public Fraction add(Fraction other) {
		int m = this.m * other.n + other.m * this.n;
		int n = this.n * other.n;
		return new Fraction(m, n);
	}
	
	public static Fraction sum(Fraction[] array) {
		Fraction sum = new Fraction();
		for (Fraction a: array) {
			sum = sum.add(a);
		}
		return sum;
	}
}
