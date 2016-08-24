package com.strontsitskiy.dao;

import com.strontsitskiy.models.PetOrder;

public interface OrderDao extends  CommonDAO<PetOrder> {
    PetOrder getByCreatorId(Long creatorId);
}
