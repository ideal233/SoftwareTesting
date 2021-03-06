package st.lab1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ScaleneTriangleTest {

	private int a;
	private int b;
	private int c;
	private String result;
	private static int count = 1;
	private ScaleneTriangle tri;
	
	public ScaleneTriangleTest(int a, int b, int c, String result)
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
			{5, 1, 2, "not a triangle"},
			{2, 3, 4, "scalene"},
			{2, 2, 2, "not scalene"},
		});
	}

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("Create a scalene triangle " + count);
		tri = new ScaleneTriangle(a, b, c);
	}

	@Test
	public void test() {
		System.out.println("Processing scalene test" + count);
		assertEquals(result, tri.triangle());
	}
	
	@After
	public void tearDown() throws Exception
	{
		count++;
		System.out.println("scalene test " + (count - 1) + " have finished!");
	}
}
