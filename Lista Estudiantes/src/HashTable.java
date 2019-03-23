
public class HashTable <K,V>{
	
	private Entry <K, Node<V>>[] entries;
	
	public HashTable () {
		entries= new Entry[100];
	}

	public Entry <K, Node<V>>[] getEntries() {
		return entries;
	}

	public void setEntries(Entry <K, Node<V>>[] entries) {
		this.entries = entries;
	}

}
