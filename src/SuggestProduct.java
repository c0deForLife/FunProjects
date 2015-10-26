import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class SuggestProduct {

	Map<String,List<String>> friendList = new HashMap<String,List<String>>();
	Map<String,List<String>> PurchaseList = new HashMap<String,List<String>>();


	List<String> getFriendsListForUser(String username)
	{
		return friendList.get(username);
	}
	List<String> getPurchasesForUser(String username)
	{
		return PurchaseList.get(username);
	}
	void generateFriendList()
	{
		List<String> u1FriendList = new ArrayList<String>();
		List<String> u2FriendList = new ArrayList<String>();
		List<String> u3FriendList = new ArrayList<String>();
		List<String> u4FriendList = new ArrayList<String>();
		List<String> u5FriendList = new ArrayList<String>();

		u1FriendList.add("u2");
		u1FriendList.add("u3");
		//u1FriendList.add("u4");
		u1FriendList.add("u5");
		friendList.put("u1",u1FriendList);

		u2FriendList.add("u1");
		u2FriendList.add("u4");
		friendList.put("u2",u2FriendList);

		u3FriendList.add("u1");
		u3FriendList.add("u5");
		friendList.put("u3",u3FriendList);

		u4FriendList.add("u1");
		u4FriendList.add("u2");
		friendList.put("u4",u4FriendList);

		u5FriendList.add("u1");
		u5FriendList.add("u3");
		friendList.put("u5",u5FriendList);
	}

	void generatePurchaseList()
	{
		List<String> u1PurchaseList = new ArrayList<String>();
		List<String> u2PurchaseList = new ArrayList<String>();
		List<String> u3PurchaseList = new ArrayList<String>();
		List<String> u4PurchaseList = new ArrayList<String>();
		List<String> u5PurchaseList = new ArrayList<String>();

		/*u1PurchaseList.add("p1");
		u1PurchaseList.add("p1");
		u1PurchaseList.add("p1");
		u1PurchaseList.add("p2");
		u1PurchaseList.add("p3");
		u1PurchaseList.add("p5");
		u1PurchaseList.add("p4")
		u1PurchaseList.add("p4");*/
		u1PurchaseList.add("p6");
		PurchaseList.put("u1",u1PurchaseList);

		u2PurchaseList.add("p2");
		u2PurchaseList.add("p2");
		u2PurchaseList.add("p2");
		u2PurchaseList.add("p1");
		u2PurchaseList.add("p3");
		u2PurchaseList.add("p5");
		u2PurchaseList.add("p4");
		u2PurchaseList.add("p4");
		PurchaseList.put("u2",u2PurchaseList);

		u3PurchaseList.add("p3");
		u3PurchaseList.add("p3");
		u3PurchaseList.add("p3");
		u3PurchaseList.add("p1");
		u3PurchaseList.add("p2");
		u3PurchaseList.add("p5");
		u3PurchaseList.add("p4");
		u3PurchaseList.add("p4");		
		PurchaseList.put("u3",u3PurchaseList);

		u4PurchaseList.add("p4");
		u4PurchaseList.add("p4");
		u4PurchaseList.add("p4");
		u4PurchaseList.add("p1");
		u4PurchaseList.add("p2");
		u4PurchaseList.add("p3");
		u4PurchaseList.add("p5");
		u4PurchaseList.add("p5");		
		PurchaseList.put("u4",u4PurchaseList);

		u5PurchaseList.add("p5");
		u5PurchaseList.add("p5");
		u5PurchaseList.add("p5");
		u5PurchaseList.add("p1");
		u5PurchaseList.add("p2");
		u5PurchaseList.add("p3");
		u5PurchaseList.add("p4");
		u5PurchaseList.add("p4");
		PurchaseList.put("u5",u5PurchaseList);
	}
	void recommendProductForUser(String username) {
		List<String> usersFriend = getFriendsListForUser(username);
		List<String> ownPurchaseList = getPurchasesForUser(username);
		Map<String,Integer> productList = new HashMap<String,Integer>();
		for(String friend:usersFriend)
		{
			List<String> purchaseList = getPurchasesForUser(friend);
			for(String purchase:purchaseList)
			{
				if(!ownPurchaseList.contains(purchase))
				{
					Integer count = productList.get(purchase);
					if(count != null)
					{
						productList.replace(purchase, count+1);
					}
					else
					{
						productList.put(purchase, 1);
					}
				}
			}
		}
		System.out.println(productList);
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(productList.entrySet());
		Collections.sort(list,new SortImpl());
		  productList = new LinkedHashMap<String, Integer>();
	        for (Entry<String, Integer> entry : list)
	        {
	        	productList.put(entry.getKey(), entry.getValue());
	        }

		System.out.println(productList);		
	}
	/*private Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Integer>>()
        {
            public int compare(Entry<String, Integer> o1,
                    Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }*/
	public static void main(String a[])
	{
		SuggestProduct t1 = new SuggestProduct();
		t1.generateFriendList();
		t1.generatePurchaseList();
		t1.recommendProductForUser("u1");
	}
}
class SortImpl implements Comparator<Entry<String, Integer>>
{

	@Override
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		 
             return o2.getValue().compareTo(o1.getValue());
	}
	
}
