package n2k_.moduleshell.core.command;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
public class CommandContext<EventType> {
    private final JDA JDA;
    private final String COMMAND;
    private final Member AUTHOR;
    private final MessageChannel CHANNEL;
    private final String[] ARGS;
    private final EventType EVENT;

    @Contract(pure = true)
    public CommandContext(JDA jda, @NotNull String command, Member author, MessageChannel channel, EventType event) {
        this.JDA = jda;
        this.COMMAND = command;
        this.AUTHOR = author;
        this.CHANNEL = channel;
        this.EVENT = event;
        this.ARGS = command.split(" ");
    }

    public JDA getJDA() {
        return this.JDA;
    }

    public String getCommand() {
        return this.COMMAND;
    }

    public Member getAuthor() {
        return this.AUTHOR;
    }

    public MessageChannel getChannel() {
        return this.CHANNEL;
    }

    public String[] getArgs() {
        return this.ARGS;
    }

    public EventType getEvent() {
        return this.EVENT;
    }
}
