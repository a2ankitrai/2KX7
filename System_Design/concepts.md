# Scaling

Vertical scaling :  increasing processors (cores, caches), DISK, RAM

Horizontal scaling:  using mutliple servers and increasing them as the load increses.

---

# System Design Question Concepts

- **Amount of data (disk)**

- **RAID configuration**

- **Amount of RAM – does everything need to be in RAM? (a lot of times – yes)**

- **Requests/sec**

- **Request time**

- **Data transfer rates**

- **Network requests in single data center**

- **Geographically separated locations**

- **Operations should never be more than nlogn, preferably n**

- **Sharding/Partitioning (by user/date/content-type/alphabetically) – how do we rebalance?**

- **Frontend/backend**

- **Backups? Backup a single user on how many servers?**

- **Many requests for the same data/lots of updates – all in cache**

- **Distribute so that the network is negligible**

- **Parallelizing network requests**

- **Fan-out (scatter and gather)**

- **Caching**

- **Load-balancing**

- **High availability**

- **MapReduce**

- **CDN**

- **Queues**

- **Timeouts**

- **Fail fast**

- **Circuit breakers**

- **Throttling**

- **Consistent hashing for sharding/partitioning**

- **Compression**

- **Possible to work harder on writes in order to make reads easier**

---

# Platform Needs

- Monitoring (app, resp. time, throughput, OS level, errors)

- Alerting 

- Metrics

- Distributed tracing + logging

- Datastores

- Caching

- Queues

- Service discovery

- Configuration

- Debugging, profiling

- ALM and deployment

- Auto scaling

- Load balancing, traffic splitting/control

- KPIs and actions based on them

- Deployment (blue-green), rollback, canary/testbed