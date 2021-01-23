package MW.GameManagers;

import MW.DamageType;
import MW.GamePlayer;
import MW.Kit;
import MW.Main;
import org.bukkit.entity.Player;

public class DamageManager {

    public static void dealDamage(Player attacker, Player victim, double damage, DamageType damageType, String reason, int iframes){
        GamePlayer attackerGamePlayer = Main.gamePlayerHashMap.get(attacker);
        GamePlayer victimGamePlayer = Main.gamePlayerHashMap.get(victim);
        if (victimGamePlayer.getPlayerMeleeIframes().containsKey(attacker)){
            return;
        }
        Kit victimKit = victimGamePlayer.getKit();
        damage *= attackerGamePlayer.getOutgoingDamageMultiplier() * victimGamePlayer.getIncomingDamageMultiplier();
        double armor = (100 - (victimKit.getArmor()*8)) / 100;
        victim.damage(armor * damage);
        victim.setNoDamageTicks(0);
        victimGamePlayer.setLastDamageReason(reason);
        victimGamePlayer.setPlayerMeleeIframes(attacker, iframes);
    }
}
