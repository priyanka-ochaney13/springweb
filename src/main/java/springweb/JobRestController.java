package springweb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import springweb.service.JobService;
import springweb.model.JobPost;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    // @ResponseBody // if we dont add this annotation, it will look for a view named "jobs" but we want to return data. We can also use @RestController instead of @Controller to avoid adding @ResponseBody to each method.
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/job/{id}")
    public JobPost getJobById(@PathVariable("id") int id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/job")
    //request body annotation is used to bind the request body with a method parameter.
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
        return jobService.getJobById(jobPost.getPostId()); 
    }

    @PutMapping("/job")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJobById(jobPost.getPostId());
    }

    @DeleteMapping("/job/{id}")
    public String deleteJob(@PathVariable("id") int id) {
        jobService.deleteJob(id);
        return "Job with id " + id + " deleted successfully.";
    }

    //jackson library is used to convert java object to json and json to java object.
    //how it works: when we return a java object from a controller method, spring boot uses jackson to convert it to json and send it to the client.
    //when we receive a json from the client, spring boot uses jackson to convert it to a java object and bind it to the method parameter.
    //this is done automatically by spring boot if jackson library is present in the classpath.
    //spring boot starter web dependency includes jackson library by default.
    //we can also customize the jackson object mapper by defining a bean of type ObjectMapper in the configuration class.
    //we can also use other libraries like gson, jsonb etc. by adding their dependencies and configuring them in the configuration class.

    //working of reqbody annotation: when we use @RequestBody annotation on a method parameter, spring boot uses jackson to convert the json received in the request body to a java object and bind it to the method parameter.
}
