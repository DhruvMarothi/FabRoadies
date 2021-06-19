package com.fabRoadies.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabRoadies.entity.Bus;
import com.fabRoadies.entity.Busquery;
import com.fabRoadies.entity.Ticket;
import com.fabRoadies.service.BusService;

/**
 * This modules controls all bus activities.
 * @author Dhruv Marothi & Shailendra
 * @version 2.5
 */
@RestController
@CrossOrigin(origins = { "*" })
public class BusController {

	@Autowired
	BusService busService;

	//List all Buses wrt their source,destination,dateOfDeparture
	@PostMapping("/findBuses")
	public List<Bus> findBusesByRoute(@RequestBody Busquery query){
//			@PathVariable("source") String source, @PathVariable("destination") String destination,
//			@PathVariable("date") LocalDate departDate) {
//			@RequestParam(name = "departDate") String departDate) {

		List<Bus> buses = busService.findBuses(query.getSource(),query.getDestination(),query.getDateOfDeparture());
		return buses;
	}

	@GetMapping("/admin/showAllBuses")
//	@RequestMapping("/admin/showAllBuses")
	public List<Bus> showAllBuses() {
		return busService.findBuses();
	}

	@PostMapping("/admin/addBus")
	public void addBus(@RequestBody Bus bus) {
//		LocalDate dateofDeparture = (LocalDate.parse(date)).minus(1, ChronoUnit.MONTHS);
//		bus.setDateofDeparture(dateofDeparture);
		busService.save(bus);
	}
///////////////////////////////
	
	@DeleteMapping("/admin/deleteBus/{id}")
	public void deleteBus(@PathVariable("id") String id) {
		busService.delete(id);
	}
	
	//Updates the Bus Details
	@PutMapping(path = "/bus/edit", produces = "application/json")
	public void updateEmp(@RequestBody Bus bus) {
		busService.update(bus);
	}
	
	@GetMapping(value="/get/bus/{busid}",produces="application/json")
	public Bus getBustById(@PathVariable("busid") String busid){
		return busService.getBusById(busid);
	}

}





// ,@RequestBody @DateTimeFormat(pattern = "yyyy-mm-dd") Date departDate
// List <Bus> buses = busService.findBuses(source,destination,departDate);

//LocalDate d3 = LocalDate.parse(departDate);
//System.out.println(d3.minus(1, ChronoUnit.MONTHS));

//@RequestMapping(value = "/findbus",method = RequestMethod.POST)
//public List<Bus> findFLights(@RequestBody Busquery query){
// 
//	System.out.println(query.getSource()+" "+query.getDestination()+" "+query.getDateofDeparture());
//	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//	Date temp = formatter.parse(formatter.format(query.getDateofDeparture()));
//	System.out.println(temp);
////	List <Bus> buses = busService.findBuses(query.getSource(),query.getDestination(),query.getDateofDeparture());
////   System.out.println(buses);   
////   return  buses;
//	return null;
// 
//}  
//
//public List<Bus> findFLights(){
//	
//	return null;
//}

