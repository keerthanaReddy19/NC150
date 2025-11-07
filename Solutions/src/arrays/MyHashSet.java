/*
Having array of size 10^6 would lead to waste of space.

Using double hashing technique to prevent hashing conflict

Mod for secondary array will lead to collision
Using modulus for primary array and division for secondary array

T:C: 0(1)
S:C: 0(n)
 */
package arrays;

public class MyHashSet {
    int key;
    int primary_size = 1000;
    int secondary_size = 1000;
    boolean[][] HashArray;

    public MyHashSet()
    {
      this.primary_size = 1000;
      this.secondary_size = 1000;
      //need not initialize the secondary array until it is required.
      HashArray = new boolean[this.primary_size][];

    }

    public int getPrimaryIndex(int key)
    {
        return key % primary_size;
    }

    public int getSecondaryIndex(int key)
    {
        return key / secondary_size;
    }


   public void add(int key)
    {
        int primary_index = getPrimaryIndex(key);
        int secondary_index = getSecondaryIndex(key);
        if(HashArray[primary_index] == null) {

            /*
            Handle the case where a key of size 10^6 can exist,
            here mod gives 0 and division gives 1000, but there is no index 1000 in secondary array (0-999),
            so inc the secondary array size for 0th index
             */

            if (primary_index == 0) {
                HashArray[primary_index] = new boolean[secondary_index + 1];
            } else {
                HashArray[primary_index] = new boolean[secondary_index];
            }
        }
        HashArray[primary_index][secondary_index] = true;

    }

    public void remove(int key)
    {
        int primary_index = getPrimaryIndex(key);
        int secondary_index = getSecondaryIndex(key);
        if(HashArray[primary_index] == null)
        {
            return;
        }
        HashArray[primary_index][secondary_index] = false;
    }

    public boolean contains(int key){
        int primary_index = getPrimaryIndex(key);
        int secondary_index = getSecondaryIndex(key);
        if(HashArray[primary_index] == null)
        {
            return false;
        }
        return HashArray[primary_index][secondary_index];
    }
}
