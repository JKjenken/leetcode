### 解题思路
背包问题的dp【i】【j】数组可以看作是当遇到第i个物品时候，背包的容量为j，dp【i】【j】代表的就是此刻将背包装满的装法有几种
在这个题目中，第i个物品就可以看作第i个硬币coins【i-1】，背包容量j就可以看作需要达到一定数量（amount）的总金额，而dp【i】【j】则是硬币能拼出amount总金额的拼法。
分析完dp数组后，就可以套用labuladong大神的完全背包问题模板了，：

```
int dp[N+1][amount+1]
//BaseCase条件
if dp【0】【、、】=0    dp【、、】【0】=1
for i in【1、、N】：
     for j in 【1、、amount】：
        if判断是否装得下
            若能装下，装不装
        else 继承上一步状态
return dp【N】【amount】
```
大方向已经定了，接下来就是一些小问题的处理，比如这个题目：
1）。需要求的是最小值，那我们就需要先给dp数组全都赋一个最大值,一般常取Integer.MAX_VALUE,这个题目中,因为amount的值我们已经知道所有可以取一个值amount+1,这样和Integer.MAX_VALUE的效果是一样的,相当于取了一个"天花板"值.不可能超过这个值.(这个地方要小心别忘记写了.不然会一直报结果为-1)
2).还有一点注意,如果选择第i个硬币,那么就是dp[i][j-coins[i-1]]+1,如果写成dp[i-1][j-coins[i-1]]+1,那么结果会一直报结果是amount+1


### 代码

```java
class Solution {
    public int coinChange(int[] coins, int amount) {
int[][] dp=new int[coins.length+1][amount+1];
        //BaseCase条件
        for (int[] n:dp
             ) {
            Arrays.fill(n,amount+1);
        }

        for (int i = 0; i <=coins.length ; i++) {
            dp[i][0]=0;
        }

        //套模板
        for (int i = 1; i <=coins.length; i++) {
            for (int j = 1; j <=amount; j++) {
                if (j>=coins[i-1] && dp[i][j-coins[i-1]]!=amount+1){
                        //这里注意如果选择第i个硬币,那么就是dp[i][j-coins[i-1]]+1
                    dp[i][j] = Math.min (dp[i-1][j],dp[i][j-coins[i-1]]+1);
                }
                else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
if (dp[coins.length][amount]==amount+1){
    dp[coins.length][amount]=-1;
}

        return dp[coins.length][amount];
    }
}
```
希望自己继续加油能写出更加好的代码.
