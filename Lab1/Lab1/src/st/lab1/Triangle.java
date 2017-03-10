package st.lab1;

public class Triangle {
	
	private int a,b,c;
	
	public Triangle(int a, int b, int c)
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
		else if((a != b)&&(b != c)&&(a != c))
			return "scalene";
		else
			return "isosceles";	
	}
}
