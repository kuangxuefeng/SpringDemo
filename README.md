# SpringDemo
#### SpringDemo
#### mybatis generator

### 打包
* maven clean
* maven install
* target下生成文件

### 关闭进程
```
root@kxf:~# ps -aux|grep Spring
root      1314  0.1 13.2 2525260 271712 ?      Sl    2021 457:01 java -jar SpringDemo-0.0.2-alpha.jar
root     31986  0.0  0.0  14220   924 pts/0    S+   15:07   0:00 grep --color=auto Spring
root@kxf:~# kill 1314
```

### 只输出错误信息到日志文件 
nohup java -jar yourProject.jar >/dev/null 2>log & 

### 什么信息也不要 
nohup java -jar yourProject.jar >/dev/null 2>&1 & 

### 错误解决 
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.8.1:compile (default-compile) on project SpringDemo: Compilation failure
[ERROR] No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?

使用了jre，尝试工程clean再maven clean
```

### 数据库
```
CREATE SCHEMA `mysql_test` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;

CREATE TABLE `mysql_test`.`user_table` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `pw` VARCHAR(45) NOT NULL,
  `info` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;
```