package n2k_.moduleshell.core.command;
import n2k_.moduleshell.core.module.AbstractModule;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
public class CallCommand extends AbstractMessageCommand {
    private final ICommandCall COMMAND_CALL;

    public CallCommand(AbstractModule module, JDA jda, String name, String description, String prefix, ICommandCall commandCall) {
        super(module, jda, name, description, prefix);
        this.COMMAND_CALL = commandCall;
    }

    @Override
    protected void onMessageCommand(CommandContext ctx, MessageReceivedEvent event) {
        this.COMMAND_CALL.call(ctx);
    }
}
