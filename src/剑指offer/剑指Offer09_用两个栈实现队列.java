package 剑指offer;

import java.util.Stack;

public class 剑指Offer09_用两个栈实现队列 {

    private Stack<Integer> inStack;

    private Stack<Integer> outStack;

    public 剑指Offer09_用两个栈实现队列() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public String appendTail(int value) {
        inStack.push(value);
        return "null";
    }

    public int deleteHead() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        } else if (!inStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        剑指Offer09_用两个栈实现队列 obj = new 剑指Offer09_用两个栈实现队列();
        System.out.println(obj.deleteHead());
        System.out.println(obj.appendTail(12));
        System.out.println(obj.deleteHead());
        System.out.println(obj.appendTail(10));
        System.out.println(obj.appendTail(9));
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.appendTail(20));
        System.out.println(obj.deleteHead());
        System.out.println(obj.appendTail(1));
        System.out.println(obj.appendTail(8));
        System.out.println(obj.appendTail(20));
        System.out.println(obj.appendTail(1));
        System.out.println(obj.appendTail(11));
        System.out.println(obj.appendTail(2));
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());



    }
}
