/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.Arrays;
import java.lang.IllegalStateException;
/**
 *
 * @author sridhar
 */


class binheap
{
    int[] array;
    int capacity;
    int size = 0;
    public binheap(int n)
    {
        capacity = n;
        array = new int[n];
    }
    
    
    public int getleftchildindex(int index){return 2*index +1;}
    public int getrightchildindex(int index){return 2*index +2;}
    public int getparentindex(int index){return (index-1)/2;}
    
    public boolean hasleftchild(int index){return getleftchildindex(index) < size;}
    public boolean hasrightchild(int index){return getrightchildindex(index) < size;}
    public boolean hasparent(int index){return getparentindex(index) >= 0;}
            
    public int getparent(int index){ return array[getparentindex(index)];}
    public int getleftchild(int index){ return array[getleftchildindex(index)];}
    public int getrightchild(int index){ return array[getrightchildindex(index)];}
            
    public void checksize()
    {
        if(size == capacity)
        {
            array = Arrays.copyOf(array,capacity*2);
            capacity *=2;
        }
                
    }
    
    
    public void heapifyup(int index)
    {
        while(hasparent(index) && getparent(index) < array[index])
        {
            swap(getparentindex(index),index);
            index = getparentindex(index);
        }        
    }
    public void heapifydown(int index)
    {
        while(hasleftchild(index))
        {
            
            int biggerchildindex = getleftchildindex(index);
            if(hasrightchild(index))
            {               
                if(getrightchild(index) > getleftchild(index))
                {
                    biggerchildindex = getrightchildindex(index);
                }
            }
            
            if(array[index] < array[biggerchildindex])
            {
                swap(index,biggerchildindex);
                index = biggerchildindex;
            }
            else
            {
                break;
            }
        }       
    }
    
    public void insert(int value)
    {
        checksize();
        array[size] = value;
        size++;
        heapifyup(size-1);       
    }
    
    public int delete()
    {
        if(size == 0) throw new IllegalStateException();
        int value = array[0];
        array[0] = array[size-1];
        size--;
        heapifydown(0);
        return value;
        
    }
    
    public void swap(int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;        
    }
    
    public void print()
    {
        for(int i =0;i<size;i++)
        {
            System.out.print(array[i]+" ");
        }
    }
    
    
    
    
}


public class Heap {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        binheap hp = new binheap(10);
        hp.insert(10);
        hp.insert(25);
        hp.insert(8);
        hp.insert(45);
        hp.insert(102);
        hp.insert(70);
        hp.delete();
        hp.print();
        
    }
    
}
