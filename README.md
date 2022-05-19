
## java基础项目 从零开始上手MVC框架

##### 这是用于学习GO语言的项目
* 实现了MVC增删改查功能用于刚接触Java练手
* 注意：这里前端用了vue，由于更直观的展示Java的应用，没用使用npm没有前后端分离，建议开发项目使用npm引入vue
* 设置数据库参数在src/main/resources/application-dev.yml或者application-prod.yml文件中，这里使用MySQL数据库，数据库名为java_mall_db可以自行修改创建

* 运行项目，在项目根目录执行以下命令
- 方法一、PowerShell命令行模式
1. mvn clean install package '-Dmaven.test.skip=true' -Pdev
- 方法二、Cmd命令行模式
1. mvn clean install package -Dmaven.test.skip=true -Pdev

- 在target目录下找到jar包，执行以下命令
1. java -jar ***.jar
2. 这里***.jar改为你的真实包名


访问：http://localhost:8080/home/index

- jdk下载地址（这里使用jdk 8）
1. https://www.oracle.com/java/technologies/downloads/archive/
2. 选择Java SE 8 (8u211 and later)

- maven下载地址
1. https://maven.apache.org/download.cgi
2. Linux版：apache-maven-3.8.5-bin.tar.gz
3. Windows版：apache-maven-3.8.5-bin.zip

把jdk和maven都配置到系统变量中，让其可以在命令行中执行