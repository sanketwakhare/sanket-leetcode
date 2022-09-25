class MyCircularDeque {

    int[] arr;
    int size;
    int front;
    int rear;
    int k;
    
    public MyCircularDeque(int k) {
        arr = new int[k];
        front = rear = 0;
        size = 0;
        this.k = k;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        if(!isEmpty()) {
            front = (front - 1 + k) % k;
        }
        arr[front] = value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        if(!isEmpty()) {
            rear = (rear + 1 + k) % k;
        }
        arr[rear] = value;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        arr[front] = -1;
        front = (front + 1) % k;
        size--;
        if(isEmpty()) {
            front = rear = 0;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        arr[rear] = -1;
        rear = (rear - 1 + k) % k;
        size--;
        if(isEmpty()) {
            front = rear = 0;
        }
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(size == 0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(size == k) return true;
        return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */