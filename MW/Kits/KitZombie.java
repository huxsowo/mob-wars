package MW.Kits;

import MW.Kit;
import me.libraryaddict.disguise.disguisetypes.DisguiseType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class KitZombie extends Kit {

    public KitZombie (){
        super();

        this.name = "Zombie";
        this.damage = 6.0;
        this.armor = 5.5;
        this.knockback = 1.25;
        this.regen = 0.25;
        this.speed = 0.21f;
        this.menuItem = Material.ROTTEN_FLESH;
        this.disguise = DisguiseType.ZOMBIE;
    }

    public void equipKit(Player player){
        super.equipKit(player);
    }
}
