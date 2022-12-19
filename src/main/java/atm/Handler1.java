package atm;

public class Handler1 extends Handler {
    @Override
    public void process(int price) throws IllegalArgumentException {
        System.out.println(price/ 1 + " * 1");
        Handler next = getNext();
        if (price % 1 > 0 && next == null) {
            throw new IllegalArgumentException();
        }
        else if(next != null){
            getNext().process(price % 1);
        }
    }
}
