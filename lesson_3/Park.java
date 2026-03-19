package lesson_3;

public class Park {
    private String name;
    private String address;
    private String workingHours;
    private Attraction[] attractions;

    public static class Attraction {
        private String name;
        private String workingTime;
        private int price;

        public Attraction(String name, String workingTime, int price) {
            this.name = name;
            this.workingTime = workingTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println(name + "  " + workingTime + "  " + price + " руб.");
        }
    }

    public Park(String name, String address, String workingHours, Attraction[] attractions) {
        this.name = name;
        this.address = address;
        this.workingHours = workingHours;
        this.attractions = attractions;
    }

    public void PrintInfo() {
        System.out.println("Название парка: " + name);
        System.out.println("Адрес: " + address);
        System.out.println("Время работы парка: " + workingHours);
        for (int i = 0; i < attractions.length; i++) {
            attractions[i].printInfo();
        }
    }

    public static void main(String[] args) {
        Attraction[] sochiAttractions = new Attraction[4];
        sochiAttractions[0] = new Attraction("Богатырские гонки", "11:00-19:00", 2000);
        sochiAttractions[1] = new Attraction("Автодром", "12:00-19:00", 2000);
        sochiAttractions[2] = new Attraction("Ладья", "10:00-19:00", 2000);
        sochiAttractions[3] = new Attraction("Самоцветы", "10:00-19:00", 2000);
        Park sochiPark = new Park("Сочи Парк", "Олимпийский просп., 21", "10:00-19:00", sochiAttractions);
        System.out.println();
        sochiPark.PrintInfo();
    }
}