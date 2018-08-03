## 说明

Spring 定义 CacheManager 和 Cache 接口用来统一不同的缓存技术。例如 JCache、 Ehcache、 Hazelcast、 Guava(Spring 5.0 起不再支持)、 Redis 等。

在使用 Spring 集成 Cache 的时候，我们需要注册实现的 CacheManager 的 Bean。

Spring 从 Spring3.1 开始基于 java.util.concurrent.ConcurrentHashMap 实现的缓存管理器。

所以，Spring 默认使用 ConcurrentMapCacheManager 作为缓存技术。

但是要切换到其他缓存实现也很简单。