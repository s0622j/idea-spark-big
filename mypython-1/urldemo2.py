# -*- encoding=utf-8 -*-

import urllib.request
import os
import re

# #打开url地址上的资源
# resp2 = urllib.request.urlopen("http://www.baidu.com")
# resp = urllib.request.urlopen("http://www.python.org")
# # print(resp2.read().decode("utf8"))
# # #读取资源内容，作为bytes读取
# mybytes = resp2.read()
# # #解码bytes成为string
# mystr = mybytes.decode("utf8")
# # #关闭资源
# resp.close()
# #
# # #下载
# f = open("d:/scala/baidu.html",'wb')
# f.write(mybytes);
# f.close()
# #
# # #输出
# print(mystr)

#===================
#下载
resp = urllib.request.urlopen("https://i0.hdslb.com/bfs/article/945fe8d2dcdcc850138adeca21141f653d74e68d.jpg@1320w_742h.webp")
cont = resp.read()
resp.close()
# pageHtml = cont.decode("utf-8")
# print(pageHtml) ;
#保存
f = open("d:/scala/fz.jpg","wb")
f.write(cont);
f.close()
#
# def fileExists(url,localpath):
#     path = url ;
#     path = path.replace(":", "_");
#     path = path.replace("/", "$");
#     path = path.replace("?", "$");
#     path = localpath + "/" + path;
#     return os.path.exists(path) ;
#
# #下载网页方法
# def download(url):
#     #处理处理问题
#     path = url ;
#     path = path.replace(":","_");
#     path = path.replace("/","$");
#     path = path.replace("?","$");
#     path = "d:/scala/jd/" + path;
#
#     #判断当前的网页是否已经下载
#     resp = urllib.request.urlopen(url)
#     pageBytes = resp.read()
#     resp.close
#
#     if not os.path.exists(path):
#         #保存文件到磁盘
#         f = open(path,"wb");
#         f.write(pageBytes) ;
#         f.close();
#
#     try:
#         #解析网页的内容
#         pageStr = pageBytes.decode("utf-8");
#         #解析href地址
#         pattern = u'<a[\u0000-\uffff&&^[href]]*href="([\u0000-\uffff&&^"]*?)"'
#         res = re.finditer(pattern, pageStr)
#         for r in res:
#             addr = r.group(1);
#             print(addr)
#             if addr.startswith("//"):
#                 addr = addr.replace("//","http://");
#
#             #判断网页中是否包含自己的地址
#             if (addr.startswith("http://") and not fileExists(addr,"d:/scala/jd")):
#                 download(addr) ;
#
#     except Exception as e:
#         #print(url + " : 不是文本") ;
#         #print(Exception)
#         print(e)
#         print(pageBytes.decode("gbk", errors='ignore'));
#         return ;
#
# download("http://www.it18zhang.com");
