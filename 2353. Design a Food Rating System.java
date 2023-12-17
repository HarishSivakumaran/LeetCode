class FoodRatings {
    HashMap<String, Integer> indexMap = new HashMap();
    HashMap<String, TreeMap<Integer,TreeSet<String>>> cuisineGrp = new HashMap();
    String[] foods = null; String[] cuisines = null; int[] ratings = null;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.foods = foods; this.cuisines = cuisines; this.ratings = ratings;
        for(int i = 0; i < foods.length; i++) {
            indexMap.put(foods[i], i);
            cuisineGrp.computeIfAbsent(cuisines[i], v -> new TreeMap());
            cuisineGrp.get(cuisines[i]).computeIfAbsent(ratings[i], v -> new TreeSet()).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        int i = indexMap.get(food);
        int fromRating = ratings[i];
        ratings[i] = newRating;
        cuisineGrp.get(cuisines[i]).get(fromRating).remove(food);
        if(cuisineGrp.get(cuisines[i]).get(fromRating).size() == 0) {
            cuisineGrp.get(cuisines[i]).remove(fromRating);
        }
        cuisineGrp.get(cuisines[i])
            .computeIfAbsent(newRating, v -> new TreeSet()).add(food);

    }
    
    public String highestRated(String cuisine) {
        return cuisineGrp.get(cuisine).lastEntry().getValue().first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */