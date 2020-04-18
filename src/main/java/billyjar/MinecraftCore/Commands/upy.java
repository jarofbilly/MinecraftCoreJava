package billyjar.MinecraftCore.Commands;

import billyjar.MinecraftCore.CommandBase;
import billyjar.MinecraftCore.CoreApi;
import cn.nukkit.Player; //add these in they're usefull
import cn.nukkit.block.Block;
import cn.nukkit.command.CommandSender;
import cn.nukkit.item.Item;
import cn.nukkit.level.Location;
import cn.nukkit.level.Position;
import cn.nukkit.math.BlockFace;

public class upy extends CommandBase {
    public upy (CoreApi api) {
        super("upy", api);
    }

    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {
            return false;
        }
        sender.sendMessage("Whoosh, you've gone up loads");
        return true;
//        Player player = sender.getServer().getPlayerExact(sender.getName());
//        Position pos = (Position) sender;
//        Block block = (Block) sender;
//        block.place(Item.GLASS, Block.GLASS, Block.AIR, BlockFace.UP, pos.x, pos.y, pos.x, player);
//        return true;
    }
}
