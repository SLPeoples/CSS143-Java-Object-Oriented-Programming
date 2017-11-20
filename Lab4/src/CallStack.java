/*
 * Samuel L. Peoples, 1527650
 */
public class CallStack{

  // Called by func1()
  void func2 (){
	 System.out.println("In func2 method");
   	 int a = 0;
   	 int b;
   	 try{
   		 b = 10 / a;
   	 }
   	 catch(ArithmeticException e){
   		 System.out.println("You can't divide by zero.");
   	 }
   }

   //Called by Main
   void func1(){
	  System.out.println("In func1 method");
	  this.func2 ();
	  System.out.println("Back in func1 method");

   }


   public static void main (String args[]){
      CallStack myCallStack;
      myCallStack = new CallStack();
      System.out.println("In the main method");
      myCallStack.func1 ();

   }
}

