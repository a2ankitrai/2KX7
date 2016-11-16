# Cache

Cache memory, also called CPU memory, is random access memory (RAM) that a computer microprocessor can access more quickly than it can access regular RAM. This memory is typically integrated directly with the CPU chip or placed on a separate chip that has a separate bus interconnect with the CPU.

Caching is the technique of storing a copy of data temporarily in rapidly-accessible storage media (also known as memory) local to the CPU and separate from bulk storage, has been around for as long as computing itself.

## Cache algorithms

Cache algorithms provide instructions for how the cache should be maintained. Some examples of cache algorithms include:

**Least Frequently Used (LFU)** uses a counter to keep track of how often an entry is accessed; the entry with the lowest count is removed first.

**Least Recently Used (LRU)** keeps recently used items near the top of cache; when the cache limit has been reached, items that have been accessed less recently are removed.

**Most Recently Used (MRU)** removes the most recently used items first; this approach is good for situations in which older items are more likely to be accessed.

## Types of cache

**Write-around cache** allows write operations to be written to storage, skipping the cache altogether. This keeps the cache from becoming flooded when large amounts of write I/O occur. The disadvantage is that data is not cached unless it is read from storage. As such, the initial read operation will be comparatively slow because the data has not yet been cached.

**Write-through cache** writes data to both the cache and storage. The advantage to this approach is that newly written data is always cached, thereby allowing the data to be read quickly. A drawback is that write operations are not considered to be complete until the data is written to both the cache and primary storage. This causes write-through caching to introduce latency into write operations.

**Write-back cache** is similar to write-through caching in that all write operations are directed to the cache. The difference is that once the data is cached, the write operation is considered complete. The data is later copied from the cache to storage. In this approach, there is low latency for both read and write operations. The disadvantage is that, depending on the caching mechanism used, the data may be vulnerable to loss until it is committed to storage.

---

## Caching issues

Caching can encounter challenges that include, for example, the problem of cache warm-up, where cache needs to be loaded with enough active data to reduce cache misses and allow it to start improving I/O response times.

---

# New caching technologies

DRAM has become much cheaper over recent years and many motherboards support large numbers of DIMM slots. DRAM itself is extremely fast and offers low latency and so as a read cache, DRAM can be an attractive solution in larger servers.

---

## Cache coherence

---

## trade-off between latency and resiliency


---

Questions?

- How a particular data is being choosen for cache?

- what are the memory limitations? Suppose i am implementing a real time time system like twitter or facebook how cache management will play a role here?


 