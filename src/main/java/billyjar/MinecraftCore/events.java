package billyjar.MinecraftCore;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.*;
import cn.nukkit.form.window.FormWindowCustom;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.permission.PermissionAttachment;
import cn.nukkit.utils.TextFormat;

import java.util.HashMap;
import java.util.UUID;

public class events implements Listener {

    public HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
    protected CoreApi api;

    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        player.sendPopup(TextFormat.RED+"You Moved!");
    }

    @EventHandler
    public void onFormResponse(PlayerFormRespondedEvent e) {
        Player p = e.getPlayer();
        if (e.getWindow() instanceof FormWindowCustom) {
            FormWindowCustom gui = (FormWindowCustom) e.getWindow();
            if (gui.getTitle().equals("Speed setter")) {
                float response = gui.getResponse().getSliderResponse(0);
                p.setMovementSpeed(response/50);
                p.sendMessage("Your speed is now: "+response);
            }
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        PermissionAttachment attachment = e.getPlayer().addAttachment(CorePluginManager.plugin);
        api.playerJoin(e.getPlayer());
        perms.put(e.getPlayer().getUniqueId(), attachment);
        PermissionAttachment pperms = perms.get(e.getPlayer().getUniqueId());
        pperms.setPermission("MinecraftCore.example", true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}
