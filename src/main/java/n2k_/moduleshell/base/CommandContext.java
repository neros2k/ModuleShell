package n2k_.moduleshell.base;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
public class CommandContext {
    final JDA JDA;
    final String COMMAND;
    final Member AUTHOR;
    final MessageChannel CHANNEL;
    final String[] ARGS;

    @Contract(pure = true)
    public CommandContext(JDA jda, @NotNull String command, Member author, MessageChannel channel) {
        this.JDA = jda;
        this.COMMAND = command;
        this.AUTHOR = author;
        this.CHANNEL = channel;
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
}
