tomcat授权
chmod u+x *.sh


# cvf
cvf
编辑下面配置文件

vim /etc/sysconfig/network-scripts/ifcfg-eth0

1. 创建 keystore 文件

执行 keytool -genkey -alias tomcat -keyalg RSA 结果如下
1. 创建 keystore 文件

执行 keytool -genkey -alias tomcat -keyalg RSA 结果如下

复制代码
loiane:bin loiane$ keytool -genkey -alias tomcat -keyalg RSA
Enter keystore password:  password
Re-enter new password: password
What is your first and last name?
  [Unknown]:  Loiane Groner
What is the name of your organizational unit?
  [Unknown]:  home
What is the name of your organization?
  [Unknown]:  home
What is the name of your City or Locality?
  [Unknown]:  Sao Paulo
What is the name of your State or Province?
  [Unknown]:  SP
What is the two-letter country code for this unit?
  [Unknown]:  BR
Is CN=Loiane Groner, OU=home, O=home, L=Sao Paulo, ST=SP, C=BR correct?
  [no]:  yes
  
Enter key password for
    (RETURN if same as keystore password):  password
Re-enter new password: password
复制代码
这样就在用户的主目录下创建了一个 .keystore 文件

2. 配置 Tomcat 以使用 keystore 文件

打开 server.xml 找到下面被注释的这段

<!--
<Connector port="8443" protocol="HTTP/1.1" SSLEnabled="true"
    maxThreads="150" scheme="https" secure="true"
    clientAuth="false" sslProtocol="TLS" />
-->
干掉注释，并将内容改为

<Connector SSLEnabled="true" acceptCount="100" clientAuth="false"
    disableUploadTimeout="true" enableLookups="false" maxThreads="25"
    port="8443" keystoreFile="/Users/loiane/.keystore" keystorePass="password"
    protocol="org.apache.coyote.http11.Http11NioProtocol" scheme="https"
    secure="true" sslProtocol="TLS" />
    
3. 测试

启动 Tomcat 并访问 https://localhost:8443. 你将看到 Tomcat 默认的首页。

需要注意的是，如果你访问默认的 8080 端口，还是有效的。

4. 配置应用使用 SSL

打开应用的 web.xml 文件，增加配置如下：

复制代码
<security-constraint>
    <web-resource-collection>
        <web-resource-name>securedapp</web-resource-name>
        <url-pattern>/*</url-pattern>
    </web-resource-collection>
    <user-data-constraint>
        <transport-guarantee>CONFIDENTIAL</transport-guarantee>
    </user-data-constraint>
</security-constraint>
复制代码
将 URL 映射设为 /* ，这样你的整个应用都要求是 HTTPS 访问，而 transport-guarantee 标签设置为 CONFIDENTIAL 以便使应用支持 SSL。

如果你希望关闭 SSL ，只需要将 CONFIDENTIAL 改为 NONE 即可。

 

向 CA 提交域名及公司信息申请数字证书就可以了。当然了，数字证书的申请需要花费年费的，一年 4000 到 20000 元不等。

虽然 JDK 的 keytool 工具也可以免费制作自签名的证书，但这只能用在练习或者测试中，因为如果数字证书颁布商不在浏览器的信任列表中，是会给用户弹出警告框的。作为电子商务网站肯定要用商业的数字证书！



DEVICE="eth0"
#BOOTPROTO="dhcp"
BOOTPROTO="static"
IPADDR="192.168.121.100"
NETMASK="255.255.255.0"
GATEWAY="192.168.121.2"
DNS1="192.168.121.2"
DNS2="8.8.8.8"
HWADDR="00:0C:29:A4:40:24"
IPV6INIT="no"
NM_CONTROLLED="yes"
ONBOOT="yes"
TYPE="Ethernet"
UUID="4d9f1c60-fdaa-411b-a916-c0ef989ea443"


重启网络服务
service network restart
编辑文件 
vim /etc/resolv.conf 


centos -> centos1 master1  hosts ip 
centos -> centos2 master2  hosts ip
centos -> centos3 master3  hosts ip

vim /etc/profile
#set java environment
JAVA_HOME=/usr/lib/java/jdk1.7.0_75
JRE_HOME=/usr/lib/java/jdk1.7.0_75/jre
CLASS_PATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib
PATH=$PATH:$JAVA_HOME/bin:$JRE_HOME/bin
export JAVA_HOME JRE_HOME CLASS_PATH PATH

hadoop 文件位置
	   /usr/environment/hadoop
文件提交 git push -u origin master
强制提交 git push -u origin master -f
	   


JAVA_HOME环境配置:/usr/lib/java/jdk1.7.0_75     

hadoop 安装配置
/en/hadoop/hadoop

cd hadoop/etc/hadoop/
vim hadoop-env.sh 

	   
nginx 文件安装 和启动路径
yum install gcc-c++
yum install -y pcre pcre-devel
yum install -y zlib zlib-devel
yum install -y openssl openssl-devel
1.使用默认配置
./configure
2.自定义配置（不推荐）

./configure \
--prefix=/usr/local/nginx \
--conf-path=/usr/local/nginx/conf/nginx.conf \
--pid-path=/usr/local/nginx/conf/nginx.pid \
--lock-path=/var/lock/nginx.lock \
--error-log-path=/var/log/nginx/error.log \
--http-log-path=/var/log/nginx/access.log \
--with-http_gzip_static_module \
--http-client-body-temp-path=/var/temp/nginx/client \
--http-proxy-temp-path=/var/temp/nginx/proxy \
--http-fastcgi-temp-path=/var/temp/nginx/fastcgi \
--http-uwsgi-temp-path=/var/temp/nginx/uwsgi \
--http-scgi-temp-path=/var/temp/nginx/scgi
注：将临时文件目录指定为/var/temp/nginx，需要在/var下创建temp及nginx目录

make
make install
查找安装路径：/usr/local/nginx

whereis nginx
查看进程ID
ps -C nginx -o pid
netstat -anp | grep :80命令来判断Nginx是否启动。
lsof -i:80 也可以查到80端口进程是否有进程在运行。
netstat -ntlp
#启动命令 ./nginx
#停止命令 ./nginx -s top

redis 文件安装配置
	#切换到redis安装目录下面
	make 
	将编译后的文件移动：
	mv redis-trib.rb /usr/environment/redis/redis-3.0.0
	mv redis-server /usr/environment/redis/redis-3.0.0
	mv redis-sentinel /usr/environment/redis/redis-3.0.0
	mv redis-cli /usr/environment/redis/redis-3.0.0 
	mv redis-check-dump /usr/environment/redis/redis-3.0.0
	mv redis-check-aof /usr/environment/redis/redis-3.0.0  
	mv redis-benchmark /usr/environment/redis/redis-3.0.0 
	mv mkreleasehdr.sh /usr/environment/redis/redis-3.0.0
	
	然后 make install
	
	编译文件路径
	make PREFIX=/usr/environment/redis/
	#启动命令  redis-server redis.conf
	#安装目录
	/usr/environment/redis
	#修改redis.conf配置文件 daemonize 将no 改为yes  作为后台进程启动
	#停止redis
	redis-cli shutdown
	redis-server stop
	redis-server start
	redis-server restart
	
	ps -ef | grep redis.conf
	
	
	#rabbitmq安装 参考一下 文档：
	https://www.cnblogs.com/dreamroute/p/5877740.html
	
	关于erlang centos6.5环境安装
	#安装环境编译条件
	yum -y install make gcc gcc-c++ kernel-devel m4 ncurses-devel openssl-devel
	#解压
	tar xvf otp_src_18.3.tar.gz
	cd otp_src_18.3
	
	#配置 '--prefix'指定的安装目录
	./configure --prefix=/usr/local/erlang --with-ssl -enable-threads -enable-smmp-support -enable-kernel-poll --enable-hipe --without-javac
	
	#安装
	make && make install
	
	#配置erlang环境变量
	vim /etc/profile

	#在文件末尾添加下面代码 'ERLANG_HOME'等于上一步'--prefix'指定的目录
	ERLANG_HOME=/usr/local/erlang
	PATH=$ERLANG_HOME/bin:$PATH
	export ERLANG_HOME
	export PATH
	
	#使环境变量生效
	source /etc/profile
	
	#输入命令检验是否安装成功
	erl
	#如下输出表示安装成功
	#解压rabbitmq，官方给的包是xz压缩包，所以需要使用xz命令
	
	xz -d rabbitmq-server-generic-unix-3.6.1.tar.xz
	
	#xz解压后得到.tar包，再用tar命令解压
	tar -xvf rabbitmq-server-generic-unix-3.6.1.tar
	
	#移动目录 看个人喜好
	cp -rf ./rabbitmq_server-3.6.1 /usr/local/
	cd /usr/local/
	
	#修改文件夹名
	mv rabbitmq_server-3.6.1 rabbitmq-3.6.1
	
	#开启管理页面插件
	cd ./rabbitmq-3.6.1/sbin/
	./rabbitmq-plugins enable rabbitmq_management
	
	
	#启动命令，该命令ctrl+c后会关闭服务
	./rabbitmq-server
	
	#在后台启动Rabbit
	./rabbitmq-server -detached
	
	#关闭服务
	./rabbitmqctl stop

	#关闭服务(kill) 找到rabbitmq服务的pid   [不推荐]
	ps -ef|grep rabbitmq
	kill -9 ****
	
	
	#进入RabbitMQ安装目录
	cd /usr/local/rabbitmq-3.6.1/sbin
	
	#添加用户
	#rabbitmqctl add_user Username Password
	./rabbitmqctl add_user rabbitadmin 123456
	
	#分配用户标签
	#rabbitmqctl set_user_tags User Tag
	#[administrator]:管理员标签
	./rabbitmqctl set_user_tags rabbitadmin administrator
	
	
	#设置开机启动
	chkconfig rabbitmq-server on
	
	#防火墙开放15672端口
	/sbin/iptables -I INPUT -p tcp --dport 15672 -j ACCEPT
	/etc/rc.d/init.d/iptables save
	
	#开启web界面管理工具
	rabbitmq-plugins enable rabbitmq_management
	service rabbitmq-server restart
	

//    ABS(x)   返回x的绝对值
//    BIN(x)   返回x的二进制（OCT返回八进制，HEX返回十六进制）
//    CEILING(x)   返回大于x的最小整数值
//    EXP(x)   返回值e（自然对数的底）的x次方
//    FLOOR(x)   返回小于x的最大整数值
//    GREATEST(x1,x2,...,xn)返回集合中最大的值
//    LEAST(x1,x2,...,xn)      返回集合中最小的值
//    LN(x)                    返回x的自然对数
//    LOG(x,y)返回x的以y为底的对数
//    MOD(x,y)                 返回x/y的模（余数）
//    PI()返回pi的值（圆周率）
//    RAND()返回０到１内的随机值,可以通过提供一个参数(种子)使RAND()随机数生成器生成一个指定的值。
//    ROUND(x,y)返回参数x的四舍五入的有y位小数的值
//    SIGN(x) 返回代表数字x的符号的值
//    SQRT(x) 返回一个数的平方根
//    TRUNCATE(x,y)            返回数字x截短为y位小数的结果
//    
//    AVG(col)返回指定列的平均值
//    COUNT(col)返回指定列中非NULL值的个数
//    MIN(col)返回指定列的最小值
//    MAX(col)返回指定列的最大值
//    SUM(col)返回指定列的所有值之和
//    GROUP_CONCAT(col) 返回由属于一组的列值连接组合而成的结果
//    
//    ASCII(char)返回字符的ASCII码值
//    BIT_LENGTH(str)返回字符串的比特长度
//    CONCAT(s1,s2...,sn)将s1,s2...,sn连接成字符串
//    CONCAT_WS(sep,s1,s2...,sn)将s1,s2...,sn连接成字符串，并用sep字符间隔
//    INSERT(str,x,y,instr) 将字符串str从第x位置开始，y个字符长的子串替换为字符串instr，返回结果
//    FIND_IN_SET(str,list)分析逗号分隔的list列表，如果发现str，返回str在list中的位置
//    LCASE(str)或LOWER(str) 返回将字符串str中所有字符改变为小写后的结果
//    LEFT(str,x)返回字符串str中最左边的x个字符
//    LENGTH(s)返回字符串str中的字符数
//    LTRIM(str) 从字符串str中切掉开头的空格
//    POSITION(substr,str) 返回子串substr在字符串str中第一次出现的位置
//    QUOTE(str) 用反斜杠转义str中的单引号
//    REPEAT(str,srchstr,rplcstr)返回字符串str重复x次的结果
//    REVERSE(str) 返回颠倒字符串str的结果
//    RIGHT(str,x) 返回字符串str中最右边的x个字符
//    RTRIM(str) 返回字符串str尾部的空格
//    STRCMP(s1,s2)比较字符串s1和s2
//    TRIM(str)去除字符串首部和尾部的所有空格
//    UCASE(str)或UPPER(str) 返回将字符串str中所有字符转变为大写后的结果
//    
//    CURDATE()或CURRENT_DATE() 返回当前的日期
//    CURTIME()或CURRENT_TIME() 返回当前的时间
//    DATE_ADD(date,INTERVAL int keyword)返回日期date加上间隔时间int的结果(int必须按照关键字进行格式化),如：SELECTDATE_ADD(CURRENT_DATE,INTERVAL 6 MONTH);
//    DATE_FORMAT(date,fmt)  依照指定的fmt格式格式化日期date值
//    DATE_SUB(date,INTERVAL int keyword)返回日期date加上间隔时间int的结果(int必须按照关键字进行格式化),如：SELECTDATE_SUB(CURRENT_DATE,INTERVAL 6 MONTH);
//    DAYOFWEEK(date)   返回date所代表的一星期中的第几天(1~7)
//    DAYOFMONTH(date)  返回date是一个月的第几天(1~31)
//    DAYOFYEAR(date)   返回date是一年的第几天(1~366)
//    DAYNAME(date)   返回date的星期名，如：SELECT DAYNAME(CURRENT_DATE);
//    FROM_UNIXTIME(ts,fmt)  根据指定的fmt格式，格式化UNIX时间戳ts
//    HOUR(time)   返回time的小时值(0~23)
//    MINUTE(time)   返回time的分钟值(0~59)
//    MONTH(date)   返回date的月份值(1~12)
//    MONTHNAME(date)   返回date的月份名，如：SELECT MONTHNAME(CURRENT_DATE);
//    NOW()    返回当前的日期和时间
//    QUARTER(date)   返回date在一年中的季度(1~4)，如SELECT QUARTER(CURRENT_DATE);
//    WEEK(date)   返回日期date为一年中第几周(0~53)
//    YEAR(date)   返回日期date的年份(1000~9999)
//    一些示例：
//    获取当前系统时间：SELECT FROM_UNIXTIME(UNIX_TIMESTAMP());
//    SELECT EXTRACT(YEAR_MONTH FROM CURRENT_DATE);
//    SELECT EXTRACT(DAY_SECOND FROM CURRENT_DATE);
//    SELECT EXTRACT(HOUR_MINUTE FROM CURRENT_DATE);
//    返回两个日期值之间的差值(月数)：SELECT PERIOD_DIFF(200302,199802);
//    在Mysql中计算年龄：
//    SELECT DATE_FORMAT(FROM_DAYS(TO_DAYS(NOW())-TO_DAYS(birthday)),'%Y')+0 AS age FROM employee;
//    这样，如果Brithday是未来的年月日的话，计算结果为0。
//    下面的SQL语句计算员工的绝对年龄，即当Birthday是未来的日期时，将得到负值。
//    SELECT DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(birthday, '%Y') -(DATE_FORMAT(NOW(), '00-%m-%d') <DATE_FORMAT(birthday, '00-%m-%d')) AS age from employee
//
//    五、加密函数
//    AES_ENCRYPT(str,key)  返回用密钥key对字符串str利用高级加密标准算法加密后的结果，调用AES_ENCRYPT的结果是一个二进制字符串，以BLOB类型存储
//    AES_DECRYPT(str,key)  返回用密钥key对字符串str利用高级加密标准算法解密后的结果
//    DECODE(str,key)   使用key作为密钥解密加密字符串str
//    ENCRYPT(str,salt)   使用UNIXcrypt()函数，用关键词salt(一个可以惟一确定口令的字符串，就像钥匙一样)加密字符串str
//    ENCODE(str,key)   使用key作为密钥加密字符串str，调用ENCODE()的结果是一个二进制字符串，它以BLOB类型存储
//    MD5()    计算字符串str的MD5校验和
//    PASSWORD(str)   返回字符串str的加密版本，这个加密过程是不可逆转的，和UNIX密码加密过程使用不同的算法。
//    SHA()    计算字符串str的安全散列算法(SHA)校验和
//    示例：
//    SELECT ENCRYPT('root','salt');
//    SELECT ENCODE('xufeng','key');
//    SELECT DECODE(ENCODE('xufeng','key'),'key');#加解密放在一起
//    SELECT AES_ENCRYPT('root','key');
//    SELECT AES_DECRYPT(AES_ENCRYPT('root','key'),'key');
//    SELECT MD5('123456');
//    SELECT SHA('123456');
//
//    六、控制流函数
//    MySQL有4个函数是用来进行条件操作的，这些函数可以实现SQL的条件逻辑，允许开发者将一些应用程序业务逻辑转换到数据库后台。
//    MySQL控制流函数：
//    CASE WHEN[test1] THEN [result1]...ELSE [default] END如果testN是真，则返回resultN，否则返回default
//    CASE [test] WHEN[val1] THEN [result]...ELSE [default]END  如果test和valN相等，则返回resultN，否则返回default
//    IF(test,t,f)   如果test是真，返回t；否则返回f
//    IFNULL(arg1,arg2) 如果arg1不是空，返回arg1，否则返回arg2
//    NULLIF(arg1,arg2) 如果arg1=arg2返回NULL；否则返回arg1
//    这些函数的第一个是IFNULL()，它有两个参数，并且对第一个参数进行判断。如果第一个参数不是NULL，函数就会向调用者返回第一个参数；如果是NULL,将返回第二个参数。
//    如：SELECT IFNULL(1,2), IFNULL(NULL,10),IFNULL(4*NULL,'false');
//    NULLIF()函数将会检验提供的两个参数是否相等，如果相等，则返回NULL，如果不相等，就返回第一个参数。
//    如：SELECT NULLIF(1,1),NULLIF('A','B'),NULLIF(2+3,4+1);
//    和许多脚本语言提供的IF()函数一样，MySQL的IF()函数也可以建立一个简单的条件测试，这个函数有三个参数，第一个是要被判断的表达式，如果表达式为真，IF()将会返回第二个参数，如果为假，IF()将会返回第三个参数。
//    如：SELECTIF(1<10,2,3),IF(56>100,'true','false');
//    IF()函数在只有两种可能结果时才适合使用。然而，在现实世界中，我们可能发现在条件测试中会需要多个分支。在这种情况下，MySQL提供了CASE函数，它和PHP及Perl语言的switch-case条件例程一样。
//    CASE函数的格式有些复杂，通常如下所示：
//    CASE [expression to be evaluated]
//    WHEN [val 1] THEN [result 1]
//    WHEN [val 2] THEN [result 2]
//    WHEN [val 3] THEN [result 3]
//    ......
//    WHEN [val n] THEN [result n]
//    ELSE [default result]
//    END
//    这里，第一个参数是要被判断的值或表达式，接下来的是一系列的WHEN-THEN块，每一块的第一个参数指定要比较的值，如果为真，就返回结果。所有的WHEN-THEN块将以ELSE块结束，当END结束了所有外部的CASE块时，如果前面的每一个块都不匹配就会返回ELSE块指定的默认结果。如果没有指定ELSE块，而且所有的WHEN-THEN比较都不是真，MySQL将会返回NULL。
//    CASE函数还有另外一种句法，有时使用起来非常方便，如下：
//    CASE
//    WHEN [conditional test 1] THEN [result 1]
//    WHEN [conditional test 2] THEN [result 2]
//    ELSE [default result]
//    END
//    这种条件下，返回的结果取决于相应的条件测试是否为真。
//    示例：
//    mysql>SELECT CASE 'green'
//         WHEN 'red' THEN 'stop'
//         WHEN 'green' THEN 'go' END;
//    SELECT CASE 9 WHEN 1 THEN 'a' WHEN 2 THEN 'b' ELSE 'N/A' END;
//    SELECT CASE WHEN (2+2)=4 THEN 'OK' WHEN(2+2)<>4 THEN 'not OK' END ASSTATUS;
//    SELECT Name,IF((IsActive = 1),'已激活','未激活') AS RESULT FROMUserLoginInfo;
//    SELECT fname,lname,(math+sci+lit) AS total,
//    CASE WHEN (math+sci+lit) < 50 THEN 'D'
//    WHEN (math+sci+lit) BETWEEN 50 AND 150 THEN 'C'
//    WHEN (math+sci+lit) BETWEEN 151 AND 250 THEN 'B'
//    ELSE 'A' END
//    AS grade FROM marks;
//    SELECT IF(ENCRYPT('sue','ts')=upass,'allow','deny') AS LoginResultFROM users WHERE uname = 'sue';#一个登陆验证
//
//    七、格式化函数
//    DATE_FORMAT(date,fmt)  依照字符串fmt格式化日期date值
//    FORMAT(x,y)   把x格式化为以逗号隔开的数字序列，y是结果的小数位数
//    INET_ATON(ip)   返回IP地址的数字表示
//    INET_NTOA(num)   返回数字所代表的IP地址
//    TIME_FORMAT(time,fmt)  依照字符串fmt格式化时间time值
//    其中最简单的是FORMAT()函数，它可以把大的数值格式化为以逗号间隔的易读的序列。
//    示例：
//    SELECT FORMAT(34234.34323432,3);
//    SELECT DATE_FORMAT(NOW(),'%W,%D %M %Y %r');
//    SELECT DATE_FORMAT(NOW(),'%Y-%m-%d');
//    SELECT DATE_FORMAT(19990330,'%Y-%m-%d');
//    SELECT DATE_FORMAT(NOW(),'%h:%i %p');
//    SELECT INET_ATON('10.122.89.47');
//    SELECT INET_NTOA(175790383);
//
//    八、类型转化函数
//    为了进行数据类型转化，MySQL提供了CAST()函数，它可以把一个值转化为指定的数据类型。类型有：BINARY,CHAR,DATE,TIME,DATETIME,SIGNED,UNSIGNED
//    示例：
//    SELECT CAST(NOW() AS SIGNED INTEGER),CURDATE()+0;
//    SELECT 'f'=BINARY 'F','f'=CAST('F' AS BINARY);
//
//    九、系统信息函数
//    DATABASE()   返回当前数据库名
//    BENCHMARK(count,expr)  将表达式expr重复运行count次
//    CONNECTION_ID()   返回当前客户的连接ID
//    FOUND_ROWS()   返回最后一个SELECT查询进行检索的总行数
//    USER()或SYSTEM_USER()  返回当前登陆用户名
//    VERSION()   返回MySQL服务器的版本
//    示例：
//    SELECT DATABASE(),VERSION(),USER();
//    SELECTBENCHMARK(9999999,LOG(RAND()*PI()));#该例中,MySQL计算LOG(RAND()*PI())表达式9999999次。

JS组件系列——BootstrapTable+KnockoutJS实现增删改查解决方案（一）
http://www.cnblogs.com/landeanfen/p/5400654.html
JS组件系列——Bootstrap组件福利篇：几款好用的组件推荐（二）
https://www.cnblogs.com/landeanfen/p/5603790.html
JS组件系列——BootstrapTable+KnockoutJS实现增删改查解决方案（三）：两个Viewmodel搞定增删改查
http://www.cnblogs.com/landeanfen/p/5667022.html
JS组件系列——BootstrapTable+KnockoutJS实现增删改查解决方案（四）：自定义T4模板快速生成页面
http://www.cnblogs.com/landeanfen/p/5656307.html