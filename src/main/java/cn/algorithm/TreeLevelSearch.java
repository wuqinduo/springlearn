package cn.algorithm;



import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层次遍历 BFS
 *       (1) 利用【队列的先进先出】特点。 一层层的放进去。 先进先出
 *
 *https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/die-dai-di-gui-duo-tu-yan-shi-102er-cha-shu-de-cen/
 */
public class TreeLevelSearch {


    //每一层都利用队里的先进先出
    public void bfs(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node =  queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
    }

    //bfs 的应用1： 层序遍历
    public List<List<Integer>>  breadthFirstQueue(TreeNode root){

        List<List<Integer>> reulst = new ArrayList<>();//存储每一层的结果
        if(root==null){
            return reulst;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();//用来遍历的队列（先进先出）
        queue.add(root);
        while (!queue.isEmpty()){
            int n =  queue.size();
            List<Integer> levelN = new ArrayList<>();//第N层
            for (int i=0;i<n;n++){
                TreeNode node  = queue.poll();//遍历一个，就把他的子节点入队。 先进先出队列
                levelN.add(node.val);

                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            reulst.add(levelN);
        }
        return reulst;
    }

}
class TreeNode {
    public int val;

    public TreeNode left;

    public TreeNode right;
}
