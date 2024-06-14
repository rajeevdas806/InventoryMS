package com.inventory.ms.InventoryMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.ms.InventoryMS.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long>{

	List<Inventory> findByItemCodeIn(List<String> itemList);
}
