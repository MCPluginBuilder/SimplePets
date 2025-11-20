package simplepets.brainsynder.api.wrappers.horse;

import lib.brainsynder.EnumVersion;
import lib.brainsynder.ServerVersion;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.inventory.ItemType;

public enum HorseArmorType {
    NONE(0, "barrier"),
    LEATHER(1, "leather_horse_armor"),
    COPPER(2, "copper_horse_armor"),
    IRON(3, "iron_horse_armor"),
    GOLD(4, "golden_horse_armor"),
    DIAMOND(5, "diamond_horse_armor"),

    @EnumVersion(version = ServerVersion.v1_21_11) NETHERITE(6, "netherite_horse_armor");

    private final int id;
    private final String rawMaterial;

    HorseArmorType(int id, String rawMaterial) {
        this.id = id;
        this.rawMaterial = rawMaterial;
    }

    public ItemType itemType() {
        return Registry.ITEM.get(NamespacedKey.minecraft(rawMaterial));
    }

    public static HorseArmorType getByName(String name) {
        for (HorseArmorType wrapper : values()) {
            if (wrapper.name().equalsIgnoreCase(name)) return wrapper;
        }
        return NONE;
    }

    public static HorseArmorType fromId(int id) {
        for (HorseArmorType armor : values()) {
            if (armor.getId() == id)
                return armor;
        }
        return null;
    }

    public static HorseArmorType getPrevious(HorseArmorType current) {
        if (ServerVersion.isEqualNew(ServerVersion.v1_21_11))
            return (current == NONE) ? NETHERITE : values()[current.ordinal() - 1];
        return (current == NONE) ? DIAMOND : values()[current.ordinal() - 1];
    }

    public static HorseArmorType getNext(HorseArmorType current) {
        if (ServerVersion.isEqualNew(ServerVersion.v1_21_11))
            return (current == NETHERITE) ? NONE : values()[current.ordinal() + 1];
        return (current == DIAMOND) ? NONE : values()[current.ordinal() + 1];
    }

    public int getId() {
        return this.id;
    }
}
