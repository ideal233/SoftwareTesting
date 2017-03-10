package st.lab1;

public class EquilateralTriangle {
	
	private int a,b,c;
	
	public EquilateralTriangle(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String triangle()
	{
		if(a + b <= c || b + c <= a || a + c <= b || a <= 0 || b <= 0 || c <= 0)
			return "not a triangle";
		if((a == b)&&(b == c))
			return "equilateral";
		else
			return "not equilateral";
	}
}