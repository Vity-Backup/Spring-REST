package com.example.demo;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("")
	public String listAll(Model model) {
		List<User> listUsers = userService.listAllUser();
		model.addAttribute("listUsers", listUsers);
		// System.out.println(listUsers.size());
		return "allUsers.html";
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable Integer id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String add(@ModelAttribute("User") User user) {

		userService.saveUser(user);
		return "redirect:/users";
	}

	@RequestMapping("/new")
	public String showNewUsers(Model model) {
		User user = new User();
		model.addAttribute("user", user);

		return "new_user.html";
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
		try {
			User existUser = userService.getUser(id);
			user.setId(id);
			userService.saveUser(user);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, Model model) {

		userService.deleteUser(id);
		return "redirect:/users";
	}
}