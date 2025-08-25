import java.util.Hashtable;

public class HashTable {
	
	public void mockHashTable() {
		Hashtable<Integer, String> table = new Hashtable<>();
		table.put(100,"Spongebob");
		table.put(123, "Patrick");
		table.put(321, "Sandy");
		table.put(555, "Squidward");
		table.put(777, "Gary");
		for( Integer key: table.keySet()) {
			System.out.println(key + "\t" + table.get(key));
		}
	}
	
}
