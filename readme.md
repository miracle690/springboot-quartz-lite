
<p align="center">
<a href='https://gitee.com/leiguoqing/springboot-quartz-lite'>
    <img alt="Fork me on Gitee" src="https://gitee.com/leiguoqing/springboot-quartz-lite/widgets/widget_4.svg">
</a>
</p>
<p align="center">
<a href='https://quartz-lite.cn.utools.club/quartz-lite/login.html'>
    <img alt="Fork me on Gitee" src="https://leigq-blog.oss-cn-shenzhen.aliyuncs.com/gitee/logo.png">
</a>
</p>


<p align="center">
<a href='https://gitee.com/leiguoqing/quartz-lite-starter'>starter版本</a>已上线，欢迎使用！
</p>

<p align="center">
    <a href='https://spring.io/projects/spring-boot'>
        <img alt="springboot-version" src="https://img.shields.io/badge/SpringBoot-2.2.9.RELEASE-orange">
    </a>
    <a href='http://www.quartz-scheduler.org/'>
        <img alt="Quartz-version" src="https://img.shields.io/badge/Quartz-2.3.2-blue">
    </a>
    <a href='http://druid.apache.org/'>
        <img alt="druid-spring-boot" src="https://img.shields.io/badge/Druid-1.1.10-green">
    </a>
    <a href='https://mp.baomidou.com/'>
        <img alt="mybatis-plus-version" src="https://img.shields.io/badge/MybatisPlus-3.2.0-lightgrey?link=http://left&link=http://right">
    </a>
    <a href='https://www.apache.org/licenses/LICENSE-2.0'>
        <img alt="apache" src="https://img.shields.io/badge/license-Apache2-red?link=http://left&link=http://right">
    </a>
</p>


## 功能展示

### 登录

用户需要正常登录后，方可进入系统，若不登陆直接访问列表或日志页面，则会自动跳转至登录页面。每次登录有效时长为30分钟，过期后任何操作，也会跳转至登录页面。

帐号、密码、验证码均使用 RSA 加密，帐号、密码、RSA公钥、私钥可在application.yml中进行配置。

默认帐号、密码均为：admin。

登录接口添加 `参数签名+时间戳` 机制，时间戳用于防止 DDOS 攻击，参数签名防止被抓包恶意修改参数。

![](https://images.gitee.com/uploads/images/2020/0813/173640_adef7344_1425122.png)

### 任务列表

任务列表显示每个任务的基本信息，可对任务进行`立即执行`、`暂停`、`恢复`、`删除`、`修改`、`日志查询`操作。

对于不会写 cron 表达式的同学，可以点击左上角的 `在线生成Cron` 按钮进行生成。

右上角可以设置页面的自动刷新频率，默认一秒钟刷新一次。

右上角可以退出登录。

![](https://images.gitee.com/uploads/images/2020/0813/173640_cecbc007_1425122.png)

![](https://images.gitee.com/uploads/images/2020/0813/173640_0fe7e663_1425122.png)

### 任务日志

任务日志页面，可以看到对应任务的`执行时间`、`执行结果`、`执行成功或异常信息`。

任务的日志，按执行时间倒序排序。

任务执行失败时，可以配置是否需要发送邮件到指定邮箱，后面会讲如何配置。

![](https://images.gitee.com/uploads/images/2020/0813/173640_fb2754a5_1425122.png)

![](https://images.gitee.com/uploads/images/2020/0813/173640_e050c54a_1425122.png)

![](https://images.gitee.com/uploads/images/2020/0813/173640_1280671e_1425122.png)

## 项目结构

下面是整个项目结构，主要类已做注释。

```
├─java
│  └─com
│      └─leigq
│          └─quartz
│              │  QuartzApplication.java
│              │
│              ├─bean
│              │  ├─common
│              │  │      Response.java -- 统一返回结果
│              │  │
│              │  ├─constant
│              │  │      QuartzTriggerConstant.java
│              │  │      SysUserConstant.java
│              │  │
│              │  ├─dto
│              │  │      AddQuartzJobDTO.java
│              │  │      TaskExecuteDTO.java
│              │  │
│              │  ├─enumeration
│              │  │      SysTaskExecResultEnum.java
│              │  │
│              │  ├─job
│              │  │      BaseJob.java
│              │  │      BaseJobDisallowConcurrent.java
│              │  │      BaseTaskExecute.java  -- 任务基础抽象类，其他任务继承此类，实现其execute方法执行任务
│              │  │
│              │  └─vo
│              │          AddSysTaskVO.java
│              │          SysTaskListVO.java
│              │          SysTaskLogListVO.java
│              │          SysUserVO.java
│              │          UpdateSysTaskVO.java
│              │
│              ├─controller
│              │      LoginController.java
│              │      SysTaskController.java
│              │      SysTaskLogController.java
│              │
│              ├─domain
│              │  ├─entity
│              │  │      SysTask.java
│              │  │      SysTaskLog.java
│              │  │
│              │  └─mapper
│              │          SysTaskLogMapper.java
│              │          SysTaskMapper.java
│              │
│              ├─service
│              │      QuartzJobService.java
│              │      SysTaskLogService.java
│              │      SysTaskService.java
│              │
│              ├─task
│              │      HelloQuartz.java  --简单的任务示例
│              │
│              ├─util
│              │      EmailSender.java            -- 邮件发送
│              │      ExceptionDetailUtils.java
│              │      ImageCode.java              -- 图形验证码
│              │      JacksonUtils.java           -- JSON工具
│              │      RSACoder.java               -- RSA加密工具
│              │      SpringContextHolder.java
│              │      ThreadPoolUtils.java        -- 线程池工具
│              │      ValidUtils.java
│              │
│              └─web
│                  ├─autoconfigure
│                  │      LiteAutoConfig.java
│                  │      QuartzAutoConfig.java
│                  │
│                  ├─config
│                  │      MvcConfig.java
│                  │      MyBatisPlusConfig.java
│                  │      OrikaConfig.java
│                  │      RedisConfig.java
│                  │      RedisHttpSessionConfig.java
│                  │      QuartzConfig.java  -- Quartz任务配置
│                  │
│                  ├─exception
│                  │      GlobalExceptionHand.java  -- 全局异常处理
│                  │      ServiceException.java     -- 自定义Service异常
│                  │
│                  ├─interceptor
│                  │      LoginInterceptor.java  --登录拦截器
│                  │
│                  └─properties
│                          LiteProperties.java
│                          QuartzProperties.java
│
└─resources
    ├─config
    │      application.yml
    │      log4j2-config.xml
    │
    ├─mapper
    │      SysTaskLogMapper.xml
    │      SysTaskMapper.xml
    │
    ├─sql
    │      Quartz官方建表.sql
    │      自定义任务和任务日志表.sql
    │
    ├─static
    │  └─js
    │          jsencrypt.min.js
    │          md5.js
    │          vue-resource.js
    │          vue.js
    │
    └─templates
            login.html         -- 登录页面
            task-log.html      -- 任务日志页面
            task-manager.html  -- 任务列表页面
```

结构很简单就不多说了。

建议直接把源码克隆下来运行，源码里面注释很清晰，然后结合下面的几篇文章看，就可以很快理解了。

## 运行项目

1. 新建一个数据库或在已存在的数据库中，执行项目中 resource/sql 下面的SQL语句，先执行 `Quartz官方建表.sql`，再执行 `自定义任务和任务日志表.sql`。
2. 将项目中 `application.yml` 中的 `datasource.password` 、 `datasource.url`、`datasource.username` 改为对应你自己的。
3. 可以在 `application.yml` 中配置登录帐号、密码，不配置则默认均为：admin，RSA的公钥、私钥也可在此配置。公钥、私钥可通过RSACoder生成。
    - quartz.task-view.login-username -- 配置登录帐号，默认admin
    - quartz.task-view.login-password -- 配置登录密码，默认admin
    - lite.security.auth.pubKey       -- 配置 RSA公钥，默认已配置
    - lite.security.auth.priKey       -- 配置 RSA私钥，默认已配置

4. 可以在 `application.yml` 中配置执行任务失败时，是否需要发送邮件到指定邮箱，下面的spring.mail配置根据自己邮件服务自行配置，每家邮件服务都不一样，测试时我是用的QQ的。
    - spring.mail.username          -- 发送邮件的帐号    
    - spring.mail.password          -- 发送邮件的密码[授权码]   
    - spring.mail.host              -- host
    - spring.mail.port              -- 端口
    - quartz.mail.enable            -- 配置为true时，启用邮箱，默认false
    - quartz.mail.receive-username  -- 配置接收邮件地址，可配置多个，若不配置不会发邮件

5. 运行项目，项目启动后，在浏览器输入：<http://localhost:8080/login.html> 即可进入登录页面。
6. 此时是一个任务都没有的，项目的 src\main\java\com\leigq\quartz\task 目录下有一个任务示例，你可以把他添加进去看看效果。
7. 怎么集成到已存在的系统中？？目前有两种方法：
    1. 把项目源码拉下来，将核心实现类，复制到已存在的系统中，根据自己的项目改改，就能用了。
    2. 按照上面说的步骤，将此项目作为一个单独的系统进行部署，将执行任务所需的Mapper，Service从已有系统复制进此项目，然后就可以编写任务相关代码了。这样做的好处是：当主系统停止运行，也不影响任务系统的运行。
    3. 如果你的项目是用的SpringCloud，那你可以自己把此项目改成Cloud版本，执行任务就得去用 Feign 调用其他服务的接口了。
    4. 使用starter版本集成，详见：<https://gitee.com/leiguoqing/quartz-lite-starter>

## 演示地址

[https://quartz-lite.cn.utools.club](https://quartz-lite.cn.utools.club/quartz-lite/login.html)

- 账号：admin
- 密码：123456
