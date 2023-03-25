Data：2023.3.23

leetcode 
##### N1480.Running Sum of 1d Array 
1. 题目简述：给一个长度为n的数组nums，输出一个RunningSum数组（下标为i的元素代表nums数组前i+1个数的总和）
2. 思路：递归计算，因为前n个数据的总和计算可以拆解成递归的形式(可以利用前面已存的数据），因此直接利用递归进行求解
3. 关键：

		runningSum[i] = runningSum[i-1] + nums[i]
4. 时间复杂度 On ； 
（感觉用 java 与 c 写法大致相同）

##### N724.Find Pivot Index
1. 题目简述 :  给一个长度为n的数组nums，找到对应下标index，使得index左边所有数的总和（不包含index所指的数）＝右边所有数的总和；
2. 思路：用for循环下标index遍历整个数组，每次计算index左边所有数的和 与 右边所有数的和，并判断是否相等，if（两边和相等）{return index}，如果遍历后退出循环，则return -1  _没找到_;但是这样每循环一次，都需要计算n次（没把前面的计算数据存储起来）；
   借用前面计算runningSum方法，可以得到从左往右累计和的数组，再借此得到runningSum_right_to_left（右边所有数字的累计和数组）；借用一个index循环，如果找到__两个数组相同位置下相同元素__，则return index； 
3. 关键：

		for(index = 0; index < runningSum.length;index ++){
		 if(runningSum[index] == runningSum_right_to_left[index]){
			return index; 
		 }
		}
		return -1;
4. 时间复杂度 : On；



##### N204.Isomorphic String
1. 题目简述：判断两个字符串是否同构；（字符串同构：两个字符串的length相同的前提下，能化到同一个形式，比如fdafd,scfsc ---> abcab，则这两个字符串同构）
2. 思路：
1-- hashmap：建立起char -- char的映射，把字符串映射成abcab这种形式，最后对两个字符串的map形式进行比较，相同则同构；
2-- 循环判断：用下标index同步遍历两个String，每次比较两个字符串在当前index下的字母在对应字符串__出现的第一次位置num1与num2__，一旦num1!=num2；则说明不同构，如果num1 恒等于 num2，则说明二者同构；

3. 关键：
 2---循环判断
 
		for (i = 0 ; i < s.length() ; i++){
			if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
				return false;
			}
		}
		return true;
indexOf方法 返回对应char在当前字符串出现的第一个位置；（封装起来，或许可以看看原代码时是怎么写的~自己写一个也可以）

4. 时间复杂度： 主要集中在indexOf的查找上，跟indexOf方法挂钩；用hashmap 映射建立的过程应该会快很多，因为hashmap查找的时间复杂度是O1 ！


##### N392 Is Subsequence 
1. 题目简述：判断s是不是t的子串（s的所有字母，按照排列顺序出现在t中）
2. 思路分析：
--双指针：为两个字符串设置两个index，每次判断index上字母是否相等，相等则子串的index继续前进；开始寻找下一个字母在t上的位置；直到s遍历完（是子串） or t遍历完（不是子串，当然也可能两个字符串的length相等，反正先判断的是s的下标）
1. 关键：

		while(i_t < t.length()){
			if(s.charAt(i_s) == t.charAt(i_t)){
				i_s++;
				i_t++;
				if(i_s >= s.length()){
					return true;
				}
			}
			else{
				i_t++;
			}
		}
		return false;

4. 时间复杂度：On ，取决于两个字符串length；需要优化内存方面的问题；（判断语句有点多了，考虑把if 语句写成其他的形式减少判断）