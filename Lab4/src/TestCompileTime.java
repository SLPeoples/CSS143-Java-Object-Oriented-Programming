/*
 * Samuel L. Peoples, 1527650
 */
public class TestCompileTime{

	public TestCompileTime(){}

	public static void main(String args[])
	{
		if(Debug.dmode)
			System.err.println("Debug is turned on");
		else
  			System.out.println("Debug is turned off");
		TestCompileTime t = new TestCompileTime();
        int[] numbers = new int[5];
        for (int i=1; i<5; i++)
	        {
	            numbers[i] = i;
	            if(Debug.dmode)
	            	System.out.println("DEBUG_STATEMENT: number["+i+"]="+i);
	        }
        for (int i=1; i<5; i++)
        {
            int element = numbers[i];
            System.out.print(element + " ");
        }
	}
}
