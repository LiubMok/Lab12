package atm;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

public abstract class Handler {
    @Getter
    @Setter
    private Handler next;

    public abstract void process(int price) throws IllegalArgumentException;
}
