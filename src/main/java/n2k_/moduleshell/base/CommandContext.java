package n2k_.moduleshell.base;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Member;
public class CommandContext {
    private final JDA JDA;
    private final Member AUTHOR;
    private final String STR;

    public CommandContext(JDA jda, Member author, String str) {
        this.JDA = jda;
        this.AUTHOR = author;
        this.STR = str;
    }

    public JDA getJDA() {
        return this.JDA;
    }

    public Member getAuthor() {
        return this.AUTHOR;
    }

    public String getSTR() {
        return this.STR;
    }
}
