# rocketTest

#### 介绍
rocketmq简易测试框架

启动代码
```java
ConsumerManager.createConsumer(ConsumerEnum.CONSUMPTION_MESSAGE.getListener());
```

发送消息代码
```java
LedgerMessageVo ledgerMessageVo = new LedgerMessageVo();
ledgerMessageVo.setServiceKind(BaseServicesEnum.LEDGER_EVALUATION_BILL_FORM.getServicesKind());
ledgerMessageVo.setPackageName("aca");
List<Message> messageVos = new ArrayList<>();
messageVos.add(new BaseMessageVo(ProduceEnum.SERVICE_REQUEST_PRODUCE.getProduceCode(), ledgerMessageVo).baseMessageVo());
ProduceService produceService = new ProduceServiceImpl();
produceService.sent(messageVos,"BASE_SERVICE", ProducerEnum.ASYNCHRONOUS_TRANSMISSION.getMessageBehavior(),messageVos.size());
```
