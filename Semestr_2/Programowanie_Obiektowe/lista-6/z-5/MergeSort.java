package com.company;
import java.util.Arrays;

class MergeSort extends Thread
{
    public int[] array;

    public MergeSort(int[] a)
    {
        array = a;
    }

    public void mergeSort(int[] array)
    {
        int length = array.length;
        if (length > 1)
        {
            int mid = array.length/2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, length);

            MergeSort sort1 = new MergeSort(left);
            MergeSort sort2 = new MergeSort(right);

            sort1.start();
            sort2.start();

            try
            {
                sort1.join();
                sort2.join();
            }
            catch(Exception except)
            {

            }

            merge(array, left, right);
        }
    }
    private void merge(int[] result, int[] arr1, int[] arr2)
    {
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while (i<n1 && j <n2)
        {
            if (arr1[i] < arr2[j])
                result[k++] = arr1[i++];
            else
                result[k++] = arr2[j++];
        }

        while (i < n1) result[k++] = arr1[i++];
        while (j < n2) result[k++] = arr2[j++];
    }
    @Override
    public void run()
    {
        mergeSort(array);
    }
}