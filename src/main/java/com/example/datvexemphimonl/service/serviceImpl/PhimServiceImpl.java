package com.example.datvexemphimonl.service.serviceImpl;

import com.example.datvexemphimonl.entity.Phim;
import com.example.datvexemphimonl.repository.PhimRepository;
import com.example.datvexemphimonl.service.PhimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhimServiceImpl implements PhimService {

    @Autowired
    private PhimRepository phimRepository;

    @Override
    public List<Phim> getAllPhim() {
        return phimRepository.findAll();
    }

    @Override
    public Phim savePhim(Phim phim) {
        return phimRepository.save(phim);
    }

    @Override
    public Phim getPhimById(int id) {
        return phimRepository.getById(id);
    }

    @Override
    public void deletePhim(int id) {

    }

    @Override
    public Phim updatePhim(Phim phim) {
        return phimRepository.save(phim);
    }

	@Override
	public List<Phim> searchPhim(String search) {
		// TODO Auto-generated method stub
		return phimRepository.findPhimBySearch("%"+search+"%");
	}

}
