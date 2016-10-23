package sample.data.couchbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sample.data.couchbase.api.User;
import sample.data.couchbase.model.UserRepository;

/**public class SampleController {

	@Autowired
	private CityService cityService;

	@GetMapping("/")
	@ResponseBody
	@Transactional(readOnly = true)
	public String helloWorld() {
		return this.cityService.getCity("Bath", "UK").getName();
	}

}
 * Created by vibodha on 10/22/16.
 */

@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello world";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User addUser(@RequestBody User user){
        userRepository.save(user);
        return user;
    }
}
