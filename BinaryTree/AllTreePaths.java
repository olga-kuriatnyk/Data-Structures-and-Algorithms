import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTreePaths {
    public static void main(String[] args) {
        TreeNode a = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode c = new TreeNode('c');
        TreeNode d = new TreeNode('d');
        TreeNode e = new TreeNode('e');
        TreeNode f = new TreeNode('f');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println(allTreePaths(a));
    }

    private static List<List<Character>> allTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        if (root.left == null && root.right == null) {
            List<Character> list = new ArrayList<>(Arrays.asList(root.val));
            List<List<Character>> dlist = new ArrayList<>();
            dlist.add(list);
            return dlist;
        }

        List<List<Character>> paths = new ArrayList<>();

        List<List<Character>> leftPaths = allTreePaths(root.left);
        for (List<Character> list : leftPaths) {
            list.add(root.val);
            paths.add(list);
        }
        
        List<List<Character>> rightPaths = allTreePaths(root.right);
        for (List<Character> list : rightPaths) {
            list.add(root.val);
            paths.add(list);
        }

        return paths;
    } 
}
