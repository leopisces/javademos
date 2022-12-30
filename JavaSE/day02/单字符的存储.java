package day02;/*
单字符char类型数据的存储？
1、先把每一个字符用一个整数值表示。
最早计算机能表示的所有字符只有128个。 编码值范围0-127。
把这张字符与整数对应的表称为ASCII表。

计算机又流行到其他地方。不同的国家就动起了剩下的128个位置的念头。
1个字节一共可以有256种值的情况。

（1）出现问题，无法在同一个文档中，表示不同国家的字符。
（2）计算机流行到亚洲系列，256个也是远远不够。
中国又开始研究自己的编码表，比如GB2312，GBK，Big5

（3）为了解决上面问题，提出了万国码，Unicode编码表。

2、Java选择使用Unicode编码表。
char类型占2个字节。
编码范围是0-65535范围。
同时Unicode编码表会兼容ASCII表(0-127)。
'a' -> 97
'b' -> 98
...
'A' -> 65
'B' -> 66
...
'0' -> 48
'1' -> 49
...
空格 -> 32
...

刚才说的ASCII表和Unicode编码表，这些是处理数据在“内存”中的方式。


UTF-8，GBK，ISO8859-1等又是什么？
这些是环境编码。当把字符等存储到硬盘文件中，或者网络中传输时，
使用的编码。
为什么有这么多种编码，要在String章节再讲解。

*/