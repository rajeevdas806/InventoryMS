package com.inventory.ms.InventoryMS.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.ms.InventoryMS.dto.InventoryResponse;
import com.inventory.ms.InventoryMS.model.Inventory;
import com.inventory.ms.InventoryMS.repository.InventoryRepository;

@Service
public class InventoryService {

	private final Logger log = LoggerFactory.getLogger(InventoryService.class);
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	public List<InventoryResponse> isItemAvailable(List<String> itemList) {
		
		return inventoryRepository.findByItemCodeIn(itemList).stream().map(this :: mapToInventoryResponse).toList();
		
	}
	
	public InventoryResponse mapToInventoryResponse(Inventory inventory) {
		InventoryResponse inventoryResponse = new InventoryResponse();
		inventoryResponse.setItemCode(inventory.getItemCode());
		inventoryResponse.setItemAvailableFlag(inventory.getQuantity() > 0);
		
		return inventoryResponse;
	}
}
