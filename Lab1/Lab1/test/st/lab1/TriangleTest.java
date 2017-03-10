package st.lab1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TriangleTest {
	
	private int a;
	private int b;
	private int c;
	private String result;
	private static int count = 1;
	private Triangle tri;
	
	public TriangleTest(int a, int b, int c, String result)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.result = result;
	}
	
	@Parameters
	public static Collection data()
	{
		return Arrays.asList(new Object[][]{
			{1, 1, 2, "not a triangle"},
			{1, 1, 1, "equilateral"},
			{2, 2, 3, "isosceles"},
			{3, 4, 5, "scalene"}
		});
	}

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Create a triangle " + count);
		tri = new Triangle(a, b, c);
	}

	@Test
	public void test() {
		System.out.println("Processing test" + count);
		assertEquals(result, tri.triangle());
	}
	
	@After
	public void tearDown() throws Exception
	{
		count++;
		System.out.println("test " + (count - 1) + " have finished!");
	}
	

}
