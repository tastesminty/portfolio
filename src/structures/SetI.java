package structures;

/**
 * A set can not contain duplicates
 *
 * @param <E> element type
 */
public interface SetI<E> extends CollectionI<E> {
	 
	/**
	 * Union
	 * Combine another set with this one, modifying this set only
	 * @param another add all elements from this set not in my set
	 */
	public void addAll(SetI<E> another);

	/**
	 * Set difference
	 * Remove elements from this set that are also in another
	 */
	public void removeAll(SetI<E> another);
	
	/**
	 * 
	 * Retain elements in this set that are in another 
	 * @param another
	 */
	public void retain(SetI<E> another);
}
