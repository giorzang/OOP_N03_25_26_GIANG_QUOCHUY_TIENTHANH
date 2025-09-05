
import Model.Book;
public class TestBook {
    public static void Test (String[] agrs){
        Book b1 = new Book("Tien Thanh Test");
        Book b2 = new Book("abc", 02);
        Book b3 = new Book();

        System.out.println("b1: "+ b1.Name);
        System.out.println("b3: "+ b2.Name);
        System.out.println("b3: "+ b3.Name);
    }
}