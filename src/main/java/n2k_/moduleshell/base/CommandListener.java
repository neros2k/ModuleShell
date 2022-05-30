package n2k_.moduleshell.base;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
public abstract class CommandListener extends AbstractListener {
    private final String COMMAND_NAME;

    public CommandListener(AbstractModule module, JDA jda, String name, String description) {
        super(module, jda);
        this.COMMAND_NAME = name;
        jda.updateCommands().addCommands(Commands.slash(name, description)).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(this.isInvalid(event.getGuild()) || !event.getName().equals(COMMAND_NAME)) return;
        this.onCommand(event.getCommandString(), event.getMember(), event.getChannel());
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Guild guild = event.getGuild();
        if(this.isInvalid(guild)) return;
        String message = event.getMessage().getContentDisplay();
        String[] split = message.split(" ");
        if(split[0].equals(this.COMMAND_NAME)) {
            this.onCommand(message, event.getMember(), event.getChannel());
        }
    }

    protected abstract void onCommand(String command, Member author, MessageChannel channel);

    private boolean isInvalid(Guild guild) {
        return guild != null && !super.isValid(guild.getId());
    }
}
