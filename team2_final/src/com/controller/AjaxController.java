package com.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
	
	@RequestMapping("/bookinfo")
	public @ResponseBody Map<?, ?> infoBook(String isbn) throws IOException {
		System.out.println("ISBN ¼ö½Å :"+isbn);
		
		String str = String.format(
	    		"http://book.interpark.com/api/search.api?"
	    		+ "key=7F02945A8E0D731BED5FF398D523FECB607FD3331AF4A91AEE19FF93D23884E6"
	    		+ "&query=%s&queryType=isbn&output=json", isbn);
	    
		URL url = new URL(str);
	    
	    ObjectMapper mapper = new ObjectMapper();
	    Map<?, ?> temp = mapper.readValue(url.openStream(), Map.class);
	    
		return temp;
	}

}
