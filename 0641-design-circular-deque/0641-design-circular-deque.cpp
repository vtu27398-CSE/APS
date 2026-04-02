class MyCircularDeque {
public:
    vector<int> dq;
    int frontIdx, rearIdx, count, capacity;

    MyCircularDeque(int k) {
        dq.resize(k);
        capacity = k;
        frontIdx = 0;
        rearIdx = 0;
        count = 0;
    }
    
    bool insertFront(int value) {
        if (isFull()) return false;
        frontIdx = (frontIdx - 1 + capacity) % capacity;
        dq[frontIdx] = value;
        count++;
        return true;
    }
    
    bool insertLast(int value) {
        if (isFull()) return false;
        dq[rearIdx] = value;
        rearIdx = (rearIdx + 1) % capacity;
        count++;
        return true;
    }
    
    bool deleteFront() {
        if (isEmpty()) return false;
        frontIdx = (frontIdx + 1) % capacity;
        count--;
        return true;
    }
    
    bool deleteLast() {
        if (isEmpty()) return false;
        rearIdx = (rearIdx - 1 + capacity) % capacity;
        count--;
        return true;
    }
    
    int getFront() {
        if (isEmpty()) return -1;
        return dq[frontIdx];
    }
    
    int getRear() {
        if (isEmpty()) return -1;
        return dq[(rearIdx - 1 + capacity) % capacity];
    }
    
    bool isEmpty() {
        return count == 0;
    }
    
    bool isFull() {
        return count == capacity;
    }
};