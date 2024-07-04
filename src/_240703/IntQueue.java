package _240703;

// 데이터 입력, 출력 pointer
// 데이터 변화에 배열의 데이터를 이동 X
public class IntQueue {
    private int[] que;
    private int capacity; // 용량
    private int front; // 맨 앞 요소를 가리킨다.
    private int rear; // 맨 뒤 요소를 가리킨다.
    private int num; // 실제 데이터의 개수

    // 생성자
    public IntQueue(int maxlen){
        capacity = maxlen;
        num = front = rear = 0;

        try{
            que = new int[capacity];
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    public int enque(int x){
        if(num >= capacity){
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if(rear == capacity) rear = 0;
        return x;
    }

    public int deque(){
        if(num <= 0 ) throw new EmptyIntQueueException();
        int x = que[front++];
        num--;
        if(front == capacity) front = 0;
        return x;
    }

    public class OverflowIntQueueException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public OverflowIntQueueException() {}
    }

    public class EmptyIntQueueException extends RuntimeException{
        private static final long serialVersionUID = 1L;
        public EmptyIntQueueException() {}
    }
}
