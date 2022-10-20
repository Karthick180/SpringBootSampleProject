package com.learn.joblisting.repository;

import com.learn.joblisting.models.Post;

import java.util.List;

public interface SearchRepository {
   List<Post> findByText(String text);
}
