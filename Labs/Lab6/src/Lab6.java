
/**
 * @author Samuel L. Peoples, 1527650
 * Lab 6
 * 
 * Estimating g(x) given f(x)
 * In the following section, indicate what reference function (g(x)) we should use when
 * attempting to prove that f(x) is O(g(x)). Use the rules and reference functions above
 * to guide you.
 * 
 * (1) f(x) = n + log_2(n)
   We know that O(log_2(n))<O(n), so O(f(x)) = O(n) (addition rule)
 * 
 * (2) f(x) = n^2 + log(n^4) = n^2 + 4*log(n)
   Using the same logic as (1), O(f(x)) = O(n^2)
 * 
 * (3) f(x) = n^2*n^3 = n^5
   Using the product rule, we know O(f(x)) = O(n^5)
 * 
 * (4)  f(x) = n^5 / n^2 = n^3
   We know O(f(x)) = O(n^3)
 * 
 * (5) f(x) = n*log(n)*n = n^2*log(n)
   We know O(f(x)) = O(n^2*log(n))
 * 
 * (6) f(x) = n + n*log(n) + log(n)
   We know O(f(x)) = O(n*log(n))
 * 
 * Counting Operations to Produce Polynomials
 * In the following section, I will present you with multiple different bodies of code, and
 * it is your job to analyze each code section and build a polynomial that represents the 
 * number of abstract operations the code performs. Once we're done here, we'll have build a
 * polynomial that we will analyze further (in terms of g(x), c, and k) in the next section.
 * For the following code segments below, count the operations and produce a corresponding
 * polynomial representation.
 * 
 *  (1) f(x) =
    public static boolean isEmpty() {
		return head == null;
	}
	This function always completes one operation, so O(f(x)) = 1.
 * (2) f(x) =
   public static int num_occurrences(int n) {
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if( i == j ) continue;
				if(strings[i] == strings[j]) {
					count++;
				}
			}
		}
		return count;
	}
	This function does two operations within a loop of n-size, which is also nested in another
	n-sized loop, which provides a complexity O(f(x)) = O(2n^2) = O(n^2)
 * (3) f(x) = 
   public static void c(int n) { //three loops
		for(int a = 0; a < n; a++) {
			System.out.println( a * a);
		}
		num_occurrences(n);
	}
	This function calls the previous section, which provides a baseline complexity of O(n^2),
	with an addition of O(n), thus the complexity O(f(x)) = O(n^2)
 * (4) f(x) = 
   public static boolean isPrime(int n) {
		if(n == 1) return false;
		for(int i = 2; i <n; i++) {
			if( n % i == 0 ) {
				return false;
			}
		}
		return true;
	}
	this function does at minimum one operation, but at maxiumum n operations, which provides a
	complexity O(f(x)) = O(n)
 * 
 * Demonstrating | f(x) | \leq c | g(x) | forall n > k
 * For each of the polynomials above, pick a reference function (g(x)) and constants, c,l, such
 * that the g(x) bounds f(xO in the most succinct terms possible for Big O.
 * 
 * (1) For the function isEmpty() above, what is...
   g(x) = 1
   c = 1
   k = 0
 * (2) For the function num_occurences() above, what is...
   g(x) = n^2
   c = 2
   k = 1
 * (3) For the function c() above, what is...
   g(x) = n^2
   c = 1
   k = 1
 * (4) For the function isPrime above, what is...
   g(x) = n
   c = 1
   k = 1
 */
