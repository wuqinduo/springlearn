package cn.wqd.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dell on 2019/12/20.
 */
public class LRU<K,V> extends LinkedHashMap<K,V>{

    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRU(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.LinkedHashMap#removeEldestEntry(java.util.Map.Entry)
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return (size() > this.maxElements);
    }
}
