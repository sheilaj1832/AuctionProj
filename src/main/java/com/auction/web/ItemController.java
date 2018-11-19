package com.auction.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.auction.business.item.Item;
import com.auction.business.item.ItemRepository;

@CrossOrigin
@Controller 
@RequestMapping(path="/Jsds") 
public class ItemController extends BaseController {
	@Autowired 
	private ItemRepository jsdRepository;

	@GetMapping(path="/List") 
	public @ResponseBody Iterable<Item> getAllJsds() {
		return ItemRepository.findAll();
	}
	
	@GetMapping(path="/Get")
	public @ResponseBody List<Item> getItem (@RequestParam int id) {
		
		Optional<Item> u =ItemRepository.findById(id);
		return getReturnArray(u.get());
	}

	
	@PostMapping(path="/Add") 
	public @ResponseBody AuctionMaintenanceReturn addNewItem (@RequestBody Item item) {
			try {
		ItemRepository.save(item);
		return AuctionMaintenanceReturn.getMaintReturn(item);
	}
			catch (Exception e) {
		item = null;
	}
return AuctionMaintenanceReturn.getMaintReturn(item);
}
	
	@GetMapping(path="/Remove") 
	public @ResponseBody AuctionMaintenanceReturn deleteItem (@RequestParam int id) {
		
	Optional <Item> item = itemRepository.findById(id);
		try {
	ItemRepository.delete(item.get());
}
catch (Exception e) {
	item = null;
}
return AuctionMaintenanceReturn.getMaintReturn(item);
}
	
	@PostMapping(path="/Change") 
	public @ResponseBody AuctionMaintenanceReturn updateJsd (@RequestBody Item item) {
		try {
			itemRepository.save(item);
		}
		catch (Exception e) {
			item = null;
		}
	return AuctionMaintenanceReturn.getMaintReturn(item);
	}
}
