package n2k_.moduleshell.base;
import n2k_.moduleshell.ModuleShell;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import org.jetbrains.annotations.NotNull;
public abstract class AbstractCommand extends AbstractListener {
    private final String NAME;
    private final String DESCRIPTION;
    private final String PREFIX;
    private final ICommandCall CALL;

    public AbstractCommand(AbstractModule module, JDA jda, String name, String description, String prefix) {
        this(module, jda, name, description, prefix, null);
    }

    public AbstractCommand(AbstractModule module, JDA jda, String name, String description, String prefix, ICommandCall call) {
        super(module, jda);
        this.NAME = name;
        this.DESCRIPTION = description;
        this.PREFIX = prefix;
        this.CALL = call;
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

    protected void onSlashCommand(CommandContext ctx, SlashCommandInteractionEvent event) {
        if(this.CALL != null) {
            this.onCommand(ctx);
        }
    }

    protected void onMessageCommand(CommandContext ctx, MessageReceivedEvent event) {
        if(this.CALL != null) {
            this.onCommand(ctx);
        }
    }

    protected void onCommand(CommandContext ctx) {
        assert this.CALL != null;
        this.CALL.call(ctx);
    }

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
