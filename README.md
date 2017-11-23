# helloSSM

使用IDEA 创建SSM项目

### 安装 IntelliJ IDEA

1. 官网下载: [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) Ultimate 付费版本。
2. 购买、试用或破解


### IDEA 基本设置

1. 设置外观和字体大小(选用).

2. 设置编辑器的快捷键(选用).keymap, 可以选择为eclipse 模式.

3. 代码提示和补充功能(选用).`settings -> Editor -> General -> Code Completion -> Case sensitive completion `,默认就是 First letter 区分大小写的.区分大小写的情况是这样的：比如我们在 Java 代码文件中输入 `stringBuffer` IntelliJ IDEA 是不会帮我们提示或是代码补充的，但是如果我们输入 `StringBuffer `就可以进行代码提示和补充.如果想不区分大小写的话，改为` None `项即可.

4. 设置代码检查等级(选用).`Inspections `为最高等级检查，可以检查单词拼写，语法错误，变量使用，方法之间调用等.`Syntax `可以检查单词拼写，简单语法错误.`None `不设置检查.

5. 自动导包(建议).默认 IntelliJ IDEA 是没有开启自动 import 包的功能.`settings -> Editor -> General -> Auto Import`. 选项-`Optimize imports on the fly`,勾选该选项，IntelliJ IDEA 将在我们书写代码的时候自动帮我们优化导入的包，比如自动去掉一些没有用到的包; 选项-`Add unambigupus imports on the fly`, IntelliJ IDEA 将在我们书写代码的时候自动帮我们导入需要用到的包。但是对于那些同名的包，还是需要手动 Alt + Enter 进行导入的，IntelliJ IDEA 目前还无法智能到替我们做判断.

6. `省电模式`(可选).IntelliJ IDEA 有一种叫做`省电模式 `的状态，开启这种模式之后 IntelliJ IDEA 会关掉代码检查和代码提示等功能.所以一般我也会认为这是一种 `阅读模式`,如果你在开发过程中遇到突然代码文件不能进行检查和提示可以来看看这里是否有开启该功能.

7. 全局编码设置(必须).`File -> Other Settings -> Default Settings -> Editor -> File Encodings `三处Encoding 选为UTF-8.

8. 工程编码设置(可选).`File -> Settings->Editor -> File Encodings `同理.

9. 文件编码设置(可选).打开需要设置编码的文件, 在右下角进行设置.

10. Maven设置(建议).`File -> Other Settings -> Default Settings->Build, Execution, Deployment ->Build Tools -> Maven` . Maven home directory - maven 安装路径; User settings file - settings.xml 路径; local repository - 本地仓库位置.
11. JDK设置(必须).`File -> Other Settings -> Default Project Structure`

参考：
http://blog.csdn.net/yelove1990/article/details/51541327
http://blog.csdn.net/qq_27093465/article/details/52918873
http://blog.csdn.net/frankcheng5143/article/details/50779149



### Maven 基本设置

打开 settings.xml

1. 设置本地仓库位置(建议)
```xml
<localRepository>E:\sundry\maven\repo</localRepository>
```

2. 配置镜像(建议)
```xml
    <!-- 阿里云仓库 -->
    <mirror>
        <id>alimaven</id>
        <mirrorOf>central</mirrorOf>
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/repositories/central/</url>
    </mirror>

    <!-- 中央仓库1 -->
    <mirror>
        <id>repo1</id>
        <mirrorOf>central</mirrorOf>
        <name>Human Readable Name for this Mirror.</name>
        <url>http://repo1.maven.org/maven2/</url>
    </mirror>

    <!-- 中央仓库2 -->
    <mirror>
        <id>repo2</id>
        <mirrorOf>central</mirrorOf>
        <name>Human Readable Name for this Mirror.</name>
        <url>http://repo2.maven.org/maven2/</url>
    </mirror>

    <mirror>
        <id>ibiblio</id>
        <mirrorOf>central</mirrorOf>
        <name>Human Readable Name for this Mirror.</name>
        <url>http://mirrors.ibiblio.org/pub/mirrors/maven2/</url>
    </mirror>
    <mirror>
        <id>jboss-public-repository-group</id>
        <mirrorOf>central</mirrorOf>
        <name>JBoss Public Repository Group</name>
        <url>http://repository.jboss.org/nexus/content/groups/public</url>
    </mirror>
    <!-- 中央仓库在中国的镜像 -->
    <mirror>
        <id>maven.net.cn</id>
        <name>oneof the central mirrors in china</name>
        <url>http://maven.net.cn/content/groups/public/</url>
        <mirrorOf>central</mirrorOf>
    </mirror>
```

3. 设置代理(可选)
```xml
      <proxy>
      <id>my-proxy</id>
      <active>true</active>
      <protocol>http</protocol>
      <host>10.18.97.76</host>
      <port>3128</port>
      <nonProxyHosts>127.0.0.1</nonProxyHosts>
      <!--
        <username>shihuan</username>
        <password>123456</password>
      -->
    </proxy>
```

保存,重启IDE生效.


### 使用IDEA 搭建SSM 框架

参考: https://www.cnblogs.com/hackyo/p/6646051.html

需要的环境:

- idea 2017
- jdk 1.8
- Maven 3

#### 步骤1 使用idea新建一个Maven webapp项目

File -> New -> Project -> Maven -> 确认JDK; 勾选Create from archetype; 在列表中选择 maven-archetype-webapp -> Next -> GroupId：www.hello.com; Artifactid: hellossm; -> Next -> 确认 directory、file、replsitory -> Next -> 确认信息 -> Finish


报错: [ERROR] Maven execution terminated abnormally (exit code 1) 这个问题是常见的.检测是不是网络的问题.右击项目名 -> remove Modoule -> 退出IDE -> 去工作区间删除项目 -> 启动IDE 在欢迎页面×了该项目 -> 重新进行步骤1.

第一次搭建可能会很慢, 一次未必成功.

创建成功后右上角会提示：Maven projects need to be imported .点击Enable Auto-Import，以后更改pom文件后就会自动下载依赖包了.

控制台成功信息:
```xml
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 51.253 s
[INFO] Finished at: 2017-11-23T15:53:18+08:00
[INFO] Final Memory: 19M/172M
[INFO] ------------------------------------------------------------------------
[INFO] Maven execution finished
```

项目目录结构:
```xml
helloSSM
    │  helloSSM.iml
    │  pom.xml
    │
    ├─.idea
    │  │  compiler.xml
    │  │  encodings.xml
    │  │  misc.xml
    │  │  modules.xml
    │  │  workspace.xml
    │  │
    │  ├─artifacts
    │  │      helloSSM_war.xml
    │  │      helloSSM_war_exploded.xml
    │  │
    │  ├─dictionaries
    │  │      wuyanhui.xml
    │  │
    │  ├─inspectionProfiles
    │  │      Project_Default.xml
    │  │
    │  └─libraries
    │          Maven__junit_junit_3_8_1.xml
    │
    └─src
        └─main
            ├─resources
            └─webapp
                │  index.jsp
                │
                └─WEB-INF
                        web.xml
```

#### 步骤2 搭建目录结构

```xml
helloSSM
│  helloSSM.iml
│  pom.xml
│
├─.idea
│  │  compiler.xml
│  │  encodings.xml
│  │  misc.xml
│  │  modules.xml
│  │  workspace.xml
│  │
│  ├─artifacts
│  │      helloSSM_war.xml
│  │      helloSSM_war_exploded.xml
│  │
│  ├─dictionaries
│  │      wuyanhui.xml
│  │
│  ├─inspectionProfiles
│  │      Project_Default.xml
│  │
│  └─libraries
│          Maven__junit_junit_3_8_1.xml
│
└─src
    ├─main
    │  ├─java
    │  │  └─com.hello
    │  │      ├─controller
    │  │      │      UserController.java
    │  │      │
    │  │      ├─dao
    │  │      │      IUserDao.java
    │  │      │
    │  │      ├─model
    │  │      │      User.java
    │  │      │
    │  │      └─service
    │  │          │  IUserService.java
    │  │          │
    │  │          └─impl
    │  │                  UserServiceImpl.java
    │  │
    │  ├─resources
    │  │  │  jdbc.properties
    │  │  │  logback.xml
    │  │  │  spring-mvc.xml
    │  │  │  spring-mybatis.xml
    │  │  │
    │  │  ├─mapper
    │  │  │      UserDao.xml
    │  │  │
    │  │  └─sql
    │  │          helloSSM.sql
    │  │
    │  └─webapp
    │      │  index.html
    │      │
    │      └─WEB-INF
    │          │  web.xml
    │          │
    │          └─views
    └─test
        └─java
            └─com
                └─hello
                    ├─controller
                    └─dao
                            IUserDaoTest.java
```





注意: 新建文件如果找不到Class 格式.我们把java 文件夹设置为source , 再创建就有.clss 文件格式了.

我们可以根据对项目的任意目录进行这五种目录类型标注，这个知识点非常非常重要，必须会。

- `Sources` 一般用于标注类似 src 这种可编译目录。有时候我们不单单项目的 src 目录要可编译，还有其他一些特别的目录也许我们也要作为可编译的目录，就需要对该目录进行此标注。**只有 Sources 这种可编译目录才可以新建 Java 类和包，这一点需要牢记。** **

- ` Tests` 一般用于标注可编译的单元测试目录。在规范的 maven 项目结构中，顶级目录是 src，maven 的 src 我们是不会设置为 Sources 的，而是在其子目录 main 目录下的 java 目录，我们会设置为 Sources。而单元测试的目录是 src - test - java，这里的 java 目录我们就会设置为 Tests，表示该目录是作为可编译的单元测试目录。一般这个和后面几个我们都是在 maven 项目下进行配置的，但是我这里还是会先说说。从这一点我们也可以看出 IntelliJ IDEA 对 maven 项目的支持是比彻底的。

- `Resources `一般用于标注资源文件目录。在 maven 项目下，资源目录是单独划分出来的，其目录为：src - main -resources，这里的 resources 目录我们就会设置为 Resources，表示该目录是作为资源目录。资源目录下的文件是会被编译到输出目录下的。

- `Test Resources `一般用于标注单元测试的资源文件目录。在 maven 项目下，单元测试的资源目录是单独划分出来的，其目录为：src - test -resources，这里的 resources 目录我们就会设置为 Test Resources，表示该目录是作为单元测试的资源目录。资源目录下的文件是会被编译到输出目录下的。

- ` Excluded `一般用于标注排除目录。被排除的目录不会被 IntelliJ IDEA 创建索引，相当于被 IntelliJ IDEA 废弃，该目录下的代码文件是不具备代码检查和智能提示等常规代码功能。

通过上面的介绍，我们知道对于非 maven 项目我们只要会设置 src 即可。

参考: http://blog.csdn.net/qq_27093465/article/details/52912444

#### 步骤3 配置文件内容

pom.xml
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>www.hello.com</groupId>
    <artifactId>helloSSM</artifactId>
    <packaging>war</packaging>
    <version>1.0-SNAPSHOT</version>
    <name>helloSSM Maven Webapp</name>
    <url>http://maven.apache.org</url>

    <properties>
        <!-- 设置项目编码编码 -->
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <!-- spring版本号 -->
        <spring.version>4.3.5.RELEASE</spring.version>
        <!-- mybatis版本号 -->
        <mybatis.version>3.4.1</mybatis.version>
    </properties>

    <dependencies>
        <!-- java ee -->
        <dependency>
            <groupId>javax</groupId>
            <artifactId>javaee-api</artifactId>
            <version>8.0</version>
        </dependency>

        <!-- 单元测试 -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

        <!-- 实现slf4j接口并整合 -->
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.2.2</version>
        </dependency>

        <!-- JSON -->
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.8.7</version>
        </dependency>

        <!-- 数据库 -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.41</version>
            <scope>runtime</scope>
        </dependency>

        <!-- 数据库连接池 -->
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.2</version>
        </dependency>

        <!-- MyBatis -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>${mybatis.version}</version>
        </dependency>

        <!-- mybatis/spring整合包 -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>1.3.1</version>
        </dependency>

        <!-- Spring -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>

    </dependencies>

    <build>
        <finalName>helloSSM</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <!-- 设置JDK版本 -->
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>

</project>
```
设置好后,Maven会自动更新依赖, 可以注意右下方的信息.

logback.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration debug="true">
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
    <root level="debug">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```
这里可以控制输出格式和内容，有兴趣的可以自己设置

jdbc.properties
```java
jdbc.driver=com.mysql.jdbc.Driver
#数据库地址
jdbc.url=jdbc:mysql://localhost:3306/hellossm?useUnicode=true&characterEncoding=utf8
#用户名
jdbc.username=root
#密码
jdbc.password=123
#最大连接数
c3p0.maxPoolSize=30
#最小连接数
c3p0.minPoolSize=10
#关闭连接后不自动commit
c3p0.autoCommitOnClose=false
#获取连接超时时间
c3p0.checkoutTimeout=10000
#当获取连接失败重试次数
c3p0.acquireRetryAttempts=2
```


spring-mybatis.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd">

    <!-- 扫描service包下所有使用注解的类型 -->
    <context:component-scan base-package="com.hello.service"/>

    <!-- 配置数据库相关参数properties的属性：${url} -->
    <context:property-placeholder location="classpath:jdbc.properties"/>

    <!-- 数据库连接池 -->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"/>
        <property name="jdbcUrl" value="${jdbc.url}"/>
        <property name="user" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="maxPoolSize" value="${c3p0.maxPoolSize}"/>
        <property name="minPoolSize" value="${c3p0.minPoolSize}"/>
        <property name="autoCommitOnClose" value="${c3p0.autoCommitOnClose}"/>
        <property name="checkoutTimeout" value="${c3p0.checkoutTimeout}"/>
        <property name="acquireRetryAttempts" value="${c3p0.acquireRetryAttempts}"/>
    </bean>

    <!-- 配置SqlSessionFactory对象 -->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <!-- 注入数据库连接池 -->
        <property name="dataSource" ref="dataSource"/>
        <!-- 扫描model包 使用别名 -->
        <property name="typeAliasesPackage" value="com.hello.model"/>
        <!-- 扫描sql配置文件:mapper需要的xml文件 -->
        <property name="mapperLocations" value="classpath:mapper/*.xml"/>
    </bean>

    <!-- 配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中 -->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!-- 注入sqlSessionFactory -->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
        <!-- 给出需要扫描Dao接口包 -->
        <property name="basePackage" value="com.hello.dao"/>
    </bean>

    <!-- 配置事务管理器 -->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
        <!-- 注入数据库连接池 -->
        <property name="dataSource" ref="dataSource"/>
    </bean>

    <!-- 配置基于注解的声明式事务 -->
    <tx:annotation-driven transaction-manager="transactionManager"/>

</beans>
```

spring-mvc.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/mvc
       http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">

    <!-- 扫描web相关的bean -->
    <context:component-scan base-package="com.hello.controller"/>

    <!-- 开启SpringMVC注解模式 -->
    <mvc:annotation-driven/>

    <!-- 静态资源默认servlet配置 -->
    <mvc:default-servlet-handler/>

    <!-- 配置jsp 显示ViewResolver -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/views/"/>
        <property name="suffix" value=".jsp"/>
    </bean>

</beans>
```


web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

  <display-name>helloSSM</display-name>
  <description>helloSSM_Alpha_0.0.1</description>

  <!-- 编码过滤器 -->
  <filter>
    <filter-name>encodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
  </filter>
  <filter-mapping>
    <filter-name>encodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!-- 配置DispatcherServlet -->
  <servlet>
    <servlet-name>SpringMVC</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <!-- 配置springMVC需要加载的配置文件-->
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:spring-*.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
    <async-supported>true</async-supported>
  </servlet>
  <servlet-mapping>
    <servlet-name>SpringMVC</servlet-name>
    <!-- 匹配所有请求，此处也可以配置成 *.do 形式 -->
    <url-pattern>/</url-pattern>
  </servlet-mapping>

  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>

</web-app>
```
到这里基本上环境就搭建完成了，下面开始测试

#### 步骤4 测试

先导入一份数据库测试文件
```sql
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hellossm` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `hellossm`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `email` varchar(255) NOT NULL COMMENT '用户邮箱',
  `password` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `username` varchar(255) DEFAULT NULL COMMENT '用户昵称',
  `role` varchar(255) DEFAULT NULL COMMENT '用户身份',
  `status` int(1) DEFAULT NULL COMMENT '用户状态',
  `regTime` datetime DEFAULT NULL COMMENT '注册时间',
  `regIp` varchar(255) DEFAULT NULL COMMENT '注册IP',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 CHECKSUM=1;

/*Data for the table `user` */

insert  into `user`(`id`,`email`,`password`,`username`,`role`,`status`,`regTime`,`regIp`) values (1,'hello@163.com','1223','helloKang','root',1,'2017-03-28 09:40:31','127.0.0.1');

```

UserController
```java
package com.hello.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hello.model.User;
import com.hello.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:16
 * desc
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser.do")
    public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.selectUser(userId);
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(user));
        response.getWriter().close();
    }
}
```


IUserDao
```java
package com.hello.dao;

import com.hello.model.User;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:17
 * desc
 */
public interface IUserDao {
    User selectUser(long id);
}

```

User
```java
package com.hello.model;

import java.util.Date;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:17
 * desc
 */

public class User {
    private long id;
    private String email;
    private String password;
    private String username;
    private String role;
    private int status;
    private Date regTime;
    private String regIp;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", regTime=" + regTime +
                ", regIp='" + regIp + '\'' +
                '}';
    }
}

```

IUserService
```java
package com.hello.service;

import com.hello.model.User;

public interface IUserService {
    public User selectUser(long userId);
}

```


UserServiceImpl
```java
package com.hello.service.impl;

import com.hello.dao.IUserDao;
import com.hello.model.User;
import com.hello.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:17
 * desc
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
        }
        }

```


UserDao.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!-- 设置为IUserDao接口方法提供sql语句配置 -->
<mapper namespace="com.hello.dao.IUserDao">

    <select id="selectUser" resultType="User" parameterType="long">
        SELECT * FROM user WHERE id = #{id}
    </select>

</mapper>
```

然后新建个测试类，来测试mybatis
IUserDaoTest
```java
package com.hello.dao;

import com.hello.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:45
 * desc
 */

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        long id = 1;
        User user = dao.selectUser(id);
        System.out.println(user.getUsername());
    }
}

```
运行后结果应该是会在控制台输出id为1的用户名.

继续新建个页面来测试springmvc和mybatis

index.html
```html
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>test</title>
</head>
<script>
    function selectUser() {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                document.getElementById("test").innerHTML = xmlhttp.responseText;
            }
        }
        xmlhttp.open("POST", "user/showUser.do", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xmlhttp.send("id=1");
    }
</script>
<body>
<p id="test">Hello World!</p>
<button type="button" onclick="selectUser()">onclick test</button>
</body>
</html>
```

新建完成后配置项目运行环境，点击Run-Edit Configurations...

点击加号新建运行环境，选择Tomcat Server-Local

选中新建好的服务器，右边选择Deployment,点击加号-Atifact...

选择第二项 helloSSM:war exploded

然后在右边Application context配置你的项目名`/hellossm`

最后运行项目，项目会打开里浏览器且访问`http://localhost:8080/hellossm/`，在打开的页面中点击按钮测试，成功的话会在页面上显示id为1的用户信息`{"id":1,"email":"hello@163.com","password":"1223","username":"helloKang","role":"root","status":1,"regTime":1490665231000,"regIp":"127.0.0.1"}`

### IDEA 通过 git 把项目上传到 gitHub

本地安装好git，并配置合理的SSH key

IntelliJ IDEA->Performance->Version Control->git 将自己安装git的可执行文件路径填入Path to Git executable

选择CVS 找到 Share Project 输入账号密码即可.

本例子gitHub 地址: https://github.com/hittun/helloSSM/tree/master

不负责任声明: 本例子只用于学习. 
