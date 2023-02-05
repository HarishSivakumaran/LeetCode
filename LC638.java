// 638. Shopping Offers

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<String, Integer> cache = new HashMap();
        return getMinAmountToBuyNeeds(price, special, needs, 0, cache);

    }

    public int getMinAmountToBuyNeeds(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            int offerPos, HashMap<String, Integer> cache) {
        if (offerPos >= special.size()) {
            int amount = 0;
            for (int i = 0; i < needs.size(); i++) {
                amount += (needs.get(i) * price.get(i));
            }
            return amount;
        }

        StringBuilder key = new StringBuilder();
        for (int n : needs) {
            key.append(n + "-" + offerPos);
        }

        if (cache.containsKey(key.toString()))
            return cache.get(key.toString());

        int minAmount = Integer.MAX_VALUE;
        List<Integer> newNeed = isOfferApplicable(special, needs, offerPos);
        if (newNeed != needs) {
            minAmount = special.get(offerPos).get(special.get(offerPos).size() - 1)
                    + Math.min(minAmount, getMinAmountToBuyNeeds(price, special, newNeed, offerPos, cache));
        }
        minAmount = Math.min(minAmount, getMinAmountToBuyNeeds(price, special, needs, offerPos + 1, cache));

        cache.put(key.toString(), minAmount);

        return minAmount;

    }

    public List<Integer> isOfferApplicable(List<List<Integer>> special, List<Integer> needs, int offerPos) {
        List<Integer> newNeeds = new ArrayList();
        List<Integer> offer = special.get(offerPos);
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) - offer.get(i) < 0)
                return needs;
            newNeeds.add(needs.get(i) - offer.get(i));
        }
        return newNeeds;
    }
}