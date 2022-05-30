package n2k_.moduleshell.base;
import net.dv8tion.jda.api.JDA;
import java.util.ArrayList;
import java.util.List;
public abstract class AModule implements IInitilizable {
    final String ID;
    final List<AListener> LISTENER_LIST;
    final JDA JDA;

    public AModule(String id, JDA jda) {
        this.ID = id;
        this.LISTENER_LIST = new ArrayList<>();
        this.JDA = jda;
    }

    public void initListeners() {
        this.LISTENER_LIST.forEach(AListener::init);
    }

    public String getID() {
        return this.ID;
    }

    public JDA getJDA() {
        return this.JDA;
    }
}
