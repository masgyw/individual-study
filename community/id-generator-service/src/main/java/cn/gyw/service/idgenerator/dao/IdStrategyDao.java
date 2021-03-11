package cn.gyw.service.idgenerator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.gyw.service.idgenerator.entity.IdStrategy;

@Repository
public interface IdStrategyDao extends JpaRepository<IdStrategy, Long> {

    IdStrategy findByBizTag(String bizTag);

}
