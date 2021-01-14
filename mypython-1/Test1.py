#-*- encoding=utf-8 -*-
print("hello world")
print("你好 ，中国！")

if True:
    print("true")
else:
    print("false")
    print("xxx")  #打印输出

print("hello world")
print('hello world')
print('''hello world''')

str0 = "xxx\r\n\r\nhello"
print(str0)

str0 = '''
xxx
fgfgh

sgfsdgf
sgd
''';
print(str0)

str0 = """
aa
dd
""";
#print(str)

str0 = "hello"
print(str0[0])
print(str0[2:4])
print(str0[2:])
print(str0[2:-1])
print(str0[:4])

# 字符串重复操作
print(str0 * 2)

# list 类似于数组 可赋值
list0 = [1, 2, 3, "hello"]
list0[0] = "123wer"
print(list0[0])
print(list0 * 2)
print(list0[0:3])

print(list0.__len__())

#tuple元组 只读不可赋值
t = (1,2,3,4,5,6,"aa")
#t[0] = 123 不可赋值
print(t[0])
print(t[:4])

#字典 等价于Java中的map 可赋值
dict0 = {100: "tom", "aa": "toms", 300: "tomslee"}
dict0[100] = "jerray"
print(dict0)
print(dict0[100])
print(dict0["aa"])

s = str(100)
print(s)
print(dict0)

s = "300"
print(int(s) + 200)

# eval 求值
s = "(100 +200 +400 * 2 ) / 3"
print(s)
print(eval(s))

#定义序列
seq = 5,6,7,8,9

# 将序列变换成元组 tuple
t = tuple(seq)
print(t)

# 将序列变换成列表 list
lst = list(seq)
print(lst)

#
seq2 = (1,11),(2,22),(3,33)
dd = dict(seq2);
print(dd)

# ** 幂运算
print(3**3)

# / 浮点除法  // 整除
print(1 / 2)
print(1 // 2)

a = 3
a *= 2
print(a)
a **= 2
print(a)

# 0按位取反
print(~0)
print(0 ^ -1)
print(2 << 3)
print(3 >> 2)
print(-1 >> 4)

print(0 and 1)
print(True and True)
print(True and False)

#in操作 判断范围
print(5 in t)
print(5 not in t)

#is 是身份运算符 等价于Java中的equals(内容)
a = 100
b = 100
print(a is b)
print(a is not b)

t1 = (1,2,3,4)
t2 = (1,2,3,4)
print(a == b)
print(a is b)

age = 12
#  if
if age < 20:
    print("小孩")
elif age >70:
    print("老人")
else:
    print("中间")

rows = [1,2,3,4,5,6,7,8,9]
cols = [1,2,3,4,5,6,7,8,9]
for r in rows :
    for c in cols:
        pass
        if c <= r :
            print("%d x %d = %d" % (c , r , (c * r)) ,end='\t')
    print()

print('===================')

r = 1 ;
while r <= 9 :
    c = 1 ;
    while c <= r :
        print("%d x %d = %d" % (c, r, (c * r)), end='\t')
        if c == 5:
            break ;
        c += 1
    print()
    r += 1

t1 = (1,2,3)
t2 = (2,3,"hello")


#del t1 删除变量

print(t1 + t2)
print(t1 * 3)
print(t1[-0])

print(max(t1))
s = "hello world"
s = s[0:3] + "ttt"
print(s)

#r"" 表示的原样输出，不需要转义
s = r"hello\r\nworld"
print(s)

print("16 is 0x%x" % (16))
print("15 is 0x%x" % (15))
print(u"\u89f7\u0020world")
print(u"\001")
print("\u0001")
print("\001")

del lst[2]
lst[:-2]
print(lst)

#1,2,4
print(len(lst[:-2]))
lst = [1,2,3,4,5]
lst.append(8)
lst.insert(0,9)
print(lst)
lst.clear()
lst = [1,2,3,4,5]
lst.pop(3)
print(lst)

#弹出索引位置的元素
lst.pop()

#删除的指定元素，不是索引
#lst.remove(8)
print(lst)

arr = [[1,2,3],[4,5,6],[7,8,9]]
print(arr)

list_2d = [[col for col in cols] for row in rows]
print(list_2d)
print(dd)

for xx in dd.values():
    print(xx)


#IO操作
f = open("d:/scala/test.txt")
lines = f.readlines()
for l in lines :
    print(l,end='')

f = open("d:/scala/test.txt")
lines = f.readline()
for l in lines :
    print(l,end='')

# while True :
#     l2 = f.readline();
#     if l2 == '':
#         break ;
#     else:
#         print(l2 , end = '')

f = open("d:/scala/test.txt",'a')
f.write("how are you!")
f.closed

# f1 = open("d:/Koala.jpg",'rb')
# f2 = open("d:/KKK.jpg", 'wb');
#
# #读取所有字节
# while True:
#     data = f1.read(1024 * 100)
#     if data != b'':
#         f2.write(data);
#     else :
#         break ;
# f1.closed
# f2.closed

#
# import os
# os.renames("d:/KKK.jpg","d:/YYY.jpg")
