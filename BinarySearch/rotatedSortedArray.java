package BinarySearch;

public class rotatedSortedArray {
    public static void main(String[] args){
        int[] arr1 ={1,2};
        int[] arr2 = {3,4};
       System.out.println(findMedianSortedArrays(arr1, arr2))  ;

    }
    ////4. Median of Two Sorted Arrays
    public  static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length> nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int size= nums1.length+nums2.length;
        int low  =0, high = nums1.length;
        int leftSide  = (size+1)/2;
        int l1=0,l2=0,r1=0,r2=0;
        while(low<= high){
            int mid1 = low+(high-low)/2;
            int mid2 = leftSide-mid1;
            l1 = (mid1-1<0)? Integer.MIN_VALUE:nums1[mid1-1];
            l2 = (mid2-1<0)?Integer.MIN_VALUE:nums2[mid2-1];
            r1 = (mid1>=nums1.length)?Integer.MAX_VALUE:nums1[mid1];
            r2 = (mid2>=nums2.length)?Integer.MAX_VALUE:nums2[mid2];

            if(l1<=r2 && l2<=r1){
                break;
            }else if(l1>r2){
                high = mid1-1;
            }else if(l2>r1){
                low = mid1+1;
            }
        }
        if(size%2==0){
            return( (double)(Math.max(l1,l2)+Math.min(r1,r2))/2);
        }else{
            return (double)(Math.max(l1,l2));
        }

    }


}