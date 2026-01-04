package springweb;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import springweb.service.JobService;
import springweb.model.JobPost;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
