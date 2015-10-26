import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SortFractions {
	
	void sort(List<String> list)
	{
		Collections.sort(list, new Comparator<String>()
		        {
					public int compare(String o1, String o2) {
						Double n1 = new Double(o1);
						Double n2 = new Double(o2);
						return n1.compareTo(n2);
						}});
	}
	public static void main(String aargu[])
	{
		SortFractions s = new SortFractions();
		List<String> l1 = new ArrayList<String>();
		l1.add("2.4");
		l1.add("2.98");
		l1.add("1.7");
		l1.add("10.56");
		l1.add("22.66");
		l1.add("13.89");
		l1.add("27.74");
		l1.add("3.75");
		System.out.println(l1);
		s.sort(l1);
		System.out.println(l1);
	}

}
