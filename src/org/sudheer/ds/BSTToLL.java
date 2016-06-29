/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sudheer.ds;

import java.util.Stack;

/**
 *
 * @author I308390
 */
public class BSTToLL<K> {
    LLNode<K> root;
    LLNode<K> prev;
    public BSTToLL(LLNode<K> root){
        this.root = root;
    }
   
    public void convertBSTToLL(LLNode root, LLNode[] lHead){
        if (root == null){
            return;
        }
        convertBSTToLL(root.prev, lHead);
        
        if (prev == null){
            lHead[0] = root;
        }
        else{
            root.prev = prev;
            prev.next = root;
        }
        prev = root;
        convertBSTToLL(root.next, lHead);
    }
    
    private void convertBSTToLLIter(LLNode root, LLNode[] head){
        LLNode<Integer> prev = null;
        if (root == null){
            return;
        }
        
        Stack<LLNode<Integer>> stack = new Stack();
        
        while(root != null || stack.size() > 0){
            while(root != null){
                stack.push(root);
                root = root.prev;
            }
            root = stack.pop();
            if (prev == null){
                head[0] = root;
            }
            else{
                root.prev = prev;
                prev.next = root;
            }
            prev = root;
            root = root.next;
        }
        
    }
    
    public static void main(String[] args) {
        LLNode<Integer> node;
        node = new LLNode(Integer.valueOf(5));
        node.prev = new LLNode<Integer>(Integer.valueOf(3));
        node.next = new LLNode<Integer>(Integer.valueOf(7));
        node.prev.prev = new LLNode<Integer>(Integer.valueOf(1));
        node.next.next = new LLNode<Integer>(Integer.valueOf(13));
        node.next.prev = new LLNode<Integer>(Integer.valueOf(6));
        BSTToLL<Integer> bst = new BSTToLL(node);
        LLNode<Integer>[] lHead = new LLNode[1];
        bst.convertBSTToLLIter(node, lHead);
        LLNode<Integer> head = lHead[0];
        while (head.next != null){
            System.out.println(head.k);
            head = head.next;
        }
        System.out.println(head.k);
        System.out.println("Printing the LL in reverse order");
        while(head.prev != null){
            System.out.println(head.k);
            head = head.prev;
        }
        System.out.println(head.k);
        
    }
}

class LLNode<K> {
    K k;
    LLNode<K> next; // right
    LLNode<K> prev; // left
    
    public LLNode(K k){
        this.k = k;
    }
}
