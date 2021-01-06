package datastructures.stack;

import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

    PriorityQueue<Integer> pQueue;
    Stack<Integer> stack;

    public MinStack() {
        pQueue = new PriorityQueue<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        pQueue.add(x);
        stack.push(x);
    }

    public void pop() {
        int temp = stack.pop();
        pQueue.remove(temp);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pQueue.peek();
    }
}

class MinStackI {

    private Node head;

    public void push(int x) {
        if(head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private static class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

class MinStackII {

    int min;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStackII() {
        min = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
    }


    public void push(int x) {
        if(x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}