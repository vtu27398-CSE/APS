class MyQueue {
public:
    stack<int> inStack, outStack;

    MyQueue() {
    }
    
    void push(int x) {
        inStack.push(x);
    }

    void move() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.top());
                inStack.pop();
            }
        }
    }
    
    int pop() {
        move();
        int val = outStack.top();
        outStack.pop();
        return val;
    }
    
    int peek() {
        move();
        return outStack.top();
    }
    
    bool empty() {
        return inStack.empty() && outStack.empty();
    }
};