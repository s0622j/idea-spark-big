# -*- encoding=utf-8 -*-

#高级线程接口
import threading

#低级接口
import _thread

'''
#定义函数
def hello(str):
    tname = threading.current_thread().getName()
    print(tname + " : " + str)

_thread.start_new_thread(hello,("helloworld",))
_thread.start_new_thread(hello,("helloworld",))

while True:
    pass;
'''
#定义函数
def hello():
    #获得当前线程的名字
    tname = threading.current_thread().getName()
    for i in [1,2,3,4,5,6,7,8,9]:
        print(tname + " : " + str(i))
        import sys
        import os
        # cc = int(time.time() * 1000)
        cc = time.ctime()
        print(cc)
#启动新线程
_thread.start_new_thread(hello,())
_thread.start_new_thread(hello,())




#切记主线程需要休眠一段时间，否则分线程效果看不到。
import time ;
time.sleep(3)