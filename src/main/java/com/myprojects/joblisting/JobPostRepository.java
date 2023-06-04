package com.myprojects.joblisting;

import com.myprojects.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {

}
