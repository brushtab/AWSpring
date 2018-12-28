package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private static final String templatePOST = "You are the best, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path="/greeting", method=RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(path="/greeting", method=RequestMethod.POST)
    public Greeting YouBest(@RequestParam(value="name", defaultValue="Eugene Efimenko") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(templatePOST, name));
    }

    @RequestMapping(path="/sayhey", method=RequestMethod.POST)
    public Greeting sayHey(@RequestParam(value="name", defaultValue="Eugene Efimenko") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(templatePOST, name));
    }

    @RequestMapping(path="/sayhey", method=RequestMethod.GET)
    public Greeting sayHeyGet(@RequestParam(value="name", defaultValue="Eugene Efimenko, you made Get!") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(templatePOST, name));
    }

    @RequestMapping(path="/git", method=RequestMethod.GET)
    public Greeting git(@RequestParam(value="name", defaultValue="Hello bro") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(templatePOST, name));
    }
}