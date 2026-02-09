# Tree – Pattern Notes


---
### Balance a BST using inorder + rebuild

Problem:
- LC1382 – Balance a Binary Search Tree

Idea:
Inorder traversal of a BST gives a sorted list.  
Build a balanced BST by always choosing the middle element as the root.

Steps:
1. Inorder traverse the BST and store values in a list.
2. Recursively build a tree from the sorted list using mid as root.

Template:

```java
// inorder traversal (iterative)
void inorder(TreeNode root, List<Integer> list) {
    Stack<TreeNode> st = new Stack<>();
    while (root != null || !st.isEmpty()) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        root = st.pop();
        list.add(root.val);
        root = root.right;
    }
}

// build balanced BST from sorted list
TreeNode build(List<Integer> list, int l, int r) {
    if (l > r) return null;

    int mid = l + (r - l) / 2;

    TreeNode node = new TreeNode(list.get(mid));
    node.left = build(list, l, mid - 1);
    node.right = build(list, mid + 1, r);

    return node;
}
