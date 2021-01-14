#-*- encoding=utf-8 -*-

import mysql.connector

'''
#获取连接conn
conn = mysql.connector.connect(host='localhost',port=3306,user='root',password='root',database='py',charset='utf8')
conn.autocommit=True #可以获取连接后设置为自动提交

#获取一个cursor 游标
cursor = conn.cursor()

# 执行sql
cursor.execute('select version()')

# 提取结果
version = cursor.fetchone()
print(version)

#关闭cursor和conn
cursor.close()
conn.close()
'''


try:
    #开启连接
    conn = mysql.connector.connect(host='localhost',port=3306,user='root',password='root',database='py',charset='utf8')
    #打开游标
    cur = conn.cursor()
    #执行sql
    i = 0 ;
    while i < 100 :
        sql = "insert into t1(name,age,date) values('%s',%d,now())" % ("tom" + str(i),i % 100);
        print(sql) ;
        cur.execute(sql)
        i += 1 ;
    conn.commit()
    #
    cur.close()
    conn.close()

except Exception:
    print("发生异常")


# '''
#   执行事务管理,手动提交事务，回滚事务。
# '''
# conn = pymysql.connect(host='localhost', user='root', passwd='root', db='python', port=3306, charset='utf8')
# try:
#     #关闭自动提交
#     conn.autocommit(False)
#     #开始事务
#     conn.begin()
#     #打开游标
#     cur = conn.cursor();
#     sql = "delete from t1 where id > 130000"
#     cur.execute(sql)
#     conn.commit()
#     cur.close
#
# except Exception:
#     conn.rollback()
# finally:
#     conn.close()


# '''
#     执行update.
# '''
# conn = pymysql.connect(host='localhost', user='root', passwd='root', db='python', port=3306, charset='utf8')
# try:
#     #关闭自动提交
#     conn.autocommit(False)
#     #开始事务
#     conn.begin()
#     #打开游标
#     cur = conn.cursor();
#     sql = "update t1 set age = age - 1 where age >= 50"
#     cur.execute(sql)
#     conn.commit()
#     cur.close
#
# except Exception:
#     conn.rollback()
# finally:
#     conn.close()


#
#
# '''
#     聚合查询，统计
# '''
# conn = pymysql.connect(host='localhost', user='root', passwd='root', db='python', port=3306, charset='utf8')
# try:
#     # 关闭自动提交
#     conn.autocommit(False)
#     # 开始事务
#     conn.begin()
#     # 打开游标
#     cur = conn.cursor();
#     sql = "select count(*) from t1 where age < 20"
#     cur.execute(sql)
#     res = cur.fetchone()
#     print(res[0])
#     conn.commit()
#     cur.close
#
# except Exception:
#     conn.rollback()
# finally:
#     conn.close()






#
#    调用mysql数据中的函数
#
# conn = pymysql.connect(host='localhost', user='root', passwd='root', db='python', port=3306, charset='utf8')
# try:
#     # 关闭自动提交
#     conn.autocommit(False)
#     # 开始事务
#     conn.begin()
#     # 打开游标
#     cur = conn.cursor();
#     sql = "select mydb2.sf_add(1,2)"
#     cur.execute(sql)
#     res = cur.fetchone()
#     print(res[0])
#     conn.commit()
#     cur.close
#
# except Exception:
#     conn.rollback()
# finally:
#     conn.close()


#
#    调用mysql数据中的存储过程
#
# conn = pymysql.connect(host='localhost', user='root', passwd='root', db='mydb2', port=3306, charset='utf8')
# try:
#     # 关闭自动提交
#     conn.autocommit(False)
#     # 开始事务
#     conn.begin()
#     # 打开游标
#     cur = conn.cursor();
#     sql = "call sp_batchinsert(100000)"
#     cur.execute(sql)
#     conn.commit()
#     cur.close
#     print("ok!!!")
# except Exception:
#     conn.rollback()
#     print("挂了!!")
# finally:
#     conn.close()