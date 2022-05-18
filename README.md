# 工程简介
用户服务提供了用户的注册、查询、删除、编辑、注册成功发送邮件等功能，采用了springcloudalibaba的微服务架构，
可以避免单体应用全部功能集成在一个工程中，对于大型项目来说不容易开发和维护的缺点。

微服务架构优点：
* 微服务架构的优点服务原子化拆分，独立打包，部署和升级，保证每个微服务清晰的任务划分，利于扩展
* 微服务之间采用Restful等轻量级http协议互相调用

微服务架构缺点：

- 分布式系统的开发成本高（容错，分布式事务等）
- 复杂性更高，各个微服务独立部署，当进行模块调用的时候，分布式会变的更加麻烦

#工程结构说明
demo为父工程，管理了一些公共包以及版本号，email-server(邮件服务),user-server(用户服务)为子模块工程
email-server使用spring-mail来发送邮件，为了提高系统的响应速度，采取异步发送邮件的方式，
user-server实现了用户的注册、查询、删除、编辑功能，通过openfeign的方式调用email-server，同步请求，异步快速响应。

##user-server的技术栈

* SpringBoot 
* mybatis-plus 
* SpringValidation
* 全局异常处理，自定义异常处理
* restful api
* openfeign
* nacos-discovery-client
* swagger API文档注释



##微服务管理
服务注册&管理选择的是alibaba的nacos，之所以不选择Eureka，因为其已经不开源，而且性能不如nacos

nacos也能当做配置中心使用。



##依赖的环境

1.JDK1.8

2.Maven

3.Mysql

4.Nacos



##版本说明

经官方测试验证过的springcloudalibaba组件间的版本号如下

SpringCloudAlibabaVersion选用2.2.7RELEASE,

Nacos选择2.0.3 

SpringBoot 选择2.3.12RELEASE

SpringCloudVersion 选择 Spring Cloud Hoxton.SR12



相关部署启动脚本请查看docs文件夹





