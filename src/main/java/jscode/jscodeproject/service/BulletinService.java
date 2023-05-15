package jscode.jscodeproject.service;


import jscode.jscodeproject.domain.Bulletin;
import jscode.jscodeproject.repository.BulletinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BulletinService {

    private final BulletinRepository bulletinRepository;

    //글 작성
    @Transactional
    public Long write(Bulletin bulletin){
        bulletinRepository.save(bulletin);
        return bulletin.getId();
    }

    //전체 게시물 찾기
    public List<Bulletin> findBulletins() {
        return bulletinRepository.findAll();
    }

    //Id로 하나찾기
    public Bulletin findOne(Long bulletinId){
        return bulletinRepository.findById(bulletinId);
    }

    //게시글 업데이트
    @Transactional
    public Bulletin updateBulletin(Long bulletinId, String title, String text){
        Bulletin bulletin = bulletinRepository.findById(bulletinId);
        bulletin.update(title, text);

        return bulletin;
    }

    //삭제
    @Transactional
    public void deleteOne(Long bulletinId){
        bulletinRepository.deleteById(bulletinId);
    }

}
