package cn.wqd.exercises;

/**
 * 分而治之思想:
 * 一次分组操作. 将比对点放到正确的位置.
 */
public class QuickSort {

    public static void main(String[] args) {
            int[] a = {30,20,90,12,23,4,52,34};
            int i = 0;
            System.out.println(a[i++]);
    }

    public static void quickSort(int[] a, int l,int r){
        if(l<r){
            int i,j,x;
            i=l; j=r;
            x=a[i];
            while (i<j){
                //从右找,比X小的,找到一个停止,调整位置,再去从右边找
                while (i<j && a[j]>x) j--;
                if(i<j) a[i++] = a[j];

                //从左找,比X大的,找到一个停止,调整位置,再去从右边找
                while(i<j && a[i]<x) i++;
                if(i<j) a[j--] = a[i];
            }
            a[i] = x;
            //quickSort2();
        }
    }

    public static void quickSort2(int[] a ,int l,int r,int compare){
        if(l<r){
            while(true){
               // while (a[i++])
            }
        }
    }
}
