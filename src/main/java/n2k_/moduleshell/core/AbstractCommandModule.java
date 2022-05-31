package n2k_.moduleshell.core;
import n2k_.moduleshell.core.command.AbstractCommand;
import net.dv8tion.jda.api.JDA;
import java.util.ArrayList;
import java.util.List;
public class AbstractCommandModule extends AbstractModule {
    private final List<AbstractCommand> COMMAND_LIST;

    public AbstractCommandModule(String id, JDA jda) {
        super(id, jda);
        this.COMMAND_LIST = new ArrayList<>();
    }

    public void addCommand(AbstractCommand command) {
        this.COMMAND_LIST.add(command);
    }

    public List<AbstractCommand> getCommandList() {
        return this.COMMAND_LIST;
    }

    @Override
    public void init() {
        this.COMMAND_LIST.forEach(AbstractCommand::init);
        super.init();
    }
}
