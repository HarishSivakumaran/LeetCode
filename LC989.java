// 989. Add to Array-Form of Integer

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {

        int l = num.length - 1, r = 0, c = 0, x = 0, y = 0, z = 0;

        List<Integer> out = new ArrayList();

        while (l >= 0 || k > 0 || c > 0) {
            x = l >= 0 ? num[l] : 0;
            y = k % 10;
            k = k / 10;
            z = x + y + c;
            c = z / 10;
            out.add(z % 10);
            l--;
        }
        l = 0;
        r = out.size() - 1;
        while (l < r) {
            x = out.get(l);
            out.set(l, out.get(r));
            out.set(r, x);
            l++;
            r--;
        }

        return out;

    }
}