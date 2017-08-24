package com.bitwise.pagination.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.pagination.web.beans.Phone;
import com.bitwise.pagination.web.service.PhoneService;

@Controller
@RequestMapping(value = "/phones")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class PhoneController {

	@Autowired
	PhoneService phoneServiceService;

	@RequestMapping(value = { "/all/{type}", "/all" }, method = RequestMethod.GET)
	public ModelAndView all(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {

		PagedListHolder<Phone> productList = null;

		String type = pathVariablesMap.get("type");

		if (type == null) {
			// First Request, Return first set of list
			List<Phone> phonesList = phoneServiceService.getPhoneslist();

			productList = new PagedListHolder<Phone>();
			productList.setSource(phonesList);
			productList.setPageSize(2);

			req.getSession().setAttribute("phonesList", productList);

			printPageDetails(productList, type);

		} else if (type.equals("next")) {
			// Return next set of list
			productList = (PagedListHolder<Phone>) req.getSession().getAttribute("phonesList");

			productList.nextPage();

			printPageDetails(productList, type);

		} else if (type.equals("prev")) {
			// Return previous set of list
			productList = (PagedListHolder<Phone>) req.getSession().getAttribute("phonesList");

			productList.previousPage();

			printPageDetails(productList, type);

		} else {
			// Return specific index set of list
			
			productList = (PagedListHolder<Phone>) req.getSession().getAttribute("phonesList");

			int pageNum = Integer.parseInt(type);

			productList.setPage(pageNum);

			printPageDetails(productList, type);
		}

		ModelAndView modelAndView = new ModelAndView("index");

		return modelAndView;
	}

	private void printPageDetails(PagedListHolder productList, String type) {
		
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("type:" + type);
		
		System.out.println("curent page - productList.getPage() :" + productList.getPage());

		System.out.println("Total Num of pages - productList.getPageCount :" + productList.getPageCount());

		System.out.println("is First page - productList.isFirstPage :" + productList.isFirstPage());

		System.out.println("is Last page - productList.isLastPage :" + productList.isLastPage());
	}
}