import domain.BacklogItem;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        BacklogItem bi = new BacklogItem("Title", "Bla bla");
        System.out.println(bi.getName());
        bi.setName("Name");
        System.out.println(bi.getName());
    }
}
