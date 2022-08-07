a generates => e (1 count)
e generated a and i => (2 count)
i generates a, e, o, and u => (4 count)
o generates i and u => (2 count)
u generates a => (1 count)
​
Map
a, [e]
e, [a,i]
i, [a, e, o, u]
o, [i, u]
u, [a]
​
countMap = [a=0, e=0, i=0, o=0, u=0]
n = 1
countMap = [a=1, e=1, i=1, o=1, u=1]
ans = 5
​
n = 2
countMap = [a=3, e=2, i=2, o=1, u=2]
ans = 10
​
n=3
countMap = [a=6, e=5, i=3, o=2, u=3]
ans = 19
​
n=4
countMap = [a=5+3+3, e=6+3, i=5+2, o=0+3, u=0+3+2]
countMap = [a=11, e=9, i=7, o=3, u=5]
ans = 35
​
n=5
countMap = [a=9+7+5, e=11+7, i=9+3, o=7, u=7+3]
countMap = [a=21, e=18, i=12, o=7, u=10]
ans = 68