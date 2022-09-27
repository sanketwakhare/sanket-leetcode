class QueueNode {
    char ch;
    int index;
    public QueueNode(int index, char ch) {
        this.index = index;
        this.ch = ch;
    }
}

class Solution {
    public String pushDominoes(String dominoes) {
       
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        Queue<QueueNode> queue = new LinkedList<>();
        
        for(int i=0; i<n; i++) {
            if(arr[i] == 'L' || arr[i] == 'R') {
                queue.add(new QueueNode(i, arr[i]));
            }
        }
        
        while(!queue.isEmpty()) {
            QueueNode curr = queue.poll();
            int currIndex = curr.index;
            char currCh = curr.ch;

            if(currCh=='L' && currIndex > 0 && arr[currIndex-1]=='.'){
                queue.add(new QueueNode(currIndex-1, 'L'));
                arr[currIndex-1] = 'L';
            }
            else if (currCh=='R'){
                if(currIndex+1 < dominoes.length() && arr[currIndex+1]=='.'){
                    if(currIndex+2<dominoes.length() && arr[currIndex+2]=='L'){
                        queue.remove();
                    }
                    else{
                        queue.add(new QueueNode(currIndex+1,'R'));
                        arr[currIndex+1] = 'R';
                    }
                }
            }
        }
        return String.valueOf(arr);
    }
}

// .L.R...LR..L..
// LL.RR.LLRRLL..