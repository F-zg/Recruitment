package com.test.biz;

import java.util.List;

import com.test.domain.po.Resume;


public interface ResumeService {
	boolean register(Resume resume);
	Resume findById(Integer id);
	List<Resume> findAll();
	boolean remove(Resume resume);
	boolean update(Resume resume);
	boolean remove(Integer  id);
	Resume findByUserId(Integer userId);
}
