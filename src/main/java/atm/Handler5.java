package atm;

public class Handler5 extends Handler{
    @Override
    public void process(int price)  {
        System.out.println(price/ 5 + "* 5");
        Handler next = getNext();

        if (price % 50 > 0 && next == null) {
            throw new IllegalAccessException();
        }
        else if(next != null){
            getNext().process(price % 5);
        }
    }
}
