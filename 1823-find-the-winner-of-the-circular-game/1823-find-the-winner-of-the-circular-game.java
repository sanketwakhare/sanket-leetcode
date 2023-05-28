class Solution {
    public int findTheWinner(int n, int k) {
        return findTheWinner0Based(n, k)+1;
    }
    
    public int findTheWinner0Based(int n, int k) {
        if(n == 1) {
            return 0;
        } else {
            return (findTheWinner0Based(n - 1, k) + k) % n;
        }
    }
}


// n = 5, k = 2
    
// s = 1 k%n = 2%5 = 2 + 1
    
// s = 3 k%(n) = 2%4 = 2
    
// class Solution {
//     public int findTheWinner(int n, int k) {
//         return findTheWinner0Based(n, k)+1;
//     }
    
//     public int findTheWinner0Based(int n, int k) {
//         if(n == 1) {
//             return 0;
//         } else {
//             return (findTheWinner0Based(n - 1, k) + k) % n; (0 + 5) % 2 = 1 + 1
//         }
//     }
// }

// n = 5 k =2
// f(5, 2) + 1
//     (f(4, 2) + 2) % 5
//         (f(3, 2) + 2) % 5 = 1
//             (f(2, 2) + 2) % 5 = 4
//                 (f(1, 2) + 2) % 5 = 0 + 2 = 2

// k = 5 n = 2

//     1 2