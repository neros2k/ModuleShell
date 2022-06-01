package n2k_.moduleshell.core;
public interface ISaver<T> {
    T fromJson(String json);

    String toJson(T value);

    void saveValue(String parameter, T value);

    T findValue(String parameter);
}
