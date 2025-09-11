public class NNCollection {
    private NameNumber[] nnArray = new NameNumber[100];
    private int free;

    // Chen phan tu moi vao dung vi tri (sap xep theo lastName)
    public void insert(NameNumber n) {
        int index = free;
        for (int i = free; i != 0 && nnArray[i - 1].getLastName().compareTo(n.getLastName()) > 0; i--) {
            nnArray[i] = nnArray[i - 1]; // dich phan tu len
            index = i - 1;
        }
        nnArray[index] = n;
        free++;
    }

    // Tim so dien thoai theo ten
    public String findNumber(String IName) {
        for (int i = 0; i < free; i++) {
            if (nnArray[i].getLastName().equals(IName))
                return nnArray[i].getTelNumber();
        }
        return "Name not found";
    }
}
