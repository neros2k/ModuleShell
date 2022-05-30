package n2k_.moduleshell;
import java.util.HashMap;
import java.util.Map;
public class ModuleShell {
    private final static Map<String, String[]> ENABLED_MODULES = new HashMap<>();

    public static void main(String[] args) {

    }

    public static Map<String, String[]> getEnabledModulesMap() {
        return ModuleShell.ENABLED_MODULES;
    }
}