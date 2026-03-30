class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int m=nums1.length,n=nums2.length;
      if(m>n) return findMedianSortedArrays(nums2,nums1);
      int total=m+n;
      int half=(m+n+1)/2;
      int low=0,high=m;
      while(low<=high)
      {
         int cutA=(high+low)/2;
         int cutB=half-cutA;
         int leftA=(cutA>0)?nums1[cutA-1]:Integer.MIN_VALUE;
         int rightA=(cutA<m)?nums1[cutA]:Integer.MAX_VALUE;

         int leftB=(cutB>0)?nums2[cutB-1]:Integer.MIN_VALUE;
         int rightB=(cutB<n)?nums2[cutB]:Integer.MAX_VALUE;
         if(leftA<=rightB && leftB<=rightA)
         {
            if(total%2==1) return Math.max(leftA,leftB);
            else return (Math.max(leftA,leftB)+Math.min(rightA,rightB))/2.0;
         }else if(leftA>leftB) high=cutA-1;
          else low=cutA+1;
      }
      return 0;
    }
}
