class Solution {
    public boolean isMatch(String s, String p) {
        
        // s = "abcdddd" 
//         p ="abcd*"
//         p ="abc*"
//         p =".bcd*"
            
//         s = "abcdddde"
//         p ="abcd*"
            
            
//         s = "abcdddxy" n
//         p ="abcd*xy" m
            
//             . = n-1 m-1

//             d* 
//             0 occurrences of d => n m-2
//             1 occurrences of d => n-1 m
            
//             s[n] == p[m]
//                 n-1 m-1
//             s[n] != p[m] 
            
//             prev = 'd'
//             next
        
//             fn(s, p)
//             (abcdddxy,abcd*xy)
            
//           (s[n] == p[m]   || .)           d*
//         (abcdddx,abcd*x)            (abcddd,abc)     (abcdd,abcd*)
//             n-1 m-1
//           (abcddd,abcd*)                           (abcdd,abc)   (abcd,abcd*)
            
//                                                             (abcd,abc)  (abc,abcd*)
            
        
        return fn(s, p, s.length() - 1, p.length() - 1);

    }

    public boolean fn(String s, String p, int n, int m) {

        if (n < 0 && m < 0) {
            return true;
        } else if (n < 0 && m >= 0) {
            while (m >= 0) {
                if (p.charAt(m) != '*') {
                    return false;
                }
                m = m - 2;
            }
            return true;
        } else if (n >= 0 && m < 0) {
            return false;
        }

        boolean state = false;
        if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '.') {
            state = fn(s, p, n - 1, m - 1);
        } else if (p.charAt(m) == '*' && (p.charAt(m - 1) == s.charAt(n) || p.charAt(m - 1) == '.')) {
            state = (fn(s, p, n, m - 2) || fn(s, p, n - 1, m));
        } else if (p.charAt(m) == '*' && p.charAt(m - 1) != s.charAt(n)) {
            state = fn(s, p, n, m - 2);
        }
        return state;
    }
}