import java.util.LinkedList;
import java.util.Queue;

public class Invert_binary_tree_June_1 {
    TreeNode root;
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        helper(root.left);
        helper(root.right);
    }
    public void createSampleTree(){
        root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(6,new TreeNode(5),new TreeNode(7)));
    }

    public void levelOrderTraversal(TreeNode temp){
        if(temp == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.val+ " ");
            if(curr.left !=null){
                queue.add(curr.left);
            }
            if(curr.right !=null){
                queue.add(curr.right);
            }
        }

    }

    public static void main(String[] args) {
        Invert_binary_tree_June_1 invertTree = new Invert_binary_tree_June_1();
        invertTree.createSampleTree();
        invertTree.levelOrderTraversal(invertTree.root);
        invertTree.invertTree(invertTree.root);
        System.out.println();
        invertTree.levelOrderTraversal(invertTree.root);
    }
}
