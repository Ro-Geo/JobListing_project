package com.myprojects.joblisting.repository;

import com.myprojects.joblisting.model.JobPost;

import java.util.ArrayList;
import java.util.List;

public interface SearchRepository {

    List<JobPost> findByText(String text);
}
