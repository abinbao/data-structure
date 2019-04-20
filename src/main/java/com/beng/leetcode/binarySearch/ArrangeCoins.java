package com.beng.leetcode.binarySearch;

/*
 * @author apple
 * https://leetcode-cn.com/problems/arranging-coins/
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
给定一个数字 n，找出可形成完整阶梯行的总行数。
n 是一个非负整数，并且在32位有符号整型的范围内。
示例 1:
n = 5
硬币可排列成以下几行:
¤
¤ ¤
¤ ¤
因为第三行不完整，所以返回2.
示例 2:

n = 8

硬币可排列成以下几行:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

因为第四行不完整，所以返回3.
 */
public class ArrangeCoins {

    /*
     * 思路： 例图: n=5
     *
     **
     **
     * 从图中可以看出，本题中如果是正常的梯形，第一行 1 *，第二行 2 ** ，第三行 3 *** .. 因此使用 index
     * 来标记行，每排列一行，n 就要减去对应的行数， 也就是 第一行 index = 1， 排列之后, n 还剩 n=n-index=4, 第二行
     * index = 2，排列之后 n=n-index=2 依次类推，知道 n < index 时，就无法再行程梯形了。 时间复杂度应该是 O(n)
     * 吧， 还有一种方式就是利用 梯形公式；
     */
    public int arrangeCoins(int n) {
        if (n == 1)
            return 1;
        int index = 1;
        while (index <= n) {
            n = n - index;
            index = index + 1;
            if (n < index) {
                break;
            }
        }
        return index - 1;
    }
    /*
     * 使用梯形公式求解
     */
}
