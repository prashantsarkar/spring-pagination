package com.bitwise.pagination.web.serviceImp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bitwise.pagination.web.beans.Phone;
import com.bitwise.pagination.web.service.PhoneService;

@Service
public class PhoneServiceImp implements PhoneService {

	@Override
	public List<Phone> getPhoneslist() {

		List<Phone> phonesList = new ArrayList<Phone>();

		phonesList.add(buildPhone("1", "Samsung Galaxy Y", 8000.00));
		phonesList.add(buildPhone("2", "Nokia Lumia", 34652.65));
		phonesList.add(buildPhone("3", "Moto M", 17999.00));
		phonesList.add(buildPhone("4", "Lenovo A 7000 white", 12658.32));
		phonesList.add(buildPhone("5", "Sony XPeria", 23658.75));
		phonesList.add(buildPhone("6", "Apple iPhone 6", 55235.45));
		phonesList.add(buildPhone("7", "Apple iPhone 7", 69452.22));
		
		return phonesList;
	}

	@Override
	public Phone buildPhone(String id, String name, double price) {

		Phone phone = new Phone(id, name, price);
		return phone;
	}

}