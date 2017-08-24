package com.bitwise.pagination.web.service;

import java.util.List;
import com.bitwise.pagination.web.beans.Phone;

public interface PhoneService {

	public List<Phone> getPhoneslist();

	public Phone buildPhone(String id, String name, double price);

}