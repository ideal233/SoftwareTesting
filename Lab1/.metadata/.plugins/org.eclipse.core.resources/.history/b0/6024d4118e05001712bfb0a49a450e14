package st.lab1;

public class IsoscelesTriangle {
	
	private int a,b,c;
	
	public IsoscelesTriangle(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String triangle()
	{
		if(a + b <= c || b + c <= a || a + c <= b || a <= 0 || b <= 0 || c <= 0)
			return "not a triangle";
		if((a == b && b != c)||(a == c && b != c)||(b == c && a != b))
			return "isosceles";
		else return "not isosceles";
	}
}