/*
 * Samuel L. Peoples, 1527650
 *  * 2. The variable watch window displays the values of instance variables as the program progresses.
 * 		The method call stack displays the progression of the program's heirarchy.
 * 3. Step into: Executes the current line and proceeds to the next line of code. It will access methods and variables.
 * 		Step over: Executes the method or loop without stepping into it.
 * 		Step return: Steps out of the current call and back to the parent method.
 * 		Resume: Executes the program until the next breakpoint.
 */
class DebuggingExercise4
{
    public static void main(String[] args)
    {
        Account a = new Account();
        a.deposit(100);
        System.out.println(a.getOwner() + " has $" + a.getBalance());
        a.withdraw(200);
        System.out.println("After trying to withdraw $200, " + a.getOwner() + " has $" + a.getBalance());
    }
}