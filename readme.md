### 分布式事务框架TX-LCN开箱试用

#### 使用说明:本项目是基于SpringBoot2.0.5构建的Maven项目，旨在对TX-LCN的开箱试用

#### 相关技术官网：
1. [TX-LCN](https://www.txlcn.org/zh-cn/index.html):框架官网
2. [NACOS](https://nacos.io/zh-cn/index.html):注册中心官网
2. [MyBatis-Plus](https://nacos.io/zh-cn/index.html):MBP官网

#### 项目启动姿势：
1. 以单例模式启动Nacos注册中心：sh startup.sh -m standalone 在register/nacos/bin下；
2. 分别新建tx_manager/tx_logger/yx_sa/yx_sb数据库，并运行sql目录下对应sql脚本；
3. 分别启动yx_tm事务管理服务、测试服务yx_sa/yx_sb;
4. http://127.0.0.1:7970/admin/index.html 查看事务执行情况，密码admin
5. http://127.0.0.1:8848/ 查看服务注册情况 nacos/nacos

#### 开箱试用
1. 测试yx_sa调用yx_sb后，在yx_sa中报异常，事务执行情况；
2. 修改yx_sa服务的rest_template读取超时时间（4秒），并在yx_sb生产者方法中添加延时，模拟接口超时情景，测试事务执行情况。

