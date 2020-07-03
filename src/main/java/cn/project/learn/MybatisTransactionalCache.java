package cn.project.learn;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.cache.TransactionalCacheManager;
import org.apache.ibatis.mapping.MappedStatement;

import java.util.List;

/**
 * mybatis事务缓存：
 *         本质是一个暂存。根据事务决定是否提交到 二级缓存
 *
 *          TransactionalCache: 事务缓存，代理二级缓存，有个entriesToAddOnCommit属性作为临时存放，配合事务特性
 *
 *          TransactionalCacheManager： 事务缓存管理器。统一管理所有的事务缓存与二级缓存的关系。 Map<Cache（二级缓存）, TransactionalCache（事务缓存代理二级缓存）> transactionalCaches
 *                          做到统一管理
 *
 */
public class MybatisTransactionalCache {

    private TransactionalCacheManager tcm = new TransactionalCacheManager();

    public <E> List<E> test(MappedStatement ms,CacheKey key){
        Cache cache = ms.getCache();//SQL映射器对应的二级缓存实例，


        @SuppressWarnings("unchecked")
        List<E> list = (List<E>) tcm.getObject(cache, key);//通过tcm事务缓存管理器获取对应的事务缓存代理。通过事务缓存代理，查看二级缓存中是否有值

        tcm.putObject(cache, key, list); // 本质是先提交到 事务缓存的中临时缓存中 TransactionalCache.entriesToAddOnCommit

        return null;
    }
}
