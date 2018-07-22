## 关于fastjson的使用示范案例

### 1.FastJson的介绍: ###
FastJson是阿里巴巴的开源JSON解析库，它可以解析JSON格式的字符串，支持将Java Bean序列化为JSON字符串，也可以从JSON字符串反序列化到JavaBean。Github地址: [FastJson](https://github.com/alibaba/fastjson)
 
### 2.FastJson的特点: ###
1.速度快,无论序列化和反序列化,都是相当快。  [第三方检测结果](https://github.com/eishay/jvm-serializers/wiki)

2.使用广泛(在阿里巴巴大规模使用，在数万台服务器上部署)
  
3.测试完备(testcase超过3000个)

4.使用简单(没有依赖其它类库,使用方法简洁)

```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.x</version>
</dependency>
```

### 3.FastJson的简单说明: ###
FastJson对于json格式字符串的解析主要用到了一下三个类：  
1.JSON：fastJson的解析器，用于JSON格式字符串与JSON对象及javaBean之间的转换  
2.JSONObject：fastJson提供的json对象    
3.JSONArray：fastJson提供json数组对象
当然，还提供如下工具
JSONPath：fastJson提供json路径表达式支持