package kpaschal.wordnet.common.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author
 */
public class LRUCacheSet<T, K, V> {

    private static int _DEFAULT_CAPACITY = 1000;
    private Map<T, LRUCache<K, V>> caches_;

    public LRUCacheSet() {
        caches_ = new HashMap<T, LRUCache<K, V>>();
    }

    public void createCache(T t) {
        createCache(t, _DEFAULT_CAPACITY);
    }

    public void createCache(T t, int capacity) {
        caches_.put(t, new LRUCache<K, V>(capacity));
    }

    public void put(T t, LRUCache<K, V> cache) {
        caches_.put(t, cache);
    }

    public LRUCache<K, V> get(T t) {
        return caches_.get(t);
    }

    public void clear() {
        caches_.clear();
    }
}
