//import java.util.ArrayList;
//import java.util.List;
//
//abstract class Tree {
//    abstract class Position {
//        // 定义节点
//        public abstract int element();
//
//        public abstract boolean equals(Position other);
//
//        public abstract boolean notEquals(Position other);
//    }
//
//    public abstract Position root(); // 返回树的根节点（如果树为空，则返回 null）
//
//    public abstract Position parent(Position p); // 返回节点 p 的父节点（如果 p 是根节点，则返回 null）
//
//    public abstract int numChildren(Position p); // 返回节点 p 拥有的子节点数量
//
//    public abstract Iterable<Position> children(Position p); // 返回节点 p 的所有子节点（可迭代）
//
//    public abstract int getSize(); // 返回树的总节点数量
//
//    public boolean isRoot(Position p) {
//        return this.root() == p;
//    }
//
//    public boolean isLeaf(Position p) {
//        return this.numChildren(p) == 0; // 修改：叶节点没有孩子
//    }
//
//    public boolean isEmpty() {
//        return this.getSize() == 0;
//    }
//
//    public int depth(Position p) {
//        // 计算节点 p 的深度
//        if (this.isRoot(p)) {
//            return 0;
//        } else {
//            return 1 + this.depth(this.parent(p));
//        }
//    }
//}
//
//abstract class BinaryTree extends Tree {
//    public abstract Position left(Position p); // 返回节点 p 的左孩子
//
//    public abstract Position right(Position p); // 返回节点 p 的右孩子
//
//    public Position sibling(Position p) {
//        Position parent = this.parent(p);
//        if (parent == null) { // p 是根节点，没有兄弟节点
//            return null;
//        } else {
//            if (this.left(parent) != null && this.left(parent).equals(p)) {
//                return this.right(parent); // 如果 p 是左孩子，返回右兄弟
//            } else {
//                return this.left(parent); // 如果 p 是右孩子，返回左兄弟
//            }
//        }
//    }
////    public
//}
//
// //定义链式二叉树中的节点类
//class LinkedBinaryTree extends Tree {
//
//    // 定义二叉树中的节点类，内部实现 Position 接口
//    protected static class Node implements Position {
//        private int element;       // 节点存储的值
//        private Node left;         // 左孩子
//        private Node right;        // 右孩子
//        private Node parent;       // 父节点
//
//        public Node(int element, Node parent, Node left, Node right) {
//            this.element = element;
//            this.parent = parent;
//            this.left = left;
//            this.right = right;
//        }
//
//        @Override
//        public int element() {
//            return element;
//        }
//
//        @Override
//        public boolean equals(Position other) {
//            return other instanceof Node && this.element == ((Node) other).element;
//        }
//
//        @Override
//        public boolean notEquals(Position other) {
//            return !this.equals(other);
//        }
//
//        // 获取当前节点的父节点
//        public Node getParent() {
//            return parent;
//        }
//
//        // 获取当前节点的左孩子
//        public Node getLeft() {
//            return left;
//        }
//
//        // 获取当前节点的右孩子
//        public Node getRight() {
//            return right;
//        }
//
//        // 设置当前节点的左孩子
//        public void setLeft(Node left) {
//            this.left = left;
//        }
//
//        // 设置当前节点的右孩子
//        public void setRight(Node right) {
//            this.right = right;
//        }
//    }
//
//    // 二叉树的根节点
//    private Node root = null;
//    // 树中的节点总数
//    private int size = 0;
//
//    // 返回树的根节点
//    @Override
//    public Node root() {
//        return root;
//    }
//
//    // 返回节点 p 的父节点
//    @Override
//    public Node parent(Position p) {
//        Node node = (Node) p;
//        return node.getParent();
//    }
//
//    // 返回节点 p 的左孩子
//    @Override
//    public Node left(Position p) {
//        Node node = (Node) p;
//        return node.getLeft();
//    }
//
//    // 返回节点 p 的右孩子
//    @Override
//    public Node right(Position p) {
//        Node node = (Node) p;
//        return node.getRight();
//    }
//
//    // 返回节点 p 的子节点数量
//    @Override
//    public int numChildren(Position p) {
//        Node node = (Node) p;
//        int count = 0;
//        if (node.getLeft() != null) count++;
//        if (node.getRight() != null) count++;
//        return count;
//    }
//
//    // 返回节点 p 的子节点迭代器
//    @Override
//    public Iterable<Position> children(Position p) {
//        Node node = (Node) p;
//        List<Position> children = new ArrayList<>();
//        if (node.getLeft() != null) children.add(node.getLeft());
//        if (node.getRight() != null) children.add(node.getRight());
//        return children; // 返回 Iterable<Position>
//    }
//
//    // 返回树的节点数量
//    @Override
//    public int getSize() {
//        return size;
//    }
//
//    // 添加根节点
//    public Node addRoot(int element) {
//        if (root != null) throw new IllegalStateException("树已经有根节点了");
//        root = new Node(element, null, null, null);
//        size = 1;
//        return root;
//    }
//
//    // 为节点 p 添加左孩子
//    public Node addLeft(Position p, int element) {
//        Node parent = (Node) p;
//        if (parent.getLeft() != null) throw new IllegalArgumentException("左孩子已经存在");
//        Node child = new Node(element, parent, null, null);
//        parent.setLeft(child);
//        size++;
//        return child;
//    }
//
//    // 为节点 p 添加右孩子
//    public Node addRight(Position p, int element) {
//        Node parent = (Node) p;
//        if (parent.getRight() != null) throw new IllegalArgumentException("右孩子已经存在");
//        Node child = new Node(element, parent, null, null);
//        parent.setRight(child);
//        size++;
//        return child;
//    }
//
//    // 删除一个叶子节点
//    public int remove(Position p) {
//        Node node = (Node) p;
//        if (numChildren(node) > 0) throw new IllegalArgumentException("不能删除非叶子节点");
//        Node parent = node.getParent();
//        if (parent != null) {
//            if (parent.getLeft() == node) {
//                parent.setLeft(null);
//            } else {
//                parent.setRight(null);
//            }
//        } else {
//            root = null; // 如果是根节点，则直接删除
//        }
//        size--;
//        return node.element();
//    }
//}
