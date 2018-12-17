package learningspring._8_springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = HelloController.BASE_URL)
public class HelloController {
    static final String BASE_URL = "/hello";

    @Autowired
    private HelloRepository helloRepository;


    @GetMapping(path = "/all")
    public List<Hello> getAll() {
        return helloRepository.getAll();
    }

//    nie post, bo sie dosuzkuje jsonow i obiektow!
    @GetMapping(path = "/saveStuff")
    public void saveStuff() {
        List<Hello> h = Arrays.asList(Hello.builder().name("one").build(),
                Hello.builder().name("two").build(),
                Hello.builder().name("three").build());

        h.forEach(helloRepository::save);
    }

    @GetMapping(path = "/{id}")
    public Hello findHello(@PathVariable Long id) {
        return helloRepository.findById(id);
    }
}
