# 基于servlet的游戏商城（采用RESTful架构风格）

#### 介绍
[基于servlet的游戏商城](https://gitee.com/YOUYOU-xcu/games)，本项目使用maven进行项目管理、采用restful架构风格以及三层架构设计思想进行编写的一套完整的游戏商城，逐渐完善中……

功能比较简单，界面比较low，代码写的也比较粗糙，哈哈哈哈哈哈哈！但是本项目对于web基础进行充分的运用，按照此项目的思路，可以帮助开发者夯实web基础。

#### Maven概念

Maven是一款自动化构建工具，专注服务于Java平台的项目构建和jar包依赖管理。maven并不是一个框架，但是他其中一个功能是帮助开发者管理框架所需要的jar包使用Maven后每个jar包本身只在本地仓库中保存一份，需要jar包的工程只需要以坐标的方式简单的引用一下就可以了。不仅极大的节约了存储空间，让项目更轻巧，更避免了重复文件太多而造成的混乱。

#### RESTful 架构风格概述

在移动互联网的大潮下，随着docker等技术的兴起，『微服务』的概念也越来越被大家接受并应用于实践，日益增多的web service逐渐统一于RESTful 架构风格，如果开发者对RESTful 架构风格不甚了解，则开发出的所谓RESTful API总会貌合神离，不够规范。

#### 三层架构

三层架构主要是指将业务应用规划中的表示层 UI、数据访问层 DAL 以及业务逻辑层 BLL，其分层的核心任务是“高内聚低耦合”的实现。在整个软件架构中，分层结构是常见和普通的软件结构框架，同时也具有非常重要的地位和意义。这种三层架构可以在软件开发的过程中，划分技术人员和开发人员的具体开发工作，重视核心业务系统的分析、设计以及开发，提高信息系统开发质量和开发效率，进而为信息系统日后的更新与维护提供很大的方便。

#### 使用说明

1.  clone本项目到本地
2.  idea新建maven项目
3.  点击右边栏maven
4.  点击加号
5.  找到本项目的pom.xml
6.  点击ok
7.  运行

![image-20200929110327424](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/image-20200929110327424.png)

#### 项目预览

1. 首页
   ![image-20200929152528335](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160433.png)

2. 未登录状态
   ![image-20200929152627211](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160425.png)

3. 测试阶段（暂时不校验验证码），验证码功能已实现点击切换
   ![image-20200929152709281](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160416.png)

4. 非正常登录（用户名回显）
   ![image-20200929153329021](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160404.png)

5. 正常登录
   ![image-20200929152925297](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160352.png)

6. 登录状态加购商品
   ![image-20200929153429051](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160342.png)

   ![image-20200929153527333](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160333.png)

![image-20200929153637653](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160327.png)

7. 购物车内商品的增加与减少操作

![image-20200929153821680](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160321.png)

![image-20200929153847447](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160311.png)



7. 购物车内的删除操作（当商品数量为1或直接点击了删除按钮）
   ![image-20200929153944396](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160302.png)

8. 商品结算（需选择商品才能正常执行）

   ![image-20200929154136110](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160254.png)
   
9. 查看订单
   ![image-20200929154205031](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160247.png)

10. 订单支付

    ![image-20200929154234004](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160235.png)

    ![image-20200929154332220](https://gitee.com/YOUYOU-xcu/images/raw/master/img2/20200929160225.png)
    
11. ……







#### 项目所存在的弊端

1. 未能充分使用到三层架构的“高内聚，低耦合”思想
2. 功能代码较粗糙，未统一整理（后期可以优化）
3. 未深入做支付（仅做了修改订单状态）
4. 界面比较粗糙（为了防止太low，我将登录、注册都用了相同的界面吼吼吼吼吼）
5. 未做登录拦截（很简单，稍后做……）
6. 未做密码的加盐加密（很简单，稍后做……）
7. 未做注册（很简单，稍后做……）
8. 未做商品库存的事务