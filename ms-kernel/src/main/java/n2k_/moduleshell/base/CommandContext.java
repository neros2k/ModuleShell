package n2k_.moduleshell.base;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
public class CommandContext {
    private final String[] ARGS;
    private final Guild GUILD;
    private final AbstractCommand COMMAND;
    private final Message MESSAGE;
    private final Member AUTHOR;

    public CommandContext(String[] args, Guild guild, AbstractCommand command, Message message, Member author) {
        this.ARGS = args;
        this.GUILD = guild;
        this.COMMAND = command;
        this.MESSAGE = message;
        this.AUTHOR = author;
    }

    public CommandContext(String[] args, @NotNull MessageReceivedEvent event, AbstractCommand command) {
        this.ARGS = args;
        this.GUILD = event.getGuild();
        this.COMMAND = command;
        this.MESSAGE = event.getMessage();
        this.AUTHOR = event.getMember();
    }

    public String[] getArgs() {
        return this.ARGS;
    }

    public Guild getGuild() {
        return this.GUILD;
    }

    public AbstractCommand getCommand() {
        return this.COMMAND;
    }

    public Message getMessage() {
        return this.MESSAGE;
    }

    public Member getAuthor() {
        return this.AUTHOR;
    }
}

