package lesson_4;

public class Cat extends Animal{
    private static final int MAX_RUN = 200;
    private static int catCount = 0;
    private boolean isFull;
    private int full;
    public Cat(String name) {
        super(name);
        catCount++;
        this.isFull = false;
        this.full = 10;
    }
    public Cat(String name, int full) {
        super(name);
        catCount++;
        this.isFull = false;
        this.full = full;
    }
    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать!");
    }
    public void eat(Plate plate) {
        if (plate.decreaseFood(full)) {
            isFull = true;
            System.out.println(name + " покушал и теперь сыт! " + full + " еды.");
        } else {
            System.out.println(name + " не смог поесть: в миске недостаточно еды. Необходимо: " +
                    full + " в миске " + plate.getFoodAmount());
        }
    }
    public boolean isFull(){
        return isFull;
    }
    public static int getCatCount() {
        return catCount;
    }
    public int getFull() {
        return full;
    }
}
