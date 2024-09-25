package BinarySearch;

public class BinarySearchOnAnswer {

    public static void main(String[] args){

    }

    //////1482. Minimum Number of Days to Make m Bouquets
    public static int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length< (long)m*k) return -1;
        int low = 1;
        int high  =1;
        for(int i=0;i< bloomDay.length;i++){
            high = Math.max(bloomDay[i],high);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(bloomDay, m,k,mid)==true){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;

    }

    public static boolean isPossible(int[] bloomDay, int totalBouquet, int flowers,int maxdays){
        int currBouquet = 0;
        int currFlowers = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]> maxdays){
                currFlowers = 0;
                continue;
            }else{
                currFlowers++;
            }
            if(currFlowers==flowers){
                currBouquet++;
                currFlowers = 0;
            }
        }
        return currBouquet>=totalBouquet;
    }

    ////////1283. Find the Smallest Divisor Given a Threshold
    public static int smallestDivisor(int[] nums, int threshold) {
        if(threshold<nums.length){
            return -1;
        }
        int low = 1;
        int high = 0;
        for(int i=0;i< nums.length;i++){
            high  = Math.max(nums[i],high);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isPossible(nums, threshold, mid)==true){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    public static boolean isPossible(int[] nums, int threshold, int div){
        int sum = 0;
        for(int i=0;i< nums.length;i++){
            int currQ = (nums[i]+div-1)/div;
            sum += currQ;
        }
        return sum<=threshold;
    }

    //////Painter's Partition Problem
    public static int paint(int A, int B, int[] C) {
        long low = 0;
        long high =0;
        for(int i=0;i< C.length;i++){
            low = Math.max(low, C[i]);
            high += C[i];
        }
        while(low<=high){
            long mid = low+(high-low)/2;
            if(isPossible(C,A, mid)==true){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        long ans  =(low*B)%10000003;
        return (int)ans;
    }

    public static boolean isPossible(int[] arr, int painters, long totalTime){
        int currPainter = 1;
        int currTime = 0;
        for(int i=0;i< arr.length;i++){
            if(currTime+arr[i]<=totalTime){
                currTime += arr[i];
            }else{
                currPainter++;
                currTime = arr[i];
            }
        }
        return currPainter<=painters;
    }

}
