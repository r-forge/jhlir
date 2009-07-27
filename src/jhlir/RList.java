package jhlir;

import java.util.List;

/**
 * 
 * @param <WRAPPED_TYPE> Type of 
 */
public interface RList<WRAPPED_TYPE> extends RObj<WRAPPED_TYPE> {
	
	/**
	 * Returns the number of elements in this list.
	 * @return the number of elements in this list
	 */
    int getLength();
    
    /**
     * Returns the element at the specified position in this list.
     *
     * @param i index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= getLength()</tt>)
     */
    RObj get(int i);
    
    /**
     * Returns the element at the specified position in this list.
     *
     * @param name string index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range,
     *         i. e. not used.
     */
    RObj get(String name);
    
    /**
     * Returns the name at the specified position of this list.
     * If the name is not set {@code null} is returned.
     * This is equivalent to getNames()[i].
     * @param i index of the position 
     * @return the name of the specified position of this list
     */
    String getName(int i);
    
    /**
     * Returns a String Array of length equal to {@code getLength()}
     * that contains the names of the positions in this list.
     * If a name is not set {@code null} is included.  
     * @return the names of this list
     */
    String[] getNames();
    
    /**
     * Returns a List of Strings of size equal to {@code getLength()}
     * that contains the names of the positions in this list.
     * If a name is not set {@code null} is included.
     * @return the names of this list
     */
    List<String> getNamesAsList();
}
