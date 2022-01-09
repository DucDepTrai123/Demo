package com.trungtamjava.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.trungtamjava.model.User;
import com.trungtamjava.validator.UserValidater;

@Controller
public class HelloController {
	@Autowired
	private UserValidater userValidater;

	@RequestMapping("/hello")
	public ModelAndView seyHello(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@RequestParam(name = "user", required = false) String username,
			@RequestHeader(name = "Accept", required = false) String content) {
		request.setAttribute("msg", content);

		return new ModelAndView("hello");
	}

	@RequestMapping("/ducphi/{name}/{id}")
	public String hello(HttpServletRequest request, @PathVariable(name = "name") String name,
			@PathVariable(name = "id") int id) {
		request.setAttribute("msg", name);
		request.setAttribute("id", id);
		return "hello";
	}

	@RequestMapping(value = { "/ducphi2" }, method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		User user = new User();
		request.setAttribute("user", user);
		return "addUser";
	}

	@RequestMapping(value = { "/ducphi2" }, method = RequestMethod.POST)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") User user, BindingResult bindingResult) {
		userValidater.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "addUser";
		}
		MultipartFile file = user.getAvatar();
		try {
			File file2 = new File("/Users/ducphi/Pictures/" + file.getOriginalFilename());
			FileOutputStream fileOutputStream;

			fileOutputStream = new FileOutputStream(file2);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("u", user);
		return "viewUser";
	}

	@RequestMapping(value = { "/upload-file" }, method = RequestMethod.GET)
	public String upload(HttpServletRequest request) {

		return "upload";
	}

	@RequestMapping(value = { "/upload" }, method = RequestMethod.POST)
	public String upload(HttpServletRequest request, 
			@RequestParam(name = "file")List<MultipartFile> files) {
			for(MultipartFile file: files)
		try {
			File file2 = new File("/Users/ducphi/Pictures/" + file.getOriginalFilename());
			FileOutputStream fileOutputStream;

			fileOutputStream = new FileOutputStream(file2);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("files", files);
		return "viewFile";
	}
	@RequestMapping(value = { "/dowload-file" }, method = RequestMethod.GET)
	public void dowload(HttpServletRequest request,HttpServletResponse response) {
		String dataDirectory = "/Users/ducphi/Pictures/";
		Path  file  = Paths.get(dataDirectory,"wallpaperflare.com_wallpaper.jpg");
		if (Files.exists(file)) {
			response.setContentType("image/jpg");
			response.addHeader("Content-Disposition","attachment;filename =anh.jpg");
			try {
				Files.copy(file,response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
