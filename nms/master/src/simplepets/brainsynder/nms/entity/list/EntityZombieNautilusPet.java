package simplepets.brainsynder.nms.entity.list;

import lib.brainsynder.ServerVersion;
import lib.brainsynder.SupportedVersion;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import simplepets.brainsynder.api.entity.passive.IEntityZombieNautilusPet;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.user.PetUser;
import simplepets.brainsynder.nms.entity.branch.EntityNautilusAbstractPet;
import simplepets.brainsynder.nms.utils.PetDataAccess;

/**
 * NMS: {@link net.minecraft.world.entity.animal.nautilus.ZombieNautilus }
 */
@SupportedVersion(version = ServerVersion.v1_21_11)
public class EntityZombieNautilusPet extends EntityNautilusAbstractPet implements IEntityZombieNautilusPet {
//    private static final EntityDataAccessor<Holder<ZombieNautilusVariant>> VARIANT = SynchedEntityData.defineId(EntityZombieNautilusPet.class, EntityDataSerializers.ZOMBIE_NAUTILUS_VARIANT);
    private static final EntityDataAccessor<String> VARIANT = SynchedEntityData.defineId(EntityZombieNautilusPet.class, EntityDataSerializers.STRING);

    public EntityZombieNautilusPet(PetType type, PetUser user) {
        super(EntityType.ALLAY, type, user); // TODO: Update EntityType
    }

    @Override
    public void populateDataAccess(PetDataAccess dataAccess) {
        super.populateDataAccess(dataAccess);
        // TODO: This needs to be changed to `VariantUtils.getDefaultOrAny(registryAccess(), ZombieNautilusVariants.TEMPERATE)`
        dataAccess.define(VARIANT, "temperate");
    }
}
