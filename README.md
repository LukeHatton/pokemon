# 捕获率计算

## 1.立项原因
+ 在玩3DS 口袋妖怪究极之日(Poket Monsters Ultra Sun)时捕捉神兽,一开始我还是和和九岁时用GBA玩红宝石捉神兽一样,只能碰运气,很耗时间,还容易产生挫败感,非常难受,遂决定开发此服务,将不同情况下的捕获率和期望掷球量化出来,让玩家在尝试捕捉前有一个心理预期

## 2.项目架构
+ 因为不会有什么并发量,所以springboot+虚拟服务器的结构应该就够用了,只提供一个简单的前端入口即可

## 3.开发分项
+ 捕获率计算公式  
&emsp;来自于[口袋妖怪维基](https://wiki.52poke.com/wiki/%E6%8D%95%E8%8E%B7%E7%8E%87#.E6.8D.95.E8.8E.B7.E7.8E.87.E4.BF.AE.E6.AD.A3)  
&emsp;对于捕获率,根据个人感觉做出了一些调整,使其更贴近与游戏中实际的感觉

+ 缺点  
&emsp;针对普通精灵计算得出捕获率要比游戏中的实际体验要低15%~20%
