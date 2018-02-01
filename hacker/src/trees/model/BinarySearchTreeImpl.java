package trees.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BinarySearchTree implementation
 * User: rpanjrath
 * Date: 10/3/13
 * Time: 12:40 PM
 */
public class BinarySearchTreeImpl implements BinarySearchTree<Integer> {

    private BSTNode rootNode;

    public BinarySearchTreeImpl() {
        this.rootNode = null;
    }

    @Override
    public void insertNode(Integer data) {
        if (data != null) {
            BSTNode newSearchNode = new BSTNode();
            newSearchNode.setData(data);
            if (rootNode == null) {
                rootNode = newSearchNode;
            } else {
                BSTNode currentNode = rootNode;
                while (true) {
                    if (newSearchNode.getData() < currentNode.getData()) {
                        if (currentNode.getLeftChild() == null) {
                            currentNode.setLeftChild(newSearchNode);
                            break;
                        }
                        currentNode = (BSTNode) currentNode.getLeftChild();
                    } else {
                        if (currentNode.getRightChild() == null) {
                            currentNode.setRightChild(newSearchNode);
                            break;
                        }
                        currentNode = (BSTNode) currentNode.getRightChild();
                    }
                }
            }
        }
    }

    @Override
    public void insertNodeReverseOrder(Integer data) {
        if (data != null) {
            BSTNode newSearchNode = new BSTNode();
            newSearchNode.setData(data);
            if (rootNode == null) {
                rootNode = newSearchNode;
            } else {
                BSTNode currentNode = rootNode;
                while (true) {
                    if (newSearchNode.getData() > currentNode.getData()) {
                        if (currentNode.getLeftChild() == null) {
                            currentNode.setLeftChild(newSearchNode);
                            break;
                        }
                        currentNode = (BSTNode) currentNode.getLeftChild();
                    } else {
                        if (currentNode.getRightChild() == null) {
                            currentNode.setRightChild(newSearchNode);
                            break;
                        }
                        currentNode = (BSTNode) currentNode.getRightChild();
                    }
                }
            }
        }
    }

    @Override
    public List traverseTree(TraverseType traverseType) {
        List traversedNodesList = new ArrayList();
        if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.INORDER.toString())) {
            traverseInOrder(this.rootNode, traversedNodesList);
        } else if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.POSTORDER.toString())) {
            traversePostOrder(this.rootNode, traversedNodesList);
        } else {
            traversePreOrder(this.rootNode, traversedNodesList);
        }
        return traversedNodesList;
    }

    private void traversePreOrder(BSTNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traversedNodesList.add(searchNode.getData());
            traversePreOrder((BSTNode) searchNode.getLeftChild(), traversedNodesList);
            traversePreOrder((BSTNode) searchNode.getRightChild(), traversedNodesList);
        }
    }

    private void traverseInOrder(BSTNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traverseInOrder((BSTNode) searchNode.getLeftChild(), traversedNodesList);
            traversedNodesList.add(searchNode.getData());
            traverseInOrder((BSTNode) searchNode.getRightChild(), traversedNodesList);
        }
    }

    private void traversePostOrder(BSTNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            traversePostOrder((BSTNode) searchNode.getLeftChild(), traversedNodesList);
            traversePostOrder((BSTNode) searchNode.getRightChild(), traversedNodesList);
            traversedNodesList.add(searchNode.getData());
        }
    }

    @Override
    public List traverseTreeNonRecursion(TraverseType traverseType) {
        List traversedNodesList = new ArrayList();
        if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.INORDER.toString())) {
            traverseInOrderNonRecursive(this.rootNode, traversedNodesList);
        } else if (traverseType.getOrderType().equalsIgnoreCase(TraverseType.POSTORDER.toString())) {
            traversePostOrderNonRecursive(this.rootNode, traversedNodesList);
        } else {
            traversePreOrderNonRecursive(this.rootNode, traversedNodesList);
        }
        return traversedNodesList;
    }

    private void traversePreOrderNonRecursive(BSTNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            Stack<BSTNode> nodeStack = new Stack<>();
            nodeStack.push(searchNode);
            while (!nodeStack.isEmpty()) {
                BSTNode tempNode = nodeStack.pop();
                traversedNodesList.add(tempNode);
                if (tempNode.getRightChild() != null) {
                    nodeStack.push((BSTNode) tempNode.getRightChild());
                }
                if (tempNode.getLeftChild() != null) {
                    nodeStack.push((BSTNode) tempNode.getLeftChild());
                }
            }
        }
    }

    private void traverseInOrderNonRecursive(BSTNode searchNode, List traversedNodesList) {
        if (searchNode != null) {
            Stack<BSTNode> nodeStack = new Stack<>();
            BSTNode currentNode = searchNode;
            nodeStack.push(currentNode);
            while (!nodeStack.isEmpty()) {
                while (currentNode.getLeftChild() != null) {
                    nodeStack.push((BSTNode) currentNode.getLeftChild());
                    currentNode = (BSTNode) currentNode.getLeftChild();
                }
                currentNode = nodeStack.pop();
                traversedNodesList.add(currentNode);
                if (currentNode.getRightChild() != null) {
                    currentNode = (BSTNode) currentNode.getRightChild();
                    nodeStack.push(currentNode);
                }
            }
        }
    }

    /*
    * Push root to first stack.
    * Loop while first stack is not empty {
    *  -    Pop a node from first stack and push it to second stack
    *  -    Push left and right children of the popped node to first stack
    * }
    * Print contents of second stack
    * */
    private void traversePostOrderNonRecursive(BSTNode searchNode, List traversedNodesList) {
        Stack<BSTNode> nodeStack1 = new Stack<>();
        Stack<BSTNode> nodeStack2 = new Stack<>();
        nodeStack1.push(searchNode);
        while (!nodeStack1.empty()) {
            BSTNode tempNode = nodeStack1.pop();
            nodeStack2.push(tempNode);
            if (tempNode.getLeftChild() != null) {
                nodeStack1.push((BSTNode) tempNode.getLeftChild());
            }
            if (tempNode.getRightChild() != null) {
                nodeStack1.push((BSTNode) tempNode.getRightChild());
            }
        }
        while (!nodeStack2.empty()) {
            traversedNodesList.add(nodeStack2.pop());
        }
    }

    @Override
    public StringBuilder traverseTreeInString(TraverseType traverseType) {
        List<Integer> traversedNodesList = traverseTree(traverseType);
        StringBuilder traversedNodesBuilder = new StringBuilder();
        for (Integer integer : traversedNodesList) {
            traversedNodesBuilder.append(integer.toString());
        }
        return traversedNodesBuilder;
    }

    @Override
    public BSTNode getRootOfTree() {
        return this.rootNode;
    }
}
