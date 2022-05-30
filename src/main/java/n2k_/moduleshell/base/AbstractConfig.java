package n2k_.moduleshell.base;
import java.util.HashMap;
import java.util.Map;
public abstract class AbstractConfig implements Initilizable, Cloneable {
    private final Map<String, String> VALUES;

    public AbstractConfig() {
        this.VALUES = new HashMap<>();
    }

    public Map<String, String> getValues() {
        return this.VALUES;
    }

    @Override
    public AbstractConfig clone() {
        try {
            return (AbstractConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
