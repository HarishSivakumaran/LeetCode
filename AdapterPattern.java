// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class HelloWorld {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Tiger tiger = new BirdToTiger(bird);
        tiger.roar();
    }
}

class Bird {
    public void makeNoise() {
        System.out.println("caw caw");
    }
}

class Tiger {
    public void roar() {
        System.out.println("roaaar");
    }
}

class BirdToTiger extends Tiger {
    private Bird bird;
    
    BirdToTiger(Bird bird) {
        this.bird = bird;
    }
    
    @Override
    public void roar(){
        bird.makeNoise();
    }
    
    
}