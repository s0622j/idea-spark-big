#-*- encoding=utf-8 -*-

import mysql.connector

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