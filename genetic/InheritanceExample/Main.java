package genetic.InheritanceExample;

public class Main {
    public static void main(String[] args) {
        Test t = new Test();
        OtherTest ot = new OtherTest();

        GeneticInterface[] arr = {t, ot};

        for (int i = 0; i < arr.length; i++) {
            arr[i].hello();
        }
    }    
}
