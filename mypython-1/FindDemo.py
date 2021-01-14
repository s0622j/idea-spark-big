#-*- encoding=utf-8 -*-

import mysql.connector


try:
    #开启连接
    conn = mysql.connector.connect(host='localhost',port=3306,user='root',password='root',database='py',charset='utf8')
    #打开游标
    cur = conn.cursor()
    #执行sql
    sql = "select id,name,age,date from t1;"
    cur.execute(sql);
    all = cur.fetchall();
    for rec in all:
        print(rec)
        print(str(rec[0]) + "," + rec[1] + "," + str(rec[2]))


    conn.commit()
    #
    cur.close()
    conn.close()

except Exception:
    print("发生异常")
