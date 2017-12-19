package yuan.java.basic.demo.sample.algorithm;

/**
 * Created by yuanxin on 17/12/19.
 */
public class TreeNodeTest
{
    /*
    * @param root: the root of tree
    * @return: the max node
    */
    private TreeNode max = new TreeNode(Integer.MIN_VALUE);

    public TreeNode maxNode(TreeNode root)
    {
        // write your code here
        if (root == null)
        {
            return null;
        }
        max = max.val > root.val ? max : root;
        maxNode(root.left);
        maxNode(root.right);
        return max;

    }

}
