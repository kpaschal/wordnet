package kpaschal.wordnet.common.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author
 */
public class LRUCache<K, V> implements ICache<K, V> {

    private int capacity_; // Maximum number of items in the cache.
    private Map<K, V> map_;

    public LRUCache(int capacity) {
        map_ = new LinkedHashMap<K, V>(capacity + 1, 1.0f, true);
        capacity_ = capacity;
    }

    protected boolean removeEldestEntry(Entry entry) {
        return (map_.size() > this.capacity_);
    }

    @Override
    public void clear() {
        map_.clear();
    }

    @Override
    public boolean isEmpty() {
        return map_.isEmpty();
    }
    
    @Override
    public int getSize(){
        return map_.size();
    }

    @Override
    public boolean containsKey(K key) {
        return map_.containsKey(key);
    }

    @Override
    public V get(K key) {
        return map_.get(key);
    }

    @Override
    public int getCapacity() {
        return capacity_;
    }

    @Override
    public V put(K key, V value) {
        return map_.put(key, value);
    }

    @Override
    public V remove(K key) {
        return map_.remove(key);
    }
}
