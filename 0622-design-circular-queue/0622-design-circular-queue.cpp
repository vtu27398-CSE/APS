class MyCircularQueue {
public:
    vector<int> q;
    int frontIdx, rearIdx, count, capacity;

    MyCircularQueue(int k) {
        q.resize(k);
        capacity = k;
        frontIdx = 0;
        rearIdx = 0;
        count = 0;
    }
    
    bool enQueue(int value) {
        if (isFull()) return false;
        q[rearIdx] = value;
        rearIdx = (rearIdx + 1) % capacity;
        count++;
        return true;
    }
    
    bool deQueue() {
        if (isEmpty()) return false;
        frontIdx = (frontIdx + 1) % capacity;
        count--;
        return true;
    }
    
    int Front() {
        if (isEmpty()) return -1;
        return q[frontIdx];
    }
    
    int Rear() {
        if (isEmpty()) return -1;
        return q[(rearIdx - 1 + capacity) % capacity];
    }
    
    bool isEmpty() {
        return count == 0;
    }
    
    bool isFull() {
        return count == capacity;
    }
};