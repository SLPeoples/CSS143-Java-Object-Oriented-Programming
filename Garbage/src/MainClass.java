import java.util.ArrayList;
import java.util.Arrays;

public class MainClass 
{    
	public static void main(String[] args){        
		ArrayList<Integer> list = new ArrayList<>();
		list.add(-1);
		list.add(3);
		list.add(28);
		list.add(17);
		list.add(9);
		list.add(33);
			for(int i = 0; i < list.size(); i++) {
				int element = list.get(i);
				list.remove(i);
				list.add(0, element + 1);
				}
			System.out.println(list);
			}
}