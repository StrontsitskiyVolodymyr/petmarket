package com.strontsitskiy.dao;

import com.strontsitskiy.models.Pet;
import com.strontsitskiy.models.PetOrder;
import com.strontsitskiy.models.User;

import java.util.List;

public interface OrderDao extends  CommonDAO<PetOrder> {
   List<PetOrder > getByCreatorId(Long creatorId);
   PetOrder getOrderByPetIdAndNewOwnerId(Long petid, Long userid);
}
