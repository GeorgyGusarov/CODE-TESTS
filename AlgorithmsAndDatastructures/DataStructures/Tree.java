package AlgorithmsAndDatastructures.DataStructures;

import java.util.ArrayList;

public class Tree { // binary tree

    private class TreeNode implements Comparable {
        private Cat c;
        public TreeNode left; // link to left heir
        public TreeNode right; // link to right heir

        public TreeNode(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        // compares Cats by age
        // we have a binary tree so it sorts objects in nodes by age
        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat)) throw new ClassCastException("Not a Cat");
            if (c.getAge() - ((Cat) o).getAge() == 0) {
                System.out.println("Ages are equal");
            } else if (c.getAge() - ((Cat) o).getAge() > 0) {
                System.out.println(((Cat) o).getName() + " is younger");
            } else if (c.getAge() - ((Cat) o).getAge() < 0) {
                System.out.println(((Cat) o).getName() + " is older");
            }
            return 0;
        }
    }

    TreeNode root;
    public ArrayList<Integer> arrayList;

    public Tree(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node; // если корень = null, то это первый элемент дерева
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                parent = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                    }
                } else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    // симметричный обход
    private void preorderTravers(TreeNode current) {
        if (current != null) {
            System.out.println(current.c.getAge() + " ");
            preorderTravers(current.left);
            preorderTravers(current.right);
        }
    }

    public void displayTree() {
        preorderTravers(root);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }
        // if we found leaf
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.left = null; // обнуляем ссылку левого наследника к родителю (корню)
            } else {
                parent.right = null; // обнуляем ссылку правого наследника к родителю (корню)
            }
        } else if (current.right == null) { // if we found 1 ancestor (если элемент, который мы хотим удалить, имеет 1 наследника и 1 родителя)
            if (isLeftChild) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null) { // if we found 1 ancestor (если элемент, который мы хотим удалить, имеет 1 наследника и 1 родителя)
            if (isLeftChild) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else { // if we found 2 ancestors (если элемент, который мы хотим удалить, имеет 2 наследника и 1 родителя)
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    // вспомогательный метод для нахождения лучшй замены удаляемой ноде
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode successor = node;
        TreeNode current = node.right;

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.left;
        }

        if (successor != node.right) {
            parent.left = successor.right;
            successor.right = node.right;
        }
        return successor;
    }

    private int countDepth(TreeNode node) {
        if (node == null) return 0;

        int left = 0;
        int right = 0;

        if (node.left != null) left = countDepth(node.left);
        if (node.right != null) right = countDepth(node.right);

        return 1 + ((left > right) ? left : right);
    }

    public boolean isBalanced(boolean precision) {
        return Math.abs(countDepth(root.left) - countDepth(root.right)) <= ((precision) ? 0 : 1);
    }
}
