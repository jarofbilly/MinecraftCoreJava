package billyjar.MinecraftCore;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFormRespondedEvent;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.form.window.FormWindowSimple;
import cn.nukkit.utils.TextFormat;

public class events implements Listener {
    @EventHandler
    public void onMove(PlayerMoveEvent event)
    {
        Player player = event.getPlayer();
        player.sendPopup(TextFormat.RED+"You Moved!");
    }

    @EventHandler
    public void onFormResponse(PlayerFormRespondedEvent e) {
        Player p = e.getPlayer();
        if (e.getWindow() instanceof FormWindowSimple) {
            FormWindowSimple gui = (FormWindowSimple) e.getWindow();
            String responseName = gui.getResponse().getClickedButton().getText();



            return;
        }
    }
}
