package design;

import java.util.Stack;

/*
LC 232.
Implement Queue using Stacks

Approach: Use 2 stacks to get the right order of Queue
 */
public class QueueStack {


    Stack<Integer> first = new Stack<>();
    Stack<Integer> second = new Stack<>();


    public void push(int x)
    {
        first.push(x);
    }

    public int pop()
    {
        peek();
        return second.pop();

    }

    public int peek() {
        if (second.isEmpty()) {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }

        }
        return second.peek();
    }

    public boolean empty()
    {
         return first.isEmpty() && second.isEmpty();
    }
}
