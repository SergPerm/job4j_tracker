package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> implements Cache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    @Override
    public void put(K key, V value) {
        SoftReference<V> ref = new SoftReference<>(value);
        cache.put(key, ref);
    }

    @Override
    public V get(K key) {
        SoftReference<V> softRef;
        if (!cache.containsKey(key)) {
            put(key, load(key));
        }
        softRef = cache.get(key);
        if (softRef == null || softRef.get() == null) {
            softRef = new SoftReference<>(load(key));
            cache.put(key, softRef);
        }
        return softRef.get();
    }

    protected abstract V load(K key);
}