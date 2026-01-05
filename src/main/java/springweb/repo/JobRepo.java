package springweb.repo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springweb.model.JobPost;


@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {

        List<JobPost> findByPostProfileContainingIgnoreCaseOrPostDescContainingIgnoreCase(String postProfile, String postDesc);
    
}


// // method to return all JobPosts
//     public List<JobPost> getAllJobs() {
//         return jobs;
//     }

//     // method to save a job post object into arrayList
//     public void addJob(JobPost job) {
//         jobs.add(job);
//         System.out.println(jobs);
//     }

//     public JobPost getJobById(int id) {
//         for (JobPost job: jobs) {
//                 if (job.getPostId() == id) {
//                     return job;
//                 }
//         }
//         return null;
//     }

//     public void updateJob(JobPost jobPost) {
//         for (JobPost job: jobs) {
//                 if(job.getPostId() == jobPost.getPostId()) {
//                         job.setPostProfile(jobPost.getPostProfile());
//                         job.setPostDesc(jobPost.getPostDesc());
//                         job.setPostTechStack(jobPost.getPostTechStack());
//                         job.setReqExperience(jobPost.getReqExperience());
//                 }
//         }
//     }

//     public boolean deleteJob(int id) {
//         for (JobPost job: jobs) {
//                 if (job.getPostId() == id) {
//                         jobs.remove(id);
//                         return true;
//                 }
//         }
//         return false;
//     }