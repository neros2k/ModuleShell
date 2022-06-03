package n2k_.moduleshell.core;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public abstract class AbstractCommand extends AbstractListener {
    private final String NAME;
    private final String DESCRIPTION;
    private final String PREFIX;

    public AbstractCommand(AbstractModule module, String name, String description, String prefix) {
        super(module);
        this.NAME = name;
        this.DESCRIPTION = description;
        this.PREFIX = prefix;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String[] args = event.getMessage().getContentDisplay().split(" ");
        if(args[0].equals(this.PREFIX+this.NAME)) {
            this.onCommandCall(new CommandContext(args, event, this));
        }
    }

    public abstract void onCommandCall(CommandContext ctx);

    public String getName() {
        return this.NAME;
    }

    public String getDescription() {
        return this.DESCRIPTION;
    }

    public String getPrefix() {
        return this.PREFIX;
    }
}
