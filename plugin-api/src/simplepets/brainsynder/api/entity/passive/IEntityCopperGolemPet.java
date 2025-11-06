package simplepets.brainsynder.api.entity.passive;

import simplepets.brainsynder.api.entity.IEntityPet;
import simplepets.brainsynder.api.entity.misc.EntityPetType;
import simplepets.brainsynder.api.pet.PetType;
import simplepets.brainsynder.api.wrappers.OxidationWrapper;

@EntityPetType(petType = PetType.COPPER_GOLEM)
public interface IEntityCopperGolemPet extends IEntityPet {
    OxidationWrapper getOxidation ();
    void setOxidation (OxidationWrapper wrapper);
}
