import java.util.StringTokenizer;

/*
 * Samuel L. Peoples, 1527650
 * Compiles on Eclipse Neon
* InFixCalc, V0.0 (concept borrowed from Carol Zander's Infix Calculator)
* Exercise author: Rob Nash
* Complete the calculate() function below to build a simple, infix
* calculator that evaluates a compound expression from left to right,
* regardless of operator precedence
*
* Example: " 1 * -3 + 6 / 3"
* Execution: calculate 1 * -3 first, then -3 + 6 next, then 3 / 3
* last to obtain the value 1
*
* Solution by <your name goes here>
6
*/
public class Lab1a8 {

	public static void main(String[] args) {
		//String input = "4 + 4";
		//String input = "4 + 4 / 2";
		//String input ="1 * -3";
		String input ="1 * -3 + 6 / 3";
		//String input ="5";
		//String input ="-5";
		int answer = calculate(input);
		System.out.println("Answer is " + answer);
		}
	
	
	public static int calculate(String input){		
		int lhs=0;
		int rhs=0;
		StringTokenizer st = new StringTokenizer(input);
		while(st.hasMoreTokens()){
			//I had issues here when breaking up the numbers and operations
			String token = st.nextToken();
			switch(token){
			case "-9":
			case "-8":
			case "-7":
			case "-6":
			case "-5":
			case "-4":
			case "-3":
			case "-2":
			case "-1":
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				//I was able to separate them and conduct the operations as needed, but I was doing the math in chunks.
				//For example, this calculator does 1*-3, then -3+6, then 6/3, and returns 6/3.
				lhs = Integer.parseInt(token);
				System.out.println("lhs is " +lhs);
				token = st.nextToken();
				System.out.println("token is " +token);
				switch(token){
				case "+": 
					rhs = lhs + Integer.parseInt(st.nextToken());
					System.out.println("rhs is " +rhs);
					break;
				case "-":
					rhs = lhs + Integer.parseInt(st.nextToken());
					System.out.println("rhs is " +rhs);
					break;
				case "*":
					rhs = lhs * (Integer.parseInt(st.nextToken()));
					System.out.println("rhs is " +rhs);
					break;
				case "/":
					rhs = lhs / (Integer.parseInt(st.nextToken()));
					System.out.println("rhs is " +rhs);
					break;
				}
				break;
				default: break;
			}
			
		}
		return rhs;
		}
	
	
	}