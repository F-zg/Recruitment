package com.test.dao;

import com.test.domain.po.Resume;

public interface ResumeDao extends GenericDao<Resume, Integer> {
      Resume findByUserId(Integer userId);
}
