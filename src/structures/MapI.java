package structures; 
/**
 * A generic map (associative list)
 * @param <K> for finding data in the map
 * @param <V> data you want to store
 */
public interface MapI<K,V> extends Iterable<MapI.Entry<K,V>> {
	
	/**
	 * For a particular key, set its associated value
	 * @param myKey  key to set
	 * @param newValue new value for key
	 * @return true if a new entry was added, false otherwise
		 */
	public boolean set(K myKey,V newValue);
	
	/**
	 * Find value
	 * @param myKey search key
	 * @return get value associated with this key, or null if not set
	 */
	public V get(K myKey);
	
	/**
	 * 
	 * @return number of entries 
	 */
	public int size();
	
	/**
	 * Remove a entry
	 * @param myKey find entry with this key
	 * @return true if an item was found and removed
	 */
	public boolean remove(K myKey);
	
	/**
	 * 
	 * @param myKey
	 * @return true if this key is in map
	 */
	public boolean contains(K myKey);
	
	/**
	 * @return list of key/value pairs, unordered
	 */
	public Object[] toArray();
	
	/**
	 * Key / value pair
	 * Constructor should set both key and value
	 */
	public static interface Entry<K,V>{
		public K getKey();
		public V getValue();
		public void setValue(V newValue); 
	}
}
