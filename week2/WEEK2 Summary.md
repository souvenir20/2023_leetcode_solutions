java 的链表实现：
1.  组成：节点（linknode）, 头节点（有了头结点才算拥有这个链表），current 节点 ，size（记录节点的数量）
2. 节点实现：

以下是linklist，linknode 实现；

		class Linknode{
			int value; // 能不能泛型实现？
			Linknode next;
			void Linknode(){};
			void Linknode(int value){
				this.value = value;
			}
			void Linknode(int value,Linknode e){
				this.value = value;
				this.next = e;
			}
		}

		class Linklist{         //
			Linknode  head;
			Linknode current;
			int size = 0;     // 定义size 有局限性，size 属性的操作主要还是在主函数之中，（自己在操作了函数之后自己进行重定义；）
			public void addFirst(int a){
				Linknode node = new Linknode(a);
				node.next = this.head;
				this.head = node;
				this.size +=1;
			}
			public void addLast(int e){
				Linknode node = new Linknode(e);
				Linknode cur = this.head;
				while(cur.next != NULL){
						cur = cur.next;
				}
				cur.next = node;
				this.size +=1;
			}
			public int[] getAll(){
				int[] valueList = new int[this.size];
				Linknode cur = this.head;
				int i = 0;
				while(cur!=NULL){
					valueList[i] = cur.value;
					i++;
					cur = cur.next;
				}
				return  valueList;
			}
		}


		class testDemo{
			public static void main(String[] args){
				Linklist e = new Linklist();
				Linknode node1 = new Linknode(2);
				e.head = node1;
				e.addFirst(2);
				e.addFirst(5);
				e.addLast(3);
				int[] e_value = e.getAll();
			}
		}

简化：只用linknode类来实现链表：
那如何代表linklist？ 
很简单：直接用头结点来代表整个链表；失去了size的属性，但其实size属性对于链表本身这个对象并不重要，而且更新比较繁琐，比较难将更新定义在方法里面；（但也可实现）

		// 主函数中；
		Listnode node1 = new Listnode(5);
		Linknode list1 = node1;       // 把node1作为list1的头结点：在操作list1，注意头结点有没有变动；
		list1.addFirst(4);
		Linknode nodeX = new Linknode(4);
		// 下展示头插法：
		nodeX.next = list1;
		list1 = nodeX;
		// 下展示尾插法：
		Linknode cur_list1 = list1;
		while(curList1.next != NULL){
			curList1 = curList1.next;
		}
		cur.next = nodeX;


Date : 2023.3.31

leetcode
##### N21.Merge Two Sorted Lists
1. 题目简述：两个升序链表list1，list2，将其合成一个新的升序链表list
2. 思路：类似双指针思路：两个cur分别指向两个链表，每次比较两个cur指向的节点大小，比较大小后将小的进行尾插，随后更新对应cur，直到完全读完某一个链表；把剩下的尾部分接上新链表的末端即可
3. 关键：需要利用一个cur在这过程中指向新链表的末尾（方便每次新的插入）；最后return的是list.next；因为每次cur指的是链表最后一个节点，新插入的节点都在cur.next，因此插入第一个节点时，cur.next = list.next 才算是新链表的头结点；
4. 时间：有cur的存在，插入操作是简单的（常数级）；空间耗费集中在三个指针的存储，以及开辟了新链表；__（或许也可以直接在老链表上进行插入）__



##### N206.Reverse Linked list
1. 题目简介：反转链表；
2. 思路：
   三指针法：从头开始修改；用三个变量记录前中后三个节点；
   头插法：从头遍历链表，每次将新节点头插进新链表；

3. 关键（三指针）：

		while(cur != null){
			curNext = cur.next;
			cur.next = curPre;
			curPre = cur;
			cur = curNext;
		}

##### N876 Find Middle Node
1. 题目简述：找到链表的中间节点；
2. 思路：快慢指针：fast每次走两步，slow每次走一步，当fast走完链表时，slow也就抵达了链表的中间节点；要注意fast的临界条件处理；

3. 关键：

		while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

##### N141 Linked List Cycle
1.题目描述：查询链表中是否有环；
2.思路：快慢指针：fast和slow：如果fast能追上slow，则说明链表中一定有环（在环中，fast与slow每走一次，双方的距离缩短1格），如果fast走完链表，则链表一定没环（这是单链表结构所决定的）
3.关键：

		while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;


##### N142 Linked List Cycle2
1. 题目描述：查询链表中是否有环，有的话找出第一个入环点；
2. 思路：
	 简单直接方法：创建一个动态Arraylist存放节点引用，开始遍历数组，遇到节点先判断是否在动态数组中，若不存在，则加入数组；若存在，则可以确定链表中存在环（本质上就是遍历链表，找到了第一个重复访问的节点）
	 
	 __利用数学关系法：（更好！因为不用创建动态数组浪费空间）本质上利用快慢指针，相遇时slow指针再走x步就能到达第一个入环点__

		fast = 2 * slow;
		fast = slow + n*l ;   其中的l是环的长度
		第一个环的位置 =  x + n*l  ； 其中 的x是 不在环内的长度

3. 关键：
(数学关系求解)

		while (fast != slow) {
	        if (fast == null || fast.next == null) {
	            return null;
		 }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

##### N409 Longest Palindrome
1. 题目描述：给定一个字符串s，return一个整数，该整数是这个字符串中的字母能组成的最长的回文字符串（不用保持字母顺序）的长度
2. 思路：一个字符串中的字母要重新组成回文字符串，在不考虑中间字母的情况下，字母必须满足成对出现才能放在回文字符串中，当字符串中 字符a 一共有n个，那么能放在回文字符串中的个数应该是 n/2 × 2； 所以我们利用hashmap 来存储 <字母，出现个数>的键值对，然后遍历hashmap 的value数组，来对 每个字母能放在回文字符串中的个数（value /2 × 2）加一个总和；
_最后再将longestString 与 原字符串进行对比，如果不相等，则说明最长回文字符串中间可以再随便塞一个字母，即longestString ++；_

hashmap  存储每个字母对应个数键值对 --> 遍历键值对，累加出最长回文字符串长度 --> 两个长度进行判断，看最长回文字符串能否再加1

3. 关键：

		for(int val : hash.values()){
            longestString = longestString + val/2*2;
        }
        if(longestString != s.length()){
            longestString += 1;
        }
        return longestString;


4. 时间复杂度：主要集中在 构建hashmap 的过程；以及 最后遍历values进行累加 的 操作；__（可以优化吧）__

##### N278,N704 Binary Search
1. 题目描述：给定有序数组nums，在nums中查找到对应target，返回下标；（N704）在nums中查找到第一个badVersion，返回版本号（N278）
2. 思路分析：二者用的都是二分查找：二分查找应用最明显的特点：
目标：为了找到某一个元素，而目标元素可以通过其他元素判断相对位置；（这就要求原数组必须按照一定要求排序）
最关键的就是：左界和右界的改动：本质上就是利用中间元素，来判断目标元素到底在哪个范围之中；（左半边还是右半边？包不包括临界点？等等）
退出条件：1.找到目标 2.左右边界相等
3. 关键：

		while(nums[middle] != target && left < right){
            if(nums[middle] > target){
                right = middle - 1;
            }
            else{
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }


4. 时间复杂度：Ologn  空间复杂度：O1

