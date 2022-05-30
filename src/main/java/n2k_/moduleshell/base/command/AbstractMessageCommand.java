package n2k_.moduleshell.base.command;
import n2k_.moduleshell.ModuleShell;
import n2k_.moduleshell.base.AbstractModule;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public abstract class AbstractMessageCommand extends AbstractCommand {
    public AbstractMessageCommand(AbstractModule module, net.dv8tion.jda.api.JDA jda, String name, String description, String prefix) {
        super(module, jda, name, description, prefix);
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        String[] split = message.split(" ");
        if(split[0].equals(super.getPrefix()+super.getName())) {
            if(super.getModule().notValid(event.getGuild().getId())) {
                event.getMessage().reply(ModuleShell.notEnabledModuleMessage(super.getModule().getID())).queue();
            } else {
                this.onMessageCommand(new CommandContext(super.getJDA(), message, event.getMember(), event.getChannel()), event);
            }
        }
    }

    protected abstract void onMessageCommand(CommandContext ctx, MessageReceivedEvent event);
}
