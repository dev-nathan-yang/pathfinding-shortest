package algorithms;

public class Complexity
{
    private static final String LINE_DIVIDER = "----------------";
    // O(1)
    // This function is O(1)
    public static void printFirstItem(int[] arrayOfItems){
        int count = 0;
        System.out.println(arrayOfItems[0]);
        count++;
        System.out.printf("n's Big O = %d\n", count);
        System.out.println(LINE_DIVIDER);
    }

    // O(n)
    public static void printAllItems(int[] arrayOfItems){
        int count = 0;
        for (int i : arrayOfItems){
            System.out.println(i);
            count++;
        }
        System.out.printf("n's Big O = %d\n", count);
        System.out.println(LINE_DIVIDER);
    }

    // notable: O(n) + O(n) ~ O(n)
    public static void printAllItemsTwice(int[] arrayOfItems){
        int count = 0;

        for (int i : arrayOfItems){
            System.out.println(i);
            count++;
        }

        for (int i : arrayOfItems){
            System.out.println(i);
            count++;
        }

        System.out.printf("n's Big O = %d\n", count);
        System.out.println(LINE_DIVIDER);
    }

    // O(n^2)
    public static void printAllOrderedItemPairs(int[] arrayOfItems){
        int count = 0;
        for (int firstIteration : arrayOfItems){
            for (int secondIteration : arrayOfItems){
                System.out.printf("(%d, %d), ",
                        firstIteration, secondIteration);
                count++;
            }
        }
        System.out.println();
        System.out.printf("n's Big O = %d\n", count);
        System.out.println(LINE_DIVIDER);
    }
}
