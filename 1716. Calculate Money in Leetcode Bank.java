class Solution {
    public int totalMoney(int n) {
       int noOfWeeks = n/7;
       int amount = (noOfWeeks*7*8)/2 + ((7*(noOfWeeks-1)*(noOfWeeks))/2);
       int rem = n%7;
       amount += (rem*(rem+1))/2 + (rem*noOfWeeks);
       return amount;
    }
}