# data-structure
数据结构与算法

#### 01 为什么要学习数据结构与算法

- 数据结构和算法
- 操作系统
- 计算机网络



**时间复杂度**

**空间复杂度**

#### 02 如何高效学习数据结构与算法



**广义**

数据结构就是指一组数据的存储格式。

算法就是操作数据的一组方法。

**狭义**

指著名 的数据结构和算法，比如 队列、栈、堆、二分查找、动态规划等



**数据结构是为算法服务的，算法要作用在特定的数据机构中**



##### 学习重点

- 复杂度分析

![913e0ababe43a2d57267df5c5f0832a7](./913e0ababe43a2d57267df5c5f0832a7.jpg)



**常用基础数据结构和算法**

- 数据结构
  - 数组
  - 链表
  - 栈
  - 队列
  - 散列表
  - 二叉树
  - 堆
  - 跳表
  - 图
  - Trie 数
- 算法
  - 递归
  - 排序
  - 二分查找
  - 搜索
  - 哈希算法
  - 贪心算法
  - 分治算法
  - 回溯算法
  - 动态规划
  - 字符串匹配



#### 03 复杂度分析（上）：如何分析、统计算法的执行效率和资源消耗

**快** **省**

- 时间复杂度
- 空间复杂度



##### 为什么要复杂度分析？

1. 测试结果非常依赖测试环境
2. 测试结果受数据规模的影响很大

##### 大 O 复杂度表示法

```java
public int cal(int n) {
    int sum = 0;
    int i = 1;
    for(;int i <= n; ++i) {
        sum = sum + i;
    }
    return sum;
}
```

**读数据-运算-写数据**

假设每行代码执行时间一样，为 **unit_time**

2、3 行代码分别要 1 个 **unit_time** 的执行时间

4、5 行代码运行了 n 遍

共 （2n+2）unit_time 的时间

代码的执行时间 **T(n)** 和每行代码的执行次数成正比



```java
 public int cal(int n) {
   int sum = 0;
   int i = 1;
   int j = 1;
   for (; i <= n; ++i) {
     j = 1;
     for (; j <= n; ++j) {
       sum = sum +  i * j;
     }
   }
 }

```

T(n) = (2n2+2n+3)*unit_time  

![22900968aa2b190072c985a08b0e92ef](./22900968aa2b190072c985a08b0e92ef.png)



我来具体解释一下这个公式。其中，T(n) 我们已经讲过了，它表示代码执行的时间；n 表示数据规模的大小；f(n) 表示表示每行代码执行的次数总和。因为这是一个公式，所以用 f(n) 来表示。公式中的 O，表示代码的执行时间 T(n) 与  f(n) 表达式成正比。

**大O时间复杂度表示法**

并不具体表示代码真正的执行时间，而是表示代码执行时间随数据规模增长的变化趋势，也叫**渐进时间复杂度**

T(n) = O(n)； T(n) = O(n2)。



##### 时间复杂度分析

- 只关注循环执行次数最多的一段代码

```c++
 int cal(int n) {
   int sum = 0;
   int i = 1;
   for (; i <= n; ++i) {
     sum = sum + i;
   }
   return sum;
 }

```



- 加法法则：总复杂度等于量级最大的那段代码的复杂度

```c++
int cal(int n) {
   int sum_1 = 0;
   int p = 1;
   for (; p < 100; ++p) {
     sum_1 = sum_1 + p;
   }

   int sum_2 = 0;
   int q = 1;
   for (; q < n; ++q) {
     sum_2 = sum_2 + q;
   }
 
   int sum_3 = 0;
   int i = 1;
   int j = 1;
   for (; i <= n; ++i) {
     j = 1; 
     for (; j <= n; ++j) {
       sum_3 = sum_3 +  i * j;
     }
   }
 
   return sum_1 + sum_2 + sum_3;
 }

```

- 乘法法则：嵌套代码的复杂度等于嵌套内外代码复杂度的乘积

```c
int cal(int n) {
   int ret = 0; 
   int i = 1;
   for (; i < n; ++i) {
     ret = ret + f(i);
   } 
 } 
 
 int f(int n) {
  int sum = 0;
  int i = 1;
  for (; i < n; ++i) {
    sum = sum + i;
  } 
  return sum;
 }

```



##### 几种常见复杂度示例分析

![3723793cc5c810e9d5b06bc95325bf0a](./3723793cc5c810e9d5b06bc95325bf0a.jpg)

- 多项式量级
- 非多项式量级 **O(2n) 和 O(n!)**

##### 空间复杂度分析

表示算法的存储空间和数据规模之间的增长关系

```java
void print(int n) {
  int i = 0;
  int[] a = new int[n];
  for (i; i <n; ++i) {
    a[i] = i * i;
  }

  for (i = n-1; i >= 0; --i) {
    print out a[i]
  }
}
```



![497a3f120b7debee07dc0d03984faf04](./497a3f120b7debee07dc0d03984faf04.jpg)



####  04 复杂度分析（下）：浅析最好、最坏、平均、均摊时间复杂度

- 最好情况时间复杂度
- 最坏情况时间复杂度
- 平均情况时间复杂度
- 均摊时间复杂度

##### 最好、最坏情况时间复杂度

```java
// n 表示数组 array 的长度
int find(int[] array, int n, int x) {
  int i = 0;
  int pos = -1;
  for (; i < n; ++i) {
    if (array[i] == x) pos = i;
  }
  return pos;
}
```



### 05 数组：为什么很多编程语言中数组都从 0 开始编号？



##### 如何实现随机访问？

**数组是一种线性表数据结构。用一组连续的内存空间，来存储一组具有相同类型的数据。**

- 线性表

  - 数组
  - 链表
  - 队列
  - 栈

  ![b6b71ec46935130dff5c4b62cf273477](./b6b71ec46935130dff5c4b62cf273477.jpg)

- 非线性表

  - 二叉树
  - 堆
  - 图

  ![6ebf42641b5f98f912d36f6bf86f6569](./6ebf42641b5f98f912d36f6bf86f6569.jpg)

- 连续的内存空间和相同类型的数据

![98df8e702b14096e7ee4a5141260cdc4](./98df8e702b14096e7ee4a5141260cdc4.jpg)

##### 低效的**"插入"**和**"删除"**

- 插入操作
- 删除操作



**警惕数组的访问越界问题**



##### 容器能否完全代替数组？

**ArrayList 优势**

-  将很多数组操作的细节封装起来
- 支持动态扩容
- 自动扩容 1.5 倍

```java
ArrayList<User> users = new ArrayList(10000);
for (int i = 0; i < 10000; ++i) {
  users.add(xxx);
}
```



用数组更适合的情况：

- Java ArrayList 无法存储基础数据类型，例如 int、long，需要封装成 Integer、Long 类，而 Autoboxing、unboxing 则有一定的性能消耗，所以如果特备关注性能，或者系统使用基本类型，就可以选用数组
- 如果数据大小事先已知，并且对数据的操作非常简单，用不到ArrayList 提供的大部分方法，也可以直接使用数组
- 多维数组



### 06 链表（上）：如何实现 LRU 缓存淘汰算法？

链表应用场景：LRU缓存淘汰算法



#### 缓存

- CPU 缓存
- 数据库缓存
- 浏览器缓存

#### 缓存淘汰策略

- 先进先出策略 FIFO
- 最少使用策略 LFU
- 最近最少使用策略 LRU

#### 五花八门的链表结构

![d5d5bee4be28326ba3c28373808a62cd](./d5d5bee4be28326ba3c28373808a62cd.jpg)

- 单链表
- 双向链表
- 循环链表

##### 单链表

![b93e7ade9bb927baad1348d9a806ddeb](./b93e7ade9bb927baad1348d9a806ddeb.jpg)

- 头结点
  - 记录链表的基地址
- 尾结点
  - 指针不是指向下一个结点，而是指向一个空地址 NULL，表示这是链表上最后一个结点

查找、插入、删除

![452e943788bdeea462d364389bd08a17](./452e943788bdeea462d364389bd08a17.jpg)

随机查找：

时间复杂度 O(n)

##### 循环链表

![86cb7dc331ea958b0a108b911f38d155](./86cb7dc331ea958b0a108b911f38d155.jpg)

##### 双向链表

![cbc8ab20276e2f9312030c313a9ef70b](./cbc8ab20276e2f9312030c313a9ef70b.jpg)

##### 链表 VS 数组性能比较

![4f63e92598ec2551069a0eef69db7168](./4f63e92598ec2551069a0eef69db7168.jpg)



### 07 链表（下）：如何轻松写出正确的链表代码



- **技巧一**：理解指针或引用的含义

  将某个变量赋值给指针，实际上就是将这个变量的地址赋值给指针，或者反过来说，指针中存储了这个变量的内存地址，指向了这个变量，通过指针就能找到这个变量。

- **技巧二**：警惕指针丢失和内存泄漏

- **技巧三**：利用哨兵简化实现难度

- **技巧四**：重点留意边界条件处理

  - 如果链表为空时，代码是否能正常工作？
  - 如果链表只包含一个结点时，代码是否能正常工作？
  - 如果链表只包含两个结点时，代码是否能正常工作？
  - 代码逻辑在处理头结点和尾结点时，是否能正常工作？

**5 个常见的链表操作**

- 单链表反转

  ```java
  /*
  public class ListNode {
      int val;
      ListNode next = null;
  
      ListNode(int val) {
          this.val = val;
      }
  }*/
  public class Solution {
      public ListNode ReverseList(ListNode head) {
         
          if(head==null)
              return null;
          //head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
          ListNode pre = null;
          ListNode next = null;
          //当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
          //需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
          //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
          //所以需要用到pre和next两个节点
          //1->2->3->4->5
          //1<-2<-3 4->5
          while(head!=null){
              //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
              //如此就可以做到反转链表的效果
              //先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
              next = head.next;
              //保存完next，就可以让head从指向next变成指向pre了，代码如下
              head.next = pre;
              //head指向pre后，就继续依次反转下一个节点
              //让pre，head，next依次向后移动一个节点，继续下一次的指针反转
              pre = head;
              head = next;
          }
          //如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
          //直接输出pre就是我们想要得到的反转后的链表
          return pre;
      }
  }
  ```

- 链表中环的检测

- ```java
  
  ```

- 两个有序的链表合并

- 删除链表倒数第 n 个结点

- 求链表的中间结点



### 08 栈：如何实现浏览器的前进和后退功能？



栈是一种操作受限的线性表，只允许在一端插入和删除数据。

- 用数组实现的栈，叫顺序栈
- 用链表实现的栈，叫链式栈

```java
// 基于数组实现的顺序栈
public class ArrayStack {
  private String[] items;  // 数组
  private int count;       // 栈中元素个数
  private int n;           // 栈的大小

  // 初始化数组，申请一个大小为 n 的数组空间
  public ArrayStack(int n) {
    this.items = new String[n];
    this.n = n;
    this.count = 0;
  }

  // 入栈操作
  public boolean push(String item) {
    // 数组空间不够了，直接返回 false，入栈失败。
    if (count == n) return false;
    // 将 item 放到下标为 count 的位置，并且 count 加一
    items[count] = item;
    ++count;
    return true;
  }
  
  // 出栈操作
  public String pop() {
    // 栈为空，则直接返回 null
    if (count == 0) return null;
    // 返回下标为 count-1 的数组元素，并且栈中元素个数 count 减一
    String tmp = items[count-1];
    --count;
    return tmp;
  }
}

```



### 09 队列：队列在线程池等有限资源池中的应用



#### 如何理解“队列”？

队列是一种操作受限的线性表数据结构。



- 循环队列
- 阻塞队列
- 并发队列 

**Disruptor、Linux 环形缓存** 循环并发队列。

**Java concurrent** 并发包利用 **ArrayBlockingQueue** 实现公平锁。



#### 顺序队列和链式队列

先进先出

队尾插入，队头删除

用数组实现的队列叫做顺序队列，用链表实现的队列叫做链式队列

```java
// 用数组实现的队列
public class ArrayQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head 表示队头下标，tail 表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为 capacity 的数组
  public ArrayQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 如果 tail == n 表示队列已经满了
    if (tail == n) return false;
    items[tail] = item;
    ++tail;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果 head == tail 表示队列为空
    if (head == tail) return null;
    // 为了让其他语言的同学看的更加明确，把 -- 操作放到单独一行来写了
    String ret = items[head];
    ++head;
    return ret;
  }
}

```

**数据搬移**

**基于链表的队列实现方法**



**循环队列**

```java
public class CircularQueue {
  // 数组：items，数组大小：n
  private String[] items;
  private int n = 0;
  // head 表示队头下标，tail 表示队尾下标
  private int head = 0;
  private int tail = 0;

  // 申请一个大小为 capacity 的数组
  public CircularQueue(int capacity) {
    items = new String[capacity];
    n = capacity;
  }

  // 入队
  public boolean enqueue(String item) {
    // 队列满了
    if ((tail + 1) % n == head) return false;
    items[tail] = item;
    tail = (tail + 1) % n;
    return true;
  }

  // 出队
  public String dequeue() {
    // 如果 head == tail 表示队列为空
    if (head == tail) return null;
    String ret = items[head];
    head = (head + 1) % n;
    return ret;
  }
}
```



**阻塞队列和并发队列**

- 阻塞队列 生产者和消费者模型
- 并发队列 线程安全的队列  CAS 原子操作



线程池没有空闲线程时，新的任务请求线程资源时，线程池该如何处理？各种处理策略又是如何实现的呢？

**两种处理策略**

- 非阻塞的处理方式，直接拒绝任务请求
- 阻塞方式，将请求排队，等到有空闲线程时，取出排队的请求继续处理。

如何存储排队的请求呢？

队列来存储排队请求。

- 基于链表的实现方式，可以实现一个支持无线排队的无界队列，但是可能导致过多的请求排队等待，请求处理的响应时间过长。所以，针对响应时间比较敏感的系统，基于链表实现的无限排队的线程池是不合适的。
- 基于数组实现的有界队列，队列的大小有限，所以线程池中排队的请求超过队列大小时，接下来的请求就会被拒绝，这种方式对响应时间敏感的系统来说，就相对更加合理。



### 10 递归：如何用三行大吗找到“最终推荐人”？

- 动态规划
- 递归
  - DFS 深度优先搜索
  - 前中后序二叉树遍历



#### 递归需要满足的三个条件

1. 一个问题的解可以分解为几个子问题的解
2. 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
3. 存在递归终止条件



- 堆栈溢出  设置深度 depth
- 重复计算 散列表保存已经计算好的值

```java
long findRootReferrerId(long actorId) {
  Long referrerId = select referrer_id from [table] where actor_id = actorId;
  if (referrerId == null) return actorId;
  return findRootReferrerId(referrerId);
}
```



### 11 排序（上）：为什么插入排序比冒泡排序更受欢迎？

- 猴子排序
- 睡眠排序
- 面条排序
- 冒泡排序
- 插入排序
- 选择排序
- 归并排序
- 快速排序
- 计数排序
- 基数排序
- 桶排序

![fb8394a588b12ff6695cfd664afb17cd](./fb8394a588b12ff6695cfd664afb17cd.jpg)



#### 如何分析一个“排序算法”

**排序算法的执行效率**

- 最好情况、最坏情况、平均情况时间复杂度
- 时间复杂度的系数、常数、低阶
- 比较次数和交换（或者移动）次数

**排序算法的内存消耗**

算法的内存消耗可以通过空间复杂度来衡量。

**原地排序**，特指空间复杂度是O(1)的排序算法。

**排序算法的稳定性**



#### 冒泡排序

```java
// 冒泡排序，a 表示数组，n 表示数组大小
public void bubbleSort(int[] a, int n) {
  if (n <= 1) return;
 
 for (int i = 0; i < n; ++i) {
    // 提前退出冒泡循环的标志位
    boolean flag = false;
    for (int j = 0; j < n - i - 1; ++j) {
      if (a[j] > a[j+1]) { // 交换
        int tmp = a[j];
        a[j] = a[j+1];
        a[j+1] = tmp;
        flag = true;  // 表示有数据交换      
      }
    }
    if (!flag) break;  // 没有数据交换，提前退出
  }
}
```



**1. 冒泡排序是原地排序算法吗？**

**2. 冒泡排序是稳定的排序算法吗？**

**3. 冒泡排序的时间复杂度是多少？**

**有序度**

#### 插入排序

```java
// 插入排序，a 表示数组，n 表示数组大小
public void insertionSort(int[] a, int n) {
  if (n <= 1) return;

  for (int i = 1; i < n; ++i) {
    int value = a[i];
    int j = i - 1;
    // 查找插入的位置
    for (; j >= 0; --j) {
      if (a[j] > value) {
        a[j+1] = a[j];  // 数据移动
      } else {
        break;
      }
    }
    a[j+1] = value; // 插入数据
  }
}
```



**1. 插入排序是原地排序算法吗？**

**2. 插入排序是稳定的排序算法吗？**

**3. 插入排序的时间复杂度是多少？**

#### 选择排序



冒泡排序和插入排序的时间复杂度都是 O(n2)，都是原地排序。



### 12 排序（下）：如何使用快排思想在O(n)内查找第 K 大元素？

**O(n2)**

- 冒泡排序
- 插入排序
- 选择排序

**nlogn**

- 归并排序
- 快速排序

分治思想

#### 归并排序

如果要排序一个数组，我们先把数组从中间分成前后两部分，然后对前后两部分分别排序，在将排好序的两部分合并在一起。

```java
递推公式：
merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))

终止条件：
p >= r 不用再继续分解
```

```java
// 归并排序算法, A 是数组，n 表示数组大小
merge_sort(A, n) {
  merge_sort_c(A, 0, n-1)
}

// 递归调用函数
merge_sort_c(A, p, r) {
  // 递归终止条件
  if p >= r  then return

  // 取 p 到 r 之间的中间位置 q
  q = (p+r) / 2
  // 分治递归
  merge_sort_c(A, p, q)
  merge_sort_c(A, q+1, r)
  // 将 A[p...q] 和 A[q+1...r] 合并为 A[p...r]
  merge(A[p...r], A[p...q], A[q+1...r])
}

```

```java
merge(A[p...r], A[p...q], A[q+1...r]) {
  var i := p，j := q+1，k := 0 // 初始化变量 i, j, k
  var tmp := new array[0...r-p] // 申请一个大小跟 A[p...r] 一样的临时数组
  while i<=q AND j<=r do {
    if A[i] <= A[j] {
      tmp[k++] = A[i++] // i++ 等于 i:=i+1
    } else {
      tmp[k++] = A[j++]
    }
  }
  
  // 判断哪个子数组中有剩余的数据
  var start := i，end := q
  if j<=r then start := j, end:=r
  
  // 将剩余的数据拷贝到临时数组 tmp
  while start <= end do {
    tmp[k++] = A[start++]
  }
  
  // 将 tmp 中的数组拷贝回 A[p...r]
  for i:=0 to r-p do {
    A[p+i] = tmp[i]
  }
}
```



#### 快速排序的原理

如果要排序数组中下标 P 到 R 之间的一组数据，我们选择 P 到 R 之间的任意一个数据作为 PIVOT（分区点）

```java
递推公式：
quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1, r)

终止条件：
p >= r
```



```java
// 快速排序，A 是数组，n 表示数组的大小
quick_sort(A, n) {
  quick_sort_c(A, 0, n-1)
}
// 快速排序递归函数，p,r 为下标
quick_sort_c(A, p, r) {
  if p >= r then return
  
  q = partition(A, p, r) // 获取分区点
  quick_sort_c(A, p, q-1)
  quick_sort_c(A, q+1, r)
}
```



```java
partition(A, p, r) {
  pivot := A[r]
  i := p
  for j := p to r-1 do {
    if A[j] < pivot {
      swap A[i] with A[j]
      i := i+1
    }
  }
  swap A[i] with A[r]
  return i
```



### 13 线性排序：如何根据年龄给100万用户数据排序？

- 常用排序算法的原理
- 时间复杂度
- 空间复杂度
- 稳定性



**线性排序**

- 桶排序
- 计数排序
- 基数排序



#### 桶排序

桶排序比较适合用在外部排序中。外部排序是指数据存储在外部磁盘中，数据量比较大，内存邮箱，无法将数据全部加载到内存中。



#### 计数排序

计数排序其实是桶排序的一种特殊情况。当要排序的n个数据，所处的范围并不大的时候，比如最大值是k，我们就可以把数据划分成 k 个桶。没个桶内的数据值都是相同的，省掉了桶内排序的时间。

```java
// 计数排序，a 是数组，n 是数组大小。假设数组中存储的都是非负整数。
public void countingSort(int[] a, int n) {
  if (n <= 1) return;

  // 查找数组中数据的范围
  int max = a[0];
  for (int i = 1; i < n; ++i) {
    if (max < a[i]) {
      max = a[i];
    }
  }

  int[] c = new int[max + 1]; // 申请一个计数数组 c，下标大小 [0,max]
  for (int i = 0; i <= max; ++i) {
    c[i] = 0;
  }

  // 计算每个元素的个数，放入 c 中
  for (int i = 0; i < n; ++i) {
    c[a[i]]++;
  }

  // 依次累加
  for (int i = 1; i <= max; ++i) {
    c[i] = c[i-1] + c[i];
  }

  // 临时数组 r，存储排序之后的结果
  int[] r = new int[n];
  // 计算排序的关键步骤，有点难理解
  for (int i = n - 1; i >= 0; --i) {
    int index = c[a[i]]-1;
    r[index] = a[i];
    c[a[i]]--;
  }

  // 将结果拷贝给 a 数组
  for (int i = 0; i < n; ++i) {
    a[i] = r[i];
  }
}
```

**计数排序只能用在范围不大的场景中，如果数据范围k比要排序的数据n大很多，就不适用计数排序了。而且，计数排序只能给非负整数排序，如果要排序的是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。**

#### 基数排序



### 14 排序优化：如何实现一个通用的、高性能的排序函数？



#### 如何优化快速排序

**最理想的区分点是：**被区分点分开的两个分区中，数据的数量差不多

- 三数取中法
- 随机法



### 15 二分查找（上）：如何用最省内存的方式实现快速查找功能



**二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为0。**

```java
public int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while(low <= high) {
        int mid = (low + high)/2;
        if(a[mid] == value)
        	return mid;
        else if(a[mid] < value)
        	low = mid + 1；
        else
        	high = mid - 1;
    }
    return -1;
}
```

**容易出错的 3 个地方**

1. 循环退出的条件

   注意是 low <= high ，不是 low < high

2. mid 的取值

   (low + high)/2 是有问题的。如果 low 和 high

    比较大的话，两者之和可能溢出。

   改进： low + (high - low)/2

   ​            low + ((high-low)>>1) 

3. low 和 high 的更新

   low = mid + 1, high = mid -1； 如果直接写成 low = mid 或者 high = mid 就可能发生死循环。

```java
// 二分查找的递归实现
public int bsearch(int[] a, int n, int val) {
  return bsearchInternally(a, 0, n - 1, val);
}

private int bsearchInternally(int[] a, int low, int high, int value) {
  if (low > high) return -1;

  int mid =  low + ((high - low) >> 1);
  if (a[mid] == value) {
    return mid;
  } else if (a[mid] < value) {
    return bsearchInternally(a, mid+1, high, value);
  } else {
    return bsearchInternally(a, low, mid-1, value);
  }
}

```



**二分查找应用的局限性**

- 二分查找依赖的是顺序表结构，简单点说就是数组
- 二分查找针对的是有序数据
- 数据量太小不适合二分查找
- 数据量太大也不适合二分查找



### 16 二分查找（下）：如何快速定位 IP 对应的省份地址？

**四种常见的二分查找变形问题**

- 查找第一个值等于给定值得元素
- 查找最后一个值等于给定值的元素
- 查找第一个大于等于给定值的元素
- 查找最后一个小于等于给定值的元素



#### 变体一：查找第一个值等于给定值得元素

```java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid = low + ((high - low) >> 1);
    if (a[mid] >= value) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  if (low < n && a[low]==value) return low;
  else return -1;
}
```



```java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] > value) {
      high = mid - 1;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      if ((mid == 0) || (a[mid - 1] != value)) return mid;
      else high = mid - 1;
    }
  }
  return -1;
}
```



#### 变体二：查找最后一个值等于给定值的元素

```java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] > value) {
      high = mid - 1;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
      else low = mid + 1;
    }
  }
  return -1;
}
```

#### 变体三：查找第一个大于等于给定值的元素

```java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] >= value) {
      if ((mid == 0) || (a[mid - 1] < value)) return mid;
      else high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
}
```

#### 变体四：查找最后一个小于等于给定值的元素

```java
public int bsearch7(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] > value) {
      high = mid - 1;
    } else {
      if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
      else low = mid + 1;
    }
  }
  return -1;
}
```



### 17 跳表：为什么 Redis 一定要用跳表来实现有序集合？

**二分查找底层依赖的是数组随机访问的特性，所以只能用数组来实现。** 



如果数据存储在链表中，没法用二分查找了吗？

**跳表**

动态数据结构，可以支持快速的插入、删除、查找操作。



Redis 中的有序集合（Sorted Set）就是用跳表实现的。



**如何理解“跳表”**

链表加多级索引的结构



### 18 散列表（上）：Word文档中的单词拼写检查功能是如何实现的？

**散列表用的是数组支持按照下标随机访问数据的特性，所以散列表其实就是数组的一种扩展，由数组演化而来。可以说，如果没有数组，就没有散列表。**

#### 散列函数



**hash(key)**

- 散列函数计算得到的散列值是一个非负整数
- 如果 key1 = key2, 那 hash(key1) == hash(key2)
- 如果 key1 != key2, 那 hash(key1) != hash(key2)



#### 散列冲突

- 开放寻址法
- 链表法

**1. 开放寻址法**

核心思想：如果出现了散列冲突，我们就重新探测一个空闲位置，将其插入。

**线性探测**

**二次探测**

**双重散列**

**2. 链表法**

### 19 散列表（中）：如何打造一个工业级水平的散列表



#### 装载因子过大了怎么办？

装载因子越大，说明散列表中的元素越多，空闲位置越少，散列冲突的概率就越大。不仅插入数据的过程要多次寻址或者拉很长的链，查找过程也会因此变得很慢。

**动态扩容**



#### 如果避免低效扩容？

将扩容操作穿插在插入操作的过程中，分批完成。当装载因子达到阈值时，我们只申请新空间，但并不将老的数据搬移到新散列表中。



#### 如何选择重入解决方法？



- Java 中 LinkedHashMap 就是用链表法解决冲突。
- ThreadLocalMap 使用线性探测的开放寻址法来解决冲突。

1. 开放寻址法

   散列表中的数据都存储在数组中，可以有效的利用CPU缓存加快查询速度。

   序列化比较简单。

   链表法包含指针，序列换就没那么容易。

   删除数据比较麻烦。

   使用开放寻址法解决冲突的散列表，装载因子的上线不能太大。这也导致这种方法比链表法更浪费内存空间。

   **总结，当数据量比较小，装载因子小的时候，适合采用开放寻址法。 Java 中 ThreadLocalMap 使用开放寻址法解决散列冲突的原因。**

2. 链表法

   链表法对内存的利用率比开放寻址法要高。因为链表节点可以在需要的时候再去进行创建，并不需要像开放寻址法那样事先申请好。也是链表优于数组的地方。

   链表法对比开放寻址法，对大装载因子的容忍度更高。开放寻址法只能使用装载因子小于1 的情况。接近 1 时，就可能出现大量的散列冲突，导致大量的探测、再散列等，性能下降。

   对于链表法，只要散列函数的值随机均匀，即使装载因子变成10，也就是链表的长度变长，虽然查询效率下降，但是比顺序查找快。

   **总结，基于链表的散列冲突处理方法比较适合存储大对象、大数据量的散列表，而且，比起开放寻址法，它更加灵活，支持更多的优化策略，比如红黑树代替链表。**



**HashMap**

- 初始大小

  HashMap 默认的初始大小是 16，这个可以设置。

- 装载因子和动态扩容

  最大装载因子默认是 0.75, 当 HashMap 中元素个数超过 0.75*capacity （capacaity 表示散列表的容量）的时候，就会启动扩容，每次扩容都会扩容为原来的两倍大小。

- 散列冲突解决方法

  HashMap 底层采用链表法解决冲突。

  JDK 1.8 , 对 HashMap 进行了优化，引入了 红黑树。

- 散列函数

  ```java
  int hash(Object key) {
      int h = key.hashCode()；
      return (h ^ (h >>> 16)) & (capitity -1); //capicity 表示散列表的大小
  }
  ```

**摘自评论：**

```java
int hash(Object key) {
    int h = key.hashCode()；
    return (h ^ (h >>> 16)) & (capitity -1); //capicity 表示散列表的大小
}

先补充下老师使用的这段代码的一些问题：在JDK HashMap源码中，是分两步走的：
1. hash值的计算，源码如下：
static final int hash(Object key) {
        int hash;
        return key == null ? 0 : (hash = key.hashCode()) ^ hash >>> 16;
 }

2. 在插入或查找的时候，计算Key被映射到桶的位置：
int index = hash(key) & (capacity - 1)

----------------------------
JDK HashMap中hash函数的设计，确实很巧妙：

首先hashcode本身是个32位整型值，在系统中，这个值对于不同的对象必须保证唯一（JAVA规范），这也是大家常说的，重写equals必须重写hashcode的重要原因。

获取对象的hashcode以后，先进行移位运算，然后再和自己做异或运算，即：hashcode ^ (hashcode >>> 16)，这一步甚是巧妙，是将高16位移到低16位，这样计算出来的整型值将“具有”高位和低位的性质

最后，用hash表当前的容量减去一，再和刚刚计算出来的整型值做位与运算。进行位与运算，很好理解，是为了计算出数组中的位置。但这里有个问题：
为什么要用容量减去一？
因为 A % B = A & (B - 1)，所以，(h ^ (h >>> 16)) & (capitity -1) = (h ^ (h >>> 16)) % capitity，可以看出这里本质上是使用了「除留余数法」

综上，可以看出，hashcode的随机性，加上移位异或算法，得到一个非常随机的hash值，再通过「除留余数法」，得到index，整体的设计过程与老师所说的“散列函数”设计原则非常吻合！

```



### 20 散列表（下）：为什么散列表和链表经常会一起使用？



- LRU 缓存淘汰算法

  链表实现 时间复杂度O(n)

  通过散列 O(1)

- Redis 有序结合 

  跳表 散列表

- LinkedHashMap 

  散列表 链表



#### **LRU 缓存淘汰算法**

- 向缓存中添加一个数据
- 向缓存中删除一个数据
- 在缓存中查找一个数据

![eaefd5f4028cc7d4cfbb56b24ce8ae6e](./eaefd5f4028cc7d4cfbb56b24ce8ae6e.jpg)

使用双向链表存储数据，链表中的每个节点处理存储数据、前驱指针、后驱指针之外，还有一个字段hnext。

**hnext 指针是为了将节点串在散列表的拉链中**

#### **Redis 有序集合**

**key**

**score**



#### **Java LinkedHashMap**

```java
HashMap<Integer, Integer> m = new LinkedHashMap<>();
m.put(3, 11);
m.put(1, 12);
m.put(5, 23);
m.put(2, 22);

for (Map.Entry e : m.entrySet()) {
  System.out.println(e.getKey());
}
```

打印的顺序就是 3，1，5，2

```java
// 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序
HashMap<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
m.put(3, 11);
m.put(1, 12);
m.put(5, 23);
m.put(2, 22);

m.put(3, 26);
m.get(5);

for (Map.Entry e : m.entrySet()) {
  System.out.println(e.getKey());
}
```

这段代码打印的结果是 1，2，3，5

**LinkedHashMap 是通过双向链表和散列表这两种数据结构组合实现的。LinkedHashMap 中的“Linked”实际上是指的是双向链表，并非指用链表法解决散列冲突**



### 21 哈希算法（上）：如何防止数据库中的用户信被脱库



哈希算法：将任意长度的二进制值串映射为固定长度的二进制值串，这个映射的规则就是哈斯算法。



哈希算法的应用：

- 安全加密
- 唯一标识
- 数据校验
- 散列函数
- 负载均衡
- 数据分片
- 分布式存储

#### **应用一：安全加密**

**MD5** **SHA**

**DES** **AES**

- 很难根据哈希值反向推导出原始数据
- 散列冲突的概率很小



#### **应用二：唯一标识**

#### **应用三：数据校验**

#### **应用四：散列函数**



### 22 哈希算法（下）：哈希算法在分布式系统中有哪些应用？



#### **应用五：负载均衡**

- 轮询
- 随机
- 加权轮询



#### **应用六：数据分片**

- 如何统计“搜索关键词”出现的次数
- 如何快速判断如偏是否在图库中

#### **应用七：分布式存储**



### 23 二叉树基础（上）：什么样的二叉树适合用数组来存储？



#### **树（Tree）**

- 高度
- 深度
- 层

#### **二叉树（Binary Tree）**

- 左子节点
- 右子节点



- 满二叉树
- 完全二叉树

存储二叉树

- 基于指针或者应用的二叉树式存储法
- 基于数组的顺序存储法

如果某颗二叉树是一颗完全二叉树，那用数组存储无疑就是最节省内存的一种方式。

堆就是一种完全二叉树，最常用的存储方式就是数组。



#### **二叉树的遍历**

- 前序遍历

  对于树中的任意节点来说，先打印这个节点，然后再打印它的左子树，最后打印它的右子树

- 中序遍历

  对于树中的任意节点来说，先打印它的左子树，然后再打印这个节点，最后打印它的右子树

- 后序遍历

  对于树中的任意节点来说，先打印它的左子树，然后再打印它的右子树，最后打印这个节点

![ab103822e75b5b15c615b68560cb2416](./ab103822e75b5b15c615b68560cb2416.jpg)



```C++
前序遍历的递推公式：
preOrder(r) = print r->preOrder(r->left)->preOrder(r->right)

中序遍历的递推公式：
inOrder(r) = inOrder(r->left)->print r->inOrder(r->right)

后序遍历的递推公式：
postOrder(r) = postOrder(r->left)->postOrder(r->right)->print r
```

er'cha

```C++
void preOrder(Node* root) {
  if (root == null) return;
  print root // 此处为伪代码，表示打印 root 节点
  preOrder(root->left);
  preOrder(root->right);
}

void inOrder(Node* root) {
  if (root == null) return;
  inOrder(root->left);
  print root // 此处为伪代码，表示打印 root 节点
  inOrder(root->right);
}

void postOrder(Node* root) {
  if (root == null) return;
  postOrder(root->left);
  postOrder(root->right);
  print root // 此处为伪代码，表示打印 root 节点
}
```

二叉树遍历的时间复杂度是 O(n)



### 24 二叉树基础（下）：有了如此高效的散列表，为什么还需要二叉树？

二叉查找树

支持动态数据集合的快速插入、删除、查找操作。

#### 二叉查找树（Binary Search Tree）

**二叉查找树的查找操作**

```java
public class BinarySearchTree {
  private Node tree;

  public Node find(int data) {
    Node p = tree;
    while (p != null) {
      if (data < p.data) p = p.left;
      else if (data > p.data) p = p.right;
      else return p;
    }
    return null;
  }

  public static class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
      this.data = data;
    }
  }
}
```

**二叉查找树的插入操作**

```java
public void insert(int data) {
  if (tree == null) {
    tree = new Node(data);
    return;
  }

  Node p = tree;
  while (p != null) {
    if (data > p.data) {
      if (p.right == null) {
        p.right = new Node(data);
        return;
      }
      p = p.right;
    } else { // data < p.data
      if (p.left == null) {
        p.left = new Node(data);
        return;
      }
      p = p.left;
    }
  }
}
```

**二叉查找树的删除操作**

```java
public void delete(int data) {
  Node p = tree; // p 指向要删除的节点，初始化指向根节点
  Node pp = null; // pp 记录的是 p 的父节点
  while (p != null && p.data != data) {
    pp = p;
    if (data > p.data) p = p.right;
    else p = p.left;
  }
  if (p == null) return; // 没有找到

  // 要删除的节点有两个子节点
  if (p.left != null && p.right != null) { // 查找右子树中最小节点
    Node minP = p.right;
    Node minPP = p; // minPP 表示 minP 的父节点
    while (minP.left != null) {
      minPP = minP;
      minP = minP.left;
    }
    p.data = minP.data; // 将 minP 的数据替换到 p 中
    p = minP; // 下面就变成了删除 minP 了
    pp = minPP;
  }

  // 删除节点是叶子节点或者仅有一个子节点
  Node child; // p 的子节点
  if (p.left != null) child = p.left;
  else if (p.right != null) child = p.right;
  else child = null;

  if (pp == null) tree = child; // 删除的是根节点
  else if (pp.left == p) pp.left = child;
  else pp.right = child;
}
```

