package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player; //add these in they're usefull
import cn.nukkit.command.CommandSender;
import cn.nukkit.level.Location;

public class up extends CommandBase {
    public up (CoreApi api) {
        super("up", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {
            return false;
        }

    return true;
    }
}
