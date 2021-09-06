package algorithms;

public class Driver
{
    public static void main(String[] args)
    {
        int[] example1 = {
                0,1,1,2,3,5,8,13,21,34,55
        };
        Complexity.printFirstItem(example1);
        Complexity.printAllItems(example1);
        Complexity.printAllItemsTwice(example1);
        Complexity.printAllOrderedItemPairs(example1);
    }
}
