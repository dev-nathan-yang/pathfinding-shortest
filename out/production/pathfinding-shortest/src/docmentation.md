# This java project is to solve shortest-pathfinding in Row * Column map
If we put 1 = wall, 0 = way, we can make a maze like following:
```
0 1 0 0 0 0
0 0 0 1 0 0
0 0 0 0 0 0
0 0 0 0 1 0
0 0 0 0 0 0
```
And store them in a 5 * 6 array
```java
class Example{
    
    int[][] map =
            {
                    {0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0},
                    {0, 0, 0, 0, 0, 0}
            };    

}
```

For better manipulation, we use text based *.in file

```text
*inside <example1.in>*
R 5                 #First line tells the total rows count
C 6                 #Second line tells the total columns count
S 0,1               #Third line tells the start point's row and column which is (0, 1)
T 4,5               #Fourth line tells the target point's row and column which is (4, 5)
B 0,1               #Start from Fifth line, they all are block cell's coordinates
B 1,3               #Another ...
B 3,4               #Another ...
*end of <example1.in>*
```