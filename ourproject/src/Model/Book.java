package Model;

public class Book {
    public String Name;
    public int ID;
    public String valString1;//bassaed on business logic 
    public String valString2;// doccument varlable name is Manual
    public int valInt1;
    public int valInt2;
    
    public Book (){}

   public Book (String name, int id){
        Name = name;
        ID = id;
    }

     public Book (int id){
        ID = id;
    }

   public Book (String name){
        Name = name;
    }
    public String  layName (){
        return Name;
    }
}
