package com.test.biz.impl;

import java.util.List;

import com.test.biz.ResumeService;
import com.test.dao.ResumeDao;
import com.test.dao.jdbcimpl.ResumeDaoImpl;
import com.test.domain.po.Resume;

public class ResumeServiceImpl implements ResumeService {
   private ResumeDao resumeDao=new ResumeDaoImpl();
	@Override
	public boolean register(Resume resume) {
		boolean result = false;
		int res = resumeDao.insert(resume);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public Resume findById(Integer id) {
		return resumeDao.findById(id);
	}

	@Override
	public List<Resume> findAll() {
		return resumeDao.findAll();
	}

	@Override
	public boolean remove(Resume resume) {
		boolean result = false;
		int res = resumeDao.delete(resume);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public boolean update(Resume resume) {
		boolean result = false;
		int res = resumeDao.update(resume);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public boolean remove(Integer id) {
		boolean result = false;
		int res = resumeDao.delete(id);
		if (res == 1)
			result = true;
		return result;
	}

	@Override
	public Resume findByUserId(Integer userId) {
		return resumeDao.findByUserId(userId);
	}

}
