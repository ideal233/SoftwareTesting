package st.lab1;

public class Triangle {
	public String triangle(int a, int b, int c)
	{
		if((a == b)&&(b == c))
			return "equilateral";
		else if((a != b)&&(b != c)&&(a != c))
			return "scalene";
		else
			return "isosceles";
					
	}
}
