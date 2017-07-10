package structures; 
/**
 * A  map (associative list) whose key type is comparable
 * @param <K> for finding data in the map
 * @param <V> data you want to store
 */
public interface ComparableMap<K extends Comparable<K>,V> extends MapI<K,V> {
	/**
	 * Key / value pair
	 * Constructor should set both key and value
	 */
	public static interface Entry<K extends Comparable<K>,V> extends Comparable  {
		public K getKey();
		public V getValue();
		public void setValue(V newValue); 
	}
}
