/**
 * @param {number[]} A
 * @return {number}
 */
var longestConsecutive = function(A) {
    
    const N =A.length; 
    if(N === 0) return 0;
	   // prepate hashSet
	   let hashSet = new Set();
	   for(let i=0; i<N; i++) {
	       hashSet.add(A[i]);
	   }
	   
	   // initialize answer as 1
	   let maxLength = 1;
	   
	   //iterate over HashSet and check if current element can be start of sequence
	   for(let key of hashSet.keys()) {
	       
	       let count = 1;
	       let previousElement = key-1;
	       // check if current element can be start of sequence
	       if(!hashSet.has(previousElement)) {
	           // current element key can be start of sequence
	           // count the consecutive element
	           let nextElement = key+1;
	           while(hashSet.has(nextElement)){
    	           nextElement++;
    	           count++;
	           }
	       }
	       maxLength = Math.max(maxLength, count);
	   }
	   
	   return maxLength;
    
};

// [100,4,200,1,1,1,1,1,3,2]

// [100,2,3,1,4,200]