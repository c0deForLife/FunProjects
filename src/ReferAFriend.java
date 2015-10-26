import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class ReferAFriend {

	Map<String,List<String>> friendList = new HashMap<String,List<String>>();


	List<String> getFriendsListForUser(String username)
	{
		return friendList.get(username);
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
		u3FriendList.add("u4");
		u3FriendList.add("u6");
		friendList.put("u3",u3FriendList);

		u4FriendList.add("u2");
		u4FriendList.add("u3");
		u4FriendList.add("u5");
		u4FriendList.add("u6");
		friendList.put("u4",u4FriendList);

		u5FriendList.add("u1");
		u5FriendList.add("u3");
		u5FriendList.add("u4");
		u5FriendList.add("u7");
		friendList.put("u5",u5FriendList);
	}

	
	void recommendAFriend(String username) {
		List<String> usersFriend = getFriendsListForUser(username);
		Map<String,Integer> recommendation = new Hashtable<String,Integer>();
		for(String friend:usersFriend)
		{
			List<String> friendsFList = getFriendsListForUser(friend);
			friendsFList.remove(username);
			for(String friendsF:friendsFList)
			{
				if(!usersFriend.contains(friendsF))
				{
					Integer count = recommendation.get(friendsF);
					if(count != null)
					{
						recommendation.replace(friendsF, count+1);
					}
					else
					{
						recommendation.put(friendsF, 1);
					}
				}
			}
		}
		System.out.println(recommendation);
		System.out.println(sortByComparator(recommendation,false));
	}
	private Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
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
    }
	public static void main(String a[])
	{
		ReferAFriend t1 = new ReferAFriend();
		t1.generateFriendList();
		t1.recommendAFriend("u1");
	}
}
