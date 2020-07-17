package cn.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 深度遍历：
 *  先：根-左-右
 *  中：左-中-右
 *  后：左-右-根
 *
 *  遍历方式：
 *      迭代： 其实利用的是系统的栈
 *      栈： 语言的j栈
 *      总的来说： 利用栈的先进后出。
 *
 *
 *  总结：
 *      循环遍历，迭代，栈，队列都是算法中查用的辅助手段
 *      https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/leetcodesuan-fa-xiu-lian-dong-hua-yan-shi-xbian-2/
 */
public class TreeDepthSearch {


    public void dfs(TreeNode root){
        if(root ==null){
            return;
        }
        dfs(root.left);//进入线程栈。(每一次方法调用都是入栈的过程)
        dfs(root.right);
    }

    //先序遍历栈实现: 根-左-右
    public void  dfsPreStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack =  new Stack();
        if(root!=null){
            stack.push(root);
        }
        while (!stack.isEmpty()){
          TreeNode node =  stack.pop();
          result.add(node.val);
          if(node.right!=null){//先进后出，先进右
              stack.push(node.right);
          }
          if(node.left!=null){
              stack.push(node.left);
          }
        }
    }

    //中序，指针+栈实现， 左-跟-右
    public void inOrderStack(TreeNode root){
        if(root==null){
            return;
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack =  new Stack();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur !=null){
            while (cur!=null){//尽可能的将左子节点入栈。
                stack.push(cur);
                cur=cur.left;
            }

            //在一个单元内，左根优先访问，右子当做另一个单元的左。
            TreeNode node =  stack.pop();
            result.add(node.val);
            cur =cur.right;
        }
    }

    //后续： 左 -右 -中。
    public void postOrderStack(TreeNode root){
       // https://blog.csdn.net/qq_44932835/article/details/104948804
    }
}

