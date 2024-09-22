public class my {
    protected class Position {
        public Position left;
        public Position right;
        public Position parent;
        public int score;

        Position(Position left, Position right, Position parent, int score) {
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.score = score;
        }

        Position(int score) {
            this.score = score;
        }


    }
    interface InsertStrategy {
        boolean GoLeft(Position root,int score);
    }
    protected class ValueBaseInsertaionStrategy implements InsertStrategy{
        @Override
        public boolean GoLeft(Position root,int score){
            return score < root.score;
        }
        public void sorted(Position root, int score){
            if (this.GoLeft(root, score)){
                if (root.right == null){
                    root.right = new Position(score);
                }
                else{
                    sorted(root,score);
                }
            }
        }
    }
    protected class LeveBaseInsertaionStrategy implements InsertStrategy{
        @Override
        public boolean GoLeft(Position root, int score){
            return (root.left == null );
        }
        public void sorted(Position root, int score){
            if(root.left==null){
                root.left = new Position(score);
            } else if (root.right == null) {
                root.right = new Position(score);

            }
            else {
                sorted(root.left, score);
            }

        }
    }
    public void add_note_with_strategy(int score, InsertStrategy strategy){
        if (this.head == null){
            this.head = new Position(score);
        }
        else{
            add_note_recursive_with_strategy(this.head,score,strategy);
        }
    }
    protected void add_note_recursive_with_strategy(Position root, int score, InsertStrategy strategy){
        if (strategy.GoLeft(root,score)){
            if (root.left == null){
                root.left = new Position(score);
            }
            else{
                add_note_recursive_with_strategy(root.left,score,strategy);
            }
        }else{
            if (root.right == null){
                root.right = new Position(score);
            }
            else{
                add_note_recursive_with_strategy(root.right,score,strategy);
            }
        }
    }
    public Position head = null;

    public boolean is_root(Position p) {
        if (p.parent == null) {
            return true;
        } else {
            return false;
        }
    }
    public void show(){
        Position node = this.head;
        if (node == null) {
            System.out.println("空树！");
            return;
        }
        preOrderTraversalWithNames(node,"root");
    }

//    public boolean is_leaf() {
//    }
//
//    public int get_size() {
//
//    }
//    public void show_all_tree(){
//        if (this.head == null){
//            System.out.println("树为空！！！");
//        }
//        else {
//            System.out.println("前序输出：");
//            Position cur_point = this.head;
//
//        }
//    }
    public void preOrderTraversalWithNames(Position node, String relationship) {
        if(node == null){
            return;
        }

        // 打印当前节点的名称和它的关系
        System.out.println(relationship + ": " + node.score);

        // 递归访问左子树，关系为“左子节点”
        preOrderTraversalWithNames(node.left, "Left child of " + node.score);

        // 递归访问右子树，关系为“右子节点”
        preOrderTraversalWithNames(node.right, "Right child of " + node.score);
    }
    public void add_note(int score) {
        if (this.head == null){
            this.head = new Position(score);
        } else {
            this.add_note_recursive(this.head,score);
        }
    }
    protected void add_note_recursive(Position root,int score){
        if(root.left==null){
            root.left = new Position(score);
        } else if (root.right == null) {
            root.right = new Position(score);

        }
        else {
            add_note_recursive(root.left, score);
        }
    }
    public static void main(String[] args){
        my myo = new my();

        // 使用基于层次填充的策略
        InsertStrategy layerStrategy = myo.new LeveBaseInsertaionStrategy();
        System.out.println("Using layer-based insertion strategy:");
        for (int i = 0; i <= 10; i++) {
            myo.add_note_with_strategy(i, layerStrategy);
        }
        myo.show();

        // 使用基于值比较的策略
        myo.head = null; // 清空树
        InsertStrategy valueStrategy = myo.new ValueBaseInsertaionStrategy();
        System.out.println("Using value-based insertion strategy:");
        for (int i = 0; i <= 10; i++) {
            myo.add_note_with_strategy(i, valueStrategy);
        }
        myo.show();
    }
}
