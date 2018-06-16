/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kpaschal.wordnet.common.cache;

/**
 *
 * @author Emy
 */
public interface ICache<K, V> {

    void clear();

    boolean containsKey(K key);

    V get(K key);

    int getCapacity();

    int getSize();

    boolean isEmpty();

    V put(K key, V value);

    V remove(K key);
    
}
