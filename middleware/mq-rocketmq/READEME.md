# rocketMQ

## 生产者


## 消费者
### 1. 配置
- ConsumeFromWhere

## QA
1. 同一个topic和group，如果两个应用A/B，A集群消费，B广播消费，A消费？B消费？AB同时消费？
A: B应用可以消费到全部消息，A应用缺失部分消息，未能消费到全部消息
2. 同一个topic和group，应用A/B，集群消费
A: 同时只会有一个应用消费，要么A消费，要么B消费
3. 同一个topic，不同group，应用A/B，都是集群消费，A和B是否同时消费所有消息