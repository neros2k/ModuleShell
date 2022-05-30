package n2k_.moduleshell.base;
import n2k_.moduleshell.ModuleShell;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
public abstract class CommandListener extends AbstractListener {
    private final String NAME;
    private final String DESCRIPTION;
    private final String PREFIX;

    public CommandListener(AbstractModule module, JDA jda, String name, String description, String prefix) {
        super(module, jda);
        this.NAME = name;
        this.DESCRIPTION = description;
        this.PREFIX = prefix;
    }

    @Override
    public void init() {
        super.init();
        super.getJDA().updateCommands().addCommands(Commands.slash(this.NAME, this.DESCRIPTION)).queue();
    }

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getGuild() == null || !event.getName().equals(NAME)) return;
        if(super.getModule().notValid(event.getGuild().getId())) {
            event.reply(ModuleShell.notEnabledModuleMessage(super.getModule().getID())).queue();
        } else {
            this.onSlashCommand(new CommandContext(super.getJDA(), event.getCommandString(), event.getMember(), event.getChannel()), event);
        }
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        String[] split = message.split(" ");
        if(split[0].equals(this.PREFIX+this.NAME)) {
            if(super.getModule().notValid(event.getGuild().getId())) {
                event.getMessage().reply(ModuleShell.notEnabledModuleMessage(super.getModule().getID())).queue();
            } else {
                this.onMessageCommand(new CommandContext(super.getJDA(), message, event.getMember(), event.getChannel()), event);
            }
        }
    }

    protected abstract void onSlashCommand(CommandContext ctx, SlashCommandInteractionEvent event);
    protected abstract void onMessageCommand(CommandContext ctx, MessageReceivedEvent event);
}
